package ru.mg.fanout.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import ru.mg.accountservice.Account;
import ru.mg.accountservice.AccountDetailsRequest;
import ru.mg.accountservice.AccountDetailsResponse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

@Service
public class SOAPMapperService {

    @Autowired
    @Qualifier("request")
    private JAXBContext rqContext;

    @Autowired
    @Qualifier("response")
    private JAXBContext rsContext;

    public String createAccountWSRequest(String accountNumber) {

        try {
            Marshaller marshaller = rqContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            AccountDetailsRequest request = new AccountDetailsRequest();
            request.setAccountNumber(accountNumber);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            marshaller.marshal(request, doc);

            MessageFactory factory = MessageFactory.newInstance();
            SOAPMessage soapMessage = factory.createMessage();
            SOAPBody soapBody = soapMessage.getSOAPBody();
            soapBody.addDocument(doc);

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                soapMessage.writeTo(baos);
                return new String(baos.toByteArray(), StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            throw Exceptions.propagate(e);
        }
    }

    public Account createAccountWCResponse(String body) {
        try(ByteArrayInputStream bais = new ByteArrayInputStream(body.getBytes())) {
            SOAPMessage message = MessageFactory.newInstance().createMessage(null, bais);

            Unmarshaller unmarshaller = rsContext.createUnmarshaller();
            final AccountDetailsResponse response = (AccountDetailsResponse) unmarshaller
                            .unmarshal(message.getSOAPBody().extractContentAsDocument());
            return response.getAccountDetails();
        } catch (Exception e) {
            throw Exceptions.propagate(e);
        }
    }

    public Mono<Account> createAccountWCMono(String body) {
        return Mono.fromSupplier(() -> createAccountWCResponse(body));
    }
}

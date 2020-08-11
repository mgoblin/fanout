package ru.mg.fanout;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.Document;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.AccountDetailsRequest;
import ru.mg.accountservice.AccountService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class Application {

    private static final String DELAYED_SERVICE_URL = "http://localhost:8080/service/accounts/delayed";
    private static final String FAST_SERVICE_URL = "http://localhost:8080/service/accounts/fast";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean("delayedAccountWSClient")
    public AccountService delayedAccountServiceClient() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AccountService.class);
        jaxWsProxyFactoryBean.setAddress(DELAYED_SERVICE_URL);
        return (AccountService) jaxWsProxyFactoryBean.create();
    }

    @Bean("fastAccountWSClient")
    public AccountService fastAccountServiceClient() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AccountService.class);
        jaxWsProxyFactoryBean.setAddress(FAST_SERVICE_URL);
        return (AccountService) jaxWsProxyFactoryBean.create();
    }

    @Bean
    public JAXBContext jaxbContext() throws JAXBException {
        return JAXBContext.newInstance(AccountDetailsRequest.class);
    }
}

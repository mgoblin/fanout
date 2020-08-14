package ru.mg.fanout.rest.service.wc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;

@Service
public class WCRestService {
    @Autowired
    @Qualifier("fastWebClient")
    private WebClient fastWebClient;

    @Autowired
    @Qualifier("delayedWebClient")
    private WebClient delayedWebClient;

    @Autowired
    private SOAPMapperService mapper;

    public Mono<Account> getFastAccountWC(String accountNumber) {
        final String accountWSRequest = mapper.createAccountWSRequest(accountNumber);
        return fastWebClient
                .post()
                .body(BodyInserters.fromValue(accountWSRequest))
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(s -> mapper.createAccountWCMono(s));
    }

    public Mono<Account> getDelayedAccountWC(String accountNumber) {
        final Mono<String> accountWSRequest = Mono
                .fromSupplier(() -> mapper.createAccountWSRequest(accountNumber));

        return delayedWebClient
                .post()
                .body(BodyInserters.fromPublisher(accountWSRequest, String.class))
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(s -> mapper.createAccountWCMono(s));
    }
}

package ru.mg.fanout.rest.service.wc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.rest.SOAPMapperService;

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

    public Mono<Account> getFastAccountWC() {
        final String accountWSRequest = mapper.createAccountWSRequest("1");
        return fastWebClient
                .post()
                .body(BodyInserters.fromValue(accountWSRequest))
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(s -> mapper.createAccountWCMono(s));
    }

    public Mono<Account> getDelayedAccountWC() {
        final Mono<String> accountWSRequest = Mono.fromSupplier(() -> mapper.createAccountWSRequest("1"));
        return delayedWebClient
                .post()
                .body(BodyInserters.fromValue("test"))
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(s -> mapper.createAccountWCMono(s));
    }
}

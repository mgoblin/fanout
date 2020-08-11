package ru.mg.fanout.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.rest.SOAPMapperService;
import ru.mg.fanout.rest.model.AccountsResponse;
import ru.mg.fanout.ws.WSAccountService;

import java.util.stream.IntStream;

@Service
public class RestAccountService {

    @Autowired
    private WSAccountService wsAccountService;

    @Autowired
    @Qualifier("fastWebClient")
    private WebClient fastWebClient;

    @Autowired
    @Qualifier("delayedWebClient")
    private WebClient delayedWebClient;

    @Autowired
    private SOAPMapperService mapper;

    public Mono<AccountsResponse> getAccountsStub(int max) {
        return Flux.fromStream(IntStream.range(1, max + 1).boxed())
                .flatMap(id -> wsAccountService.getAccountStub(id.toString()))
                .collectList()
                .map(responses -> new AccountsResponse(responses.size(), responses));
    }

    public Flux<Account> getAccountsStubFlux(int max) {
        return Flux.fromStream(IntStream.range(1, max).boxed())
                .flatMap(id -> wsAccountService.getAccountStub(id.toString()));
    }

    public Mono<Account> getAccountStub() {
        return Mono.from(wsAccountService.getAccountStub("1"));
    }

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

    public Mono<AccountsResponse> getFastAccountsWS(int max) {
        return Flux.fromStream(IntStream.range(1, max + 1).boxed())
                .flatMap(id -> wsAccountService.getFastAccountWS(id.toString()))
                .collectList()
                .map(responses -> new AccountsResponse(responses.size(), responses));
    }

    public Mono<AccountsResponse> getDelayedAccountsWS(int max) {
        return Flux.fromStream(IntStream.range(1, max + 1).boxed())
                .flatMap(id -> wsAccountService.getDelayedAccountWS(id.toString()))
                .collectList()
                .map(responses -> new AccountsResponse(responses.size(), responses));
    }
}

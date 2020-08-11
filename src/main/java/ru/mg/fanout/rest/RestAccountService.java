package ru.mg.fanout.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.ws.WSAccountService;

import java.util.stream.IntStream;

@Service
public class RestAccountService {

    @Autowired
    private WSAccountService wsAccountService;

    @Autowired
    private WebClient webClient;

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
        return webClient
                .post()
                .body(BodyInserters.fromValue(mapper.createAccountWSRequest("1")))
                .retrieve()
                .bodyToMono(String.class)
                .map(s -> mapper.createAccountWCResponse(s));
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

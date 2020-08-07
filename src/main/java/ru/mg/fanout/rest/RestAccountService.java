package ru.mg.fanout.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.ws.WSAccountService;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class RestAccountService {

    @Autowired
    private WSAccountService wsAccountService;

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

    public Mono<AccountsResponse> getAccountsWS(int max) {
        return Flux.fromStream(IntStream.range(1, max + 1).boxed())
                .flatMap(id -> wsAccountService.getAccountWS(id.toString()))
                .collectList()
                .map(responses -> new AccountsResponse(responses.size(), responses));
    }
}

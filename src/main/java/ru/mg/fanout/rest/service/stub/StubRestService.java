package ru.mg.fanout.rest.service.stub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.rest.model.AccountsResponse;
import ru.mg.fanout.rest.service.wc.WSSingleService;

import java.util.stream.IntStream;

@Service
public class StubRestService {

    @Autowired
    private WSSingleService wsSingleService;

    public Mono<AccountsResponse> getAccountsStub(int max) {
        return Flux.fromStream(IntStream.range(1, max + 1).boxed())
                .flatMap(id -> wsSingleService.getAccountStub(id.toString()))
                .collectList()
                .map(responses -> new AccountsResponse(responses.size(), responses));
    }

    public Flux<Account> getAccountsStubFlux(int max) {
        return Flux.fromStream(IntStream.range(1, max).boxed())
                .flatMap(id -> wsSingleService.getAccountStub(id.toString()));
    }

    public Mono<Account> getAccountStub() {
        return Mono.from(wsSingleService.getAccountStub("1"));
    }

}

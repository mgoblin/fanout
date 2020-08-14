package ru.mg.fanout.rest.service.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.mg.fanout.rest.model.AccountsResponse;

import java.util.stream.IntStream;

@Service
public class WSPackageService {

    @Autowired
    private WSSingleService wsSingleService;

    public Mono<AccountsResponse> getFastAccountsWS(int max) {
        return Flux.fromStream(IntStream.range(1, max + 1).boxed())
                .flatMap(id -> wsSingleService.getFastAccountWS(id.toString()))
                .collectList()
                .map(responses -> new AccountsResponse(responses.size(), responses));
    }

    public Mono<AccountsResponse> getDelayedAccountsWS(int max) {
        return Flux.fromStream(IntStream.range(1, max + 1).boxed())
                .flatMap(id -> wsSingleService.getDelayedAccountWS(id.toString()))
                .collectList()
                .map(responses -> new AccountsResponse(responses.size(), responses));
    }
}

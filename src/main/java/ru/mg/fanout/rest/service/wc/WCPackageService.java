package ru.mg.fanout.rest.service.wc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.mg.fanout.rest.model.AccountsResponse;

import java.util.stream.IntStream;

@Service
public class WCPackageService {
    @Autowired
    private WCSingleService wcSingleService;

    public Mono<AccountsResponse> getFastAccountsWS(int max) {
        return Flux.fromStream(IntStream.range(1, max + 1).boxed())
                .flatMap(id -> wcSingleService.getFastAccountWC(id.toString()))
                .collectList()
                .map(responses -> new AccountsResponse(responses.size(), responses));
    }

    public Mono<AccountsResponse> getDelayedAccountsWS(int max) {
        return Flux.fromStream(IntStream.range(1, max + 1).boxed())
                .flatMap(id -> wcSingleService.getDelayedAccountWC(id.toString()))
                .collectList()
                .map(responses -> new AccountsResponse(responses.size(), responses));
    }
}

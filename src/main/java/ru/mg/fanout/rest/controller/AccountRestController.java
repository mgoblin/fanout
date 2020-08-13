package ru.mg.fanout.rest.controller;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.rest.model.AccountsResponse;

public interface AccountRestController<T, TR> {
    Mono<ResponseEntity<T>> getAccount();
    Mono<ResponseEntity<TR>> getAccounts(int size);
}

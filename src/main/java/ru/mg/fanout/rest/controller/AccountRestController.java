package ru.mg.fanout.rest.controller;

import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.rest.model.AccountsResponse;

public interface AccountRestController {
    Mono<Account> getAccount();
    Mono<AccountsResponse> getAccounts(int size);
}

package ru.mg.fanout.ws;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.accountservice.EnumAccountStatus;

@Service
public class WSAccountService {

    public Mono<Account> getAccountStub(String accountNumber) {

        final Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setAccountName("Account " + accountNumber);
        account.setAccountBalance(1000);
        account.setAccountStatus(EnumAccountStatus.ACTIVE);

        return Mono.just(account);
    }

}

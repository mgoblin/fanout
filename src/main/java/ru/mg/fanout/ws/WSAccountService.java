package ru.mg.fanout.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.*;

@Service
public class WSAccountService {

    @Autowired
    @Qualifier("delayedAccountWSClient")
    private AccountService delayedAccountService;

    public Mono<Account> getAccountStub(String accountNumber) {

        final Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setAccountName("Account " + accountNumber);
        account.setAccountBalance(1000);
        account.setAccountStatus(EnumAccountStatus.ACTIVE);

        return Mono.just(account);
    }

    public Mono<Account> getDelayedAccountWS(String accountNumber) {
        AccountDetailsRequest request = new AccountDetailsRequest();
        request.setAccountNumber(accountNumber);
        Mono<AccountDetailsResponse> call = Mono.create(
                sink -> delayedAccountService.getAccountDetailsAsync(request, ReactorAsyncHandler.into(sink)));
        return call.map(AccountDetailsResponse::getAccountDetails);
    }

}

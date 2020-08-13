package ru.mg.fanout.rest.controller.wc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.rest.controller.AccountRestController;
import ru.mg.fanout.rest.model.AccountsResponse;
import ru.mg.fanout.rest.service.wc.WCRestService;

/**
 * Контроллер упрощенного вызова SOAP, не содержащего задержку ответа
 */
@RestController
@RequestMapping("/wc/fast")
public class AccountWCFastController implements AccountRestController {

    @Autowired
    private WCRestService restAccountService;

    @GetMapping(path="/single", produces = "application/json")
    public Mono<Account> getAccount() {
        return restAccountService.getFastAccountWC();
    }

    @Override
    public Mono<AccountsResponse> getAccounts(int size) {
        return null;
    }
}

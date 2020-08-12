package ru.mg.fanout.rest.controller.wc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.rest.service.wc.WCRestService;

@RestController
@RequestMapping("/wc/fast")
public class AccountWCFastController {

    @Autowired
    private WCRestService restAccountService;

    @GetMapping(path="/single", produces = "application/json")
    public Mono<Account> getAccount() {
        return restAccountService.getFastAccountWC();
    }
}

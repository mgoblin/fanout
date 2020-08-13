package ru.mg.fanout.rest.controller.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.rest.controller.AccountRestController;
import ru.mg.fanout.rest.service.ws.WSPackageService;
import ru.mg.fanout.rest.model.AccountsResponse;
import ru.mg.fanout.ws.WSAccountService;

@RestController
@RequestMapping("/ws/delayed")
public class AccountsWSDelayedController implements AccountRestController {

    @Autowired
    private WSAccountService wsAccountService;

    @Autowired
    private WSPackageService WSPackageService;

    @GetMapping(path="/single", produces = "application/json")
    public Mono<Account> getAccount() {
        return wsAccountService.getDelayedAccountWS("1")
                .onErrorResume(e -> Mono.error(
                        new ResponseStatusException(
                                HttpStatus.SERVICE_UNAVAILABLE,
                                e.getMessage())));
    }

    @GetMapping("package/{size}")
    public Mono<AccountsResponse> getAccounts(@PathVariable("size") int size) {
        return WSPackageService.getDelayedAccountsWS(size)
                .onErrorResume(e -> Mono.error(
                        new ResponseStatusException(
                                HttpStatus.SERVICE_UNAVAILABLE,
                                e.getMessage())));
    }
}

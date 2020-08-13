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
import ru.mg.fanout.rest.service.ws.WSSOAPService;
import ru.mg.fanout.rest.model.AccountsResponse;
import ru.mg.fanout.ws.WSAccountService;

@RestController
@RequestMapping("/ws/fast")
public class AccountsWSFastController {

    @Autowired
    private WSAccountService wsAccountService;

    @Autowired
    private WSSOAPService WSSOAPService;

    @GetMapping(path="/single", produces = "application/json")
    public Mono<Account> getAccount() {
        return wsAccountService.getFastAccountWS("1")
                .onErrorResume(e -> Mono.error(
                        new ResponseStatusException(
                                HttpStatus.SERVICE_UNAVAILABLE,
                                e.getMessage())));
    }

    @GetMapping("package/{size}")
    public Mono<AccountsResponse> getAccountsWS(@PathVariable("size") int size) {
        return WSSOAPService.getFastAccountsWS(size)
                .onErrorResume(e -> Mono.error(
                        new ResponseStatusException(
                                HttpStatus.SERVICE_UNAVAILABLE,
                                e.getMessage())));
    }
}

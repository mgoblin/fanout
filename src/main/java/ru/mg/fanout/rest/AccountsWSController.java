package ru.mg.fanout.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.accountservice.AccountDetailsResponse;
import ru.mg.fanout.ws.WSAccountService;

@RestController
@RequestMapping("/ws")
public class AccountsWSController {

    @Autowired
    private WSAccountService wsAccountService;

    @GetMapping(path="/single", produces = "application/json")
    public Mono<Account> getAccount() {
        return wsAccountService.getAccountWS("1")
                .onErrorResume(e -> Mono.error(
                        new ResponseStatusException(
                                HttpStatus.SERVICE_UNAVAILABLE,
                                e.getMessage())));
    }
}

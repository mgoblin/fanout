package ru.mg.fanout.rest.controller.stub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.rest.controller.AccountRestController;
import ru.mg.fanout.rest.model.AccountsResponse;
import ru.mg.fanout.rest.service.stub.StubRestService;

/**
 * Контроллер "заглушенной" реализации
 */
@RestController
@RequestMapping("/stub")
public class AccountStubController implements AccountRestController  {

    @Autowired
    private StubRestService restAccountService;

    /**
     * Получение пачки без обращения в вебсервис в виде POJO
     * @param size размер пачки
     * @return ответ с пачкой и ее размером
     */
    @GetMapping(path="/package/{size}", produces = "application/json")
    public Mono<AccountsResponse> getAccounts(@PathVariable("size") int size) {
        return restAccountService.getAccountsStub(size);
    }

    /**
     * Получение пачки без обращения в вебсервис в виде flux
     * @return пачка
     */
    @GetMapping(path="/package/flux", produces = "application/json")
    public Flux<Account> getAccountsStubFlux() {
        return restAccountService.getAccountsStubFlux(100);
    }

    /**
     * Получение единичного ответа без обращения в вебсервис и сборки пачки
     * @return ответ с одним аккаунтом
     */
    @GetMapping(path="/single", produces = "application/json")
    public Mono<Account> getAccount() {
        return restAccountService.getAccountStub();
    }
}

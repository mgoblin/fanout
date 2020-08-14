package ru.mg.fanout.rest.controller;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import ru.mg.accountservice.Account;
import ru.mg.fanout.rest.model.AccountsResponse;

/**
 * Базовый интерфейс Spring контроллера
 * @param <T> единичная сущность ответа
 * @param <TR> аггрегированный ответ на пачку
 */
public interface AccountRestController<T, TR> {
    Mono<ResponseEntity<T>> getAccount();
    Mono<ResponseEntity<TR>> getAccounts(int size);
}

package ru.mg.fanout.rest.controller.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import ru.mg.fanout.rest.model.OperationErrorResponse;

import static ru.mg.fanout.rest.controller.utils.JsonMapper.mapToString;

/**
 * Утилитный класс обработки ошибок
 */
public class ErrorHandler {
    /**
     * Метод генерации ответа с ошибкой таймаута
     *
     * @param errorMessage сообщение об ошибке
     * @return Ошибка таймаута
     */
    public static Mono<ResponseEntity<String>> timeoutResponse(String errorMessage) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .contentType(MediaType.APPLICATION_JSON)
                .body(mapToString(new OperationErrorResponse(
                        errorMessage,
                        "Flux timeout"))));
    }

    /**
     * Метод генерации ошибочного ответа
     *
     * @param errorMessage сообщение об ошибке
     * @param errorCause детализированная причина ошибки
     * @return Ошибка
     */
    public static Mono<ResponseEntity<String>> errorResponse(String errorMessage, String errorCause) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(mapToString(new OperationErrorResponse(
                        errorMessage,
                        errorCause))));
    }
}

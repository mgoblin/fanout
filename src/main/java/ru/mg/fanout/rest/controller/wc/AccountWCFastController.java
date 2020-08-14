package ru.mg.fanout.rest.controller.wc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.mg.fanout.rest.controller.AccountRestController;
import ru.mg.fanout.rest.service.wc.WCPackageService;
import ru.mg.fanout.rest.service.wc.WCRestService;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

import static ru.mg.fanout.rest.controller.utils.ErrorHandler.errorResponse;
import static ru.mg.fanout.rest.controller.utils.ErrorHandler.timeoutResponse;
import static ru.mg.fanout.rest.controller.utils.JsonMapper.mapToString;

/**
 * Контроллер упрощенного вызова SOAP, не содержащего задержку ответа
 */
@RestController
@RequestMapping("/wc/fast")
public class AccountWCFastController implements AccountRestController<String, String> {

    @Autowired
    private WCRestService restAccountService;

    @Autowired
    private WCPackageService wcPackageService;

    @GetMapping(path="/single", produces = "application/json")
    public Mono<ResponseEntity<String>> getAccount() {
        return restAccountService.getFastAccountWC("1")
                .map(acc -> ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapToString(acc)))
                .onErrorResume(
                        ExecutionException.class,
                        ex -> errorResponse("SOAP Service error", ex.getCause().getMessage()))
                .timeout(Duration.ofMillis(1000), timeoutResponse("SOAP Service timeout"));

    }

    @Override
    public Mono<ResponseEntity<String>> getAccounts(int size) {
        return Mono.empty();
    }
}

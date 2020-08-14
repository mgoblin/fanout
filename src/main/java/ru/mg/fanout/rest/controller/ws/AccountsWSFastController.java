package ru.mg.fanout.rest.controller.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.mg.fanout.rest.controller.AccountRestController;
import ru.mg.fanout.rest.service.ws.WSPackageService;
import ru.mg.fanout.rest.service.wc.WSSingleService;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

import static ru.mg.fanout.rest.controller.utils.ErrorHandler.errorResponse;
import static ru.mg.fanout.rest.controller.utils.ErrorHandler.timeoutResponse;
import static ru.mg.fanout.rest.controller.utils.JsonMapper.mapToString;

@RestController
@RequestMapping("/ws/fast")
public class AccountsWSFastController implements AccountRestController<String, String> {

    @Autowired
    private WSSingleService wsSingleService;

    @Autowired
    private WSPackageService WSPackageService;

    @GetMapping(path="/single", produces = "application/json")
    public Mono<ResponseEntity<String>> getAccount() {
        return wsSingleService.getFastAccountWS("1")
                .map(acc -> ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapToString(acc)))
                .onErrorResume(
                        ExecutionException.class,
                        ex -> errorResponse("SOAP Service error", ex.getCause().getMessage()))
                .timeout(Duration.ofMillis(1000), timeoutResponse("SOAP Service timeout"));

    }

    @GetMapping("package/{size}")
    public Mono<ResponseEntity<String>> getAccounts(@PathVariable("size") int size) {
        return WSPackageService.getFastAccountsWS(size)
                .map(acc -> ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapToString(acc)))
                .onErrorResume(
                        ExecutionException.class,
                        ex -> errorResponse("SOAP Service error", ex.getCause().getMessage()))
                .timeout(Duration.ofMillis(1000), timeoutResponse("SOAP Service timeout"));
    }
}

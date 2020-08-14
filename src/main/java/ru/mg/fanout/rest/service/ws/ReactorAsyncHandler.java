package ru.mg.fanout.rest.service.ws;

import reactor.core.publisher.MonoSink;

import javax.xml.ws.AsyncHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ReactorAsyncHandler {
    public static <T> AsyncHandler<T> into(MonoSink<T> sink) {
        return res -> {
            try {
                sink.success(res.get());
            } catch (InterruptedException | ExecutionException e) {
                sink.error(e);
            }
        };
    }
}

package ru.mg.fanout.rest.controller.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.Exceptions;

public class JsonMapper {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String mapToString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw Exceptions.propagate(e);
        }
    }
}

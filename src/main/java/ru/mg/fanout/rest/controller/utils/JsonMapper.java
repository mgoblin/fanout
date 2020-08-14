package ru.mg.fanout.rest.controller.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.Exceptions;

/**
 * Утилитный класс преобразования POJO в строку JSON.
 *
 * Обертка над Jackson ObjectMapper
 */
public class JsonMapper {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * Метод преобразования POJO в строку
     *
     * @param object POJO
     * @return строка JSON
     */
    public static String mapToString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw Exceptions.propagate(e);
        }
    }
}

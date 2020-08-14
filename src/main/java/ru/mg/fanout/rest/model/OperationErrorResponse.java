package ru.mg.fanout.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationErrorResponse {

    private final String errorMessage;
    private final String errorCause;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public OperationErrorResponse(
            @JsonProperty("errorMessage") String errorMessage,
            @JsonProperty("errorCause") String errorCause
    ) {
        this.errorMessage = errorMessage;
        this.errorCause = errorCause;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCause() {
        return errorCause;
    }
}

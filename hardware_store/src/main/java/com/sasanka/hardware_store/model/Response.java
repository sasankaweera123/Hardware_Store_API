package com.sasanka.hardware_store.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class Response {
    protected LocalDateTime timestamp;
    protected int statusCode;
    protected HttpStatus status;
    protected  String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?,?> data;
}
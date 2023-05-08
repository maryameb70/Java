package ir.mapsa.telepardaz.exceptions;

import lombok.Data;

@Data
public class ExceptionResponse {
    private String message;
    private Boolean error;
}

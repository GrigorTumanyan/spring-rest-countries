package eu.restcountries.teams.exception.handler;

import eu.restcountries.teams.exception.ResourceNotFoundException;
import eu.restcountries.teams.exception.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> onResourceNotFoundException(ResourceNotFoundException e) {
        ErrorDetail errorDetails = new ErrorDetail();

        errorDetails.setCode(404);
        errorDetails.setMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }
}

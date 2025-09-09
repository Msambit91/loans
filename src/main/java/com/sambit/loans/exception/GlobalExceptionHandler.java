package com.sambit.loans.exception;

import com.sambit.loans.dto.ErrorResponseDto;
import org.owasp.encoder.Encode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleLoanAlreadyExistsException(LoanAlreadyExistsException laee, WebRequest webRequest) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, laee.getMessage(), webRequest);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception, WebRequest webRequest) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), webRequest);
    }

    private ResponseEntity<ErrorResponseDto> buildErrorResponse(HttpStatus status, String message, WebRequest webRequest){
        String sanitizedMessage = sanitize(message);
        String sanitizedPath = sanitize(webRequest.getDescription(false));

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                sanitizedPath,
                status,
                sanitizedMessage,
                LocalDateTime.now()
        );
        return ResponseEntity.status(status).body(errorResponseDto);
    }
    private String sanitize(String input){
        return input == null ? "" : Encode.forHtmlContent(input);
    }
}

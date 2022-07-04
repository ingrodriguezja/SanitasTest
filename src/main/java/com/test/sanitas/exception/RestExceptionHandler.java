package com.test.sanitas.exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.test.sanitas.dto.ExceptionMessageDto;

@ControllerAdvice
public class RestExceptionHandler { 

	@Value("${calculator.format.date}")
	private String format;
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptionMethod(Exception ex, WebRequest requset) {

    ExceptionMessageDto exceptionMessage = new ExceptionMessageDto();
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    Date date= new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat(format);
    if(ex instanceof MethodArgumentNotValidException) {
        StringBuilder sb = new StringBuilder(); 
        List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
        for(FieldError fieldError: fieldErrors){
            sb.append(fieldError.getDefaultMessage());
            sb.append(";");
        }
        exceptionMessage.setMessage(sb.toString());
        status=HttpStatus.BAD_REQUEST;
    }else if(ex instanceof HttpMessageNotReadableException) {
        exceptionMessage.setMessage("The data entered must be numeric");
        status=HttpStatus.BAD_REQUEST;
    }
    else{
    	exceptionMessage.setMessage(ex.getLocalizedMessage());
    }
    exceptionMessage.setDate(DateFor.format(date));
    exceptionMessage.setError(ex.getClass().getCanonicalName());
    exceptionMessage.setPath(((ServletWebRequest) requset).getRequest().getServletPath());

    return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), status);
  }
}
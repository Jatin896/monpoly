package com.consilx.monopolygame.exception;
/**
 * This class is used to handle functional and other exceptions.
 */
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.consilx.monopolygame.exception.pojo.ApiError;

@RestControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(FunctionalException.class)
	/**
	 * This method is used to handle functional exception.
	 * @param ex
	 * @param request
	 * @return
	 */
	public final ResponseEntity<ApiError> handleFunctionalException(FunctionalException ex, WebRequest request) {
		ApiError errorDetails = new ApiError(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * This method is used to handle all exceptions.
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ApiError> handleAllExceptions(Exception ex, WebRequest request) {
		ApiError errorDetails = new ApiError(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

package com.bl.onboarding.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bl.onboarding.response.Response;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
public class GobalExceptionHandler{
	
	
	private static final String message = "Exception While Processing REST Request";

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Response> handelHttpMessageNotReadableException(
			HttpMessageNotReadableException exception) {
		log.error("Invalid Date Format", exception);
		Response responseDTO = new Response(message, (long)500, "Should have date in dd MM yyyy format");
		return new ResponseEntity<Response>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMessage = errorList.stream().map(objerr -> objerr.getDefaultMessage())
				.collect(Collectors.toList());

		Response responseDTO = new Response(message,(long) 404, errorMessage);
		return new ResponseEntity<Response>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundException(UserNotFoundException userNotFoundException) {
		return new ResponseEntity<String>(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UserAlreadyExistsException.class)
	public ResponseEntity<String> userAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException) {
		return new ResponseEntity<String>("User already exists", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = LoginException.class)
	public ResponseEntity<String> userAlreadyExistsException(LoginException loginException) {
		return new ResponseEntity<String>(loginException.getMessage(), HttpStatus.UNAUTHORIZED);
	}

	public ResponseEntity<Object> databaseConnectionFailsException(Exception exception) {
		return new ResponseEntity<>("DB Connection Lost", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

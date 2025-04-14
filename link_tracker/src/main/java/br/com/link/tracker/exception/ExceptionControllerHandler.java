package br.com.link.tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import br.com.link.tracker.dto.ExceptionDto;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionControllerHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFound(NotFoundException e) {
		ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
		return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> businessError(BusinessException e) {
		ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
		return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
	}

}

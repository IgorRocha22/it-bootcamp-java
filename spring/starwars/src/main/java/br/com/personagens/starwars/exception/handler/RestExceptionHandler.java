package br.com.personagens.starwars.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.personagens.starwars.dto.ErrorDTO;
import br.com.personagens.starwars.exception.BusinessRuleException;
import br.com.personagens.starwars.exception.NotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<ErrorDTO> runtimeException(RuntimeException ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDTO(ex.getMessage()));
	}

	@ExceptionHandler({ BusinessRuleException.class })
	public ResponseEntity<ErrorDTO> businessRuleException(BusinessRuleException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(ex.getMessage()));
	}

	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<ErrorDTO> notFoundException(NotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(ex.getMessage()));
	}
}

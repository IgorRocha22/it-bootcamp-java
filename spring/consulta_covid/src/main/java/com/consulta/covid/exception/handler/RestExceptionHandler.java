package com.consulta.covid.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.consulta.covid.dto.ErroDTO;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<ErroDTO> notFoundException(RuntimeException ex) {
		System.err.println(ex);
		return ResponseEntity.status(400).body(new ErroDTO(ex.getMessage()));
	}
}

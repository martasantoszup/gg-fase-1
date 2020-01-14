package br.com.backend.desafio5.desafio5;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found.")
public class ResourceNotFound extends RuntimeException {
}

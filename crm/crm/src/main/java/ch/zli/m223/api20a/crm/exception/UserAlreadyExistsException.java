package ch.zli.m223.api20a.crm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User already exists")
public class UserAlreadyExistsException extends NoTraceException {

}

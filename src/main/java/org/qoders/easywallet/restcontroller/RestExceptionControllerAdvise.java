package org.qoders.easywallet.restcontroller;

import org.qoders.easywallet.domain.JsonError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handle all RESTFUL services Exception
 * @author Nhu Trinh
 *
 */
@ControllerAdvice
public class RestExceptionControllerAdvise {
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public @ResponseBody JsonError internalServerError(Exception e) {
		return new JsonError(e);
    }
}

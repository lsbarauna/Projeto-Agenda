package br.com.barauna.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ApplicationException(String msg){
		super(msg);
	}

}

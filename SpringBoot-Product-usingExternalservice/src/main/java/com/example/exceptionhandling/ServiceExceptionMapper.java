package com.example.exceptionhandling;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.http.HttpStatus;

import com.example.api.ErrorMessage;

public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

	@Override
	public Response toResponse(ServiceException exception) {
		ErrorMessage error = new ErrorMessage();

		error.setErrorCode(exception.getStatusCode());
		error.setErrorMessage(exception.getMessage());

		StringWriter writer = new StringWriter();
		exception.printStackTrace(new PrintWriter(writer));

		return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).entity(error).type(MediaType.APPLICATION_JSON).build();
	}

}


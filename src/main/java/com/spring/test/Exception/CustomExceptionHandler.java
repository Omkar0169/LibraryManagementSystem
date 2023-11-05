package com.spring.test.Exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@SuppressWarnings("deprecation")
@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ProblemDetail handlesecurityException(Exception e) {
		
		ProblemDetail errordetails = null;
		
		if(e instanceof BadCredentialsException)
		{
			errordetails = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401),e.getMessage());
			errordetails.setProperty("access denied reason", "Wrong Username or Password !!");
		}
		
		if(e instanceof AccessDeniedException)
		{
			errordetails = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),e.getMessage());
			errordetails.setProperty("access denied reason", "Wrong Authorization or you don't have permission to access this!!");
		}
		
		if(e instanceof SignatureException)
		{
			errordetails = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),e.getMessage());
			errordetails.setProperty("access denied reason", "JWT Token is wrong !!");
		}
		
		if(e instanceof ExpiredJwtException)
		{
			errordetails = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),e.getMessage());
			errordetails.setProperty("access denied reason", "Jwt Token is expired please login again !!");
		}
		
		return errordetails;
	}
}

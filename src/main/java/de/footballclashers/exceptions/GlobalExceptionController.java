package de.footballclashers.exceptions;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.footballclashers.beans.ErrorDetail;

@ControllerAdvice(basePackages = {"de.footballclashers.controller"})
public class GlobalExceptionController extends AbstractExceptionHandler{

	@ExceptionHandler(EmailAlreadyExistedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public ErrorDetail emailAlreadyExistedException(EmailAlreadyExistedException exception) {
		String errorMessage = resourceBundle.getMessage(exception.getKeyMessage(), null, Locale.getDefault());
		errorMessage = new MessageFormat(errorMessage).format(new Object[]{exception.getExtraMesaage()});
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(errorMessage);
		return error;
	}		
	
	@ExceptionHandler(EmailNotExistedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public ErrorDetail emailNotExistedException(EmailNotExistedException exception) {
		String errorMessage = resourceBundle.getMessage(exception.getKeyMessage(), null, Locale.getDefault());
		errorMessage = new MessageFormat(errorMessage).format(new Object[]{exception.getExtraMesaage()});
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(errorMessage);
		return error;
	}
	
	@ExceptionHandler(SocialIdNotPossibleToChangeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public ErrorDetail socialIdNotPossibleToChangeException(SocialIdNotPossibleToChangeException exception) {
		String errorMessage = resourceBundle.getMessage(exception.getKeyMessage(), null, Locale.getDefault());
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(errorMessage);
		return error;
	}		
	
	@ExceptionHandler(LogInFailureException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public ErrorDetail logInFailureException(LogInFailureException exception) {
		String errorMessage = resourceBundle.getMessage(exception.getKeyMessage(), null, Locale.getDefault());
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(errorMessage);
		return error;
	}	
	
	@ExceptionHandler(CurrentPasswordNotCorrect.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public ErrorDetail currentPasswordNotCorrect(CurrentPasswordNotCorrect exception) {
		String errorMessage = resourceBundle.getMessage(exception.getKeyMessage(), null, Locale.getDefault());
		errorMessage = new MessageFormat(errorMessage).format(new Object[]{exception.getExtraMesaage()});
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(errorMessage);
		return error;
	}
}

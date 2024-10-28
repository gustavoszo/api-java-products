package br.com.api.exceptions;

public class UsernameUniqueValidationException extends RuntimeException {

    public UsernameUniqueValidationException(String msg) {
        super(msg);
    }
    
}

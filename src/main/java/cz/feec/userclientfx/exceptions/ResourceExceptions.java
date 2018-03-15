/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.feec.userclientfx.exceptions;

/**
 *
 * @author vendy
 */
public class ResourceExceptions extends Exception {

    public ResourceExceptions() {
    }

    public ResourceExceptions(String message) {
        super(message);
    }

    public ResourceExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceExceptions(Throwable cause) {
        super(cause);
    }

    public ResourceExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static class EmailAlreadyExistException extends ResourceExceptions {

        public EmailAlreadyExistException() {
        }

        public EmailAlreadyExistException(String message) {
            super(message);
        }

        public EmailAlreadyExistException(String message, Throwable cause) {
            super(message, cause);
        }

        public EmailAlreadyExistException(Throwable cause) {
            super(cause);
        }

        public EmailAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

    }

    public static class BadRequestException extends ResourceExceptions {

        public BadRequestException() {
        }

        public BadRequestException(String message) {
            super(message);
        }

        public BadRequestException(String message, Throwable cause) {
            super(message, cause);
        }

        public BadRequestException(Throwable cause) {
            super(cause);
        }

        public BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

    }

    public static class EmailNotFoundException extends ResourceExceptions {

        public EmailNotFoundException() {
        }

        public EmailNotFoundException(String message) {
            super(message);
        }

        public EmailNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public EmailNotFoundException(Throwable cause) {
            super(cause);
        }

        public EmailNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

    }

    public static class BadResourceExeption extends ResourceExceptions {

        public BadResourceExeption() {
        }

        public BadResourceExeption(String message) {
            super(message);
        }

        public BadResourceExeption(String message, Throwable cause) {
            super(message, cause);
        }

        public BadResourceExeption(Throwable cause) {
            super(cause);
        }

        public BadResourceExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

    }

    public static class BadConnectionException extends ResourceExceptions {

        public BadConnectionException() {
        }

        public BadConnectionException(String message) {
            super(message);
        }

        public BadConnectionException(String message, Throwable cause) {
            super(message, cause);
        }

        public BadConnectionException(Throwable cause) {
            super(cause);
        }

        public BadConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

    }
}

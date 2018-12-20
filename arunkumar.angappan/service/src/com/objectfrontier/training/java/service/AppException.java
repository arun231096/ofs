package com.objectfrontier.training.java.service;


class AppException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AppException(ErrorCodes Error) {

        super(new StringBuilder()
                .append(Error.getErrorCode())
                .append(" " +Error.getErrorMeggage()).toString());
    }
}
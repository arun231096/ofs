package com.objectfrontier.training.spring_view.utilities;

import java.util.ArrayList;
import java.util.List;

public class AppException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private List <ErrorCodes> errorCodes = new ArrayList<>();

    public AppException(Exception e) {
        super(e);
    }

    public AppException(List<ErrorCodes> Error) {

        super();
        this.errorCodes = Error;
    }

    public AppException(ErrorCodes Error, Throwable cause) {

        super(cause);
        this.errorCodes.add(Error);
    }

    public AppException(ErrorCodes Error) {

        super();
        this.errorCodes.add(Error);
    }

    public List<ErrorCodes> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<ErrorCodes> errorCodes) {
        this.errorCodes = errorCodes;
    }
}
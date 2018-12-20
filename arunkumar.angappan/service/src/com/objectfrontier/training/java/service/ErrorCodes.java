package com.objectfrontier.training.java.service;

public enum ErrorCodes {

    ADDRESS_FILED_EMPTY_ERROR(100, "Address Filed is empty"),
    PERSON_FILED_EMPTY_ERROR(108, "Person Filed is empty"),
    CREATE_ADDRESS_ERROR (101, "Cannot create Address"),
    ADDRESS_IDENTITFICATION_ERROR(103, "Address not exists"),
    CREATE_PERSON_ERROR(104, "Error with create Person"),
    PERSON_IDENTIFICATION(105, "Person could not found in the Database"),
    PERSON_DUPLICATE(106, "Filed have a duplicate First name and Last name"),
    PERSON_EMAIL_DUPLICATE(108, "Email duplicate"),
    DATE_FORMAT_ERROR(107, "date should be dd-mm-yyyy formatted");

    private final int errorCode;
    private final String errorMessage;

    private ErrorCodes(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }
    public String getErrorMeggage() {
        return errorMessage;
    }
}

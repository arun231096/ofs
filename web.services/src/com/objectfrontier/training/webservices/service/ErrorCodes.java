package com.objectfrontier.training.webservices.service;

public enum ErrorCodes {

    ADDRESS_FILED_EMPTY_CITY("Address city Filed is empty"),
    PERSON_FILED_FIRST_ERROR ("First name is empty"),
    PERSON_FILED_LAST_ERROR ("Last name is empty"),
    PERSON_FILED_EMAIL_ERROR ("Email is empty"),
    PERSON_FILED_DOB_ERROR ("DOB is empty"),
    PERSON_FILED_CREATED_DATE_ERROR("Created Date is empty"),
    ADDRESS_FILED_EMPTY_STREET("Address street Filed is empty"),
    ADDRESS_FILED_EMPTY_POSTAL_CODE("Address postal code Filed is empty"),
    PERSON_FILED_EMPTY_ERROR("Person Filed is empty"),
    CREATE_ADDRESS_ERROR ("Cannot create Address"),
    ADDRESS_IDENTITFICATION_ERROR("Address not exists"),
    CREATE_PERSON_ERROR("Error with create Person"),
    PERSON_IDENTIFICATION("Person could not found in the Database"),
    PERSON_DUPLICATE("Filed have a duplicate First name and Last name"),
    PERSON_EMAIL_DUPLICATE("Email duplicate"),
    DATE_FORMAT_ERROR("date should be dd-mm-yyyy formatted"),
    INTERNAL_SERVER_ERROR("Internal Server Error");

//    private final int errorCode;
    private final String errorMessage;

    private ErrorCodes(String errorMessage) {
//        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

//    public int getErrorCode() {
//        return errorCode;
//    }
    public String getErrorMeggage() {
        return errorMessage;
    }
}

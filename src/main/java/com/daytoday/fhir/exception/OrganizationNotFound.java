package com.daytoday.fhir.exception;

public class OrganizationNotFound extends RuntimeException {

    public OrganizationNotFound (String message) {
        super(message);
    }
}
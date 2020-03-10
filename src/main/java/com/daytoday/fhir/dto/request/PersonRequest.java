package com.daytoday.fhir.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class PersonRequest {

    private String firstName;

    private String lastName;

    private String gender;

    private Date birthDate;

    private String addressUse;

    private String addressType;

    private String line;

    private String city;

    private String district;

    private String state;

    private String postalCode;

    private String country;

    private String managingOrganization;
}
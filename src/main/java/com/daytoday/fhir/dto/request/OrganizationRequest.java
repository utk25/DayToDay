package com.daytoday.fhir.dto.request;

import lombok.Data;

@Data
public class OrganizationRequest {

    private String name;

    private String addressUse;

    private String addressType;

    private String line;

    private String city;

    private String district;

    private String state;

    private String postalCode;

    private String country;
}
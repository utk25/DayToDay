package com.daytoday.fhir.adapter;

import com.daytoday.fhir.dao.Address;
import com.daytoday.fhir.dto.request.OrganizationRequest;
import com.daytoday.fhir.dto.request.PersonRequest;
import com.daytoday.fhir.enums.AddressType;
import com.daytoday.fhir.enums.AddressUse;
import com.daytoday.fhir.exception.InvalidOrganizationAddressUse;
import com.daytoday.fhir.util.DynamicIdGenerator;

public class AddressModelConverter {

    public static Address getAddress(PersonRequest personRequest) {
        Address address = new Address();
        address.setIdentifier(DynamicIdGenerator.generateDynamicId());
        address.setUse(AddressUse.getByCode(personRequest.getAddressUse()));
        address.setType(AddressType.getByCode(personRequest.getAddressType()));
        address.setLine(personRequest.getLine());
        address.setCity(personRequest.getCity());
        address.setDistrict(personRequest.getDistrict());
        address.setState(personRequest.getState());
        address.setPostalCode(personRequest.getPostalCode());
        address.setCountry(personRequest.getCountry());
        return address;
    }

    public static Address getAddress(OrganizationRequest organizationRequest) {
        if (AddressUse.home.getCode().equalsIgnoreCase(organizationRequest.getAddressUse())) {
            throw new InvalidOrganizationAddressUse("Organization AddressUse can't be home type");
        }

        Address address = new Address();
        address.setIdentifier(DynamicIdGenerator.generateDynamicId());
        address.setUse(AddressUse.getByCode(organizationRequest.getAddressUse()));
        address.setType(AddressType.getByCode(organizationRequest.getAddressType()));
        address.setLine(organizationRequest.getLine());
        address.setCity(organizationRequest.getCity());
        address.setDistrict(organizationRequest.getDistrict());
        address.setState(organizationRequest.getState());
        address.setPostalCode(organizationRequest.getPostalCode());
        address.setCountry(organizationRequest.getCountry());
        return address;
    }
}
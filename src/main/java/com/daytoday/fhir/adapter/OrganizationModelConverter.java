package com.daytoday.fhir.adapter;

import com.daytoday.fhir.dao.Organization;
import com.daytoday.fhir.dto.request.OrganizationRequest;
import com.daytoday.fhir.util.DynamicIdGenerator;

public class OrganizationModelConverter {

    public static Organization convertToDomainObject(OrganizationRequest organizationRequest) {
        Organization organization = new Organization();
        organization.setIdentifier(DynamicIdGenerator.generateDynamicId());
        organization.setActive(true);
        organization.setName(organizationRequest.getName());
        organization.setAddress(AddressModelConverter.getAddress(organizationRequest));
        return organization;
    }
}
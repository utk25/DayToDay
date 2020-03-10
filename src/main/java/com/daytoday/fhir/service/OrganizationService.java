package com.daytoday.fhir.service;

import com.daytoday.fhir.adapter.OrganizationModelConverter;
import com.daytoday.fhir.dao.Organization;
import com.daytoday.fhir.dto.request.OrganizationRequest;
import com.daytoday.fhir.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private AddressService addressService;

    public String createOrganization(OrganizationRequest organizationRequest) {

        Organization organization = OrganizationModelConverter.convertToDomainObject(organizationRequest);
        addressService.saveAddress(organization.getAddress());
        organizationRepository.save(organization);
        return organization.getIdentifier();
    }
}
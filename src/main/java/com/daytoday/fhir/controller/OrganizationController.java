package com.daytoday.fhir.controller;

import com.daytoday.fhir.dto.request.OrganizationRequest;
import com.daytoday.fhir.dto.response.BaseResponse;
import com.daytoday.fhir.dto.response.CreateOrganizationResponse;
import com.daytoday.fhir.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/addOrganization")
    public ResponseEntity<BaseResponse> createPerson(@Valid @RequestBody OrganizationRequest organizationRequest) {
        String organizationId = organizationService.createOrganization(organizationRequest);
        return new ResponseEntity<>(BaseResponse.builder().data(CreateOrganizationResponse.builder()
                .organizationId(organizationId).build()).statusCode("0").build(),
                HttpStatus.OK);
    }

    public OrganizationService getOrganizationService() {
        return organizationService;
    }

    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
}
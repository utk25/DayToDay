package com.daytoday.fhir.controller;

import com.daytoday.fhir.constants.Constants;
import com.daytoday.fhir.dto.request.PersonRequest;
import com.daytoday.fhir.dto.response.BaseResponse;
import com.daytoday.fhir.dto.response.CreatePersonResponse;
import com.daytoday.fhir.dto.response.PersonOrganizationResponse;
import com.daytoday.fhir.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/api/v1/persons")
    public ResponseEntity<BaseResponse> getAllPersons() {
        PersonOrganizationResponse personOrganizationResponse = personService.getAllPersons();
        return new ResponseEntity<>(BaseResponse.builder().data(personOrganizationResponse)
                .statusCode("0").build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/addPerson")
    public ResponseEntity<BaseResponse> createPerson(@Valid @RequestBody PersonRequest personRequest) {
        String personId = personService.createPerson(personRequest);

        if (personId.equals(Constants.ORGANIZATION_NOT_FOUND) ||
                personId.equals(Constants.PERSON_SAVE_ERROR)) {
            return new ResponseEntity<>(BaseResponse.builder().data(CreatePersonResponse.builder()
                    .personId(personId).build()).statusCode("500").build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(BaseResponse.builder().data(CreatePersonResponse.builder()
                .personId(personId).build()).statusCode("200").build(),
                HttpStatus.OK);
    }

    @RequestMapping("/api/v1/person/prefix/{firstName}/suffix/{lastName}/organization/{organizationName}")
    public ResponseEntity<BaseResponse> findPerson(@PathVariable String firstName,
                                                   @PathVariable String lastName,
                                                   @PathVariable String organizationName) {
        PersonOrganizationResponse personOrganizationResponse = personService.findPerson(firstName, lastName, organizationName);
        return new ResponseEntity<>(BaseResponse.builder().data(personOrganizationResponse)
                .statusCode("200").build(), HttpStatus.OK);
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
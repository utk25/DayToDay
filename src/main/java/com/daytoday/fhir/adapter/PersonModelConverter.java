package com.daytoday.fhir.adapter;

import com.daytoday.fhir.dao.Person;
import com.daytoday.fhir.dto.request.PersonRequest;
import com.daytoday.fhir.enums.AdministrativeGender;
import com.daytoday.fhir.util.DynamicIdGenerator;

public class PersonModelConverter {
    
    public static Person convertToDomainObject(PersonRequest personRequest) {
        Person person = new Person();
        person.setIdentifier(DynamicIdGenerator.generateDynamicId());
        person.setName(HumanNameModelConverter.getHumanName(personRequest));
        person.setGender(AdministrativeGender.getByCode(personRequest.getGender()));
        person.setBirthDate(personRequest.getBirthDate());
        person.setAddress(AddressModelConverter.getAddress(personRequest));
        person.setManagingOrganization(personRequest.getManagingOrganization());
        return person;
    }
}
package com.daytoday.fhir.dto.response;

import com.daytoday.fhir.dao.Organization;
import com.daytoday.fhir.dao.Person;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonInfo {

    private Person person;

    private Organization organization;
}
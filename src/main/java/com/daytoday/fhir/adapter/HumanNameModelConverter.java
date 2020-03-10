package com.daytoday.fhir.adapter;

import com.daytoday.fhir.dao.HumanName;
import com.daytoday.fhir.dto.request.PersonRequest;
import com.daytoday.fhir.util.DynamicIdGenerator;

public class HumanNameModelConverter {

    public static HumanName getHumanName(PersonRequest personRequest) {
        HumanName humanName = new HumanName();
        humanName.setIdentifier(DynamicIdGenerator.generateDynamicId());
        humanName.setPrefix(personRequest.getFirstName());
        humanName.setSuffix(personRequest.getLastName());
        return humanName;
    }
}
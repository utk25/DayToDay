package com.daytoday.fhir.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PersonOrganizationResponse {

    private List<PersonInfo> personInfo;
}
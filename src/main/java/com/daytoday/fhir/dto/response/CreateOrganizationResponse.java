package com.daytoday.fhir.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateOrganizationResponse {

    private String organizationId;
}
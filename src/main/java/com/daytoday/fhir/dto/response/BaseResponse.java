package com.daytoday.fhir.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BaseResponse {

    private Object data;

    private String statusCode;

    private String errorMessage;

    private String displayMessage;
}
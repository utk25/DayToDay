package com.daytoday.fhir.enums;

public enum AddressUse {

    home("Home"),
    work("Work"),
    temp("Temporary"),
    old("Old/Incorrect"),
    billing("Billing");

    private String code;

    private AddressUse (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static AddressUse getByCode(String code) {
        for (AddressUse each : values()) {
            if (each.getCode().equalsIgnoreCase(code)) {
                return each;
            }
        }
        return null;
    }
}
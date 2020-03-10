package com.daytoday.fhir.enums;

public enum AddressType {

    postal("Postal"),
    physical("Physical"),
    both("Postal & Physical");

    private String code;

    private AddressType (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static AddressType getByCode(String code) {
        for (AddressType each : values()) {
            if (each.getCode().equalsIgnoreCase(code)) {
                return each;
            }
        }
        return null;
    }
}
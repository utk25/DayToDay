package com.daytoday.fhir.enums;

public enum AdministrativeGender {

    male("Male", "Male."),
    female("Female", "Female."),
    other("Other", "Other."),
    unknown("Unknown", "Unknown.");

    private String code;

    private String def;

    private AdministrativeGender (String code, String def) {
        this.code = code;
        this.def = def;
    }

    public String getCode() {
        return code;
    }

    public String getDef() {
        return def;
    }

    public static AdministrativeGender getByCode(String code) {
        for (AdministrativeGender each : values()) {
            if (each.getCode().equalsIgnoreCase(code)) {
                return each;
            }
        }
        return null;
    }

    public static AdministrativeGender getByDef(String def) {
        for (AdministrativeGender each : values()) {
            if (each.getDef().equalsIgnoreCase(def)) {
                return each;
            }
        }
        return null;
    }
}
package com.daytoday.fhir.enums;

public enum NameUse {

    usual("Usual", "0"),
    official("Offical", "0"),
    temp("Temp", "0"),
    nickname("Nickname", "0"),
    anonymous("Anonymous", "0"),
    old("Old", "0"),
    maiden("Name changed for Marriage", "1");

    private String code;

    private String lvl;

    private NameUse (String code, String lvl) {
        this.code = code;
        this.lvl = lvl;
    }

    public String getCode() {
        return code;
    }

    public String getLvl() {
        return lvl;
    }

    public static NameUse getByCode(String code) {
        for (NameUse each : values()) {
            if (each.getCode().equalsIgnoreCase(code)) {
                return each;
            }
        }
        return null;
    }

    public static NameUse getByLvl(String lvl) {
        for (NameUse each : values()) {
            if (each.getLvl().equalsIgnoreCase(lvl)) {
                return each;
            }
        }
        return null;
    }
}

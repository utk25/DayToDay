package com.daytoday.fhir.util;

import java.util.UUID;

public class DynamicIdGenerator {

    public static String generateDynamicId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
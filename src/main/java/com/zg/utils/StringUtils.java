package com.zg.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringUtils {
    private final ObjectMapper mapper = new ObjectMapper();

    private static final StringUtils INSTANCE = new StringUtils();

    private StringUtils() {
    }

    public String asString(Object o, boolean pretty) {
        String str = null;
        try {
            if (pretty) {
                str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
            } else {
                str = mapper.writeValueAsString(o);
            }
        } catch (JsonProcessingException e) {
        }
        return str;
    }

    public static String asString(Object o) {
        return INSTANCE.asString(o, false);
    }

    public static String asStringPretty(Object o) {
        return INSTANCE.asString(o, true);
    }
}

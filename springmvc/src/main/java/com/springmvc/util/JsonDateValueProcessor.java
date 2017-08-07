package com.springmvc.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("all")
public class JsonDateValueProcessor implements JsonValueProcessor {
    private String pattern = "yyyy-MM-dd";

    public JsonDateValueProcessor() {

    }

    public JsonDateValueProcessor(String pattern) {
        this.pattern = pattern;
    }

    public Object processArrayValue(Object value, JsonConfig config) {
        return process(value);
    }

    public Object processObjectValue(String key, Object value, JsonConfig config) {
        return process(value);
    }

    private Object process(Object value) {
        if (value instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format((Date) value);
        }
        return value == null ? "" : value.toString();
    }


}

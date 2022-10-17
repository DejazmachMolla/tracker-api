package com.vehicletrack.trackerapi.util;

import java.io.IOException;
import java.text.DateFormat;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
@Configuration
@Primary
public class JacksonUtils {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        mapper.setDateFormat(df);
    }

    /**
     * Convert a json string to a java object throw a runtime exception if there
     * is an error.
     *
     * @param json
     *            the json string
     * @param type
     *            the type of the java object the string should be converted
     *            into
     * @return an instance of the java object based on the json string
     *
     * @throws RuntimeException
     *             if there is an error
     *
     */
    public static <T> T fromJSON(String json, Class<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts an object to JSON or throw a runtime exception if there is a
     * problem. The generated JSON String is nicely indented to making reading
     * it easier.
     *
     * @param o
     *            the object to be converted to json
     * @return Json string representation of the object
     *
     * @throws RuntimeException
     *             if there is a conversion error
     */
    public static String toJSON(Object o) {
        try {
            String json = mapper.writeValueAsString(o);
            return json;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
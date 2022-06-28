package com.example.sportnews.web.api.controllers;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;

import java.math.BigInteger;
import java.util.Base64;
import java.util.Map;

public class TokenUtil {

    public static int getRoleFromToken(String token) {
        String bodyEncoded = token.split("\\.")[1];
        String payloadAsString = new String(Base64.getUrlDecoder().decode(bodyEncoded));

        Map<String, Object> payload = null;
        try {
            payload = new JSONParser(payloadAsString).parseObject();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return ((BigInteger) payload.get("role")).intValue();
    }

    public static int getUserFromToken(String token) {
        String bodyEncoded = token.split("\\.")[1];
        String payloadAsString = new String(Base64.getUrlDecoder().decode(bodyEncoded));

        Map<String, Object> payload = null;
        try {
            payload = new JSONParser(payloadAsString).parseObject();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return ((BigInteger) payload.get("id")).intValue();
    }
}

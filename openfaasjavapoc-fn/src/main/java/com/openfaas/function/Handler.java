package com.openfaas.function;

import java.util.Base64;
import java.util.Map;

import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;

public class Handler extends com.openfaas.model.AbstractHandler {

    public IResponse Handle(IRequest req) {
        Response res = new Response();
        try {
            Map<String, String> query = req.getQuery();
            String q = query.get("q");
            if (!q.isEmpty()) {
                String encodedString = Base64.getEncoder().encodeToString(q.getBytes());
                res.setBody("Original String = " + q + " | Encoded value = " + encodedString);
            } else {
                res.setBody("Error: Query parameter is empty or null");
            }
        } catch (Exception e) {
            res.setBody("Error: " + e.getMessage());
        }
        return res;
    }
}
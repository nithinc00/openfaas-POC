package com.openfaas.function;

import java.util.Base64;
import java.util.Map;

import com.openfaas.model.IResponse;
import com.openfaas.model.IRequest;
import com.openfaas.model.Response;

public class Handler extends com.openfaas.model.AbstractHandler {

    public IResponse Handle(IRequest req) {
        Response res = new Response();
        Map<String, String> query = req.getQuery();
        String q = query.get("q");
        String encodedString = Base64.getEncoder().encodeToString(q.getBytes());
	    res.setBody("Original String = "+q+" Encoded value = "+encodedString);
	    return res;
    }
}
package com.daugherty.dashboardbackend.util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OutboundRequestUtil {

    private static final Logger LOG = LoggerFactory.getLogger(OutboundRequestUtil.class);
    private static final String JSON_HEADER = "application/json";

    /**
     * Endpoint-agnostic HTTP POST request, used for issuing POST requests to other services
     *
     * @param endpoint String that contains the URI which we want to invoke
     * @param jsonString String of JSON-formatted paramaters.
     * @return HTTPResponse of the result, or null if an error occurs.
     */
    public HttpResponse sendPostRequestWithBody(String endpoint, String jsonString) {
        try {
            HttpResponse<String> response = Unirest.post(endpoint)
                    .header("accept", JSON_HEADER)
                    .header("Content-Type", JSON_HEADER)
                    .body(jsonString)
                    .asString();
            LOG.info("Sent POST request from RTS to the endpoint at: {}", endpoint);
            return response;
        } catch (Exception e) {
            LOG.error("Sending POST request failed", e);
            return null;
        }
    }

    /**
     * Endpoint-agnostic HTTP GET request, used for issuing GET requests to other services
     *
     * @param endpoint String that contains the URI which we want to invoke
     * @return HTTPResponse of the result, or null if an error occurs.
     */
    public HttpResponse sendGetRequest(String endpoint) {
        try {
            HttpResponse<String> response = Unirest.get(endpoint)
                    .header("accept", JSON_HEADER)
                    .asString();
            LOG.debug("response - {}", response.getBody());
            LOG.info("Sent GET request from RTS to the endpoint at: {}", endpoint);
            return response;
        } catch (Exception e) {
            LOG.error("Sending GET request failed", e);
            return null;
        }
    }
}
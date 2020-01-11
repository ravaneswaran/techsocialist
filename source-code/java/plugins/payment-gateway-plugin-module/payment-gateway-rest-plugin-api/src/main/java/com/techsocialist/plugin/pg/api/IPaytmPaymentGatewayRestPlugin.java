package com.techsocialist.plugin.pg.api;

import java.io.IOException;

public interface IPaytmPaymentGatewayRestPlugin {

    public String processPaytmRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws IOException;

}

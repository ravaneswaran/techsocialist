package com.techsocialist.plugin.pg.api;

import java.io.IOException;

public interface IPaymentGatewayRestPlugin {

    public String processRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws IOException;

}

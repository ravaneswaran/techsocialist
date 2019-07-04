package com.techsocialist.webapps.demo.paypal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class PayPalServlet extends HttpServlet {

    public static final Logger LOGGER = Logger.getLogger(PayPalServlet.class.getName());

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.logRequestDetails(request);
    }

    private void logRequestDetails(HttpServletRequest request){

        StringBuilder logStringBuilder = new StringBuilder();
        logStringBuilder.append("-------------------------------------------------+").append("\n");
        logStringBuilder.append(String.format("  Protocol Info     := %s",request.getProtocol())).append("\n");
        logStringBuilder.append(String.format("  Method Info       := %s",request.getMethod())).append("\n");
        logStringBuilder.append(String.format("  Scheme Info       := %s",request.getScheme())).append("\n");
        logStringBuilder.append(String.format("  Context Path Info := %s",request.getContextPath())).append("\n");
        logStringBuilder.append(String.format("  URI Info          := %s",request.getRequestURI())).append("\n");
        logStringBuilder.append(String.format("  Path Info         := %s",request.getPathInfo())).append("\n");

        logStringBuilder.append(String.format("  Servlet Path Info := %s",request.getServletPath())).append("\n");
        logStringBuilder.append(String.format("  Content Type Info := %s",request.getContentType())).append("\n");
        logStringBuilder.append("+------------------------------------------------------+");

        LOGGER.info(logStringBuilder.toString());
    }
}

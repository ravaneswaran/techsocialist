package com.techsocialist.controlpanel.ticketconfig.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.techsocialist.controlpanel.ticketconfig.constants.TicketTaxConfigurationPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.add-default-resource=true",
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.layout-cacheable=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=FilmTicketPriceConfiguration",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/jsp/film-ticket-tax/view.jsp",
                "javax.portlet.name=" + TicketTaxConfigurationPortletKeys.FILM_TICKET_TAX_CONFIGURATION,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",

        },
        service = Portlet.class
)
public class TicketTaxConfigurationPortlet extends MVCPortlet {
}

package com.techsocialist.controlpanel.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.techsocialist.controlpanel.constants.TicketPriceConfigurationPanelCategoryKeys;
import com.techsocialist.controlpanel.constants.TicketTaxConfigurationPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author ravaneswaran
 */
@Component(
        immediate = true,
        property = {
                "panel.app.order:Integer=100",
                "panel.category.key=" + TicketPriceConfigurationPanelCategoryKeys.CONTROL_PANEL_CATEGORY
        },
        service = PanelApp.class
)
public class TicketTaxConfigurationPanelApp extends BasePanelApp {

    @Override
    public String getPortletId() {
        return TicketTaxConfigurationPortletKeys.FILM_TICKET_TAX_CONFIGURATION;
    }

    @Override
    @Reference(
            target = "(javax.portlet.name=" + TicketTaxConfigurationPortletKeys.FILM_TICKET_TAX_CONFIGURATION + ")",
            unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }

}

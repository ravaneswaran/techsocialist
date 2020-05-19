package com.techsocialist.controlpanel.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.techsocialist.controlpanel.constants.FilmTicketPriceConfigurationPanelCategoryKeys;
import com.techsocialist.controlpanel.constants.FilmTicketPriceConfigurationPortletKeys;
import com.techsocialist.controlpanel.constants.FilmTicketTaxConfigurationPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author ravaneswaran
 */
@Component(
        immediate = true,
        property = {
                "panel.app.order:Integer=100",
                "panel.category.key=" + FilmTicketPriceConfigurationPanelCategoryKeys.CONTROL_PANEL_CATEGORY
        },
        service = PanelApp.class
)
public class FilmTicketTaxConfigurationPanelApp extends BasePanelApp {

    @Override
    public String getPortletId() {
        return FilmTicketTaxConfigurationPortletKeys.FILM_TICKET_TAX_CONFIGURATION;
    }

    @Override
    @Reference(
            target = "(javax.portlet.name=" + FilmTicketTaxConfigurationPortletKeys.FILM_TICKET_TAX_CONFIGURATION + ")",
            unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }

}

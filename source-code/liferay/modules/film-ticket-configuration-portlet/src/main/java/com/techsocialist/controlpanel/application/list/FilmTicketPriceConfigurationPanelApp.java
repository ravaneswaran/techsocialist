package com.techsocialist.controlpanel.application.list;

import com.techsocialist.controlpanel.constants.FilmTicketPriceConfigurationPanelCategoryKeys;
import com.techsocialist.controlpanel.constants.FilmTicketPriceConfigurationPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

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
public class FilmTicketPriceConfigurationPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return FilmTicketPriceConfigurationPortletKeys.FILM_TICKET_PRICE_CONFIGURATION;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + FilmTicketPriceConfigurationPortletKeys.FILM_TICKET_PRICE_CONFIGURATION + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
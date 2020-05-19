package com.techsocialist.controlpanel.application.list;

import com.techsocialist.controlpanel.constants.HostPlatformTicketShareConfigurationPanelCategoryKeys;
import com.techsocialist.controlpanel.constants.HostPlatformTicketShareConfigurationPortletKeys;

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
		"panel.category.key=" + HostPlatformTicketShareConfigurationPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class HostPlatformTicketShareConfigurationPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return HostPlatformTicketShareConfigurationPortletKeys.HOSTPLATFORMTICKETSHARECONFIGURATION;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + HostPlatformTicketShareConfigurationPortletKeys.HOSTPLATFORMTICKETSHARECONFIGURATION + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
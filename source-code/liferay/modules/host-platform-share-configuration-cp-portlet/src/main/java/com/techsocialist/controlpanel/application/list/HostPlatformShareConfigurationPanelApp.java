package com.techsocialist.controlpanel.application.list;

import com.techsocialist.controlpanel.constants.HostPlatformShareConfigurationPanelCategoryKeys;
import com.techsocialist.controlpanel.constants.HostPlatformShareConfigurationPortletKeys;

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
		"panel.category.key=" + HostPlatformShareConfigurationPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class HostPlatformShareConfigurationPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return HostPlatformShareConfigurationPortletKeys.HOSTPLATFORMSHARECONFIGURATION;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + HostPlatformShareConfigurationPortletKeys.HOSTPLATFORMSHARECONFIGURATION + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
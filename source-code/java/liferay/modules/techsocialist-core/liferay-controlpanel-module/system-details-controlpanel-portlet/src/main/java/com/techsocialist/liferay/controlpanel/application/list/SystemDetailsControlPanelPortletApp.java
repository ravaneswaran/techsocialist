package com.techsocialist.liferay.controlpanel.application.list;

import com.techsocialist.liferay.controlpanel.constants.SystemDetailsControlPanelPortletCategoryKeys;
import com.techsocialist.liferay.controlpanel.constants.SystemDetailsControlPanelPortletKeys;

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
		"panel.category.key=" + SystemDetailsControlPanelPortletCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class SystemDetailsControlPanelPortletApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return SystemDetailsControlPanelPortletKeys.SystemDetailsControlPanelPortlet;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + SystemDetailsControlPanelPortletKeys.SystemDetailsControlPanelPortlet + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
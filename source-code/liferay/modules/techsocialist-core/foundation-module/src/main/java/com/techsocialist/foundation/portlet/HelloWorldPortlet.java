package com.techsocialist.foundation.portlet;

import com.techsocialist.foundation.constants.HelloWorldPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=TS-Foundation",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Hello World",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/hello-world/view.jsp",
                "javax.portlet.name=" + HelloWorldPortletKeys.HELLO_WORLD,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class HelloWorldPortlet extends TechSocialistMVCPortlet{
}
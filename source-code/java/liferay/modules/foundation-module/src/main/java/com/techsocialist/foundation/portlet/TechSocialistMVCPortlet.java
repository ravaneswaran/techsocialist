package com.techsocialist.foundation.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class TechSocialistMVCPortlet extends MVCPortlet {

    protected Log _log;

    private ActionRequest actionRequest;

    private ActionResponse actionResponse;

    private RenderRequest renderRequest;

    private RenderResponse renderResponse;

    private ResourceRequest resourceRequest;

    private ResourceResponse resourceResponse;

    public TechSocialistMVCPortlet(){
        this._log = LogFactoryUtil.getLog(this.getClass().getName());
    }

    @Override
    public final void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
        _log.info("In processAction method...");
        this.setActionRequestAndResponse(actionRequest, actionResponse);
        super.processAction(actionRequest, actionResponse);
    }

    @Override
    public final void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
        _log.info("In serveResource method...");
        this.setResourceRequestAndResponse(resourceRequest, resourceResponse);
        super.serveResource(resourceRequest, resourceResponse);
    }

    @Override
    public final void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        _log.info("In doView method...");
        this.setRenderRequestAndResponse(renderRequest, renderResponse);
        super.doView(renderRequest, renderResponse);
    }

    @Override
    protected final void doDispatch(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        _log.info("In doDispatch method...");
        this.setRenderRequestAndResponse(renderRequest, renderResponse);
        super.doDispatch(renderRequest, renderResponse);
    }

    @Override
    protected final void doHeaders(RenderRequest renderRequest, RenderResponse renderResponse) {
        _log.info("In doHeaders method...");
        this.setRenderRequestAndResponse(renderRequest, renderResponse);
        super.doHeaders(renderRequest, renderResponse);
    }

    @Override
    public final void doAbout(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        _log.info("In doAbout method...");
        this.setRenderRequestAndResponse(renderRequest, renderResponse);
        super.doAbout(renderRequest, renderResponse);
    }

    @Override
    protected final boolean callActionMethod(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {
        _log.info("In callActionMethod method...");
        String actionName = ParamUtil.getString(
                actionRequest, ActionRequest.ACTION_NAME);

        if (Validator.isNull(actionName) ||
                actionName.equals("callActionMethod") ||
                actionName.equals("processAction")) {
            return false;
        }

        try {
            Method method = getActionMethod(actionName);

            if(0 != method.getParameterCount()){
                _log.info("TechSocialistMVCPortlet will reject all the action methods with parameters what so ever the type is.");
                return false;
            }

            if(method.getName().endsWith("Action")){
                _log.info("Make sure the action method name ends with string 'Action'");
                return false;
            }

            Class<?> classes[] = method.getExceptionTypes();
            if(null != classes || classes.length == 0){
                _log.info("Action methods defined in sub classes of TechSocialistMVCPortlet should not throw any Exceptions...");
                return false;
            }

            method.invoke(this, null);
            return true;

        } catch (NoSuchMethodException nsme) {
            try {
                super.processAction(actionRequest, actionResponse);
                return true;
            } catch (Exception e) {
                throw new PortletException(e);
            }
        } catch (InvocationTargetException ite) {
            Throwable cause = ite.getCause();
            if (cause != null) {
                throw new PortletException(cause);
            } else {
                throw new PortletException(ite);
            }
        } catch (Exception e) {
            throw new PortletException(e);
        }
    }

    private void setActionRequestAndResponse(ActionRequest actionRequest, ActionResponse actionResponse) {
        this.actionRequest = actionRequest;
        this.actionResponse = actionResponse;
    }

    private void setRenderRequestAndResponse(RenderRequest renderRequest, RenderResponse renderResponse) {
        this.renderRequest = renderRequest;
        this.renderResponse = renderResponse;
    }

    private void setResourceRequestAndResponse(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        this.resourceRequest = resourceRequest;
        this.resourceResponse = resourceResponse;
    }

    protected ActionRequest _getActionRequest() {
        return this.actionRequest;
    }

    protected ActionResponse _getActionResponse() {
        return this.actionResponse;
    }

    protected RenderRequest _getRenderRequest() {
        return this.renderRequest;
    }

    protected RenderResponse _getRenderResponse() {
        return this.renderResponse;
    }

    protected ResourceRequest _getResourceRequest() {
        return this.resourceRequest;
    }

    protected ResourceResponse _getResourceResponse() {
        return this.resourceResponse;
    }
}

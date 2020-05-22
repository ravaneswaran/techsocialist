package com.techsocialist.controlpanel.ticketconfig.service.api;

import com.liferay.portal.kernel.exception.PortalException;
import com.techsocialist.servicebuilder.model.TicketTax;

public interface TicketTaxService {

    public TicketTax addTicketTax(long percent, String userFullName);

    public TicketTax deleteTicketTax(long id) throws PortalException;

    public int deleteTicketTax(TicketTax ticketTax) throws PortalException;

}

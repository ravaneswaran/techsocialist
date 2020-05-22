package com.techsocialist.controlpanel.ticketconfig.service.api;

import com.liferay.portal.kernel.exception.PortalException;
import com.techsocialist.servicebuilder.model.TicketPrice;

public interface TicketPriceService {

    public TicketPrice addTicketPrice(long ticketPrice, String userFullName);

    public TicketPrice deleteTicketPrice(long id) throws PortalException;

    public int deleteTicketPrice(TicketPrice ticketPrice) throws PortalException;

}

package com.techsocialist.controlpanel.ticketconfig.service.impl;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.techsocialist.controlpanel.ticketconfig.service.api.TicketPriceService;
import com.techsocialist.servicebuilder.model.TicketPrice;
import com.techsocialist.servicebuilder.service.TicketPriceLocalService;
import org.osgi.service.component.annotations.Component;

import javax.inject.Inject;
import java.util.Date;

@Component(immediate = true, service = TicketPriceService.class)
public class TicketPriceServiceImpl implements TicketPriceService {

    @Inject
    private TicketPriceLocalService _ticketPriceLocalService;

    @Inject
    private CounterLocalService _counterLocalService;

    @Override
    public TicketPrice addTicketPrice(long price, String userFullName) {
        long id = _counterLocalService.increment(TicketPrice.class.getName());
        TicketPrice ticketPrice = _ticketPriceLocalService.createTicketPrice(id);

        ticketPrice.setPrice(price);
        ticketPrice.setCreatedBy(userFullName);
        ticketPrice.setModifiedBy(userFullName);
        ticketPrice.setCreatedDate(new Date());
        ticketPrice.setModifiedDate(new Date());

        return _ticketPriceLocalService.addTicketPrice(ticketPrice);
    }

    @Override
    public TicketPrice deleteTicketPrice(long id) throws PortalException {
        return _ticketPriceLocalService.deleteTicketPrice(id);
    }

    @Override
    public int deleteTicketPrice(TicketPrice ticketPrice) throws PortalException {
        TicketPrice theTicketPrice = _ticketPriceLocalService.deleteTicketPrice(ticketPrice);
        return null != theTicketPrice ? 0 : -1;
    }
}

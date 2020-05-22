package com.techsocialist.controlpanel.ticketconfig.service.impl;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.techsocialist.controlpanel.ticketconfig.service.api.TicketTaxService;
import com.techsocialist.servicebuilder.model.TicketTax;
import com.techsocialist.servicebuilder.service.TicketTaxLocalService;
import org.osgi.service.component.annotations.Component;

import javax.inject.Inject;
import java.util.Date;

@Component(immediate = true, service = TicketTaxService.class)
public class TicketTaxServiceImpl implements TicketTaxService {

    @Inject
    private CounterLocalService _counterLocalService;

    @Inject
    private TicketTaxLocalService _ticketTaxLocalService;

    @Override
    public TicketTax addTicketTax(long percent, String userFullName) {
        long id = _counterLocalService.increment(TicketTax.class.getName());

        TicketTax ticketTax = _ticketTaxLocalService.createTicketTax(id);
        ticketTax.setCreatedBy(userFullName);
        ticketTax.setModifiedBy(userFullName);
        ticketTax.setCreatedDate(new Date());
        ticketTax.setModifiedDate(new Date());

        return _ticketTaxLocalService.addTicketTax(ticketTax);
    }

    @Override
    public TicketTax deleteTicketTax(long id) throws PortalException {
        return _ticketTaxLocalService.deleteTicketTax(id);
    }

    @Override
    public int deleteTicketTax(TicketTax ticketTax) throws PortalException {
        TicketTax theTicketTax = _ticketTaxLocalService.deleteTicketTax(ticketTax);
        return null != theTicketTax ? 0 : -1;
    }
}

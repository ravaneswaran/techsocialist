/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.techsocialist.servicebuilder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TicketTaxLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketTaxLocalService
 * @generated
 */
public class TicketTaxLocalServiceWrapper
	implements ServiceWrapper<TicketTaxLocalService>, TicketTaxLocalService {

	public TicketTaxLocalServiceWrapper(
		TicketTaxLocalService ticketTaxLocalService) {

		_ticketTaxLocalService = ticketTaxLocalService;
	}

	/**
	 * Adds the ticket tax to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketTax the ticket tax
	 * @return the ticket tax that was added
	 */
	@Override
	public com.techsocialist.servicebuilder.model.TicketTax addTicketTax(
		com.techsocialist.servicebuilder.model.TicketTax ticketTax) {

		return _ticketTaxLocalService.addTicketTax(ticketTax);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketTaxLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new ticket tax with the primary key. Does not add the ticket tax to the database.
	 *
	 * @param id the primary key for the new ticket tax
	 * @return the new ticket tax
	 */
	@Override
	public com.techsocialist.servicebuilder.model.TicketTax createTicketTax(
		long id) {

		return _ticketTaxLocalService.createTicketTax(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketTaxLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ticket tax with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ticket tax
	 * @return the ticket tax that was removed
	 * @throws PortalException if a ticket tax with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.TicketTax deleteTicketTax(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketTaxLocalService.deleteTicketTax(id);
	}

	/**
	 * Deletes the ticket tax from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketTax the ticket tax
	 * @return the ticket tax that was removed
	 */
	@Override
	public com.techsocialist.servicebuilder.model.TicketTax deleteTicketTax(
		com.techsocialist.servicebuilder.model.TicketTax ticketTax) {

		return _ticketTaxLocalService.deleteTicketTax(ticketTax);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketTaxLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ticketTaxLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.TicketTaxModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ticketTaxLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.TicketTaxModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ticketTaxLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ticketTaxLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _ticketTaxLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.techsocialist.servicebuilder.model.TicketTax fetchTicketTax(
		long id) {

		return _ticketTaxLocalService.fetchTicketTax(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketTaxLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketTaxLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketTaxLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketTaxLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ticket tax with the primary key.
	 *
	 * @param id the primary key of the ticket tax
	 * @return the ticket tax
	 * @throws PortalException if a ticket tax with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.TicketTax getTicketTax(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketTaxLocalService.getTicketTax(id);
	}

	/**
	 * Returns a range of all the ticket taxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.TicketTaxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket taxs
	 * @param end the upper bound of the range of ticket taxs (not inclusive)
	 * @return the range of ticket taxs
	 */
	@Override
	public java.util.List<com.techsocialist.servicebuilder.model.TicketTax>
		getTicketTaxs(int start, int end) {

		return _ticketTaxLocalService.getTicketTaxs(start, end);
	}

	/**
	 * Returns the number of ticket taxs.
	 *
	 * @return the number of ticket taxs
	 */
	@Override
	public int getTicketTaxsCount() {
		return _ticketTaxLocalService.getTicketTaxsCount();
	}

	/**
	 * Updates the ticket tax in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketTax the ticket tax
	 * @return the ticket tax that was updated
	 */
	@Override
	public com.techsocialist.servicebuilder.model.TicketTax updateTicketTax(
		com.techsocialist.servicebuilder.model.TicketTax ticketTax) {

		return _ticketTaxLocalService.updateTicketTax(ticketTax);
	}

	@Override
	public TicketTaxLocalService getWrappedService() {
		return _ticketTaxLocalService;
	}

	@Override
	public void setWrappedService(TicketTaxLocalService ticketTaxLocalService) {
		_ticketTaxLocalService = ticketTaxLocalService;
	}

	private TicketTaxLocalService _ticketTaxLocalService;

}
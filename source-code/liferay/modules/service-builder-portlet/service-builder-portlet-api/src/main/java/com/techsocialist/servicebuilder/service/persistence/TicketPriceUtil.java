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

package com.techsocialist.servicebuilder.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.techsocialist.servicebuilder.model.TicketPrice;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket price service. This utility wraps <code>com.techsocialist.servicebuilder.service.persistence.impl.TicketPricePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketPricePersistence
 * @generated
 */
public class TicketPriceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TicketPrice ticketPrice) {
		getPersistence().clearCache(ticketPrice);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TicketPrice> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketPrice> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketPrice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketPrice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketPrice> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketPrice update(TicketPrice ticketPrice) {
		return getPersistence().update(ticketPrice);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketPrice update(
		TicketPrice ticketPrice, ServiceContext serviceContext) {

		return getPersistence().update(ticketPrice, serviceContext);
	}

	/**
	 * Caches the ticket price in the entity cache if it is enabled.
	 *
	 * @param ticketPrice the ticket price
	 */
	public static void cacheResult(TicketPrice ticketPrice) {
		getPersistence().cacheResult(ticketPrice);
	}

	/**
	 * Caches the ticket prices in the entity cache if it is enabled.
	 *
	 * @param ticketPrices the ticket prices
	 */
	public static void cacheResult(List<TicketPrice> ticketPrices) {
		getPersistence().cacheResult(ticketPrices);
	}

	/**
	 * Creates a new ticket price with the primary key. Does not add the ticket price to the database.
	 *
	 * @param id the primary key for the new ticket price
	 * @return the new ticket price
	 */
	public static TicketPrice create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the ticket price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ticket price
	 * @return the ticket price that was removed
	 * @throws NoSuchTicketPriceException if a ticket price with the primary key could not be found
	 */
	public static TicketPrice remove(long id)
		throws com.techsocialist.servicebuilder.exception.
			NoSuchTicketPriceException {

		return getPersistence().remove(id);
	}

	public static TicketPrice updateImpl(TicketPrice ticketPrice) {
		return getPersistence().updateImpl(ticketPrice);
	}

	/**
	 * Returns the ticket price with the primary key or throws a <code>NoSuchTicketPriceException</code> if it could not be found.
	 *
	 * @param id the primary key of the ticket price
	 * @return the ticket price
	 * @throws NoSuchTicketPriceException if a ticket price with the primary key could not be found
	 */
	public static TicketPrice findByPrimaryKey(long id)
		throws com.techsocialist.servicebuilder.exception.
			NoSuchTicketPriceException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the ticket price with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ticket price
	 * @return the ticket price, or <code>null</code> if a ticket price with the primary key could not be found
	 */
	public static TicketPrice fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the ticket prices.
	 *
	 * @return the ticket prices
	 */
	public static List<TicketPrice> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketPriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket prices
	 * @param end the upper bound of the range of ticket prices (not inclusive)
	 * @return the range of ticket prices
	 */
	public static List<TicketPrice> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketPriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket prices
	 * @param end the upper bound of the range of ticket prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket prices
	 */
	public static List<TicketPrice> findAll(
		int start, int end, OrderByComparator<TicketPrice> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketPriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket prices
	 * @param end the upper bound of the range of ticket prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket prices
	 */
	public static List<TicketPrice> findAll(
		int start, int end, OrderByComparator<TicketPrice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket prices from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket prices.
	 *
	 * @return the number of ticket prices
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketPricePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketPricePersistence, TicketPricePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TicketPricePersistence.class);

		ServiceTracker<TicketPricePersistence, TicketPricePersistence>
			serviceTracker =
				new ServiceTracker
					<TicketPricePersistence, TicketPricePersistence>(
						bundle.getBundleContext(), TicketPricePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
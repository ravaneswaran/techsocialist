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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.techsocialist.servicebuilder.exception.NoSuchTicketPriceException;
import com.techsocialist.servicebuilder.model.TicketPrice;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ticket price service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketPriceUtil
 * @generated
 */
@ProviderType
public interface TicketPricePersistence extends BasePersistence<TicketPrice> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketPriceUtil} to access the ticket price persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the ticket price in the entity cache if it is enabled.
	 *
	 * @param ticketPrice the ticket price
	 */
	public void cacheResult(TicketPrice ticketPrice);

	/**
	 * Caches the ticket prices in the entity cache if it is enabled.
	 *
	 * @param ticketPrices the ticket prices
	 */
	public void cacheResult(java.util.List<TicketPrice> ticketPrices);

	/**
	 * Creates a new ticket price with the primary key. Does not add the ticket price to the database.
	 *
	 * @param id the primary key for the new ticket price
	 * @return the new ticket price
	 */
	public TicketPrice create(long id);

	/**
	 * Removes the ticket price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ticket price
	 * @return the ticket price that was removed
	 * @throws NoSuchTicketPriceException if a ticket price with the primary key could not be found
	 */
	public TicketPrice remove(long id) throws NoSuchTicketPriceException;

	public TicketPrice updateImpl(TicketPrice ticketPrice);

	/**
	 * Returns the ticket price with the primary key or throws a <code>NoSuchTicketPriceException</code> if it could not be found.
	 *
	 * @param id the primary key of the ticket price
	 * @return the ticket price
	 * @throws NoSuchTicketPriceException if a ticket price with the primary key could not be found
	 */
	public TicketPrice findByPrimaryKey(long id)
		throws NoSuchTicketPriceException;

	/**
	 * Returns the ticket price with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ticket price
	 * @return the ticket price, or <code>null</code> if a ticket price with the primary key could not be found
	 */
	public TicketPrice fetchByPrimaryKey(long id);

	/**
	 * Returns all the ticket prices.
	 *
	 * @return the ticket prices
	 */
	public java.util.List<TicketPrice> findAll();

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
	public java.util.List<TicketPrice> findAll(int start, int end);

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
	public java.util.List<TicketPrice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketPrice>
			orderByComparator);

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
	public java.util.List<TicketPrice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketPrice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ticket prices from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket prices.
	 *
	 * @return the number of ticket prices
	 */
	public int countAll();

}
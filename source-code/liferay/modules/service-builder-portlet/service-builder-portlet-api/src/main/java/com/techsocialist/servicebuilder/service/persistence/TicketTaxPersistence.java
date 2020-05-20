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

import com.techsocialist.servicebuilder.exception.NoSuchTicketTaxException;
import com.techsocialist.servicebuilder.model.TicketTax;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ticket tax service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketTaxUtil
 * @generated
 */
@ProviderType
public interface TicketTaxPersistence extends BasePersistence<TicketTax> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketTaxUtil} to access the ticket tax persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the ticket tax in the entity cache if it is enabled.
	 *
	 * @param ticketTax the ticket tax
	 */
	public void cacheResult(TicketTax ticketTax);

	/**
	 * Caches the ticket taxs in the entity cache if it is enabled.
	 *
	 * @param ticketTaxs the ticket taxs
	 */
	public void cacheResult(java.util.List<TicketTax> ticketTaxs);

	/**
	 * Creates a new ticket tax with the primary key. Does not add the ticket tax to the database.
	 *
	 * @param id the primary key for the new ticket tax
	 * @return the new ticket tax
	 */
	public TicketTax create(long id);

	/**
	 * Removes the ticket tax with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ticket tax
	 * @return the ticket tax that was removed
	 * @throws NoSuchTicketTaxException if a ticket tax with the primary key could not be found
	 */
	public TicketTax remove(long id) throws NoSuchTicketTaxException;

	public TicketTax updateImpl(TicketTax ticketTax);

	/**
	 * Returns the ticket tax with the primary key or throws a <code>NoSuchTicketTaxException</code> if it could not be found.
	 *
	 * @param id the primary key of the ticket tax
	 * @return the ticket tax
	 * @throws NoSuchTicketTaxException if a ticket tax with the primary key could not be found
	 */
	public TicketTax findByPrimaryKey(long id) throws NoSuchTicketTaxException;

	/**
	 * Returns the ticket tax with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ticket tax
	 * @return the ticket tax, or <code>null</code> if a ticket tax with the primary key could not be found
	 */
	public TicketTax fetchByPrimaryKey(long id);

	/**
	 * Returns all the ticket taxs.
	 *
	 * @return the ticket taxs
	 */
	public java.util.List<TicketTax> findAll();

	/**
	 * Returns a range of all the ticket taxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketTaxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket taxs
	 * @param end the upper bound of the range of ticket taxs (not inclusive)
	 * @return the range of ticket taxs
	 */
	public java.util.List<TicketTax> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ticket taxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketTaxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket taxs
	 * @param end the upper bound of the range of ticket taxs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket taxs
	 */
	public java.util.List<TicketTax> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketTax>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket taxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketTaxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket taxs
	 * @param end the upper bound of the range of ticket taxs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket taxs
	 */
	public java.util.List<TicketTax> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketTax>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ticket taxs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket taxs.
	 *
	 * @return the number of ticket taxs
	 */
	public int countAll();

}
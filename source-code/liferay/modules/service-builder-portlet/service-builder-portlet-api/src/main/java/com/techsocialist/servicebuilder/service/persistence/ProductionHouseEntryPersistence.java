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

import com.techsocialist.servicebuilder.exception.NoSuchProductionHouseEntryException;
import com.techsocialist.servicebuilder.model.ProductionHouseEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the production house entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouseEntryUtil
 * @generated
 */
@ProviderType
public interface ProductionHouseEntryPersistence
	extends BasePersistence<ProductionHouseEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductionHouseEntryUtil} to access the production house entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the production house entry in the entity cache if it is enabled.
	 *
	 * @param productionHouseEntry the production house entry
	 */
	public void cacheResult(ProductionHouseEntry productionHouseEntry);

	/**
	 * Caches the production house entries in the entity cache if it is enabled.
	 *
	 * @param productionHouseEntries the production house entries
	 */
	public void cacheResult(
		java.util.List<ProductionHouseEntry> productionHouseEntries);

	/**
	 * Creates a new production house entry with the primary key. Does not add the production house entry to the database.
	 *
	 * @param id the primary key for the new production house entry
	 * @return the new production house entry
	 */
	public ProductionHouseEntry create(long id);

	/**
	 * Removes the production house entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house entry
	 * @return the production house entry that was removed
	 * @throws NoSuchProductionHouseEntryException if a production house entry with the primary key could not be found
	 */
	public ProductionHouseEntry remove(long id)
		throws NoSuchProductionHouseEntryException;

	public ProductionHouseEntry updateImpl(
		ProductionHouseEntry productionHouseEntry);

	/**
	 * Returns the production house entry with the primary key or throws a <code>NoSuchProductionHouseEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the production house entry
	 * @return the production house entry
	 * @throws NoSuchProductionHouseEntryException if a production house entry with the primary key could not be found
	 */
	public ProductionHouseEntry findByPrimaryKey(long id)
		throws NoSuchProductionHouseEntryException;

	/**
	 * Returns the production house entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the production house entry
	 * @return the production house entry, or <code>null</code> if a production house entry with the primary key could not be found
	 */
	public ProductionHouseEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the production house entries.
	 *
	 * @return the production house entries
	 */
	public java.util.List<ProductionHouseEntry> findAll();

	/**
	 * Returns a range of all the production house entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house entries
	 * @param end the upper bound of the range of production house entries (not inclusive)
	 * @return the range of production house entries
	 */
	public java.util.List<ProductionHouseEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the production house entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house entries
	 * @param end the upper bound of the range of production house entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of production house entries
	 */
	public java.util.List<ProductionHouseEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductionHouseEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the production house entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house entries
	 * @param end the upper bound of the range of production house entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of production house entries
	 */
	public java.util.List<ProductionHouseEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductionHouseEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the production house entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of production house entries.
	 *
	 * @return the number of production house entries
	 */
	public int countAll();

}
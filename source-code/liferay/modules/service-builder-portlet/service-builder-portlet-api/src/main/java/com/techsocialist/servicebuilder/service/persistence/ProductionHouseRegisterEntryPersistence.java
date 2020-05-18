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

import com.techsocialist.servicebuilder.exception.NoSuchProductionHouseRegisterEntryException;
import com.techsocialist.servicebuilder.model.ProductionHouseRegisterEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the production house register entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouseRegisterEntryUtil
 * @generated
 */
@ProviderType
public interface ProductionHouseRegisterEntryPersistence
	extends BasePersistence<ProductionHouseRegisterEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductionHouseRegisterEntryUtil} to access the production house register entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the production house register entry in the entity cache if it is enabled.
	 *
	 * @param productionHouseRegisterEntry the production house register entry
	 */
	public void cacheResult(
		ProductionHouseRegisterEntry productionHouseRegisterEntry);

	/**
	 * Caches the production house register entries in the entity cache if it is enabled.
	 *
	 * @param productionHouseRegisterEntries the production house register entries
	 */
	public void cacheResult(
		java.util.List<ProductionHouseRegisterEntry>
			productionHouseRegisterEntries);

	/**
	 * Creates a new production house register entry with the primary key. Does not add the production house register entry to the database.
	 *
	 * @param id the primary key for the new production house register entry
	 * @return the new production house register entry
	 */
	public ProductionHouseRegisterEntry create(long id);

	/**
	 * Removes the production house register entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house register entry
	 * @return the production house register entry that was removed
	 * @throws NoSuchProductionHouseRegisterEntryException if a production house register entry with the primary key could not be found
	 */
	public ProductionHouseRegisterEntry remove(long id)
		throws NoSuchProductionHouseRegisterEntryException;

	public ProductionHouseRegisterEntry updateImpl(
		ProductionHouseRegisterEntry productionHouseRegisterEntry);

	/**
	 * Returns the production house register entry with the primary key or throws a <code>NoSuchProductionHouseRegisterEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the production house register entry
	 * @return the production house register entry
	 * @throws NoSuchProductionHouseRegisterEntryException if a production house register entry with the primary key could not be found
	 */
	public ProductionHouseRegisterEntry findByPrimaryKey(long id)
		throws NoSuchProductionHouseRegisterEntryException;

	/**
	 * Returns the production house register entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the production house register entry
	 * @return the production house register entry, or <code>null</code> if a production house register entry with the primary key could not be found
	 */
	public ProductionHouseRegisterEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the production house register entries.
	 *
	 * @return the production house register entries
	 */
	public java.util.List<ProductionHouseRegisterEntry> findAll();

	/**
	 * Returns a range of all the production house register entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseRegisterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house register entries
	 * @param end the upper bound of the range of production house register entries (not inclusive)
	 * @return the range of production house register entries
	 */
	public java.util.List<ProductionHouseRegisterEntry> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the production house register entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseRegisterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house register entries
	 * @param end the upper bound of the range of production house register entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of production house register entries
	 */
	public java.util.List<ProductionHouseRegisterEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductionHouseRegisterEntry> orderByComparator);

	/**
	 * Returns an ordered range of all the production house register entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseRegisterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house register entries
	 * @param end the upper bound of the range of production house register entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of production house register entries
	 */
	public java.util.List<ProductionHouseRegisterEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductionHouseRegisterEntry> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the production house register entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of production house register entries.
	 *
	 * @return the number of production house register entries
	 */
	public int countAll();

}
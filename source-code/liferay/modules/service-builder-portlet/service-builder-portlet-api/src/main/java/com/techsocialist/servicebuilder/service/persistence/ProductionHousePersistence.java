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

import com.techsocialist.servicebuilder.exception.NoSuchProductionHouseException;
import com.techsocialist.servicebuilder.model.ProductionHouse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the production house service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouseUtil
 * @generated
 */
@ProviderType
public interface ProductionHousePersistence
	extends BasePersistence<ProductionHouse> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductionHouseUtil} to access the production house persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the production house in the entity cache if it is enabled.
	 *
	 * @param productionHouse the production house
	 */
	public void cacheResult(ProductionHouse productionHouse);

	/**
	 * Caches the production houses in the entity cache if it is enabled.
	 *
	 * @param productionHouses the production houses
	 */
	public void cacheResult(java.util.List<ProductionHouse> productionHouses);

	/**
	 * Creates a new production house with the primary key. Does not add the production house to the database.
	 *
	 * @param id the primary key for the new production house
	 * @return the new production house
	 */
	public ProductionHouse create(long id);

	/**
	 * Removes the production house with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house
	 * @return the production house that was removed
	 * @throws NoSuchProductionHouseException if a production house with the primary key could not be found
	 */
	public ProductionHouse remove(long id)
		throws NoSuchProductionHouseException;

	public ProductionHouse updateImpl(ProductionHouse productionHouse);

	/**
	 * Returns the production house with the primary key or throws a <code>NoSuchProductionHouseException</code> if it could not be found.
	 *
	 * @param id the primary key of the production house
	 * @return the production house
	 * @throws NoSuchProductionHouseException if a production house with the primary key could not be found
	 */
	public ProductionHouse findByPrimaryKey(long id)
		throws NoSuchProductionHouseException;

	/**
	 * Returns the production house with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the production house
	 * @return the production house, or <code>null</code> if a production house with the primary key could not be found
	 */
	public ProductionHouse fetchByPrimaryKey(long id);

	/**
	 * Returns all the production houses.
	 *
	 * @return the production houses
	 */
	public java.util.List<ProductionHouse> findAll();

	/**
	 * Returns a range of all the production houses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production houses
	 * @param end the upper bound of the range of production houses (not inclusive)
	 * @return the range of production houses
	 */
	public java.util.List<ProductionHouse> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the production houses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production houses
	 * @param end the upper bound of the range of production houses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of production houses
	 */
	public java.util.List<ProductionHouse> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductionHouse>
			orderByComparator);

	/**
	 * Returns an ordered range of all the production houses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production houses
	 * @param end the upper bound of the range of production houses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of production houses
	 */
	public java.util.List<ProductionHouse> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductionHouse>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the production houses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of production houses.
	 *
	 * @return the number of production houses
	 */
	public int countAll();

}
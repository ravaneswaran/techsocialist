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

package com.techsocialis.servicebuilder.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.techsocialis.servicebuilder.exception.NoSuchProductionHouseRegisterException;
import com.techsocialis.servicebuilder.model.ProductionHouseRegister;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the production house register service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouseRegisterUtil
 * @generated
 */
@ProviderType
public interface ProductionHouseRegisterPersistence
	extends BasePersistence<ProductionHouseRegister> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductionHouseRegisterUtil} to access the production house register persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the production house register in the entity cache if it is enabled.
	 *
	 * @param productionHouseRegister the production house register
	 */
	public void cacheResult(ProductionHouseRegister productionHouseRegister);

	/**
	 * Caches the production house registers in the entity cache if it is enabled.
	 *
	 * @param productionHouseRegisters the production house registers
	 */
	public void cacheResult(
		java.util.List<ProductionHouseRegister> productionHouseRegisters);

	/**
	 * Creates a new production house register with the primary key. Does not add the production house register to the database.
	 *
	 * @param id the primary key for the new production house register
	 * @return the new production house register
	 */
	public ProductionHouseRegister create(long id);

	/**
	 * Removes the production house register with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house register
	 * @return the production house register that was removed
	 * @throws NoSuchProductionHouseRegisterException if a production house register with the primary key could not be found
	 */
	public ProductionHouseRegister remove(long id)
		throws NoSuchProductionHouseRegisterException;

	public ProductionHouseRegister updateImpl(
		ProductionHouseRegister productionHouseRegister);

	/**
	 * Returns the production house register with the primary key or throws a <code>NoSuchProductionHouseRegisterException</code> if it could not be found.
	 *
	 * @param id the primary key of the production house register
	 * @return the production house register
	 * @throws NoSuchProductionHouseRegisterException if a production house register with the primary key could not be found
	 */
	public ProductionHouseRegister findByPrimaryKey(long id)
		throws NoSuchProductionHouseRegisterException;

	/**
	 * Returns the production house register with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the production house register
	 * @return the production house register, or <code>null</code> if a production house register with the primary key could not be found
	 */
	public ProductionHouseRegister fetchByPrimaryKey(long id);

	/**
	 * Returns all the production house registers.
	 *
	 * @return the production house registers
	 */
	public java.util.List<ProductionHouseRegister> findAll();

	/**
	 * Returns a range of all the production house registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house registers
	 * @param end the upper bound of the range of production house registers (not inclusive)
	 * @return the range of production house registers
	 */
	public java.util.List<ProductionHouseRegister> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the production house registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house registers
	 * @param end the upper bound of the range of production house registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of production house registers
	 */
	public java.util.List<ProductionHouseRegister> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductionHouseRegister> orderByComparator);

	/**
	 * Returns an ordered range of all the production house registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house registers
	 * @param end the upper bound of the range of production house registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of production house registers
	 */
	public java.util.List<ProductionHouseRegister> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProductionHouseRegister> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the production house registers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of production house registers.
	 *
	 * @return the number of production house registers
	 */
	public int countAll();

}
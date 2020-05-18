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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.techsocialis.servicebuilder.model.ProductionHouseRegister;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the production house register service. This utility wraps <code>com.techsocialis.servicebuilder.service.persistence.impl.ProductionHouseRegisterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouseRegisterPersistence
 * @generated
 */
public class ProductionHouseRegisterUtil {

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
	public static void clearCache(
		ProductionHouseRegister productionHouseRegister) {

		getPersistence().clearCache(productionHouseRegister);
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
	public static Map<Serializable, ProductionHouseRegister> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductionHouseRegister> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductionHouseRegister> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductionHouseRegister> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductionHouseRegister> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductionHouseRegister update(
		ProductionHouseRegister productionHouseRegister) {

		return getPersistence().update(productionHouseRegister);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductionHouseRegister update(
		ProductionHouseRegister productionHouseRegister,
		ServiceContext serviceContext) {

		return getPersistence().update(productionHouseRegister, serviceContext);
	}

	/**
	 * Caches the production house register in the entity cache if it is enabled.
	 *
	 * @param productionHouseRegister the production house register
	 */
	public static void cacheResult(
		ProductionHouseRegister productionHouseRegister) {

		getPersistence().cacheResult(productionHouseRegister);
	}

	/**
	 * Caches the production house registers in the entity cache if it is enabled.
	 *
	 * @param productionHouseRegisters the production house registers
	 */
	public static void cacheResult(
		List<ProductionHouseRegister> productionHouseRegisters) {

		getPersistence().cacheResult(productionHouseRegisters);
	}

	/**
	 * Creates a new production house register with the primary key. Does not add the production house register to the database.
	 *
	 * @param id the primary key for the new production house register
	 * @return the new production house register
	 */
	public static ProductionHouseRegister create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the production house register with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house register
	 * @return the production house register that was removed
	 * @throws NoSuchProductionHouseRegisterException if a production house register with the primary key could not be found
	 */
	public static ProductionHouseRegister remove(long id)
		throws com.techsocialis.servicebuilder.exception.
			NoSuchProductionHouseRegisterException {

		return getPersistence().remove(id);
	}

	public static ProductionHouseRegister updateImpl(
		ProductionHouseRegister productionHouseRegister) {

		return getPersistence().updateImpl(productionHouseRegister);
	}

	/**
	 * Returns the production house register with the primary key or throws a <code>NoSuchProductionHouseRegisterException</code> if it could not be found.
	 *
	 * @param id the primary key of the production house register
	 * @return the production house register
	 * @throws NoSuchProductionHouseRegisterException if a production house register with the primary key could not be found
	 */
	public static ProductionHouseRegister findByPrimaryKey(long id)
		throws com.techsocialis.servicebuilder.exception.
			NoSuchProductionHouseRegisterException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the production house register with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the production house register
	 * @return the production house register, or <code>null</code> if a production house register with the primary key could not be found
	 */
	public static ProductionHouseRegister fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the production house registers.
	 *
	 * @return the production house registers
	 */
	public static List<ProductionHouseRegister> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProductionHouseRegister> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProductionHouseRegister> findAll(
		int start, int end,
		OrderByComparator<ProductionHouseRegister> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProductionHouseRegister> findAll(
		int start, int end,
		OrderByComparator<ProductionHouseRegister> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the production house registers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of production house registers.
	 *
	 * @return the number of production house registers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductionHouseRegisterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProductionHouseRegisterPersistence, ProductionHouseRegisterPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProductionHouseRegisterPersistence.class);

		ServiceTracker
			<ProductionHouseRegisterPersistence,
			 ProductionHouseRegisterPersistence> serviceTracker =
				new ServiceTracker
					<ProductionHouseRegisterPersistence,
					 ProductionHouseRegisterPersistence>(
						 bundle.getBundleContext(),
						 ProductionHouseRegisterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
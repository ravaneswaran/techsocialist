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

package com.techsocialis.servicebuilder.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ProductionHouseRegister. This utility wraps
 * <code>com.techsocialis.servicebuilder.service.impl.ProductionHouseRegisterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouseRegisterLocalService
 * @generated
 */
public class ProductionHouseRegisterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.techsocialis.servicebuilder.service.impl.ProductionHouseRegisterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the production house register to the database. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseRegister the production house register
	 * @return the production house register that was added
	 */
	public static com.techsocialis.servicebuilder.model.ProductionHouseRegister
		addProductionHouseRegister(
			com.techsocialis.servicebuilder.model.ProductionHouseRegister
				productionHouseRegister) {

		return getService().addProductionHouseRegister(productionHouseRegister);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new production house register with the primary key. Does not add the production house register to the database.
	 *
	 * @param id the primary key for the new production house register
	 * @return the new production house register
	 */
	public static com.techsocialis.servicebuilder.model.ProductionHouseRegister
		createProductionHouseRegister(long id) {

		return getService().createProductionHouseRegister(id);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the production house register with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house register
	 * @return the production house register that was removed
	 * @throws PortalException if a production house register with the primary key could not be found
	 */
	public static com.techsocialis.servicebuilder.model.ProductionHouseRegister
			deleteProductionHouseRegister(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteProductionHouseRegister(id);
	}

	/**
	 * Deletes the production house register from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseRegister the production house register
	 * @return the production house register that was removed
	 */
	public static com.techsocialis.servicebuilder.model.ProductionHouseRegister
		deleteProductionHouseRegister(
			com.techsocialis.servicebuilder.model.ProductionHouseRegister
				productionHouseRegister) {

		return getService().deleteProductionHouseRegister(
			productionHouseRegister);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialis.servicebuilder.model.impl.ProductionHouseRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialis.servicebuilder.model.impl.ProductionHouseRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.techsocialis.servicebuilder.model.ProductionHouseRegister
		fetchProductionHouseRegister(long id) {

		return getService().fetchProductionHouseRegister(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the production house register with the primary key.
	 *
	 * @param id the primary key of the production house register
	 * @return the production house register
	 * @throws PortalException if a production house register with the primary key could not be found
	 */
	public static com.techsocialis.servicebuilder.model.ProductionHouseRegister
			getProductionHouseRegister(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProductionHouseRegister(id);
	}

	/**
	 * Returns a range of all the production house registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialis.servicebuilder.model.impl.ProductionHouseRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house registers
	 * @param end the upper bound of the range of production house registers (not inclusive)
	 * @return the range of production house registers
	 */
	public static java.util.List
		<com.techsocialis.servicebuilder.model.ProductionHouseRegister>
			getProductionHouseRegisters(int start, int end) {

		return getService().getProductionHouseRegisters(start, end);
	}

	/**
	 * Returns the number of production house registers.
	 *
	 * @return the number of production house registers
	 */
	public static int getProductionHouseRegistersCount() {
		return getService().getProductionHouseRegistersCount();
	}

	/**
	 * Updates the production house register in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseRegister the production house register
	 * @return the production house register that was updated
	 */
	public static com.techsocialis.servicebuilder.model.ProductionHouseRegister
		updateProductionHouseRegister(
			com.techsocialis.servicebuilder.model.ProductionHouseRegister
				productionHouseRegister) {

		return getService().updateProductionHouseRegister(
			productionHouseRegister);
	}

	public static ProductionHouseRegisterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProductionHouseRegisterLocalService,
		 ProductionHouseRegisterLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProductionHouseRegisterLocalService.class);

		ServiceTracker
			<ProductionHouseRegisterLocalService,
			 ProductionHouseRegisterLocalService> serviceTracker =
				new ServiceTracker
					<ProductionHouseRegisterLocalService,
					 ProductionHouseRegisterLocalService>(
						 bundle.getBundleContext(),
						 ProductionHouseRegisterLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
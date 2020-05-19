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
 * Provides a wrapper for {@link ProductionHouseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouseLocalService
 * @generated
 */
public class ProductionHouseLocalServiceWrapper
	implements ProductionHouseLocalService,
			   ServiceWrapper<ProductionHouseLocalService> {

	public ProductionHouseLocalServiceWrapper(
		ProductionHouseLocalService productionHouseLocalService) {

		_productionHouseLocalService = productionHouseLocalService;
	}

	/**
	 * Adds the production house to the database. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouse the production house
	 * @return the production house that was added
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouse
		addProductionHouse(
			com.techsocialist.servicebuilder.model.ProductionHouse
				productionHouse) {

		return _productionHouseLocalService.addProductionHouse(productionHouse);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new production house with the primary key. Does not add the production house to the database.
	 *
	 * @param id the primary key for the new production house
	 * @return the new production house
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouse
		createProductionHouse(long id) {

		return _productionHouseLocalService.createProductionHouse(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the production house with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house
	 * @return the production house that was removed
	 * @throws PortalException if a production house with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouse
			deleteProductionHouse(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseLocalService.deleteProductionHouse(id);
	}

	/**
	 * Deletes the production house from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouse the production house
	 * @return the production house that was removed
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouse
		deleteProductionHouse(
			com.techsocialist.servicebuilder.model.ProductionHouse
				productionHouse) {

		return _productionHouseLocalService.deleteProductionHouse(
			productionHouse);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productionHouseLocalService.dynamicQuery();
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

		return _productionHouseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.ProductionHouseModelImpl</code>.
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

		return _productionHouseLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.ProductionHouseModelImpl</code>.
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

		return _productionHouseLocalService.dynamicQuery(
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

		return _productionHouseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _productionHouseLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouse
		fetchProductionHouse(long id) {

		return _productionHouseLocalService.fetchProductionHouse(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productionHouseLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouseBannerBlobModel
		getBannerBlobModel(java.io.Serializable primaryKey) {

		return _productionHouseLocalService.getBannerBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productionHouseLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouseLogoBlobModel
		getLogoBlobModel(java.io.Serializable primaryKey) {

		return _productionHouseLocalService.getLogoBlobModel(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productionHouseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the production house with the primary key.
	 *
	 * @param id the primary key of the production house
	 * @return the production house
	 * @throws PortalException if a production house with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouse
			getProductionHouse(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseLocalService.getProductionHouse(id);
	}

	/**
	 * Returns a range of all the production houses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.ProductionHouseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production houses
	 * @param end the upper bound of the range of production houses (not inclusive)
	 * @return the range of production houses
	 */
	@Override
	public java.util.List
		<com.techsocialist.servicebuilder.model.ProductionHouse>
			getProductionHouses(int start, int end) {

		return _productionHouseLocalService.getProductionHouses(start, end);
	}

	/**
	 * Returns the number of production houses.
	 *
	 * @return the number of production houses
	 */
	@Override
	public int getProductionHousesCount() {
		return _productionHouseLocalService.getProductionHousesCount();
	}

	@Override
	public java.io.InputStream openBannerInputStream(long id) {
		return _productionHouseLocalService.openBannerInputStream(id);
	}

	@Override
	public java.io.InputStream openLogoInputStream(long id) {
		return _productionHouseLocalService.openLogoInputStream(id);
	}

	/**
	 * Updates the production house in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouse the production house
	 * @return the production house that was updated
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouse
		updateProductionHouse(
			com.techsocialist.servicebuilder.model.ProductionHouse
				productionHouse) {

		return _productionHouseLocalService.updateProductionHouse(
			productionHouse);
	}

	@Override
	public ProductionHouseLocalService getWrappedService() {
		return _productionHouseLocalService;
	}

	@Override
	public void setWrappedService(
		ProductionHouseLocalService productionHouseLocalService) {

		_productionHouseLocalService = productionHouseLocalService;
	}

	private ProductionHouseLocalService _productionHouseLocalService;

}
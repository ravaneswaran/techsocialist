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
 * Provides a wrapper for {@link ProductionHouseEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouseEntryLocalService
 * @generated
 */
public class ProductionHouseEntryLocalServiceWrapper
	implements ProductionHouseEntryLocalService,
			   ServiceWrapper<ProductionHouseEntryLocalService> {

	public ProductionHouseEntryLocalServiceWrapper(
		ProductionHouseEntryLocalService productionHouseEntryLocalService) {

		_productionHouseEntryLocalService = productionHouseEntryLocalService;
	}

	/**
	 * Adds the production house entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseEntry the production house entry
	 * @return the production house entry that was added
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouseEntry
		addProductionHouseEntry(
			com.techsocialist.servicebuilder.model.ProductionHouseEntry
				productionHouseEntry) {

		return _productionHouseEntryLocalService.addProductionHouseEntry(
			productionHouseEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new production house entry with the primary key. Does not add the production house entry to the database.
	 *
	 * @param id the primary key for the new production house entry
	 * @return the new production house entry
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouseEntry
		createProductionHouseEntry(long id) {

		return _productionHouseEntryLocalService.createProductionHouseEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the production house entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house entry
	 * @return the production house entry that was removed
	 * @throws PortalException if a production house entry with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouseEntry
			deleteProductionHouseEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseEntryLocalService.deleteProductionHouseEntry(id);
	}

	/**
	 * Deletes the production house entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseEntry the production house entry
	 * @return the production house entry that was removed
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouseEntry
		deleteProductionHouseEntry(
			com.techsocialist.servicebuilder.model.ProductionHouseEntry
				productionHouseEntry) {

		return _productionHouseEntryLocalService.deleteProductionHouseEntry(
			productionHouseEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productionHouseEntryLocalService.dynamicQuery();
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

		return _productionHouseEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.ProductionHouseEntryModelImpl</code>.
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

		return _productionHouseEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.ProductionHouseEntryModelImpl</code>.
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

		return _productionHouseEntryLocalService.dynamicQuery(
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

		return _productionHouseEntryLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _productionHouseEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouseEntry
		fetchProductionHouseEntry(long id) {

		return _productionHouseEntryLocalService.fetchProductionHouseEntry(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productionHouseEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productionHouseEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productionHouseEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the production house entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.ProductionHouseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house entries
	 * @param end the upper bound of the range of production house entries (not inclusive)
	 * @return the range of production house entries
	 */
	@Override
	public java.util.List
		<com.techsocialist.servicebuilder.model.ProductionHouseEntry>
			getProductionHouseEntries(int start, int end) {

		return _productionHouseEntryLocalService.getProductionHouseEntries(
			start, end);
	}

	/**
	 * Returns the number of production house entries.
	 *
	 * @return the number of production house entries
	 */
	@Override
	public int getProductionHouseEntriesCount() {
		return _productionHouseEntryLocalService.
			getProductionHouseEntriesCount();
	}

	/**
	 * Returns the production house entry with the primary key.
	 *
	 * @param id the primary key of the production house entry
	 * @return the production house entry
	 * @throws PortalException if a production house entry with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouseEntry
			getProductionHouseEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseEntryLocalService.getProductionHouseEntry(id);
	}

	/**
	 * Updates the production house entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseEntry the production house entry
	 * @return the production house entry that was updated
	 */
	@Override
	public com.techsocialist.servicebuilder.model.ProductionHouseEntry
		updateProductionHouseEntry(
			com.techsocialist.servicebuilder.model.ProductionHouseEntry
				productionHouseEntry) {

		return _productionHouseEntryLocalService.updateProductionHouseEntry(
			productionHouseEntry);
	}

	@Override
	public ProductionHouseEntryLocalService getWrappedService() {
		return _productionHouseEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ProductionHouseEntryLocalService productionHouseEntryLocalService) {

		_productionHouseEntryLocalService = productionHouseEntryLocalService;
	}

	private ProductionHouseEntryLocalService _productionHouseEntryLocalService;

}
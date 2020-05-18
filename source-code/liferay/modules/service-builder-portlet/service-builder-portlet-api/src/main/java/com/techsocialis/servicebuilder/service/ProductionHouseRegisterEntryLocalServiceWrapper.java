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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductionHouseRegisterEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouseRegisterEntryLocalService
 * @generated
 */
public class ProductionHouseRegisterEntryLocalServiceWrapper
	implements ProductionHouseRegisterEntryLocalService,
			   ServiceWrapper<ProductionHouseRegisterEntryLocalService> {

	public ProductionHouseRegisterEntryLocalServiceWrapper(
		ProductionHouseRegisterEntryLocalService
			productionHouseRegisterEntryLocalService) {

		_productionHouseRegisterEntryLocalService =
			productionHouseRegisterEntryLocalService;
	}

	/**
	 * Adds the production house register entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseRegisterEntry the production house register entry
	 * @return the production house register entry that was added
	 */
	@Override
	public com.techsocialis.servicebuilder.model.ProductionHouseRegisterEntry
		addProductionHouseRegisterEntry(
			com.techsocialis.servicebuilder.model.ProductionHouseRegisterEntry
				productionHouseRegisterEntry) {

		return _productionHouseRegisterEntryLocalService.
			addProductionHouseRegisterEntry(productionHouseRegisterEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseRegisterEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new production house register entry with the primary key. Does not add the production house register entry to the database.
	 *
	 * @param id the primary key for the new production house register entry
	 * @return the new production house register entry
	 */
	@Override
	public com.techsocialis.servicebuilder.model.ProductionHouseRegisterEntry
		createProductionHouseRegisterEntry(long id) {

		return _productionHouseRegisterEntryLocalService.
			createProductionHouseRegisterEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseRegisterEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the production house register entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house register entry
	 * @return the production house register entry that was removed
	 * @throws PortalException if a production house register entry with the primary key could not be found
	 */
	@Override
	public com.techsocialis.servicebuilder.model.ProductionHouseRegisterEntry
			deleteProductionHouseRegisterEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseRegisterEntryLocalService.
			deleteProductionHouseRegisterEntry(id);
	}

	/**
	 * Deletes the production house register entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseRegisterEntry the production house register entry
	 * @return the production house register entry that was removed
	 */
	@Override
	public com.techsocialis.servicebuilder.model.ProductionHouseRegisterEntry
		deleteProductionHouseRegisterEntry(
			com.techsocialis.servicebuilder.model.ProductionHouseRegisterEntry
				productionHouseRegisterEntry) {

		return _productionHouseRegisterEntryLocalService.
			deleteProductionHouseRegisterEntry(productionHouseRegisterEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productionHouseRegisterEntryLocalService.dynamicQuery();
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

		return _productionHouseRegisterEntryLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialis.servicebuilder.model.impl.ProductionHouseRegisterEntryModelImpl</code>.
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

		return _productionHouseRegisterEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialis.servicebuilder.model.impl.ProductionHouseRegisterEntryModelImpl</code>.
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

		return _productionHouseRegisterEntryLocalService.dynamicQuery(
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

		return _productionHouseRegisterEntryLocalService.dynamicQueryCount(
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

		return _productionHouseRegisterEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.techsocialis.servicebuilder.model.ProductionHouseRegisterEntry
		fetchProductionHouseRegisterEntry(long id) {

		return _productionHouseRegisterEntryLocalService.
			fetchProductionHouseRegisterEntry(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productionHouseRegisterEntryLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productionHouseRegisterEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productionHouseRegisterEntryLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseRegisterEntryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the production house register entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialis.servicebuilder.model.impl.ProductionHouseRegisterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house register entries
	 * @param end the upper bound of the range of production house register entries (not inclusive)
	 * @return the range of production house register entries
	 */
	@Override
	public java.util.List
		<com.techsocialis.servicebuilder.model.ProductionHouseRegisterEntry>
			getProductionHouseRegisterEntries(int start, int end) {

		return _productionHouseRegisterEntryLocalService.
			getProductionHouseRegisterEntries(start, end);
	}

	/**
	 * Returns the number of production house register entries.
	 *
	 * @return the number of production house register entries
	 */
	@Override
	public int getProductionHouseRegisterEntriesCount() {
		return _productionHouseRegisterEntryLocalService.
			getProductionHouseRegisterEntriesCount();
	}

	/**
	 * Returns the production house register entry with the primary key.
	 *
	 * @param id the primary key of the production house register entry
	 * @return the production house register entry
	 * @throws PortalException if a production house register entry with the primary key could not be found
	 */
	@Override
	public com.techsocialis.servicebuilder.model.ProductionHouseRegisterEntry
			getProductionHouseRegisterEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productionHouseRegisterEntryLocalService.
			getProductionHouseRegisterEntry(id);
	}

	/**
	 * Updates the production house register entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseRegisterEntry the production house register entry
	 * @return the production house register entry that was updated
	 */
	@Override
	public com.techsocialis.servicebuilder.model.ProductionHouseRegisterEntry
		updateProductionHouseRegisterEntry(
			com.techsocialis.servicebuilder.model.ProductionHouseRegisterEntry
				productionHouseRegisterEntry) {

		return _productionHouseRegisterEntryLocalService.
			updateProductionHouseRegisterEntry(productionHouseRegisterEntry);
	}

	@Override
	public ProductionHouseRegisterEntryLocalService getWrappedService() {
		return _productionHouseRegisterEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ProductionHouseRegisterEntryLocalService
			productionHouseRegisterEntryLocalService) {

		_productionHouseRegisterEntryLocalService =
			productionHouseRegisterEntryLocalService;
	}

	private ProductionHouseRegisterEntryLocalService
		_productionHouseRegisterEntryLocalService;

}
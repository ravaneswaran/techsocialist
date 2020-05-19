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
 * Provides a wrapper for {@link PosterEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PosterEntryLocalService
 * @generated
 */
public class PosterEntryLocalServiceWrapper
	implements PosterEntryLocalService,
			   ServiceWrapper<PosterEntryLocalService> {

	public PosterEntryLocalServiceWrapper(
		PosterEntryLocalService posterEntryLocalService) {

		_posterEntryLocalService = posterEntryLocalService;
	}

	/**
	 * Adds the poster entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param posterEntry the poster entry
	 * @return the poster entry that was added
	 */
	@Override
	public com.techsocialist.servicebuilder.model.PosterEntry addPosterEntry(
		com.techsocialist.servicebuilder.model.PosterEntry posterEntry) {

		return _posterEntryLocalService.addPosterEntry(posterEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _posterEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new poster entry with the primary key. Does not add the poster entry to the database.
	 *
	 * @param id the primary key for the new poster entry
	 * @return the new poster entry
	 */
	@Override
	public com.techsocialist.servicebuilder.model.PosterEntry createPosterEntry(
		long id) {

		return _posterEntryLocalService.createPosterEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _posterEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the poster entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the poster entry
	 * @return the poster entry that was removed
	 * @throws PortalException if a poster entry with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.PosterEntry deletePosterEntry(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _posterEntryLocalService.deletePosterEntry(id);
	}

	/**
	 * Deletes the poster entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param posterEntry the poster entry
	 * @return the poster entry that was removed
	 */
	@Override
	public com.techsocialist.servicebuilder.model.PosterEntry deletePosterEntry(
		com.techsocialist.servicebuilder.model.PosterEntry posterEntry) {

		return _posterEntryLocalService.deletePosterEntry(posterEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _posterEntryLocalService.dynamicQuery();
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

		return _posterEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.PosterEntryModelImpl</code>.
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

		return _posterEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.PosterEntryModelImpl</code>.
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

		return _posterEntryLocalService.dynamicQuery(
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

		return _posterEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _posterEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.techsocialist.servicebuilder.model.PosterEntry fetchPosterEntry(
		long id) {

		return _posterEntryLocalService.fetchPosterEntry(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _posterEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.techsocialist.servicebuilder.model.PosterEntryContentBlobModel
		getContentBlobModel(java.io.Serializable primaryKey) {

		return _posterEntryLocalService.getContentBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _posterEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _posterEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _posterEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the poster entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.PosterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of poster entries
	 * @param end the upper bound of the range of poster entries (not inclusive)
	 * @return the range of poster entries
	 */
	@Override
	public java.util.List<com.techsocialist.servicebuilder.model.PosterEntry>
		getPosterEntries(int start, int end) {

		return _posterEntryLocalService.getPosterEntries(start, end);
	}

	/**
	 * Returns the number of poster entries.
	 *
	 * @return the number of poster entries
	 */
	@Override
	public int getPosterEntriesCount() {
		return _posterEntryLocalService.getPosterEntriesCount();
	}

	/**
	 * Returns the poster entry with the primary key.
	 *
	 * @param id the primary key of the poster entry
	 * @return the poster entry
	 * @throws PortalException if a poster entry with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.PosterEntry getPosterEntry(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _posterEntryLocalService.getPosterEntry(id);
	}

	@Override
	public java.io.InputStream openContentInputStream(long id) {
		return _posterEntryLocalService.openContentInputStream(id);
	}

	/**
	 * Updates the poster entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param posterEntry the poster entry
	 * @return the poster entry that was updated
	 */
	@Override
	public com.techsocialist.servicebuilder.model.PosterEntry updatePosterEntry(
		com.techsocialist.servicebuilder.model.PosterEntry posterEntry) {

		return _posterEntryLocalService.updatePosterEntry(posterEntry);
	}

	@Override
	public PosterEntryLocalService getWrappedService() {
		return _posterEntryLocalService;
	}

	@Override
	public void setWrappedService(
		PosterEntryLocalService posterEntryLocalService) {

		_posterEntryLocalService = posterEntryLocalService;
	}

	private PosterEntryLocalService _posterEntryLocalService;

}
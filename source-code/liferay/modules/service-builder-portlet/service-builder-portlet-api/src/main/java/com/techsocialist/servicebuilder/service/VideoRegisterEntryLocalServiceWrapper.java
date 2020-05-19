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
 * Provides a wrapper for {@link VideoRegisterEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VideoRegisterEntryLocalService
 * @generated
 */
public class VideoRegisterEntryLocalServiceWrapper
	implements ServiceWrapper<VideoRegisterEntryLocalService>,
			   VideoRegisterEntryLocalService {

	public VideoRegisterEntryLocalServiceWrapper(
		VideoRegisterEntryLocalService videoRegisterEntryLocalService) {

		_videoRegisterEntryLocalService = videoRegisterEntryLocalService;
	}

	/**
	 * Adds the video register entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoRegisterEntry the video register entry
	 * @return the video register entry that was added
	 */
	@Override
	public com.techsocialist.servicebuilder.model.VideoRegisterEntry
		addVideoRegisterEntry(
			com.techsocialist.servicebuilder.model.VideoRegisterEntry
				videoRegisterEntry) {

		return _videoRegisterEntryLocalService.addVideoRegisterEntry(
			videoRegisterEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videoRegisterEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new video register entry with the primary key. Does not add the video register entry to the database.
	 *
	 * @param id the primary key for the new video register entry
	 * @return the new video register entry
	 */
	@Override
	public com.techsocialist.servicebuilder.model.VideoRegisterEntry
		createVideoRegisterEntry(long id) {

		return _videoRegisterEntryLocalService.createVideoRegisterEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videoRegisterEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the video register entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the video register entry
	 * @return the video register entry that was removed
	 * @throws PortalException if a video register entry with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.VideoRegisterEntry
			deleteVideoRegisterEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videoRegisterEntryLocalService.deleteVideoRegisterEntry(id);
	}

	/**
	 * Deletes the video register entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoRegisterEntry the video register entry
	 * @return the video register entry that was removed
	 */
	@Override
	public com.techsocialist.servicebuilder.model.VideoRegisterEntry
		deleteVideoRegisterEntry(
			com.techsocialist.servicebuilder.model.VideoRegisterEntry
				videoRegisterEntry) {

		return _videoRegisterEntryLocalService.deleteVideoRegisterEntry(
			videoRegisterEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _videoRegisterEntryLocalService.dynamicQuery();
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

		return _videoRegisterEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.VideoRegisterEntryModelImpl</code>.
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

		return _videoRegisterEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.VideoRegisterEntryModelImpl</code>.
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

		return _videoRegisterEntryLocalService.dynamicQuery(
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

		return _videoRegisterEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _videoRegisterEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.techsocialist.servicebuilder.model.VideoRegisterEntry
		fetchVideoRegisterEntry(long id) {

		return _videoRegisterEntryLocalService.fetchVideoRegisterEntry(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _videoRegisterEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public
		com.techsocialist.servicebuilder.model.
			VideoRegisterEntryContentBlobModel getContentBlobModel(
				java.io.Serializable primaryKey) {

		return _videoRegisterEntryLocalService.getContentBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _videoRegisterEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _videoRegisterEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videoRegisterEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the video register entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.VideoRegisterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video register entries
	 * @param end the upper bound of the range of video register entries (not inclusive)
	 * @return the range of video register entries
	 */
	@Override
	public java.util.List
		<com.techsocialist.servicebuilder.model.VideoRegisterEntry>
			getVideoRegisterEntries(int start, int end) {

		return _videoRegisterEntryLocalService.getVideoRegisterEntries(
			start, end);
	}

	/**
	 * Returns the number of video register entries.
	 *
	 * @return the number of video register entries
	 */
	@Override
	public int getVideoRegisterEntriesCount() {
		return _videoRegisterEntryLocalService.getVideoRegisterEntriesCount();
	}

	/**
	 * Returns the video register entry with the primary key.
	 *
	 * @param id the primary key of the video register entry
	 * @return the video register entry
	 * @throws PortalException if a video register entry with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.VideoRegisterEntry
			getVideoRegisterEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videoRegisterEntryLocalService.getVideoRegisterEntry(id);
	}

	@Override
	public java.io.InputStream openContentInputStream(long id) {
		return _videoRegisterEntryLocalService.openContentInputStream(id);
	}

	/**
	 * Updates the video register entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param videoRegisterEntry the video register entry
	 * @return the video register entry that was updated
	 */
	@Override
	public com.techsocialist.servicebuilder.model.VideoRegisterEntry
		updateVideoRegisterEntry(
			com.techsocialist.servicebuilder.model.VideoRegisterEntry
				videoRegisterEntry) {

		return _videoRegisterEntryLocalService.updateVideoRegisterEntry(
			videoRegisterEntry);
	}

	@Override
	public VideoRegisterEntryLocalService getWrappedService() {
		return _videoRegisterEntryLocalService;
	}

	@Override
	public void setWrappedService(
		VideoRegisterEntryLocalService videoRegisterEntryLocalService) {

		_videoRegisterEntryLocalService = videoRegisterEntryLocalService;
	}

	private VideoRegisterEntryLocalService _videoRegisterEntryLocalService;

}
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
 * Provides a wrapper for {@link VideoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VideoLocalService
 * @generated
 */
public class VideoLocalServiceWrapper
	implements ServiceWrapper<VideoLocalService>, VideoLocalService {

	public VideoLocalServiceWrapper(VideoLocalService videoLocalService) {
		_videoLocalService = videoLocalService;
	}

	/**
	 * Adds the video to the database. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was added
	 */
	@Override
	public com.techsocialist.servicebuilder.model.Video addVideo(
		com.techsocialist.servicebuilder.model.Video video) {

		return _videoLocalService.addVideo(video);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param id the primary key for the new video
	 * @return the new video
	 */
	@Override
	public com.techsocialist.servicebuilder.model.Video createVideo(long id) {
		return _videoLocalService.createVideo(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the video
	 * @return the video that was removed
	 * @throws PortalException if a video with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.Video deleteVideo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videoLocalService.deleteVideo(id);
	}

	/**
	 * Deletes the video from the database. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was removed
	 */
	@Override
	public com.techsocialist.servicebuilder.model.Video deleteVideo(
		com.techsocialist.servicebuilder.model.Video video) {

		return _videoLocalService.deleteVideo(video);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _videoLocalService.dynamicQuery();
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

		return _videoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.VideoModelImpl</code>.
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

		return _videoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.VideoModelImpl</code>.
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

		return _videoLocalService.dynamicQuery(
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

		return _videoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _videoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.techsocialist.servicebuilder.model.Video fetchVideo(long id) {
		return _videoLocalService.fetchVideo(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _videoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.techsocialist.servicebuilder.model.VideoContentBlobModel
		getContentBlobModel(java.io.Serializable primaryKey) {

		return _videoLocalService.getContentBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _videoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _videoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videoLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.techsocialist.servicebuilder.model.VideoThumbnailBlobModel
		getThumbnailBlobModel(java.io.Serializable primaryKey) {

		return _videoLocalService.getThumbnailBlobModel(primaryKey);
	}

	/**
	 * Returns the video with the primary key.
	 *
	 * @param id the primary key of the video
	 * @return the video
	 * @throws PortalException if a video with the primary key could not be found
	 */
	@Override
	public com.techsocialist.servicebuilder.model.Video getVideo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _videoLocalService.getVideo(id);
	}

	/**
	 * Returns a range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.VideoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of videos
	 */
	@Override
	public java.util.List<com.techsocialist.servicebuilder.model.Video>
		getVideos(int start, int end) {

		return _videoLocalService.getVideos(start, end);
	}

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	@Override
	public int getVideosCount() {
		return _videoLocalService.getVideosCount();
	}

	@Override
	public java.io.InputStream openContentInputStream(long id) {
		return _videoLocalService.openContentInputStream(id);
	}

	@Override
	public java.io.InputStream openThumbnailInputStream(long id) {
		return _videoLocalService.openThumbnailInputStream(id);
	}

	/**
	 * Updates the video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was updated
	 */
	@Override
	public com.techsocialist.servicebuilder.model.Video updateVideo(
		com.techsocialist.servicebuilder.model.Video video) {

		return _videoLocalService.updateVideo(video);
	}

	@Override
	public VideoLocalService getWrappedService() {
		return _videoLocalService;
	}

	@Override
	public void setWrappedService(VideoLocalService videoLocalService) {
		_videoLocalService = videoLocalService;
	}

	private VideoLocalService _videoLocalService;

}
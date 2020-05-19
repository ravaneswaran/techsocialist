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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Video. This utility wraps
 * <code>com.techsocialist.servicebuilder.service.impl.VideoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see VideoLocalService
 * @generated
 */
public class VideoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.techsocialist.servicebuilder.service.impl.VideoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the video to the database. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was added
	 */
	public static com.techsocialist.servicebuilder.model.Video addVideo(
		com.techsocialist.servicebuilder.model.Video video) {

		return getService().addVideo(video);
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
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param id the primary key for the new video
	 * @return the new video
	 */
	public static com.techsocialist.servicebuilder.model.Video createVideo(
		long id) {

		return getService().createVideo(id);
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
	 * Deletes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the video
	 * @return the video that was removed
	 * @throws PortalException if a video with the primary key could not be found
	 */
	public static com.techsocialist.servicebuilder.model.Video deleteVideo(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteVideo(id);
	}

	/**
	 * Deletes the video from the database. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was removed
	 */
	public static com.techsocialist.servicebuilder.model.Video deleteVideo(
		com.techsocialist.servicebuilder.model.Video video) {

		return getService().deleteVideo(video);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.VideoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.VideoModelImpl</code>.
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

	public static com.techsocialist.servicebuilder.model.Video fetchVideo(
		long id) {

		return getService().fetchVideo(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.techsocialist.servicebuilder.model.VideoContentBlobModel
		getContentBlobModel(java.io.Serializable primaryKey) {

		return getService().getContentBlobModel(primaryKey);
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

	public static com.techsocialist.servicebuilder.model.VideoThumbnailBlobModel
		getThumbnailBlobModel(java.io.Serializable primaryKey) {

		return getService().getThumbnailBlobModel(primaryKey);
	}

	/**
	 * Returns the video with the primary key.
	 *
	 * @param id the primary key of the video
	 * @return the video
	 * @throws PortalException if a video with the primary key could not be found
	 */
	public static com.techsocialist.servicebuilder.model.Video getVideo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getVideo(id);
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
	public static java.util.List<com.techsocialist.servicebuilder.model.Video>
		getVideos(int start, int end) {

		return getService().getVideos(start, end);
	}

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	public static int getVideosCount() {
		return getService().getVideosCount();
	}

	public static java.io.InputStream openContentInputStream(long id) {
		return getService().openContentInputStream(id);
	}

	public static java.io.InputStream openThumbnailInputStream(long id) {
		return getService().openThumbnailInputStream(id);
	}

	/**
	 * Updates the video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param video the video
	 * @return the video that was updated
	 */
	public static com.techsocialist.servicebuilder.model.Video updateVideo(
		com.techsocialist.servicebuilder.model.Video video) {

		return getService().updateVideo(video);
	}

	public static VideoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VideoLocalService, VideoLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VideoLocalService.class);

		ServiceTracker<VideoLocalService, VideoLocalService> serviceTracker =
			new ServiceTracker<VideoLocalService, VideoLocalService>(
				bundle.getBundleContext(), VideoLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
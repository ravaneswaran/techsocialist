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
 * Provides the local service utility for VideoEntry. This utility wraps
 * <code>com.techsocialist.servicebuilder.service.impl.VideoEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see VideoEntryLocalService
 * @generated
 */
public class VideoEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.techsocialist.servicebuilder.service.impl.VideoEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the video entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoEntry the video entry
	 * @return the video entry that was added
	 */
	public static com.techsocialist.servicebuilder.model.VideoEntry
		addVideoEntry(
			com.techsocialist.servicebuilder.model.VideoEntry videoEntry) {

		return getService().addVideoEntry(videoEntry);
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
	 * Creates a new video entry with the primary key. Does not add the video entry to the database.
	 *
	 * @param id the primary key for the new video entry
	 * @return the new video entry
	 */
	public static com.techsocialist.servicebuilder.model.VideoEntry
		createVideoEntry(long id) {

		return getService().createVideoEntry(id);
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
	 * Deletes the video entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the video entry
	 * @return the video entry that was removed
	 * @throws PortalException if a video entry with the primary key could not be found
	 */
	public static com.techsocialist.servicebuilder.model.VideoEntry
			deleteVideoEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteVideoEntry(id);
	}

	/**
	 * Deletes the video entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoEntry the video entry
	 * @return the video entry that was removed
	 */
	public static com.techsocialist.servicebuilder.model.VideoEntry
		deleteVideoEntry(
			com.techsocialist.servicebuilder.model.VideoEntry videoEntry) {

		return getService().deleteVideoEntry(videoEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.VideoEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.VideoEntryModelImpl</code>.
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

	public static com.techsocialist.servicebuilder.model.VideoEntry
		fetchVideoEntry(long id) {

		return getService().fetchVideoEntry(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.techsocialist.servicebuilder.model.VideoEntryContentBlobModel
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

	/**
	 * Returns a range of all the video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.VideoEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of video entries
	 */
	public static java.util.List
		<com.techsocialist.servicebuilder.model.VideoEntry> getVideoEntries(
			int start, int end) {

		return getService().getVideoEntries(start, end);
	}

	/**
	 * Returns the number of video entries.
	 *
	 * @return the number of video entries
	 */
	public static int getVideoEntriesCount() {
		return getService().getVideoEntriesCount();
	}

	/**
	 * Returns the video entry with the primary key.
	 *
	 * @param id the primary key of the video entry
	 * @return the video entry
	 * @throws PortalException if a video entry with the primary key could not be found
	 */
	public static com.techsocialist.servicebuilder.model.VideoEntry
			getVideoEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getVideoEntry(id);
	}

	public static java.io.InputStream openContentInputStream(long id) {
		return getService().openContentInputStream(id);
	}

	/**
	 * Updates the video entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param videoEntry the video entry
	 * @return the video entry that was updated
	 */
	public static com.techsocialist.servicebuilder.model.VideoEntry
		updateVideoEntry(
			com.techsocialist.servicebuilder.model.VideoEntry videoEntry) {

		return getService().updateVideoEntry(videoEntry);
	}

	public static VideoEntryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<VideoEntryLocalService, VideoEntryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VideoEntryLocalService.class);

		ServiceTracker<VideoEntryLocalService, VideoEntryLocalService>
			serviceTracker =
				new ServiceTracker
					<VideoEntryLocalService, VideoEntryLocalService>(
						bundle.getBundleContext(), VideoEntryLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
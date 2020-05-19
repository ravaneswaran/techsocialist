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

package com.techsocialist.servicebuilder.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.techsocialist.servicebuilder.model.VideoEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the video entry service. This utility wraps <code>com.techsocialist.servicebuilder.service.persistence.impl.VideoEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VideoEntryPersistence
 * @generated
 */
public class VideoEntryUtil {

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
	public static void clearCache(VideoEntry videoEntry) {
		getPersistence().clearCache(videoEntry);
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
	public static Map<Serializable, VideoEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VideoEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<VideoEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static VideoEntry update(VideoEntry videoEntry) {
		return getPersistence().update(videoEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static VideoEntry update(
		VideoEntry videoEntry, ServiceContext serviceContext) {

		return getPersistence().update(videoEntry, serviceContext);
	}

	/**
	 * Caches the video entry in the entity cache if it is enabled.
	 *
	 * @param videoEntry the video entry
	 */
	public static void cacheResult(VideoEntry videoEntry) {
		getPersistence().cacheResult(videoEntry);
	}

	/**
	 * Caches the video entries in the entity cache if it is enabled.
	 *
	 * @param videoEntries the video entries
	 */
	public static void cacheResult(List<VideoEntry> videoEntries) {
		getPersistence().cacheResult(videoEntries);
	}

	/**
	 * Creates a new video entry with the primary key. Does not add the video entry to the database.
	 *
	 * @param id the primary key for the new video entry
	 * @return the new video entry
	 */
	public static VideoEntry create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the video entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the video entry
	 * @return the video entry that was removed
	 * @throws NoSuchVideoEntryException if a video entry with the primary key could not be found
	 */
	public static VideoEntry remove(long id)
		throws com.techsocialist.servicebuilder.exception.
			NoSuchVideoEntryException {

		return getPersistence().remove(id);
	}

	public static VideoEntry updateImpl(VideoEntry videoEntry) {
		return getPersistence().updateImpl(videoEntry);
	}

	/**
	 * Returns the video entry with the primary key or throws a <code>NoSuchVideoEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the video entry
	 * @return the video entry
	 * @throws NoSuchVideoEntryException if a video entry with the primary key could not be found
	 */
	public static VideoEntry findByPrimaryKey(long id)
		throws com.techsocialist.servicebuilder.exception.
			NoSuchVideoEntryException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the video entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the video entry
	 * @return the video entry, or <code>null</code> if a video entry with the primary key could not be found
	 */
	public static VideoEntry fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the video entries.
	 *
	 * @return the video entries
	 */
	public static List<VideoEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of video entries
	 */
	public static List<VideoEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video entries
	 */
	public static List<VideoEntry> findAll(
		int start, int end, OrderByComparator<VideoEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of video entries
	 */
	public static List<VideoEntry> findAll(
		int start, int end, OrderByComparator<VideoEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the video entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of video entries.
	 *
	 * @return the number of video entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VideoEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VideoEntryPersistence, VideoEntryPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VideoEntryPersistence.class);

		ServiceTracker<VideoEntryPersistence, VideoEntryPersistence>
			serviceTracker =
				new ServiceTracker
					<VideoEntryPersistence, VideoEntryPersistence>(
						bundle.getBundleContext(), VideoEntryPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
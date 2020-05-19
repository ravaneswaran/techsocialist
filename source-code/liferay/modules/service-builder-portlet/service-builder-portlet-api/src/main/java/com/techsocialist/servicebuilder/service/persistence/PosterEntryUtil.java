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

import com.techsocialist.servicebuilder.model.PosterEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the poster entry service. This utility wraps <code>com.techsocialist.servicebuilder.service.persistence.impl.PosterEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PosterEntryPersistence
 * @generated
 */
public class PosterEntryUtil {

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
	public static void clearCache(PosterEntry posterEntry) {
		getPersistence().clearCache(posterEntry);
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
	public static Map<Serializable, PosterEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PosterEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PosterEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PosterEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PosterEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PosterEntry update(PosterEntry posterEntry) {
		return getPersistence().update(posterEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PosterEntry update(
		PosterEntry posterEntry, ServiceContext serviceContext) {

		return getPersistence().update(posterEntry, serviceContext);
	}

	/**
	 * Caches the poster entry in the entity cache if it is enabled.
	 *
	 * @param posterEntry the poster entry
	 */
	public static void cacheResult(PosterEntry posterEntry) {
		getPersistence().cacheResult(posterEntry);
	}

	/**
	 * Caches the poster entries in the entity cache if it is enabled.
	 *
	 * @param posterEntries the poster entries
	 */
	public static void cacheResult(List<PosterEntry> posterEntries) {
		getPersistence().cacheResult(posterEntries);
	}

	/**
	 * Creates a new poster entry with the primary key. Does not add the poster entry to the database.
	 *
	 * @param id the primary key for the new poster entry
	 * @return the new poster entry
	 */
	public static PosterEntry create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the poster entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the poster entry
	 * @return the poster entry that was removed
	 * @throws NoSuchPosterEntryException if a poster entry with the primary key could not be found
	 */
	public static PosterEntry remove(long id)
		throws com.techsocialist.servicebuilder.exception.
			NoSuchPosterEntryException {

		return getPersistence().remove(id);
	}

	public static PosterEntry updateImpl(PosterEntry posterEntry) {
		return getPersistence().updateImpl(posterEntry);
	}

	/**
	 * Returns the poster entry with the primary key or throws a <code>NoSuchPosterEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the poster entry
	 * @return the poster entry
	 * @throws NoSuchPosterEntryException if a poster entry with the primary key could not be found
	 */
	public static PosterEntry findByPrimaryKey(long id)
		throws com.techsocialist.servicebuilder.exception.
			NoSuchPosterEntryException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the poster entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the poster entry
	 * @return the poster entry, or <code>null</code> if a poster entry with the primary key could not be found
	 */
	public static PosterEntry fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the poster entries.
	 *
	 * @return the poster entries
	 */
	public static List<PosterEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the poster entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PosterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of poster entries
	 * @param end the upper bound of the range of poster entries (not inclusive)
	 * @return the range of poster entries
	 */
	public static List<PosterEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the poster entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PosterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of poster entries
	 * @param end the upper bound of the range of poster entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of poster entries
	 */
	public static List<PosterEntry> findAll(
		int start, int end, OrderByComparator<PosterEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the poster entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PosterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of poster entries
	 * @param end the upper bound of the range of poster entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of poster entries
	 */
	public static List<PosterEntry> findAll(
		int start, int end, OrderByComparator<PosterEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the poster entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of poster entries.
	 *
	 * @return the number of poster entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PosterEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PosterEntryPersistence, PosterEntryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PosterEntryPersistence.class);

		ServiceTracker<PosterEntryPersistence, PosterEntryPersistence>
			serviceTracker =
				new ServiceTracker
					<PosterEntryPersistence, PosterEntryPersistence>(
						bundle.getBundleContext(), PosterEntryPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
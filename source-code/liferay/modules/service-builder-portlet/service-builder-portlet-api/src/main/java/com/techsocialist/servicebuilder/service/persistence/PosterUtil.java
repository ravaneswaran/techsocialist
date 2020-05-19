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

import com.techsocialist.servicebuilder.model.Poster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the poster service. This utility wraps <code>com.techsocialist.servicebuilder.service.persistence.impl.PosterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PosterPersistence
 * @generated
 */
public class PosterUtil {

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
	public static void clearCache(Poster poster) {
		getPersistence().clearCache(poster);
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
	public static Map<Serializable, Poster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Poster> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Poster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Poster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Poster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Poster update(Poster poster) {
		return getPersistence().update(poster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Poster update(Poster poster, ServiceContext serviceContext) {
		return getPersistence().update(poster, serviceContext);
	}

	/**
	 * Caches the poster in the entity cache if it is enabled.
	 *
	 * @param poster the poster
	 */
	public static void cacheResult(Poster poster) {
		getPersistence().cacheResult(poster);
	}

	/**
	 * Caches the posters in the entity cache if it is enabled.
	 *
	 * @param posters the posters
	 */
	public static void cacheResult(List<Poster> posters) {
		getPersistence().cacheResult(posters);
	}

	/**
	 * Creates a new poster with the primary key. Does not add the poster to the database.
	 *
	 * @param id the primary key for the new poster
	 * @return the new poster
	 */
	public static Poster create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the poster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the poster
	 * @return the poster that was removed
	 * @throws NoSuchPosterException if a poster with the primary key could not be found
	 */
	public static Poster remove(long id)
		throws com.techsocialist.servicebuilder.exception.
			NoSuchPosterException {

		return getPersistence().remove(id);
	}

	public static Poster updateImpl(Poster poster) {
		return getPersistence().updateImpl(poster);
	}

	/**
	 * Returns the poster with the primary key or throws a <code>NoSuchPosterException</code> if it could not be found.
	 *
	 * @param id the primary key of the poster
	 * @return the poster
	 * @throws NoSuchPosterException if a poster with the primary key could not be found
	 */
	public static Poster findByPrimaryKey(long id)
		throws com.techsocialist.servicebuilder.exception.
			NoSuchPosterException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the poster with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the poster
	 * @return the poster, or <code>null</code> if a poster with the primary key could not be found
	 */
	public static Poster fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the posters.
	 *
	 * @return the posters
	 */
	public static List<Poster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the posters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PosterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posters
	 * @param end the upper bound of the range of posters (not inclusive)
	 * @return the range of posters
	 */
	public static List<Poster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the posters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PosterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posters
	 * @param end the upper bound of the range of posters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of posters
	 */
	public static List<Poster> findAll(
		int start, int end, OrderByComparator<Poster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the posters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PosterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posters
	 * @param end the upper bound of the range of posters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of posters
	 */
	public static List<Poster> findAll(
		int start, int end, OrderByComparator<Poster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the posters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of posters.
	 *
	 * @return the number of posters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PosterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PosterPersistence, PosterPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PosterPersistence.class);

		ServiceTracker<PosterPersistence, PosterPersistence> serviceTracker =
			new ServiceTracker<PosterPersistence, PosterPersistence>(
				bundle.getBundleContext(), PosterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
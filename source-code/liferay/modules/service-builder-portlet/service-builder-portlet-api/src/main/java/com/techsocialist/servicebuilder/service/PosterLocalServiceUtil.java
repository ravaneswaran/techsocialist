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
 * Provides the local service utility for Poster. This utility wraps
 * <code>com.techsocialist.servicebuilder.service.impl.PosterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PosterLocalService
 * @generated
 */
public class PosterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.techsocialist.servicebuilder.service.impl.PosterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the poster to the database. Also notifies the appropriate model listeners.
	 *
	 * @param poster the poster
	 * @return the poster that was added
	 */
	public static com.techsocialist.servicebuilder.model.Poster addPoster(
		com.techsocialist.servicebuilder.model.Poster poster) {

		return getService().addPoster(poster);
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
	 * Creates a new poster with the primary key. Does not add the poster to the database.
	 *
	 * @param id the primary key for the new poster
	 * @return the new poster
	 */
	public static com.techsocialist.servicebuilder.model.Poster createPoster(
		long id) {

		return getService().createPoster(id);
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
	 * Deletes the poster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the poster
	 * @return the poster that was removed
	 * @throws PortalException if a poster with the primary key could not be found
	 */
	public static com.techsocialist.servicebuilder.model.Poster deletePoster(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePoster(id);
	}

	/**
	 * Deletes the poster from the database. Also notifies the appropriate model listeners.
	 *
	 * @param poster the poster
	 * @return the poster that was removed
	 */
	public static com.techsocialist.servicebuilder.model.Poster deletePoster(
		com.techsocialist.servicebuilder.model.Poster poster) {

		return getService().deletePoster(poster);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.PosterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.PosterModelImpl</code>.
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

	public static com.techsocialist.servicebuilder.model.Poster fetchPoster(
		long id) {

		return getService().fetchPoster(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.techsocialist.servicebuilder.model.PosterContentBlobModel
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
	 * Returns the poster with the primary key.
	 *
	 * @param id the primary key of the poster
	 * @return the poster
	 * @throws PortalException if a poster with the primary key could not be found
	 */
	public static com.techsocialist.servicebuilder.model.Poster getPoster(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPoster(id);
	}

	/**
	 * Returns a range of all the posters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.PosterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posters
	 * @param end the upper bound of the range of posters (not inclusive)
	 * @return the range of posters
	 */
	public static java.util.List<com.techsocialist.servicebuilder.model.Poster>
		getPosters(int start, int end) {

		return getService().getPosters(start, end);
	}

	/**
	 * Returns the number of posters.
	 *
	 * @return the number of posters
	 */
	public static int getPostersCount() {
		return getService().getPostersCount();
	}

	public static java.io.InputStream openContentInputStream(long id) {
		return getService().openContentInputStream(id);
	}

	/**
	 * Updates the poster in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param poster the poster
	 * @return the poster that was updated
	 */
	public static com.techsocialist.servicebuilder.model.Poster updatePoster(
		com.techsocialist.servicebuilder.model.Poster poster) {

		return getService().updatePoster(poster);
	}

	public static PosterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PosterLocalService, PosterLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PosterLocalService.class);

		ServiceTracker<PosterLocalService, PosterLocalService> serviceTracker =
			new ServiceTracker<PosterLocalService, PosterLocalService>(
				bundle.getBundleContext(), PosterLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
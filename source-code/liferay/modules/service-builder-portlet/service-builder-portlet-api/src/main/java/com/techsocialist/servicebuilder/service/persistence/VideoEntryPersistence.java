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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.techsocialist.servicebuilder.exception.NoSuchVideoEntryException;
import com.techsocialist.servicebuilder.model.VideoEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the video entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VideoEntryUtil
 * @generated
 */
@ProviderType
public interface VideoEntryPersistence extends BasePersistence<VideoEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoEntryUtil} to access the video entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the video entry in the entity cache if it is enabled.
	 *
	 * @param videoEntry the video entry
	 */
	public void cacheResult(VideoEntry videoEntry);

	/**
	 * Caches the video entries in the entity cache if it is enabled.
	 *
	 * @param videoEntries the video entries
	 */
	public void cacheResult(java.util.List<VideoEntry> videoEntries);

	/**
	 * Creates a new video entry with the primary key. Does not add the video entry to the database.
	 *
	 * @param id the primary key for the new video entry
	 * @return the new video entry
	 */
	public VideoEntry create(long id);

	/**
	 * Removes the video entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the video entry
	 * @return the video entry that was removed
	 * @throws NoSuchVideoEntryException if a video entry with the primary key could not be found
	 */
	public VideoEntry remove(long id) throws NoSuchVideoEntryException;

	public VideoEntry updateImpl(VideoEntry videoEntry);

	/**
	 * Returns the video entry with the primary key or throws a <code>NoSuchVideoEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the video entry
	 * @return the video entry
	 * @throws NoSuchVideoEntryException if a video entry with the primary key could not be found
	 */
	public VideoEntry findByPrimaryKey(long id)
		throws NoSuchVideoEntryException;

	/**
	 * Returns the video entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the video entry
	 * @return the video entry, or <code>null</code> if a video entry with the primary key could not be found
	 */
	public VideoEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the video entries.
	 *
	 * @return the video entries
	 */
	public java.util.List<VideoEntry> findAll();

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
	public java.util.List<VideoEntry> findAll(int start, int end);

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
	public java.util.List<VideoEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoEntry>
			orderByComparator);

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
	public java.util.List<VideoEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the video entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of video entries.
	 *
	 * @return the number of video entries
	 */
	public int countAll();

}
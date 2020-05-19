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

import com.techsocialist.servicebuilder.exception.NoSuchVideoRegisterEntryException;
import com.techsocialist.servicebuilder.model.VideoRegisterEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the video register entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VideoRegisterEntryUtil
 * @generated
 */
@ProviderType
public interface VideoRegisterEntryPersistence
	extends BasePersistence<VideoRegisterEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoRegisterEntryUtil} to access the video register entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the video register entry in the entity cache if it is enabled.
	 *
	 * @param videoRegisterEntry the video register entry
	 */
	public void cacheResult(VideoRegisterEntry videoRegisterEntry);

	/**
	 * Caches the video register entries in the entity cache if it is enabled.
	 *
	 * @param videoRegisterEntries the video register entries
	 */
	public void cacheResult(
		java.util.List<VideoRegisterEntry> videoRegisterEntries);

	/**
	 * Creates a new video register entry with the primary key. Does not add the video register entry to the database.
	 *
	 * @param id the primary key for the new video register entry
	 * @return the new video register entry
	 */
	public VideoRegisterEntry create(long id);

	/**
	 * Removes the video register entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the video register entry
	 * @return the video register entry that was removed
	 * @throws NoSuchVideoRegisterEntryException if a video register entry with the primary key could not be found
	 */
	public VideoRegisterEntry remove(long id)
		throws NoSuchVideoRegisterEntryException;

	public VideoRegisterEntry updateImpl(VideoRegisterEntry videoRegisterEntry);

	/**
	 * Returns the video register entry with the primary key or throws a <code>NoSuchVideoRegisterEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the video register entry
	 * @return the video register entry
	 * @throws NoSuchVideoRegisterEntryException if a video register entry with the primary key could not be found
	 */
	public VideoRegisterEntry findByPrimaryKey(long id)
		throws NoSuchVideoRegisterEntryException;

	/**
	 * Returns the video register entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the video register entry
	 * @return the video register entry, or <code>null</code> if a video register entry with the primary key could not be found
	 */
	public VideoRegisterEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the video register entries.
	 *
	 * @return the video register entries
	 */
	public java.util.List<VideoRegisterEntry> findAll();

	/**
	 * Returns a range of all the video register entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoRegisterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video register entries
	 * @param end the upper bound of the range of video register entries (not inclusive)
	 * @return the range of video register entries
	 */
	public java.util.List<VideoRegisterEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the video register entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoRegisterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video register entries
	 * @param end the upper bound of the range of video register entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video register entries
	 */
	public java.util.List<VideoRegisterEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoRegisterEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the video register entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoRegisterEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video register entries
	 * @param end the upper bound of the range of video register entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of video register entries
	 */
	public java.util.List<VideoRegisterEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VideoRegisterEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the video register entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of video register entries.
	 *
	 * @return the number of video register entries
	 */
	public int countAll();

}
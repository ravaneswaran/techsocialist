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

import com.techsocialist.servicebuilder.exception.NoSuchPosterEntryException;
import com.techsocialist.servicebuilder.model.PosterEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the poster entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PosterEntryUtil
 * @generated
 */
@ProviderType
public interface PosterEntryPersistence extends BasePersistence<PosterEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PosterEntryUtil} to access the poster entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the poster entry in the entity cache if it is enabled.
	 *
	 * @param posterEntry the poster entry
	 */
	public void cacheResult(PosterEntry posterEntry);

	/**
	 * Caches the poster entries in the entity cache if it is enabled.
	 *
	 * @param posterEntries the poster entries
	 */
	public void cacheResult(java.util.List<PosterEntry> posterEntries);

	/**
	 * Creates a new poster entry with the primary key. Does not add the poster entry to the database.
	 *
	 * @param id the primary key for the new poster entry
	 * @return the new poster entry
	 */
	public PosterEntry create(long id);

	/**
	 * Removes the poster entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the poster entry
	 * @return the poster entry that was removed
	 * @throws NoSuchPosterEntryException if a poster entry with the primary key could not be found
	 */
	public PosterEntry remove(long id) throws NoSuchPosterEntryException;

	public PosterEntry updateImpl(PosterEntry posterEntry);

	/**
	 * Returns the poster entry with the primary key or throws a <code>NoSuchPosterEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the poster entry
	 * @return the poster entry
	 * @throws NoSuchPosterEntryException if a poster entry with the primary key could not be found
	 */
	public PosterEntry findByPrimaryKey(long id)
		throws NoSuchPosterEntryException;

	/**
	 * Returns the poster entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the poster entry
	 * @return the poster entry, or <code>null</code> if a poster entry with the primary key could not be found
	 */
	public PosterEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the poster entries.
	 *
	 * @return the poster entries
	 */
	public java.util.List<PosterEntry> findAll();

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
	public java.util.List<PosterEntry> findAll(int start, int end);

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
	public java.util.List<PosterEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PosterEntry>
			orderByComparator);

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
	public java.util.List<PosterEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PosterEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the poster entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of poster entries.
	 *
	 * @return the number of poster entries
	 */
	public int countAll();

}
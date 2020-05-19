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

package com.techsocialist.servicebuilder.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;

import com.techsocialist.servicebuilder.exception.NoSuchPosterException;
import com.techsocialist.servicebuilder.model.Poster;
import com.techsocialist.servicebuilder.model.impl.PosterImpl;
import com.techsocialist.servicebuilder.model.impl.PosterModelImpl;
import com.techsocialist.servicebuilder.service.persistence.PosterPersistence;
import com.techsocialist.servicebuilder.service.persistence.impl.constants.TSPersistenceConstants;

import java.io.Serializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the poster service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PosterPersistence.class)
public class PosterPersistenceImpl
	extends BasePersistenceImpl<Poster> implements PosterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PosterUtil</code> to access the poster persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PosterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PosterPersistenceImpl() {
		setModelClass(Poster.class);

		setModelImplClass(PosterImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the poster in the entity cache if it is enabled.
	 *
	 * @param poster the poster
	 */
	@Override
	public void cacheResult(Poster poster) {
		entityCache.putResult(
			entityCacheEnabled, PosterImpl.class, poster.getPrimaryKey(),
			poster);

		poster.resetOriginalValues();
	}

	/**
	 * Caches the posters in the entity cache if it is enabled.
	 *
	 * @param posters the posters
	 */
	@Override
	public void cacheResult(List<Poster> posters) {
		for (Poster poster : posters) {
			if (entityCache.getResult(
					entityCacheEnabled, PosterImpl.class,
					poster.getPrimaryKey()) == null) {

				cacheResult(poster);
			}
			else {
				poster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all posters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PosterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the poster.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Poster poster) {
		entityCache.removeResult(
			entityCacheEnabled, PosterImpl.class, poster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Poster> posters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Poster poster : posters) {
			entityCache.removeResult(
				entityCacheEnabled, PosterImpl.class, poster.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, PosterImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new poster with the primary key. Does not add the poster to the database.
	 *
	 * @param id the primary key for the new poster
	 * @return the new poster
	 */
	@Override
	public Poster create(long id) {
		Poster poster = new PosterImpl();

		poster.setNew(true);
		poster.setPrimaryKey(id);

		return poster;
	}

	/**
	 * Removes the poster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the poster
	 * @return the poster that was removed
	 * @throws NoSuchPosterException if a poster with the primary key could not be found
	 */
	@Override
	public Poster remove(long id) throws NoSuchPosterException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the poster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the poster
	 * @return the poster that was removed
	 * @throws NoSuchPosterException if a poster with the primary key could not be found
	 */
	@Override
	public Poster remove(Serializable primaryKey) throws NoSuchPosterException {
		Session session = null;

		try {
			session = openSession();

			Poster poster = (Poster)session.get(PosterImpl.class, primaryKey);

			if (poster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPosterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(poster);
		}
		catch (NoSuchPosterException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Poster removeImpl(Poster poster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(poster)) {
				poster = (Poster)session.get(
					PosterImpl.class, poster.getPrimaryKeyObj());
			}

			if (poster != null) {
				session.delete(poster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (poster != null) {
			clearCache(poster);
		}

		return poster;
	}

	@Override
	public Poster updateImpl(Poster poster) {
		boolean isNew = poster.isNew();

		Session session = null;

		try {
			session = openSession();

			if (poster.isNew()) {
				session.save(poster);

				poster.setNew(false);
			}
			else {
				session.evict(poster);
				session.saveOrUpdate(poster);
			}

			session.flush();
			session.clear();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, PosterImpl.class, poster.getPrimaryKey(),
			poster, false);

		poster.resetOriginalValues();

		return poster;
	}

	/**
	 * Returns the poster with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the poster
	 * @return the poster
	 * @throws NoSuchPosterException if a poster with the primary key could not be found
	 */
	@Override
	public Poster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPosterException {

		Poster poster = fetchByPrimaryKey(primaryKey);

		if (poster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPosterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return poster;
	}

	/**
	 * Returns the poster with the primary key or throws a <code>NoSuchPosterException</code> if it could not be found.
	 *
	 * @param id the primary key of the poster
	 * @return the poster
	 * @throws NoSuchPosterException if a poster with the primary key could not be found
	 */
	@Override
	public Poster findByPrimaryKey(long id) throws NoSuchPosterException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the poster with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the poster
	 * @return the poster, or <code>null</code> if a poster with the primary key could not be found
	 */
	@Override
	public Poster fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the posters.
	 *
	 * @return the posters
	 */
	@Override
	public List<Poster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Poster> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Poster> findAll(
		int start, int end, OrderByComparator<Poster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Poster> findAll(
		int start, int end, OrderByComparator<Poster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Poster> list = null;

		if (useFinderCache) {
			list = (List<Poster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_POSTER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_POSTER;

				sql = sql.concat(PosterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Poster>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the posters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Poster poster : findAll()) {
			remove(poster);
		}
	}

	/**
	 * Returns the number of posters.
	 *
	 * @return the number of posters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_POSTER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POSTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PosterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the poster persistence.
	 */
	@Activate
	public void activate() {
		PosterModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		PosterModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PosterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PosterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PosterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = TSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.techsocialist.servicebuilder.model.Poster"),
			true);
	}

	@Override
	@Reference(
		target = TSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_POSTER =
		"SELECT poster FROM Poster poster";

	private static final String _SQL_COUNT_POSTER =
		"SELECT COUNT(poster) FROM Poster poster";

	private static final String _ORDER_BY_ENTITY_ALIAS = "poster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Poster exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PosterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "type"});

	static {
		try {
			Class.forName(TSPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}
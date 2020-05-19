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

import com.techsocialist.servicebuilder.exception.NoSuchProductionHouseEntryException;
import com.techsocialist.servicebuilder.model.ProductionHouseEntry;
import com.techsocialist.servicebuilder.model.impl.ProductionHouseEntryImpl;
import com.techsocialist.servicebuilder.model.impl.ProductionHouseEntryModelImpl;
import com.techsocialist.servicebuilder.service.persistence.ProductionHouseEntryPersistence;
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
 * The persistence implementation for the production house entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductionHouseEntryPersistence.class)
public class ProductionHouseEntryPersistenceImpl
	extends BasePersistenceImpl<ProductionHouseEntry>
	implements ProductionHouseEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductionHouseEntryUtil</code> to access the production house entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductionHouseEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ProductionHouseEntryPersistenceImpl() {
		setModelClass(ProductionHouseEntry.class);

		setModelImplClass(ProductionHouseEntryImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("state", "state_");
		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the production house entry in the entity cache if it is enabled.
	 *
	 * @param productionHouseEntry the production house entry
	 */
	@Override
	public void cacheResult(ProductionHouseEntry productionHouseEntry) {
		entityCache.putResult(
			entityCacheEnabled, ProductionHouseEntryImpl.class,
			productionHouseEntry.getPrimaryKey(), productionHouseEntry);

		productionHouseEntry.resetOriginalValues();
	}

	/**
	 * Caches the production house entries in the entity cache if it is enabled.
	 *
	 * @param productionHouseEntries the production house entries
	 */
	@Override
	public void cacheResult(List<ProductionHouseEntry> productionHouseEntries) {
		for (ProductionHouseEntry productionHouseEntry :
				productionHouseEntries) {

			if (entityCache.getResult(
					entityCacheEnabled, ProductionHouseEntryImpl.class,
					productionHouseEntry.getPrimaryKey()) == null) {

				cacheResult(productionHouseEntry);
			}
			else {
				productionHouseEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all production house entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductionHouseEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the production house entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductionHouseEntry productionHouseEntry) {
		entityCache.removeResult(
			entityCacheEnabled, ProductionHouseEntryImpl.class,
			productionHouseEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProductionHouseEntry> productionHouseEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductionHouseEntry productionHouseEntry :
				productionHouseEntries) {

			entityCache.removeResult(
				entityCacheEnabled, ProductionHouseEntryImpl.class,
				productionHouseEntry.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ProductionHouseEntryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new production house entry with the primary key. Does not add the production house entry to the database.
	 *
	 * @param id the primary key for the new production house entry
	 * @return the new production house entry
	 */
	@Override
	public ProductionHouseEntry create(long id) {
		ProductionHouseEntry productionHouseEntry =
			new ProductionHouseEntryImpl();

		productionHouseEntry.setNew(true);
		productionHouseEntry.setPrimaryKey(id);

		return productionHouseEntry;
	}

	/**
	 * Removes the production house entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house entry
	 * @return the production house entry that was removed
	 * @throws NoSuchProductionHouseEntryException if a production house entry with the primary key could not be found
	 */
	@Override
	public ProductionHouseEntry remove(long id)
		throws NoSuchProductionHouseEntryException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the production house entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the production house entry
	 * @return the production house entry that was removed
	 * @throws NoSuchProductionHouseEntryException if a production house entry with the primary key could not be found
	 */
	@Override
	public ProductionHouseEntry remove(Serializable primaryKey)
		throws NoSuchProductionHouseEntryException {

		Session session = null;

		try {
			session = openSession();

			ProductionHouseEntry productionHouseEntry =
				(ProductionHouseEntry)session.get(
					ProductionHouseEntryImpl.class, primaryKey);

			if (productionHouseEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductionHouseEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productionHouseEntry);
		}
		catch (NoSuchProductionHouseEntryException noSuchEntityException) {
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
	protected ProductionHouseEntry removeImpl(
		ProductionHouseEntry productionHouseEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productionHouseEntry)) {
				productionHouseEntry = (ProductionHouseEntry)session.get(
					ProductionHouseEntryImpl.class,
					productionHouseEntry.getPrimaryKeyObj());
			}

			if (productionHouseEntry != null) {
				session.delete(productionHouseEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productionHouseEntry != null) {
			clearCache(productionHouseEntry);
		}

		return productionHouseEntry;
	}

	@Override
	public ProductionHouseEntry updateImpl(
		ProductionHouseEntry productionHouseEntry) {

		boolean isNew = productionHouseEntry.isNew();

		Session session = null;

		try {
			session = openSession();

			if (productionHouseEntry.isNew()) {
				session.save(productionHouseEntry);

				productionHouseEntry.setNew(false);
			}
			else {
				session.evict(productionHouseEntry);
				session.saveOrUpdate(productionHouseEntry);
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
			entityCacheEnabled, ProductionHouseEntryImpl.class,
			productionHouseEntry.getPrimaryKey(), productionHouseEntry, false);

		productionHouseEntry.resetOriginalValues();

		return productionHouseEntry;
	}

	/**
	 * Returns the production house entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the production house entry
	 * @return the production house entry
	 * @throws NoSuchProductionHouseEntryException if a production house entry with the primary key could not be found
	 */
	@Override
	public ProductionHouseEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductionHouseEntryException {

		ProductionHouseEntry productionHouseEntry = fetchByPrimaryKey(
			primaryKey);

		if (productionHouseEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductionHouseEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productionHouseEntry;
	}

	/**
	 * Returns the production house entry with the primary key or throws a <code>NoSuchProductionHouseEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the production house entry
	 * @return the production house entry
	 * @throws NoSuchProductionHouseEntryException if a production house entry with the primary key could not be found
	 */
	@Override
	public ProductionHouseEntry findByPrimaryKey(long id)
		throws NoSuchProductionHouseEntryException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the production house entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the production house entry
	 * @return the production house entry, or <code>null</code> if a production house entry with the primary key could not be found
	 */
	@Override
	public ProductionHouseEntry fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the production house entries.
	 *
	 * @return the production house entries
	 */
	@Override
	public List<ProductionHouseEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the production house entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house entries
	 * @param end the upper bound of the range of production house entries (not inclusive)
	 * @return the range of production house entries
	 */
	@Override
	public List<ProductionHouseEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the production house entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house entries
	 * @param end the upper bound of the range of production house entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of production house entries
	 */
	@Override
	public List<ProductionHouseEntry> findAll(
		int start, int end,
		OrderByComparator<ProductionHouseEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the production house entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house entries
	 * @param end the upper bound of the range of production house entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of production house entries
	 */
	@Override
	public List<ProductionHouseEntry> findAll(
		int start, int end,
		OrderByComparator<ProductionHouseEntry> orderByComparator,
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

		List<ProductionHouseEntry> list = null;

		if (useFinderCache) {
			list = (List<ProductionHouseEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PRODUCTIONHOUSEENTRY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTIONHOUSEENTRY;

				sql = sql.concat(ProductionHouseEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<ProductionHouseEntry>)QueryUtil.list(
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
	 * Removes all the production house entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductionHouseEntry productionHouseEntry : findAll()) {
			remove(productionHouseEntry);
		}
	}

	/**
	 * Returns the number of production house entries.
	 *
	 * @return the number of production house entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRODUCTIONHOUSEENTRY);

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
		return _SQL_SELECT_PRODUCTIONHOUSEENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductionHouseEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the production house entry persistence.
	 */
	@Activate
	public void activate() {
		ProductionHouseEntryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ProductionHouseEntryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ProductionHouseEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ProductionHouseEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ProductionHouseEntryImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.techsocialist.servicebuilder.model.ProductionHouseEntry"),
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

	private static final String _SQL_SELECT_PRODUCTIONHOUSEENTRY =
		"SELECT productionHouseEntry FROM ProductionHouseEntry productionHouseEntry";

	private static final String _SQL_COUNT_PRODUCTIONHOUSEENTRY =
		"SELECT COUNT(productionHouseEntry) FROM ProductionHouseEntry productionHouseEntry";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"productionHouseEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductionHouseEntry exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductionHouseEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "state", "password"});

	static {
		try {
			Class.forName(TSPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}
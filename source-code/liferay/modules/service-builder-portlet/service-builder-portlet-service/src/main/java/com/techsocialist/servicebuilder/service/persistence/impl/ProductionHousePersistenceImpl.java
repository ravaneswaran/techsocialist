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

import com.techsocialist.servicebuilder.exception.NoSuchProductionHouseException;
import com.techsocialist.servicebuilder.model.ProductionHouse;
import com.techsocialist.servicebuilder.model.impl.ProductionHouseImpl;
import com.techsocialist.servicebuilder.model.impl.ProductionHouseModelImpl;
import com.techsocialist.servicebuilder.service.persistence.ProductionHousePersistence;
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
 * The persistence implementation for the production house service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductionHousePersistence.class)
public class ProductionHousePersistenceImpl
	extends BasePersistenceImpl<ProductionHouse>
	implements ProductionHousePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductionHouseUtil</code> to access the production house persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductionHouseImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ProductionHousePersistenceImpl() {
		setModelClass(ProductionHouse.class);

		setModelImplClass(ProductionHouseImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("state", "state_");
		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the production house in the entity cache if it is enabled.
	 *
	 * @param productionHouse the production house
	 */
	@Override
	public void cacheResult(ProductionHouse productionHouse) {
		entityCache.putResult(
			entityCacheEnabled, ProductionHouseImpl.class,
			productionHouse.getPrimaryKey(), productionHouse);

		productionHouse.resetOriginalValues();
	}

	/**
	 * Caches the production houses in the entity cache if it is enabled.
	 *
	 * @param productionHouses the production houses
	 */
	@Override
	public void cacheResult(List<ProductionHouse> productionHouses) {
		for (ProductionHouse productionHouse : productionHouses) {
			if (entityCache.getResult(
					entityCacheEnabled, ProductionHouseImpl.class,
					productionHouse.getPrimaryKey()) == null) {

				cacheResult(productionHouse);
			}
			else {
				productionHouse.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all production houses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductionHouseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the production house.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductionHouse productionHouse) {
		entityCache.removeResult(
			entityCacheEnabled, ProductionHouseImpl.class,
			productionHouse.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProductionHouse> productionHouses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductionHouse productionHouse : productionHouses) {
			entityCache.removeResult(
				entityCacheEnabled, ProductionHouseImpl.class,
				productionHouse.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ProductionHouseImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new production house with the primary key. Does not add the production house to the database.
	 *
	 * @param id the primary key for the new production house
	 * @return the new production house
	 */
	@Override
	public ProductionHouse create(long id) {
		ProductionHouse productionHouse = new ProductionHouseImpl();

		productionHouse.setNew(true);
		productionHouse.setPrimaryKey(id);

		return productionHouse;
	}

	/**
	 * Removes the production house with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house
	 * @return the production house that was removed
	 * @throws NoSuchProductionHouseException if a production house with the primary key could not be found
	 */
	@Override
	public ProductionHouse remove(long id)
		throws NoSuchProductionHouseException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the production house with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the production house
	 * @return the production house that was removed
	 * @throws NoSuchProductionHouseException if a production house with the primary key could not be found
	 */
	@Override
	public ProductionHouse remove(Serializable primaryKey)
		throws NoSuchProductionHouseException {

		Session session = null;

		try {
			session = openSession();

			ProductionHouse productionHouse = (ProductionHouse)session.get(
				ProductionHouseImpl.class, primaryKey);

			if (productionHouse == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductionHouseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productionHouse);
		}
		catch (NoSuchProductionHouseException noSuchEntityException) {
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
	protected ProductionHouse removeImpl(ProductionHouse productionHouse) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productionHouse)) {
				productionHouse = (ProductionHouse)session.get(
					ProductionHouseImpl.class,
					productionHouse.getPrimaryKeyObj());
			}

			if (productionHouse != null) {
				session.delete(productionHouse);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productionHouse != null) {
			clearCache(productionHouse);
		}

		return productionHouse;
	}

	@Override
	public ProductionHouse updateImpl(ProductionHouse productionHouse) {
		boolean isNew = productionHouse.isNew();

		Session session = null;

		try {
			session = openSession();

			if (productionHouse.isNew()) {
				session.save(productionHouse);

				productionHouse.setNew(false);
			}
			else {
				session.evict(productionHouse);
				session.saveOrUpdate(productionHouse);
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
			entityCacheEnabled, ProductionHouseImpl.class,
			productionHouse.getPrimaryKey(), productionHouse, false);

		productionHouse.resetOriginalValues();

		return productionHouse;
	}

	/**
	 * Returns the production house with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the production house
	 * @return the production house
	 * @throws NoSuchProductionHouseException if a production house with the primary key could not be found
	 */
	@Override
	public ProductionHouse findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductionHouseException {

		ProductionHouse productionHouse = fetchByPrimaryKey(primaryKey);

		if (productionHouse == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductionHouseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productionHouse;
	}

	/**
	 * Returns the production house with the primary key or throws a <code>NoSuchProductionHouseException</code> if it could not be found.
	 *
	 * @param id the primary key of the production house
	 * @return the production house
	 * @throws NoSuchProductionHouseException if a production house with the primary key could not be found
	 */
	@Override
	public ProductionHouse findByPrimaryKey(long id)
		throws NoSuchProductionHouseException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the production house with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the production house
	 * @return the production house, or <code>null</code> if a production house with the primary key could not be found
	 */
	@Override
	public ProductionHouse fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the production houses.
	 *
	 * @return the production houses
	 */
	@Override
	public List<ProductionHouse> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the production houses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production houses
	 * @param end the upper bound of the range of production houses (not inclusive)
	 * @return the range of production houses
	 */
	@Override
	public List<ProductionHouse> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the production houses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production houses
	 * @param end the upper bound of the range of production houses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of production houses
	 */
	@Override
	public List<ProductionHouse> findAll(
		int start, int end,
		OrderByComparator<ProductionHouse> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the production houses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production houses
	 * @param end the upper bound of the range of production houses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of production houses
	 */
	@Override
	public List<ProductionHouse> findAll(
		int start, int end,
		OrderByComparator<ProductionHouse> orderByComparator,
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

		List<ProductionHouse> list = null;

		if (useFinderCache) {
			list = (List<ProductionHouse>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PRODUCTIONHOUSE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTIONHOUSE;

				sql = sql.concat(ProductionHouseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<ProductionHouse>)QueryUtil.list(
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
	 * Removes all the production houses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductionHouse productionHouse : findAll()) {
			remove(productionHouse);
		}
	}

	/**
	 * Returns the number of production houses.
	 *
	 * @return the number of production houses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRODUCTIONHOUSE);

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
		return _SQL_SELECT_PRODUCTIONHOUSE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductionHouseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the production house persistence.
	 */
	@Activate
	public void activate() {
		ProductionHouseModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ProductionHouseModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ProductionHouseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ProductionHouseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ProductionHouseImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.techsocialist.servicebuilder.model.ProductionHouse"),
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

	private static final String _SQL_SELECT_PRODUCTIONHOUSE =
		"SELECT productionHouse FROM ProductionHouse productionHouse";

	private static final String _SQL_COUNT_PRODUCTIONHOUSE =
		"SELECT COUNT(productionHouse) FROM ProductionHouse productionHouse";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productionHouse.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductionHouse exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductionHousePersistenceImpl.class);

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
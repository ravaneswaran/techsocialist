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

package com.techsocialis.servicebuilder.service.persistence.impl;

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

import com.techsocialis.servicebuilder.exception.NoSuchProductionHouseRegisterException;
import com.techsocialis.servicebuilder.model.ProductionHouseRegister;
import com.techsocialis.servicebuilder.model.impl.ProductionHouseRegisterImpl;
import com.techsocialis.servicebuilder.model.impl.ProductionHouseRegisterModelImpl;
import com.techsocialis.servicebuilder.service.persistence.ProductionHouseRegisterPersistence;
import com.techsocialis.servicebuilder.service.persistence.impl.constants.TSPersistenceConstants;

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
 * The persistence implementation for the production house register service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductionHouseRegisterPersistence.class)
public class ProductionHouseRegisterPersistenceImpl
	extends BasePersistenceImpl<ProductionHouseRegister>
	implements ProductionHouseRegisterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductionHouseRegisterUtil</code> to access the production house register persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductionHouseRegisterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ProductionHouseRegisterPersistenceImpl() {
		setModelClass(ProductionHouseRegister.class);

		setModelImplClass(ProductionHouseRegisterImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("state", "state_");
		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the production house register in the entity cache if it is enabled.
	 *
	 * @param productionHouseRegister the production house register
	 */
	@Override
	public void cacheResult(ProductionHouseRegister productionHouseRegister) {
		entityCache.putResult(
			entityCacheEnabled, ProductionHouseRegisterImpl.class,
			productionHouseRegister.getPrimaryKey(), productionHouseRegister);

		productionHouseRegister.resetOriginalValues();
	}

	/**
	 * Caches the production house registers in the entity cache if it is enabled.
	 *
	 * @param productionHouseRegisters the production house registers
	 */
	@Override
	public void cacheResult(
		List<ProductionHouseRegister> productionHouseRegisters) {

		for (ProductionHouseRegister productionHouseRegister :
				productionHouseRegisters) {

			if (entityCache.getResult(
					entityCacheEnabled, ProductionHouseRegisterImpl.class,
					productionHouseRegister.getPrimaryKey()) == null) {

				cacheResult(productionHouseRegister);
			}
			else {
				productionHouseRegister.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all production house registers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductionHouseRegisterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the production house register.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductionHouseRegister productionHouseRegister) {
		entityCache.removeResult(
			entityCacheEnabled, ProductionHouseRegisterImpl.class,
			productionHouseRegister.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ProductionHouseRegister> productionHouseRegisters) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductionHouseRegister productionHouseRegister :
				productionHouseRegisters) {

			entityCache.removeResult(
				entityCacheEnabled, ProductionHouseRegisterImpl.class,
				productionHouseRegister.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ProductionHouseRegisterImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new production house register with the primary key. Does not add the production house register to the database.
	 *
	 * @param id the primary key for the new production house register
	 * @return the new production house register
	 */
	@Override
	public ProductionHouseRegister create(long id) {
		ProductionHouseRegister productionHouseRegister =
			new ProductionHouseRegisterImpl();

		productionHouseRegister.setNew(true);
		productionHouseRegister.setPrimaryKey(id);

		return productionHouseRegister;
	}

	/**
	 * Removes the production house register with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house register
	 * @return the production house register that was removed
	 * @throws NoSuchProductionHouseRegisterException if a production house register with the primary key could not be found
	 */
	@Override
	public ProductionHouseRegister remove(long id)
		throws NoSuchProductionHouseRegisterException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the production house register with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the production house register
	 * @return the production house register that was removed
	 * @throws NoSuchProductionHouseRegisterException if a production house register with the primary key could not be found
	 */
	@Override
	public ProductionHouseRegister remove(Serializable primaryKey)
		throws NoSuchProductionHouseRegisterException {

		Session session = null;

		try {
			session = openSession();

			ProductionHouseRegister productionHouseRegister =
				(ProductionHouseRegister)session.get(
					ProductionHouseRegisterImpl.class, primaryKey);

			if (productionHouseRegister == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductionHouseRegisterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productionHouseRegister);
		}
		catch (NoSuchProductionHouseRegisterException noSuchEntityException) {
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
	protected ProductionHouseRegister removeImpl(
		ProductionHouseRegister productionHouseRegister) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productionHouseRegister)) {
				productionHouseRegister = (ProductionHouseRegister)session.get(
					ProductionHouseRegisterImpl.class,
					productionHouseRegister.getPrimaryKeyObj());
			}

			if (productionHouseRegister != null) {
				session.delete(productionHouseRegister);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productionHouseRegister != null) {
			clearCache(productionHouseRegister);
		}

		return productionHouseRegister;
	}

	@Override
	public ProductionHouseRegister updateImpl(
		ProductionHouseRegister productionHouseRegister) {

		boolean isNew = productionHouseRegister.isNew();

		Session session = null;

		try {
			session = openSession();

			if (productionHouseRegister.isNew()) {
				session.save(productionHouseRegister);

				productionHouseRegister.setNew(false);
			}
			else {
				productionHouseRegister =
					(ProductionHouseRegister)session.merge(
						productionHouseRegister);
			}
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
			entityCacheEnabled, ProductionHouseRegisterImpl.class,
			productionHouseRegister.getPrimaryKey(), productionHouseRegister,
			false);

		productionHouseRegister.resetOriginalValues();

		return productionHouseRegister;
	}

	/**
	 * Returns the production house register with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the production house register
	 * @return the production house register
	 * @throws NoSuchProductionHouseRegisterException if a production house register with the primary key could not be found
	 */
	@Override
	public ProductionHouseRegister findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductionHouseRegisterException {

		ProductionHouseRegister productionHouseRegister = fetchByPrimaryKey(
			primaryKey);

		if (productionHouseRegister == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductionHouseRegisterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productionHouseRegister;
	}

	/**
	 * Returns the production house register with the primary key or throws a <code>NoSuchProductionHouseRegisterException</code> if it could not be found.
	 *
	 * @param id the primary key of the production house register
	 * @return the production house register
	 * @throws NoSuchProductionHouseRegisterException if a production house register with the primary key could not be found
	 */
	@Override
	public ProductionHouseRegister findByPrimaryKey(long id)
		throws NoSuchProductionHouseRegisterException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the production house register with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the production house register
	 * @return the production house register, or <code>null</code> if a production house register with the primary key could not be found
	 */
	@Override
	public ProductionHouseRegister fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the production house registers.
	 *
	 * @return the production house registers
	 */
	@Override
	public List<ProductionHouseRegister> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the production house registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house registers
	 * @param end the upper bound of the range of production house registers (not inclusive)
	 * @return the range of production house registers
	 */
	@Override
	public List<ProductionHouseRegister> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the production house registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house registers
	 * @param end the upper bound of the range of production house registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of production house registers
	 */
	@Override
	public List<ProductionHouseRegister> findAll(
		int start, int end,
		OrderByComparator<ProductionHouseRegister> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the production house registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductionHouseRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house registers
	 * @param end the upper bound of the range of production house registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of production house registers
	 */
	@Override
	public List<ProductionHouseRegister> findAll(
		int start, int end,
		OrderByComparator<ProductionHouseRegister> orderByComparator,
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

		List<ProductionHouseRegister> list = null;

		if (useFinderCache) {
			list = (List<ProductionHouseRegister>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PRODUCTIONHOUSEREGISTER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTIONHOUSEREGISTER;

				sql = sql.concat(
					ProductionHouseRegisterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<ProductionHouseRegister>)QueryUtil.list(
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
	 * Removes all the production house registers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductionHouseRegister productionHouseRegister : findAll()) {
			remove(productionHouseRegister);
		}
	}

	/**
	 * Returns the number of production house registers.
	 *
	 * @return the number of production house registers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
					_SQL_COUNT_PRODUCTIONHOUSEREGISTER);

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
		return _SQL_SELECT_PRODUCTIONHOUSEREGISTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductionHouseRegisterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the production house register persistence.
	 */
	@Activate
	public void activate() {
		ProductionHouseRegisterModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		ProductionHouseRegisterModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ProductionHouseRegisterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ProductionHouseRegisterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ProductionHouseRegisterImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.techsocialis.servicebuilder.model.ProductionHouseRegister"),
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

	private static final String _SQL_SELECT_PRODUCTIONHOUSEREGISTER =
		"SELECT productionHouseRegister FROM ProductionHouseRegister productionHouseRegister";

	private static final String _SQL_COUNT_PRODUCTIONHOUSEREGISTER =
		"SELECT COUNT(productionHouseRegister) FROM ProductionHouseRegister productionHouseRegister";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"productionHouseRegister.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductionHouseRegister exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductionHouseRegisterPersistenceImpl.class);

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
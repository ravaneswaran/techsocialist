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

import com.techsocialist.servicebuilder.exception.NoSuchTicketPriceException;
import com.techsocialist.servicebuilder.model.TicketPrice;
import com.techsocialist.servicebuilder.model.impl.TicketPriceImpl;
import com.techsocialist.servicebuilder.model.impl.TicketPriceModelImpl;
import com.techsocialist.servicebuilder.service.persistence.TicketPricePersistence;
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
 * The persistence implementation for the ticket price service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketPricePersistence.class)
public class TicketPricePersistenceImpl
	extends BasePersistenceImpl<TicketPrice> implements TicketPricePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketPriceUtil</code> to access the ticket price persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketPriceImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TicketPricePersistenceImpl() {
		setModelClass(TicketPrice.class);

		setModelImplClass(TicketPriceImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the ticket price in the entity cache if it is enabled.
	 *
	 * @param ticketPrice the ticket price
	 */
	@Override
	public void cacheResult(TicketPrice ticketPrice) {
		entityCache.putResult(
			entityCacheEnabled, TicketPriceImpl.class,
			ticketPrice.getPrimaryKey(), ticketPrice);

		ticketPrice.resetOriginalValues();
	}

	/**
	 * Caches the ticket prices in the entity cache if it is enabled.
	 *
	 * @param ticketPrices the ticket prices
	 */
	@Override
	public void cacheResult(List<TicketPrice> ticketPrices) {
		for (TicketPrice ticketPrice : ticketPrices) {
			if (entityCache.getResult(
					entityCacheEnabled, TicketPriceImpl.class,
					ticketPrice.getPrimaryKey()) == null) {

				cacheResult(ticketPrice);
			}
			else {
				ticketPrice.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket prices.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketPriceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket price.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketPrice ticketPrice) {
		entityCache.removeResult(
			entityCacheEnabled, TicketPriceImpl.class,
			ticketPrice.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TicketPrice> ticketPrices) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketPrice ticketPrice : ticketPrices) {
			entityCache.removeResult(
				entityCacheEnabled, TicketPriceImpl.class,
				ticketPrice.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TicketPriceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new ticket price with the primary key. Does not add the ticket price to the database.
	 *
	 * @param id the primary key for the new ticket price
	 * @return the new ticket price
	 */
	@Override
	public TicketPrice create(long id) {
		TicketPrice ticketPrice = new TicketPriceImpl();

		ticketPrice.setNew(true);
		ticketPrice.setPrimaryKey(id);

		return ticketPrice;
	}

	/**
	 * Removes the ticket price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ticket price
	 * @return the ticket price that was removed
	 * @throws NoSuchTicketPriceException if a ticket price with the primary key could not be found
	 */
	@Override
	public TicketPrice remove(long id) throws NoSuchTicketPriceException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the ticket price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket price
	 * @return the ticket price that was removed
	 * @throws NoSuchTicketPriceException if a ticket price with the primary key could not be found
	 */
	@Override
	public TicketPrice remove(Serializable primaryKey)
		throws NoSuchTicketPriceException {

		Session session = null;

		try {
			session = openSession();

			TicketPrice ticketPrice = (TicketPrice)session.get(
				TicketPriceImpl.class, primaryKey);

			if (ticketPrice == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketPriceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketPrice);
		}
		catch (NoSuchTicketPriceException noSuchEntityException) {
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
	protected TicketPrice removeImpl(TicketPrice ticketPrice) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketPrice)) {
				ticketPrice = (TicketPrice)session.get(
					TicketPriceImpl.class, ticketPrice.getPrimaryKeyObj());
			}

			if (ticketPrice != null) {
				session.delete(ticketPrice);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ticketPrice != null) {
			clearCache(ticketPrice);
		}

		return ticketPrice;
	}

	@Override
	public TicketPrice updateImpl(TicketPrice ticketPrice) {
		boolean isNew = ticketPrice.isNew();

		Session session = null;

		try {
			session = openSession();

			if (ticketPrice.isNew()) {
				session.save(ticketPrice);

				ticketPrice.setNew(false);
			}
			else {
				ticketPrice = (TicketPrice)session.merge(ticketPrice);
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
			entityCacheEnabled, TicketPriceImpl.class,
			ticketPrice.getPrimaryKey(), ticketPrice, false);

		ticketPrice.resetOriginalValues();

		return ticketPrice;
	}

	/**
	 * Returns the ticket price with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket price
	 * @return the ticket price
	 * @throws NoSuchTicketPriceException if a ticket price with the primary key could not be found
	 */
	@Override
	public TicketPrice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketPriceException {

		TicketPrice ticketPrice = fetchByPrimaryKey(primaryKey);

		if (ticketPrice == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketPriceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketPrice;
	}

	/**
	 * Returns the ticket price with the primary key or throws a <code>NoSuchTicketPriceException</code> if it could not be found.
	 *
	 * @param id the primary key of the ticket price
	 * @return the ticket price
	 * @throws NoSuchTicketPriceException if a ticket price with the primary key could not be found
	 */
	@Override
	public TicketPrice findByPrimaryKey(long id)
		throws NoSuchTicketPriceException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the ticket price with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ticket price
	 * @return the ticket price, or <code>null</code> if a ticket price with the primary key could not be found
	 */
	@Override
	public TicketPrice fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the ticket prices.
	 *
	 * @return the ticket prices
	 */
	@Override
	public List<TicketPrice> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketPriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket prices
	 * @param end the upper bound of the range of ticket prices (not inclusive)
	 * @return the range of ticket prices
	 */
	@Override
	public List<TicketPrice> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketPriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket prices
	 * @param end the upper bound of the range of ticket prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket prices
	 */
	@Override
	public List<TicketPrice> findAll(
		int start, int end, OrderByComparator<TicketPrice> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketPriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket prices
	 * @param end the upper bound of the range of ticket prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket prices
	 */
	@Override
	public List<TicketPrice> findAll(
		int start, int end, OrderByComparator<TicketPrice> orderByComparator,
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

		List<TicketPrice> list = null;

		if (useFinderCache) {
			list = (List<TicketPrice>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETPRICE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETPRICE;

				sql = sql.concat(TicketPriceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<TicketPrice>)QueryUtil.list(
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
	 * Removes all the ticket prices from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketPrice ticketPrice : findAll()) {
			remove(ticketPrice);
		}
	}

	/**
	 * Returns the number of ticket prices.
	 *
	 * @return the number of ticket prices
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETPRICE);

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
		return _SQL_SELECT_TICKETPRICE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketPriceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket price persistence.
	 */
	@Activate
	public void activate() {
		TicketPriceModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TicketPriceModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketPriceImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.techsocialist.servicebuilder.model.TicketPrice"),
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

	private static final String _SQL_SELECT_TICKETPRICE =
		"SELECT ticketPrice FROM TicketPrice ticketPrice";

	private static final String _SQL_COUNT_TICKETPRICE =
		"SELECT COUNT(ticketPrice) FROM TicketPrice ticketPrice";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketPrice.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketPrice exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketPricePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	static {
		try {
			Class.forName(TSPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}
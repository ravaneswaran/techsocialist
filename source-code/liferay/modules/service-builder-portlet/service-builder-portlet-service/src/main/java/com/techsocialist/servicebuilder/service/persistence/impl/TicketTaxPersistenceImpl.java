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

import com.techsocialist.servicebuilder.exception.NoSuchTicketTaxException;
import com.techsocialist.servicebuilder.model.TicketTax;
import com.techsocialist.servicebuilder.model.impl.TicketTaxImpl;
import com.techsocialist.servicebuilder.model.impl.TicketTaxModelImpl;
import com.techsocialist.servicebuilder.service.persistence.TicketTaxPersistence;
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
 * The persistence implementation for the ticket tax service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketTaxPersistence.class)
public class TicketTaxPersistenceImpl
	extends BasePersistenceImpl<TicketTax> implements TicketTaxPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketTaxUtil</code> to access the ticket tax persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketTaxImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TicketTaxPersistenceImpl() {
		setModelClass(TicketTax.class);

		setModelImplClass(TicketTaxImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the ticket tax in the entity cache if it is enabled.
	 *
	 * @param ticketTax the ticket tax
	 */
	@Override
	public void cacheResult(TicketTax ticketTax) {
		entityCache.putResult(
			entityCacheEnabled, TicketTaxImpl.class, ticketTax.getPrimaryKey(),
			ticketTax);

		ticketTax.resetOriginalValues();
	}

	/**
	 * Caches the ticket taxs in the entity cache if it is enabled.
	 *
	 * @param ticketTaxs the ticket taxs
	 */
	@Override
	public void cacheResult(List<TicketTax> ticketTaxs) {
		for (TicketTax ticketTax : ticketTaxs) {
			if (entityCache.getResult(
					entityCacheEnabled, TicketTaxImpl.class,
					ticketTax.getPrimaryKey()) == null) {

				cacheResult(ticketTax);
			}
			else {
				ticketTax.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket taxs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketTaxImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket tax.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketTax ticketTax) {
		entityCache.removeResult(
			entityCacheEnabled, TicketTaxImpl.class, ticketTax.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TicketTax> ticketTaxs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketTax ticketTax : ticketTaxs) {
			entityCache.removeResult(
				entityCacheEnabled, TicketTaxImpl.class,
				ticketTax.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TicketTaxImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new ticket tax with the primary key. Does not add the ticket tax to the database.
	 *
	 * @param id the primary key for the new ticket tax
	 * @return the new ticket tax
	 */
	@Override
	public TicketTax create(long id) {
		TicketTax ticketTax = new TicketTaxImpl();

		ticketTax.setNew(true);
		ticketTax.setPrimaryKey(id);

		return ticketTax;
	}

	/**
	 * Removes the ticket tax with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ticket tax
	 * @return the ticket tax that was removed
	 * @throws NoSuchTicketTaxException if a ticket tax with the primary key could not be found
	 */
	@Override
	public TicketTax remove(long id) throws NoSuchTicketTaxException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the ticket tax with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket tax
	 * @return the ticket tax that was removed
	 * @throws NoSuchTicketTaxException if a ticket tax with the primary key could not be found
	 */
	@Override
	public TicketTax remove(Serializable primaryKey)
		throws NoSuchTicketTaxException {

		Session session = null;

		try {
			session = openSession();

			TicketTax ticketTax = (TicketTax)session.get(
				TicketTaxImpl.class, primaryKey);

			if (ticketTax == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketTaxException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketTax);
		}
		catch (NoSuchTicketTaxException noSuchEntityException) {
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
	protected TicketTax removeImpl(TicketTax ticketTax) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketTax)) {
				ticketTax = (TicketTax)session.get(
					TicketTaxImpl.class, ticketTax.getPrimaryKeyObj());
			}

			if (ticketTax != null) {
				session.delete(ticketTax);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ticketTax != null) {
			clearCache(ticketTax);
		}

		return ticketTax;
	}

	@Override
	public TicketTax updateImpl(TicketTax ticketTax) {
		boolean isNew = ticketTax.isNew();

		Session session = null;

		try {
			session = openSession();

			if (ticketTax.isNew()) {
				session.save(ticketTax);

				ticketTax.setNew(false);
			}
			else {
				ticketTax = (TicketTax)session.merge(ticketTax);
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
			entityCacheEnabled, TicketTaxImpl.class, ticketTax.getPrimaryKey(),
			ticketTax, false);

		ticketTax.resetOriginalValues();

		return ticketTax;
	}

	/**
	 * Returns the ticket tax with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket tax
	 * @return the ticket tax
	 * @throws NoSuchTicketTaxException if a ticket tax with the primary key could not be found
	 */
	@Override
	public TicketTax findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketTaxException {

		TicketTax ticketTax = fetchByPrimaryKey(primaryKey);

		if (ticketTax == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketTaxException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketTax;
	}

	/**
	 * Returns the ticket tax with the primary key or throws a <code>NoSuchTicketTaxException</code> if it could not be found.
	 *
	 * @param id the primary key of the ticket tax
	 * @return the ticket tax
	 * @throws NoSuchTicketTaxException if a ticket tax with the primary key could not be found
	 */
	@Override
	public TicketTax findByPrimaryKey(long id) throws NoSuchTicketTaxException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the ticket tax with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the ticket tax
	 * @return the ticket tax, or <code>null</code> if a ticket tax with the primary key could not be found
	 */
	@Override
	public TicketTax fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the ticket taxs.
	 *
	 * @return the ticket taxs
	 */
	@Override
	public List<TicketTax> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket taxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketTaxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket taxs
	 * @param end the upper bound of the range of ticket taxs (not inclusive)
	 * @return the range of ticket taxs
	 */
	@Override
	public List<TicketTax> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket taxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketTaxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket taxs
	 * @param end the upper bound of the range of ticket taxs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket taxs
	 */
	@Override
	public List<TicketTax> findAll(
		int start, int end, OrderByComparator<TicketTax> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket taxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketTaxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket taxs
	 * @param end the upper bound of the range of ticket taxs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket taxs
	 */
	@Override
	public List<TicketTax> findAll(
		int start, int end, OrderByComparator<TicketTax> orderByComparator,
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

		List<TicketTax> list = null;

		if (useFinderCache) {
			list = (List<TicketTax>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETTAX);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETTAX;

				sql = sql.concat(TicketTaxModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<TicketTax>)QueryUtil.list(
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
	 * Removes all the ticket taxs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketTax ticketTax : findAll()) {
			remove(ticketTax);
		}
	}

	/**
	 * Returns the number of ticket taxs.
	 *
	 * @return the number of ticket taxs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETTAX);

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
		return _SQL_SELECT_TICKETTAX;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketTaxModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket tax persistence.
	 */
	@Activate
	public void activate() {
		TicketTaxModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TicketTaxModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketTaxImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketTaxImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketTaxImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.techsocialist.servicebuilder.model.TicketTax"),
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

	private static final String _SQL_SELECT_TICKETTAX =
		"SELECT ticketTax FROM TicketTax ticketTax";

	private static final String _SQL_COUNT_TICKETTAX =
		"SELECT COUNT(ticketTax) FROM TicketTax ticketTax";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketTax.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketTax exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketTaxPersistenceImpl.class);

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
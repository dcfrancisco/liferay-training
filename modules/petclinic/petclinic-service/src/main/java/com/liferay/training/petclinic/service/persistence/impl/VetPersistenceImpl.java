/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.training.petclinic.exception.NoSuchVetException;
import com.liferay.training.petclinic.model.Vet;
import com.liferay.training.petclinic.model.impl.VetImpl;
import com.liferay.training.petclinic.model.impl.VetModelImpl;
import com.liferay.training.petclinic.service.persistence.VetPersistence;
import com.liferay.training.petclinic.service.persistence.VetUtil;
import com.liferay.training.petclinic.service.persistence.impl.constants.PetClinicPersistenceConstants;

import java.io.Serializable;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the vet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VetPersistence.class)
public class VetPersistenceImpl
	extends BasePersistenceImpl<Vet> implements VetPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VetUtil</code> to access the vet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VetImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public VetPersistenceImpl() {
		setModelClass(Vet.class);

		setModelImplClass(VetImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the vet in the entity cache if it is enabled.
	 *
	 * @param vet the vet
	 */
	@Override
	public void cacheResult(Vet vet) {
		entityCache.putResult(VetImpl.class, vet.getPrimaryKey(), vet);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the vets in the entity cache if it is enabled.
	 *
	 * @param vets the vets
	 */
	@Override
	public void cacheResult(List<Vet> vets) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (vets.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Vet vet : vets) {
			if (entityCache.getResult(VetImpl.class, vet.getPrimaryKey()) ==
					null) {

				cacheResult(vet);
			}
		}
	}

	/**
	 * Clears the cache for all vets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VetImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vet.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Vet vet) {
		entityCache.removeResult(VetImpl.class, vet);
	}

	@Override
	public void clearCache(List<Vet> vets) {
		for (Vet vet : vets) {
			entityCache.removeResult(VetImpl.class, vet);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VetImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new vet with the primary key. Does not add the vet to the database.
	 *
	 * @param vetId the primary key for the new vet
	 * @return the new vet
	 */
	@Override
	public Vet create(long vetId) {
		Vet vet = new VetImpl();

		vet.setNew(true);
		vet.setPrimaryKey(vetId);

		return vet;
	}

	/**
	 * Removes the vet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vetId the primary key of the vet
	 * @return the vet that was removed
	 * @throws NoSuchVetException if a vet with the primary key could not be found
	 */
	@Override
	public Vet remove(long vetId) throws NoSuchVetException {
		return remove((Serializable)vetId);
	}

	/**
	 * Removes the vet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vet
	 * @return the vet that was removed
	 * @throws NoSuchVetException if a vet with the primary key could not be found
	 */
	@Override
	public Vet remove(Serializable primaryKey) throws NoSuchVetException {
		Session session = null;

		try {
			session = openSession();

			Vet vet = (Vet)session.get(VetImpl.class, primaryKey);

			if (vet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVetException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(vet);
		}
		catch (NoSuchVetException noSuchEntityException) {
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
	protected Vet removeImpl(Vet vet) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vet)) {
				vet = (Vet)session.get(VetImpl.class, vet.getPrimaryKeyObj());
			}

			if (vet != null) {
				session.delete(vet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (vet != null) {
			clearCache(vet);
		}

		return vet;
	}

	@Override
	public Vet updateImpl(Vet vet) {
		boolean isNew = vet.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(vet);
			}
			else {
				vet = (Vet)session.merge(vet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(VetImpl.class, vet, false, true);

		if (isNew) {
			vet.setNew(false);
		}

		vet.resetOriginalValues();

		return vet;
	}

	/**
	 * Returns the vet with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vet
	 * @return the vet
	 * @throws NoSuchVetException if a vet with the primary key could not be found
	 */
	@Override
	public Vet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVetException {

		Vet vet = fetchByPrimaryKey(primaryKey);

		if (vet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVetException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return vet;
	}

	/**
	 * Returns the vet with the primary key or throws a <code>NoSuchVetException</code> if it could not be found.
	 *
	 * @param vetId the primary key of the vet
	 * @return the vet
	 * @throws NoSuchVetException if a vet with the primary key could not be found
	 */
	@Override
	public Vet findByPrimaryKey(long vetId) throws NoSuchVetException {
		return findByPrimaryKey((Serializable)vetId);
	}

	/**
	 * Returns the vet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vetId the primary key of the vet
	 * @return the vet, or <code>null</code> if a vet with the primary key could not be found
	 */
	@Override
	public Vet fetchByPrimaryKey(long vetId) {
		return fetchByPrimaryKey((Serializable)vetId);
	}

	/**
	 * Returns all the vets.
	 *
	 * @return the vets
	 */
	@Override
	public List<Vet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vets
	 * @param end the upper bound of the range of vets (not inclusive)
	 * @return the range of vets
	 */
	@Override
	public List<Vet> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vets
	 * @param end the upper bound of the range of vets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vets
	 */
	@Override
	public List<Vet> findAll(
		int start, int end, OrderByComparator<Vet> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vets
	 * @param end the upper bound of the range of vets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of vets
	 */
	@Override
	public List<Vet> findAll(
		int start, int end, OrderByComparator<Vet> orderByComparator,
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

		List<Vet> list = null;

		if (useFinderCache) {
			list = (List<Vet>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VET);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VET;

				sql = sql.concat(VetModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Vet>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the vets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Vet vet : findAll()) {
			remove(vet);
		}
	}

	/**
	 * Returns the number of vets.
	 *
	 * @return the number of vets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VET);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "vetId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VetModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vet persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new VetModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Vet.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		VetUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		VetUtil.setPersistence(null);

		entityCache.removeCache(VetImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = PetClinicPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PetClinicPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PetClinicPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VET = "SELECT vet FROM Vet vet";

	private static final String _SQL_COUNT_VET =
		"SELECT COUNT(vet) FROM Vet vet";

	private static final String _ORDER_BY_ENTITY_ALIAS = "vet.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Vet exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		VetPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class VetModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			VetModelImpl vetModelImpl = (VetModelImpl)baseModel;

			long columnBitmask = vetModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(vetModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= vetModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(vetModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			VetModelImpl vetModelImpl, String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = vetModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = vetModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}
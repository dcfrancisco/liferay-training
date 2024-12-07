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
import com.liferay.training.petclinic.exception.NoSuchSpecialtyException;
import com.liferay.training.petclinic.model.Specialty;
import com.liferay.training.petclinic.model.impl.SpecialtyImpl;
import com.liferay.training.petclinic.model.impl.SpecialtyModelImpl;
import com.liferay.training.petclinic.service.persistence.SpecialtyPersistence;
import com.liferay.training.petclinic.service.persistence.SpecialtyUtil;
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
 * The persistence implementation for the specialty service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SpecialtyPersistence.class)
public class SpecialtyPersistenceImpl
	extends BasePersistenceImpl<Specialty> implements SpecialtyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SpecialtyUtil</code> to access the specialty persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SpecialtyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SpecialtyPersistenceImpl() {
		setModelClass(Specialty.class);

		setModelImplClass(SpecialtyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the specialty in the entity cache if it is enabled.
	 *
	 * @param specialty the specialty
	 */
	@Override
	public void cacheResult(Specialty specialty) {
		entityCache.putResult(
			SpecialtyImpl.class, specialty.getPrimaryKey(), specialty);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the specialties in the entity cache if it is enabled.
	 *
	 * @param specialties the specialties
	 */
	@Override
	public void cacheResult(List<Specialty> specialties) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (specialties.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Specialty specialty : specialties) {
			if (entityCache.getResult(
					SpecialtyImpl.class, specialty.getPrimaryKey()) == null) {

				cacheResult(specialty);
			}
		}
	}

	/**
	 * Clears the cache for all specialties.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SpecialtyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the specialty.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Specialty specialty) {
		entityCache.removeResult(SpecialtyImpl.class, specialty);
	}

	@Override
	public void clearCache(List<Specialty> specialties) {
		for (Specialty specialty : specialties) {
			entityCache.removeResult(SpecialtyImpl.class, specialty);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SpecialtyImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new specialty with the primary key. Does not add the specialty to the database.
	 *
	 * @param specialtyId the primary key for the new specialty
	 * @return the new specialty
	 */
	@Override
	public Specialty create(long specialtyId) {
		Specialty specialty = new SpecialtyImpl();

		specialty.setNew(true);
		specialty.setPrimaryKey(specialtyId);

		return specialty;
	}

	/**
	 * Removes the specialty with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specialtyId the primary key of the specialty
	 * @return the specialty that was removed
	 * @throws NoSuchSpecialtyException if a specialty with the primary key could not be found
	 */
	@Override
	public Specialty remove(long specialtyId) throws NoSuchSpecialtyException {
		return remove((Serializable)specialtyId);
	}

	/**
	 * Removes the specialty with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the specialty
	 * @return the specialty that was removed
	 * @throws NoSuchSpecialtyException if a specialty with the primary key could not be found
	 */
	@Override
	public Specialty remove(Serializable primaryKey)
		throws NoSuchSpecialtyException {

		Session session = null;

		try {
			session = openSession();

			Specialty specialty = (Specialty)session.get(
				SpecialtyImpl.class, primaryKey);

			if (specialty == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpecialtyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(specialty);
		}
		catch (NoSuchSpecialtyException noSuchEntityException) {
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
	protected Specialty removeImpl(Specialty specialty) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(specialty)) {
				specialty = (Specialty)session.get(
					SpecialtyImpl.class, specialty.getPrimaryKeyObj());
			}

			if (specialty != null) {
				session.delete(specialty);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (specialty != null) {
			clearCache(specialty);
		}

		return specialty;
	}

	@Override
	public Specialty updateImpl(Specialty specialty) {
		boolean isNew = specialty.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(specialty);
			}
			else {
				specialty = (Specialty)session.merge(specialty);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SpecialtyImpl.class, specialty, false, true);

		if (isNew) {
			specialty.setNew(false);
		}

		specialty.resetOriginalValues();

		return specialty;
	}

	/**
	 * Returns the specialty with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the specialty
	 * @return the specialty
	 * @throws NoSuchSpecialtyException if a specialty with the primary key could not be found
	 */
	@Override
	public Specialty findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpecialtyException {

		Specialty specialty = fetchByPrimaryKey(primaryKey);

		if (specialty == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpecialtyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return specialty;
	}

	/**
	 * Returns the specialty with the primary key or throws a <code>NoSuchSpecialtyException</code> if it could not be found.
	 *
	 * @param specialtyId the primary key of the specialty
	 * @return the specialty
	 * @throws NoSuchSpecialtyException if a specialty with the primary key could not be found
	 */
	@Override
	public Specialty findByPrimaryKey(long specialtyId)
		throws NoSuchSpecialtyException {

		return findByPrimaryKey((Serializable)specialtyId);
	}

	/**
	 * Returns the specialty with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specialtyId the primary key of the specialty
	 * @return the specialty, or <code>null</code> if a specialty with the primary key could not be found
	 */
	@Override
	public Specialty fetchByPrimaryKey(long specialtyId) {
		return fetchByPrimaryKey((Serializable)specialtyId);
	}

	/**
	 * Returns all the specialties.
	 *
	 * @return the specialties
	 */
	@Override
	public List<Specialty> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the specialties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecialtyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specialties
	 * @param end the upper bound of the range of specialties (not inclusive)
	 * @return the range of specialties
	 */
	@Override
	public List<Specialty> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the specialties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecialtyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specialties
	 * @param end the upper bound of the range of specialties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of specialties
	 */
	@Override
	public List<Specialty> findAll(
		int start, int end, OrderByComparator<Specialty> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the specialties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecialtyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specialties
	 * @param end the upper bound of the range of specialties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of specialties
	 */
	@Override
	public List<Specialty> findAll(
		int start, int end, OrderByComparator<Specialty> orderByComparator,
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

		List<Specialty> list = null;

		if (useFinderCache) {
			list = (List<Specialty>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SPECIALTY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SPECIALTY;

				sql = sql.concat(SpecialtyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Specialty>)QueryUtil.list(
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
	 * Removes all the specialties from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Specialty specialty : findAll()) {
			remove(specialty);
		}
	}

	/**
	 * Returns the number of specialties.
	 *
	 * @return the number of specialties
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SPECIALTY);

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
		return "specialtyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SPECIALTY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SpecialtyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the specialty persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new SpecialtyModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Specialty.class.getName()));

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

		SpecialtyUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SpecialtyUtil.setPersistence(null);

		entityCache.removeCache(SpecialtyImpl.class.getName());

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

	private static final String _SQL_SELECT_SPECIALTY =
		"SELECT specialty FROM Specialty specialty";

	private static final String _SQL_COUNT_SPECIALTY =
		"SELECT COUNT(specialty) FROM Specialty specialty";

	private static final String _ORDER_BY_ENTITY_ALIAS = "specialty.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Specialty exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SpecialtyPersistenceImpl.class);

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

	private static class SpecialtyModelArgumentsResolver
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

			SpecialtyModelImpl specialtyModelImpl =
				(SpecialtyModelImpl)baseModel;

			long columnBitmask = specialtyModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(specialtyModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						specialtyModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(specialtyModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SpecialtyModelImpl specialtyModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = specialtyModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = specialtyModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}
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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.training.petclinic.exception.NoSuchOwnerException;
import com.liferay.training.petclinic.model.Owner;
import com.liferay.training.petclinic.model.impl.OwnerImpl;
import com.liferay.training.petclinic.model.impl.OwnerModelImpl;
import com.liferay.training.petclinic.service.persistence.OwnerPersistence;
import com.liferay.training.petclinic.service.persistence.OwnerUtil;
import com.liferay.training.petclinic.service.persistence.impl.constants.PetClinicPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
 * The persistence implementation for the owner service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OwnerPersistence.class)
public class OwnerPersistenceImpl
	extends BasePersistenceImpl<Owner> implements OwnerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OwnerUtil</code> to access the owner persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OwnerImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByLastName;
	private FinderPath _finderPathWithoutPaginationFindByLastName;
	private FinderPath _finderPathCountByLastName;

	/**
	 * Returns all the owners where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching owners
	 */
	@Override
	public List<Owner> findByLastName(String lastName) {
		return findByLastName(
			lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the owners where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OwnerModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of owners
	 * @param end the upper bound of the range of owners (not inclusive)
	 * @return the range of matching owners
	 */
	@Override
	public List<Owner> findByLastName(String lastName, int start, int end) {
		return findByLastName(lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the owners where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OwnerModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of owners
	 * @param end the upper bound of the range of owners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching owners
	 */
	@Override
	public List<Owner> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<Owner> orderByComparator) {

		return findByLastName(lastName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the owners where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OwnerModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of owners
	 * @param end the upper bound of the range of owners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching owners
	 */
	@Override
	public List<Owner> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<Owner> orderByComparator, boolean useFinderCache) {

		lastName = Objects.toString(lastName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLastName;
				finderArgs = new Object[] {lastName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLastName;
			finderArgs = new Object[] {lastName, start, end, orderByComparator};
		}

		List<Owner> list = null;

		if (useFinderCache) {
			list = (List<Owner>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Owner owner : list) {
					if (!lastName.equals(owner.getLastName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_OWNER_WHERE);

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OwnerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLastName) {
					queryPos.add(lastName);
				}

				list = (List<Owner>)QueryUtil.list(
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
	 * Returns the first owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching owner
	 * @throws NoSuchOwnerException if a matching owner could not be found
	 */
	@Override
	public Owner findByLastName_First(
			String lastName, OrderByComparator<Owner> orderByComparator)
		throws NoSuchOwnerException {

		Owner owner = fetchByLastName_First(lastName, orderByComparator);

		if (owner != null) {
			return owner;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lastName=");
		sb.append(lastName);

		sb.append("}");

		throw new NoSuchOwnerException(sb.toString());
	}

	/**
	 * Returns the first owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching owner, or <code>null</code> if a matching owner could not be found
	 */
	@Override
	public Owner fetchByLastName_First(
		String lastName, OrderByComparator<Owner> orderByComparator) {

		List<Owner> list = findByLastName(lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching owner
	 * @throws NoSuchOwnerException if a matching owner could not be found
	 */
	@Override
	public Owner findByLastName_Last(
			String lastName, OrderByComparator<Owner> orderByComparator)
		throws NoSuchOwnerException {

		Owner owner = fetchByLastName_Last(lastName, orderByComparator);

		if (owner != null) {
			return owner;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lastName=");
		sb.append(lastName);

		sb.append("}");

		throw new NoSuchOwnerException(sb.toString());
	}

	/**
	 * Returns the last owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching owner, or <code>null</code> if a matching owner could not be found
	 */
	@Override
	public Owner fetchByLastName_Last(
		String lastName, OrderByComparator<Owner> orderByComparator) {

		int count = countByLastName(lastName);

		if (count == 0) {
			return null;
		}

		List<Owner> list = findByLastName(
			lastName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the owners before and after the current owner in the ordered set where lastName = &#63;.
	 *
	 * @param ownerId the primary key of the current owner
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next owner
	 * @throws NoSuchOwnerException if a owner with the primary key could not be found
	 */
	@Override
	public Owner[] findByLastName_PrevAndNext(
			long ownerId, String lastName,
			OrderByComparator<Owner> orderByComparator)
		throws NoSuchOwnerException {

		lastName = Objects.toString(lastName, "");

		Owner owner = findByPrimaryKey(ownerId);

		Session session = null;

		try {
			session = openSession();

			Owner[] array = new OwnerImpl[3];

			array[0] = getByLastName_PrevAndNext(
				session, owner, lastName, orderByComparator, true);

			array[1] = owner;

			array[2] = getByLastName_PrevAndNext(
				session, owner, lastName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Owner getByLastName_PrevAndNext(
		Session session, Owner owner, String lastName,
		OrderByComparator<Owner> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OWNER_WHERE);

		boolean bindLastName = false;

		if (lastName.isEmpty()) {
			sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OwnerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLastName) {
			queryPos.add(lastName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(owner)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Owner> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the owners where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	@Override
	public void removeByLastName(String lastName) {
		for (Owner owner :
				findByLastName(
					lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(owner);
		}
	}

	/**
	 * Returns the number of owners where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching owners
	 */
	@Override
	public int countByLastName(String lastName) {
		lastName = Objects.toString(lastName, "");

		FinderPath finderPath = _finderPathCountByLastName;

		Object[] finderArgs = new Object[] {lastName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OWNER_WHERE);

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLastName) {
					queryPos.add(lastName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_2 =
		"owner.lastName = ?";

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_3 =
		"(owner.lastName IS NULL OR owner.lastName = '')";

	public OwnerPersistenceImpl() {
		setModelClass(Owner.class);

		setModelImplClass(OwnerImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the owner in the entity cache if it is enabled.
	 *
	 * @param owner the owner
	 */
	@Override
	public void cacheResult(Owner owner) {
		entityCache.putResult(OwnerImpl.class, owner.getPrimaryKey(), owner);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the owners in the entity cache if it is enabled.
	 *
	 * @param owners the owners
	 */
	@Override
	public void cacheResult(List<Owner> owners) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (owners.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Owner owner : owners) {
			if (entityCache.getResult(OwnerImpl.class, owner.getPrimaryKey()) ==
					null) {

				cacheResult(owner);
			}
		}
	}

	/**
	 * Clears the cache for all owners.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OwnerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the owner.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Owner owner) {
		entityCache.removeResult(OwnerImpl.class, owner);
	}

	@Override
	public void clearCache(List<Owner> owners) {
		for (Owner owner : owners) {
			entityCache.removeResult(OwnerImpl.class, owner);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OwnerImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new owner with the primary key. Does not add the owner to the database.
	 *
	 * @param ownerId the primary key for the new owner
	 * @return the new owner
	 */
	@Override
	public Owner create(long ownerId) {
		Owner owner = new OwnerImpl();

		owner.setNew(true);
		owner.setPrimaryKey(ownerId);

		return owner;
	}

	/**
	 * Removes the owner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ownerId the primary key of the owner
	 * @return the owner that was removed
	 * @throws NoSuchOwnerException if a owner with the primary key could not be found
	 */
	@Override
	public Owner remove(long ownerId) throws NoSuchOwnerException {
		return remove((Serializable)ownerId);
	}

	/**
	 * Removes the owner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the owner
	 * @return the owner that was removed
	 * @throws NoSuchOwnerException if a owner with the primary key could not be found
	 */
	@Override
	public Owner remove(Serializable primaryKey) throws NoSuchOwnerException {
		Session session = null;

		try {
			session = openSession();

			Owner owner = (Owner)session.get(OwnerImpl.class, primaryKey);

			if (owner == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOwnerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(owner);
		}
		catch (NoSuchOwnerException noSuchEntityException) {
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
	protected Owner removeImpl(Owner owner) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(owner)) {
				owner = (Owner)session.get(
					OwnerImpl.class, owner.getPrimaryKeyObj());
			}

			if (owner != null) {
				session.delete(owner);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (owner != null) {
			clearCache(owner);
		}

		return owner;
	}

	@Override
	public Owner updateImpl(Owner owner) {
		boolean isNew = owner.isNew();

		if (!(owner instanceof OwnerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(owner.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(owner);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in owner proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Owner implementation " +
					owner.getClass());
		}

		OwnerModelImpl ownerModelImpl = (OwnerModelImpl)owner;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(owner);
			}
			else {
				owner = (Owner)session.merge(owner);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(OwnerImpl.class, ownerModelImpl, false, true);

		if (isNew) {
			owner.setNew(false);
		}

		owner.resetOriginalValues();

		return owner;
	}

	/**
	 * Returns the owner with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the owner
	 * @return the owner
	 * @throws NoSuchOwnerException if a owner with the primary key could not be found
	 */
	@Override
	public Owner findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOwnerException {

		Owner owner = fetchByPrimaryKey(primaryKey);

		if (owner == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOwnerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return owner;
	}

	/**
	 * Returns the owner with the primary key or throws a <code>NoSuchOwnerException</code> if it could not be found.
	 *
	 * @param ownerId the primary key of the owner
	 * @return the owner
	 * @throws NoSuchOwnerException if a owner with the primary key could not be found
	 */
	@Override
	public Owner findByPrimaryKey(long ownerId) throws NoSuchOwnerException {
		return findByPrimaryKey((Serializable)ownerId);
	}

	/**
	 * Returns the owner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ownerId the primary key of the owner
	 * @return the owner, or <code>null</code> if a owner with the primary key could not be found
	 */
	@Override
	public Owner fetchByPrimaryKey(long ownerId) {
		return fetchByPrimaryKey((Serializable)ownerId);
	}

	/**
	 * Returns all the owners.
	 *
	 * @return the owners
	 */
	@Override
	public List<Owner> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the owners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OwnerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of owners
	 * @param end the upper bound of the range of owners (not inclusive)
	 * @return the range of owners
	 */
	@Override
	public List<Owner> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the owners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OwnerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of owners
	 * @param end the upper bound of the range of owners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of owners
	 */
	@Override
	public List<Owner> findAll(
		int start, int end, OrderByComparator<Owner> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the owners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OwnerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of owners
	 * @param end the upper bound of the range of owners (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of owners
	 */
	@Override
	public List<Owner> findAll(
		int start, int end, OrderByComparator<Owner> orderByComparator,
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

		List<Owner> list = null;

		if (useFinderCache) {
			list = (List<Owner>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OWNER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OWNER;

				sql = sql.concat(OwnerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Owner>)QueryUtil.list(
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
	 * Removes all the owners from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Owner owner : findAll()) {
			remove(owner);
		}
	}

	/**
	 * Returns the number of owners.
	 *
	 * @return the number of owners
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OWNER);

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
		return "ownerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OWNER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OwnerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the owner persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new OwnerModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Owner.class.getName()));

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

		_finderPathWithPaginationFindByLastName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLastName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"lastName"}, true);

		_finderPathWithoutPaginationFindByLastName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLastName",
			new String[] {String.class.getName()}, new String[] {"lastName"},
			true);

		_finderPathCountByLastName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLastName",
			new String[] {String.class.getName()}, new String[] {"lastName"},
			false);

		OwnerUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		OwnerUtil.setPersistence(null);

		entityCache.removeCache(OwnerImpl.class.getName());

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

	private static final String _SQL_SELECT_OWNER =
		"SELECT owner FROM Owner owner";

	private static final String _SQL_SELECT_OWNER_WHERE =
		"SELECT owner FROM Owner owner WHERE ";

	private static final String _SQL_COUNT_OWNER =
		"SELECT COUNT(owner) FROM Owner owner";

	private static final String _SQL_COUNT_OWNER_WHERE =
		"SELECT COUNT(owner) FROM Owner owner WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "owner.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Owner exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Owner exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OwnerPersistenceImpl.class);

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

	private static class OwnerModelArgumentsResolver
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

			OwnerModelImpl ownerModelImpl = (OwnerModelImpl)baseModel;

			long columnBitmask = ownerModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(ownerModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= ownerModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(ownerModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			OwnerModelImpl ownerModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = ownerModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = ownerModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.petclinic.model.Owner;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the owner service. This utility wraps <code>com.liferay.training.petclinic.service.persistence.impl.OwnerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OwnerPersistence
 * @generated
 */
public class OwnerUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Owner owner) {
		getPersistence().clearCache(owner);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Owner> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Owner> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Owner> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Owner> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Owner> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Owner update(Owner owner) {
		return getPersistence().update(owner);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Owner update(Owner owner, ServiceContext serviceContext) {
		return getPersistence().update(owner, serviceContext);
	}

	/**
	 * Returns all the owners where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching owners
	 */
	public static List<Owner> findByLastName(String lastName) {
		return getPersistence().findByLastName(lastName);
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
	public static List<Owner> findByLastName(
		String lastName, int start, int end) {

		return getPersistence().findByLastName(lastName, start, end);
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
	public static List<Owner> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<Owner> orderByComparator) {

		return getPersistence().findByLastName(
			lastName, start, end, orderByComparator);
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
	public static List<Owner> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<Owner> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByLastName(
			lastName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching owner
	 * @throws NoSuchOwnerException if a matching owner could not be found
	 */
	public static Owner findByLastName_First(
			String lastName, OrderByComparator<Owner> orderByComparator)
		throws com.liferay.training.petclinic.exception.NoSuchOwnerException {

		return getPersistence().findByLastName_First(
			lastName, orderByComparator);
	}

	/**
	 * Returns the first owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching owner, or <code>null</code> if a matching owner could not be found
	 */
	public static Owner fetchByLastName_First(
		String lastName, OrderByComparator<Owner> orderByComparator) {

		return getPersistence().fetchByLastName_First(
			lastName, orderByComparator);
	}

	/**
	 * Returns the last owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching owner
	 * @throws NoSuchOwnerException if a matching owner could not be found
	 */
	public static Owner findByLastName_Last(
			String lastName, OrderByComparator<Owner> orderByComparator)
		throws com.liferay.training.petclinic.exception.NoSuchOwnerException {

		return getPersistence().findByLastName_Last(
			lastName, orderByComparator);
	}

	/**
	 * Returns the last owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching owner, or <code>null</code> if a matching owner could not be found
	 */
	public static Owner fetchByLastName_Last(
		String lastName, OrderByComparator<Owner> orderByComparator) {

		return getPersistence().fetchByLastName_Last(
			lastName, orderByComparator);
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
	public static Owner[] findByLastName_PrevAndNext(
			long ownerId, String lastName,
			OrderByComparator<Owner> orderByComparator)
		throws com.liferay.training.petclinic.exception.NoSuchOwnerException {

		return getPersistence().findByLastName_PrevAndNext(
			ownerId, lastName, orderByComparator);
	}

	/**
	 * Removes all the owners where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	public static void removeByLastName(String lastName) {
		getPersistence().removeByLastName(lastName);
	}

	/**
	 * Returns the number of owners where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching owners
	 */
	public static int countByLastName(String lastName) {
		return getPersistence().countByLastName(lastName);
	}

	/**
	 * Caches the owner in the entity cache if it is enabled.
	 *
	 * @param owner the owner
	 */
	public static void cacheResult(Owner owner) {
		getPersistence().cacheResult(owner);
	}

	/**
	 * Caches the owners in the entity cache if it is enabled.
	 *
	 * @param owners the owners
	 */
	public static void cacheResult(List<Owner> owners) {
		getPersistence().cacheResult(owners);
	}

	/**
	 * Creates a new owner with the primary key. Does not add the owner to the database.
	 *
	 * @param ownerId the primary key for the new owner
	 * @return the new owner
	 */
	public static Owner create(long ownerId) {
		return getPersistence().create(ownerId);
	}

	/**
	 * Removes the owner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ownerId the primary key of the owner
	 * @return the owner that was removed
	 * @throws NoSuchOwnerException if a owner with the primary key could not be found
	 */
	public static Owner remove(long ownerId)
		throws com.liferay.training.petclinic.exception.NoSuchOwnerException {

		return getPersistence().remove(ownerId);
	}

	public static Owner updateImpl(Owner owner) {
		return getPersistence().updateImpl(owner);
	}

	/**
	 * Returns the owner with the primary key or throws a <code>NoSuchOwnerException</code> if it could not be found.
	 *
	 * @param ownerId the primary key of the owner
	 * @return the owner
	 * @throws NoSuchOwnerException if a owner with the primary key could not be found
	 */
	public static Owner findByPrimaryKey(long ownerId)
		throws com.liferay.training.petclinic.exception.NoSuchOwnerException {

		return getPersistence().findByPrimaryKey(ownerId);
	}

	/**
	 * Returns the owner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ownerId the primary key of the owner
	 * @return the owner, or <code>null</code> if a owner with the primary key could not be found
	 */
	public static Owner fetchByPrimaryKey(long ownerId) {
		return getPersistence().fetchByPrimaryKey(ownerId);
	}

	/**
	 * Returns all the owners.
	 *
	 * @return the owners
	 */
	public static List<Owner> findAll() {
		return getPersistence().findAll();
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
	public static List<Owner> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Owner> findAll(
		int start, int end, OrderByComparator<Owner> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Owner> findAll(
		int start, int end, OrderByComparator<Owner> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the owners from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of owners.
	 *
	 * @return the number of owners
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OwnerPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(OwnerPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile OwnerPersistence _persistence;

}
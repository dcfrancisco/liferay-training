/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.petclinic.model.Specialty;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the specialty service. This utility wraps <code>com.liferay.training.petclinic.service.persistence.impl.SpecialtyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecialtyPersistence
 * @generated
 */
public class SpecialtyUtil {

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
	public static void clearCache(Specialty specialty) {
		getPersistence().clearCache(specialty);
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
	public static Map<Serializable, Specialty> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Specialty> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Specialty> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Specialty> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Specialty> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Specialty update(Specialty specialty) {
		return getPersistence().update(specialty);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Specialty update(
		Specialty specialty, ServiceContext serviceContext) {

		return getPersistence().update(specialty, serviceContext);
	}

	/**
	 * Caches the specialty in the entity cache if it is enabled.
	 *
	 * @param specialty the specialty
	 */
	public static void cacheResult(Specialty specialty) {
		getPersistence().cacheResult(specialty);
	}

	/**
	 * Caches the specialties in the entity cache if it is enabled.
	 *
	 * @param specialties the specialties
	 */
	public static void cacheResult(List<Specialty> specialties) {
		getPersistence().cacheResult(specialties);
	}

	/**
	 * Creates a new specialty with the primary key. Does not add the specialty to the database.
	 *
	 * @param specialtyId the primary key for the new specialty
	 * @return the new specialty
	 */
	public static Specialty create(long specialtyId) {
		return getPersistence().create(specialtyId);
	}

	/**
	 * Removes the specialty with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specialtyId the primary key of the specialty
	 * @return the specialty that was removed
	 * @throws NoSuchSpecialtyException if a specialty with the primary key could not be found
	 */
	public static Specialty remove(long specialtyId)
		throws com.liferay.training.petclinic.exception.
			NoSuchSpecialtyException {

		return getPersistence().remove(specialtyId);
	}

	public static Specialty updateImpl(Specialty specialty) {
		return getPersistence().updateImpl(specialty);
	}

	/**
	 * Returns the specialty with the primary key or throws a <code>NoSuchSpecialtyException</code> if it could not be found.
	 *
	 * @param specialtyId the primary key of the specialty
	 * @return the specialty
	 * @throws NoSuchSpecialtyException if a specialty with the primary key could not be found
	 */
	public static Specialty findByPrimaryKey(long specialtyId)
		throws com.liferay.training.petclinic.exception.
			NoSuchSpecialtyException {

		return getPersistence().findByPrimaryKey(specialtyId);
	}

	/**
	 * Returns the specialty with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specialtyId the primary key of the specialty
	 * @return the specialty, or <code>null</code> if a specialty with the primary key could not be found
	 */
	public static Specialty fetchByPrimaryKey(long specialtyId) {
		return getPersistence().fetchByPrimaryKey(specialtyId);
	}

	/**
	 * Returns all the specialties.
	 *
	 * @return the specialties
	 */
	public static List<Specialty> findAll() {
		return getPersistence().findAll();
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
	public static List<Specialty> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Specialty> findAll(
		int start, int end, OrderByComparator<Specialty> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Specialty> findAll(
		int start, int end, OrderByComparator<Specialty> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the specialties from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of specialties.
	 *
	 * @return the number of specialties
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SpecialtyPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SpecialtyPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SpecialtyPersistence _persistence;

}
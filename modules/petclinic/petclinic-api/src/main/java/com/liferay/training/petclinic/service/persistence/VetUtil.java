/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.petclinic.model.Vet;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the vet service. This utility wraps <code>com.liferay.training.petclinic.service.persistence.impl.VetPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VetPersistence
 * @generated
 */
public class VetUtil {

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
	public static void clearCache(Vet vet) {
		getPersistence().clearCache(vet);
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
	public static Map<Serializable, Vet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Vet> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Vet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Vet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Vet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Vet update(Vet vet) {
		return getPersistence().update(vet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Vet update(Vet vet, ServiceContext serviceContext) {
		return getPersistence().update(vet, serviceContext);
	}

	/**
	 * Caches the vet in the entity cache if it is enabled.
	 *
	 * @param vet the vet
	 */
	public static void cacheResult(Vet vet) {
		getPersistence().cacheResult(vet);
	}

	/**
	 * Caches the vets in the entity cache if it is enabled.
	 *
	 * @param vets the vets
	 */
	public static void cacheResult(List<Vet> vets) {
		getPersistence().cacheResult(vets);
	}

	/**
	 * Creates a new vet with the primary key. Does not add the vet to the database.
	 *
	 * @param vetId the primary key for the new vet
	 * @return the new vet
	 */
	public static Vet create(long vetId) {
		return getPersistence().create(vetId);
	}

	/**
	 * Removes the vet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vetId the primary key of the vet
	 * @return the vet that was removed
	 * @throws NoSuchVetException if a vet with the primary key could not be found
	 */
	public static Vet remove(long vetId)
		throws com.liferay.training.petclinic.exception.NoSuchVetException {

		return getPersistence().remove(vetId);
	}

	public static Vet updateImpl(Vet vet) {
		return getPersistence().updateImpl(vet);
	}

	/**
	 * Returns the vet with the primary key or throws a <code>NoSuchVetException</code> if it could not be found.
	 *
	 * @param vetId the primary key of the vet
	 * @return the vet
	 * @throws NoSuchVetException if a vet with the primary key could not be found
	 */
	public static Vet findByPrimaryKey(long vetId)
		throws com.liferay.training.petclinic.exception.NoSuchVetException {

		return getPersistence().findByPrimaryKey(vetId);
	}

	/**
	 * Returns the vet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vetId the primary key of the vet
	 * @return the vet, or <code>null</code> if a vet with the primary key could not be found
	 */
	public static Vet fetchByPrimaryKey(long vetId) {
		return getPersistence().fetchByPrimaryKey(vetId);
	}

	/**
	 * Returns all the vets.
	 *
	 * @return the vets
	 */
	public static List<Vet> findAll() {
		return getPersistence().findAll();
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
	public static List<Vet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Vet> findAll(
		int start, int end, OrderByComparator<Vet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Vet> findAll(
		int start, int end, OrderByComparator<Vet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the vets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of vets.
	 *
	 * @return the number of vets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VetPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(VetPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile VetPersistence _persistence;

}
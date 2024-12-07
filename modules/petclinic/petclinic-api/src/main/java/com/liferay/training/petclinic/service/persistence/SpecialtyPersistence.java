/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.petclinic.exception.NoSuchSpecialtyException;
import com.liferay.training.petclinic.model.Specialty;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the specialty service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecialtyUtil
 * @generated
 */
@ProviderType
public interface SpecialtyPersistence extends BasePersistence<Specialty> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpecialtyUtil} to access the specialty persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the specialty in the entity cache if it is enabled.
	 *
	 * @param specialty the specialty
	 */
	public void cacheResult(Specialty specialty);

	/**
	 * Caches the specialties in the entity cache if it is enabled.
	 *
	 * @param specialties the specialties
	 */
	public void cacheResult(java.util.List<Specialty> specialties);

	/**
	 * Creates a new specialty with the primary key. Does not add the specialty to the database.
	 *
	 * @param specialtyId the primary key for the new specialty
	 * @return the new specialty
	 */
	public Specialty create(long specialtyId);

	/**
	 * Removes the specialty with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specialtyId the primary key of the specialty
	 * @return the specialty that was removed
	 * @throws NoSuchSpecialtyException if a specialty with the primary key could not be found
	 */
	public Specialty remove(long specialtyId) throws NoSuchSpecialtyException;

	public Specialty updateImpl(Specialty specialty);

	/**
	 * Returns the specialty with the primary key or throws a <code>NoSuchSpecialtyException</code> if it could not be found.
	 *
	 * @param specialtyId the primary key of the specialty
	 * @return the specialty
	 * @throws NoSuchSpecialtyException if a specialty with the primary key could not be found
	 */
	public Specialty findByPrimaryKey(long specialtyId)
		throws NoSuchSpecialtyException;

	/**
	 * Returns the specialty with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specialtyId the primary key of the specialty
	 * @return the specialty, or <code>null</code> if a specialty with the primary key could not be found
	 */
	public Specialty fetchByPrimaryKey(long specialtyId);

	/**
	 * Returns all the specialties.
	 *
	 * @return the specialties
	 */
	public java.util.List<Specialty> findAll();

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
	public java.util.List<Specialty> findAll(int start, int end);

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
	public java.util.List<Specialty> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specialty>
			orderByComparator);

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
	public java.util.List<Specialty> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specialty>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the specialties from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of specialties.
	 *
	 * @return the number of specialties
	 */
	public int countAll();

}
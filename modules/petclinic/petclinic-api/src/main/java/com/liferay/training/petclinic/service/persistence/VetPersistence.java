/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.petclinic.exception.NoSuchVetException;
import com.liferay.training.petclinic.model.Vet;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the vet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VetUtil
 * @generated
 */
@ProviderType
public interface VetPersistence extends BasePersistence<Vet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VetUtil} to access the vet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the vet in the entity cache if it is enabled.
	 *
	 * @param vet the vet
	 */
	public void cacheResult(Vet vet);

	/**
	 * Caches the vets in the entity cache if it is enabled.
	 *
	 * @param vets the vets
	 */
	public void cacheResult(java.util.List<Vet> vets);

	/**
	 * Creates a new vet with the primary key. Does not add the vet to the database.
	 *
	 * @param vetId the primary key for the new vet
	 * @return the new vet
	 */
	public Vet create(long vetId);

	/**
	 * Removes the vet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vetId the primary key of the vet
	 * @return the vet that was removed
	 * @throws NoSuchVetException if a vet with the primary key could not be found
	 */
	public Vet remove(long vetId) throws NoSuchVetException;

	public Vet updateImpl(Vet vet);

	/**
	 * Returns the vet with the primary key or throws a <code>NoSuchVetException</code> if it could not be found.
	 *
	 * @param vetId the primary key of the vet
	 * @return the vet
	 * @throws NoSuchVetException if a vet with the primary key could not be found
	 */
	public Vet findByPrimaryKey(long vetId) throws NoSuchVetException;

	/**
	 * Returns the vet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vetId the primary key of the vet
	 * @return the vet, or <code>null</code> if a vet with the primary key could not be found
	 */
	public Vet fetchByPrimaryKey(long vetId);

	/**
	 * Returns all the vets.
	 *
	 * @return the vets
	 */
	public java.util.List<Vet> findAll();

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
	public java.util.List<Vet> findAll(int start, int end);

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
	public java.util.List<Vet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vet>
			orderByComparator);

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
	public java.util.List<Vet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the vets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of vets.
	 *
	 * @return the number of vets
	 */
	public int countAll();

}
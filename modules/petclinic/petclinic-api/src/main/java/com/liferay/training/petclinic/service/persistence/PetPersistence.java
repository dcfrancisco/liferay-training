/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.petclinic.exception.NoSuchPetException;
import com.liferay.training.petclinic.model.Pet;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetUtil
 * @generated
 */
@ProviderType
public interface PetPersistence extends BasePersistence<Pet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PetUtil} to access the pet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pets where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @return the matching pets
	 */
	public java.util.List<Pet> findByOwnerId(long ownerId);

	/**
	 * Returns a range of all the pets where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of matching pets
	 */
	public java.util.List<Pet> findByOwnerId(long ownerId, int start, int end);

	/**
	 * Returns an ordered range of all the pets where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pets
	 */
	public java.util.List<Pet> findByOwnerId(
		long ownerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pets where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pets
	 */
	public java.util.List<Pet> findByOwnerId(
		long ownerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByOwnerId_First(
			long ownerId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the first pet in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByOwnerId_First(
		long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the last pet in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet
	 * @throws NoSuchPetException if a matching pet could not be found
	 */
	public Pet findByOwnerId_Last(
			long ownerId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Returns the last pet in the ordered set where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet, or <code>null</code> if a matching pet could not be found
	 */
	public Pet fetchByOwnerId_Last(
		long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns the pets before and after the current pet in the ordered set where ownerId = &#63;.
	 *
	 * @param petId the primary key of the current pet
	 * @param ownerId the owner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public Pet[] findByOwnerId_PrevAndNext(
			long petId, long ownerId,
			com.liferay.portal.kernel.util.OrderByComparator<Pet>
				orderByComparator)
		throws NoSuchPetException;

	/**
	 * Removes all the pets where ownerId = &#63; from the database.
	 *
	 * @param ownerId the owner ID
	 */
	public void removeByOwnerId(long ownerId);

	/**
	 * Returns the number of pets where ownerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @return the number of matching pets
	 */
	public int countByOwnerId(long ownerId);

	/**
	 * Caches the pet in the entity cache if it is enabled.
	 *
	 * @param pet the pet
	 */
	public void cacheResult(Pet pet);

	/**
	 * Caches the pets in the entity cache if it is enabled.
	 *
	 * @param pets the pets
	 */
	public void cacheResult(java.util.List<Pet> pets);

	/**
	 * Creates a new pet with the primary key. Does not add the pet to the database.
	 *
	 * @param petId the primary key for the new pet
	 * @return the new pet
	 */
	public Pet create(long petId);

	/**
	 * Removes the pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet that was removed
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public Pet remove(long petId) throws NoSuchPetException;

	public Pet updateImpl(Pet pet);

	/**
	 * Returns the pet with the primary key or throws a <code>NoSuchPetException</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public Pet findByPrimaryKey(long petId) throws NoSuchPetException;

	/**
	 * Returns the pet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet
	 * @return the pet, or <code>null</code> if a pet with the primary key could not be found
	 */
	public Pet fetchByPrimaryKey(long petId);

	/**
	 * Returns all the pets.
	 *
	 * @return the pets
	 */
	public java.util.List<Pet> findAll();

	/**
	 * Returns a range of all the pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of pets
	 */
	public java.util.List<Pet> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pets
	 */
	public java.util.List<Pet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pets
	 */
	public java.util.List<Pet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pets.
	 *
	 * @return the number of pets
	 */
	public int countAll();

}
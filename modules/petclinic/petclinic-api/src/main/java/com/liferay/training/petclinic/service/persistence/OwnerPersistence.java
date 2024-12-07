/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.petclinic.exception.NoSuchOwnerException;
import com.liferay.training.petclinic.model.Owner;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the owner service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OwnerUtil
 * @generated
 */
@ProviderType
public interface OwnerPersistence extends BasePersistence<Owner> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OwnerUtil} to access the owner persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the owners where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching owners
	 */
	public java.util.List<Owner> findByLastName(String lastName);

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
	public java.util.List<Owner> findByLastName(
		String lastName, int start, int end);

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
	public java.util.List<Owner> findByLastName(
		String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Owner>
			orderByComparator);

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
	public java.util.List<Owner> findByLastName(
		String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Owner>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching owner
	 * @throws NoSuchOwnerException if a matching owner could not be found
	 */
	public Owner findByLastName_First(
			String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<Owner>
				orderByComparator)
		throws NoSuchOwnerException;

	/**
	 * Returns the first owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching owner, or <code>null</code> if a matching owner could not be found
	 */
	public Owner fetchByLastName_First(
		String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<Owner>
			orderByComparator);

	/**
	 * Returns the last owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching owner
	 * @throws NoSuchOwnerException if a matching owner could not be found
	 */
	public Owner findByLastName_Last(
			String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<Owner>
				orderByComparator)
		throws NoSuchOwnerException;

	/**
	 * Returns the last owner in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching owner, or <code>null</code> if a matching owner could not be found
	 */
	public Owner fetchByLastName_Last(
		String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<Owner>
			orderByComparator);

	/**
	 * Returns the owners before and after the current owner in the ordered set where lastName = &#63;.
	 *
	 * @param ownerId the primary key of the current owner
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next owner
	 * @throws NoSuchOwnerException if a owner with the primary key could not be found
	 */
	public Owner[] findByLastName_PrevAndNext(
			long ownerId, String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<Owner>
				orderByComparator)
		throws NoSuchOwnerException;

	/**
	 * Removes all the owners where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	public void removeByLastName(String lastName);

	/**
	 * Returns the number of owners where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching owners
	 */
	public int countByLastName(String lastName);

	/**
	 * Caches the owner in the entity cache if it is enabled.
	 *
	 * @param owner the owner
	 */
	public void cacheResult(Owner owner);

	/**
	 * Caches the owners in the entity cache if it is enabled.
	 *
	 * @param owners the owners
	 */
	public void cacheResult(java.util.List<Owner> owners);

	/**
	 * Creates a new owner with the primary key. Does not add the owner to the database.
	 *
	 * @param ownerId the primary key for the new owner
	 * @return the new owner
	 */
	public Owner create(long ownerId);

	/**
	 * Removes the owner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ownerId the primary key of the owner
	 * @return the owner that was removed
	 * @throws NoSuchOwnerException if a owner with the primary key could not be found
	 */
	public Owner remove(long ownerId) throws NoSuchOwnerException;

	public Owner updateImpl(Owner owner);

	/**
	 * Returns the owner with the primary key or throws a <code>NoSuchOwnerException</code> if it could not be found.
	 *
	 * @param ownerId the primary key of the owner
	 * @return the owner
	 * @throws NoSuchOwnerException if a owner with the primary key could not be found
	 */
	public Owner findByPrimaryKey(long ownerId) throws NoSuchOwnerException;

	/**
	 * Returns the owner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ownerId the primary key of the owner
	 * @return the owner, or <code>null</code> if a owner with the primary key could not be found
	 */
	public Owner fetchByPrimaryKey(long ownerId);

	/**
	 * Returns all the owners.
	 *
	 * @return the owners
	 */
	public java.util.List<Owner> findAll();

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
	public java.util.List<Owner> findAll(int start, int end);

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
	public java.util.List<Owner> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Owner>
			orderByComparator);

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
	public java.util.List<Owner> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Owner>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the owners from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of owners.
	 *
	 * @return the number of owners
	 */
	public int countAll();

}
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.gradebook.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.gradebook.exception.NoSuchAssignmentException;
import com.liferay.training.gradebook.model.Assignment;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentUtil
 * @generated
 */
@ProviderType
public interface AssignmentPersistence extends BasePersistence<Assignment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AssignmentUtil} to access the assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching assignments
	 */
	public java.util.List<Assignment> findByUuid(String uuid);

	/**
	 * Returns a range of all the assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @return the range of matching assignments
	 */
	public java.util.List<Assignment> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching assignments
	 */
	public java.util.List<Assignment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching assignments
	 */
	public java.util.List<Assignment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assignment
	 * @throws NoSuchAssignmentException if a matching assignment could not be found
	 */
	public Assignment findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Assignment>
				orderByComparator)
		throws NoSuchAssignmentException;

	/**
	 * Returns the first assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	 */
	public Assignment fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator);

	/**
	 * Returns the last assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assignment
	 * @throws NoSuchAssignmentException if a matching assignment could not be found
	 */
	public Assignment findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Assignment>
				orderByComparator)
		throws NoSuchAssignmentException;

	/**
	 * Returns the last assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	 */
	public Assignment fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator);

	/**
	 * Returns the assignments before and after the current assignment in the ordered set where uuid = &#63;.
	 *
	 * @param assignmentId the primary key of the current assignment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next assignment
	 * @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	 */
	public Assignment[] findByUuid_PrevAndNext(
			long assignmentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Assignment>
				orderByComparator)
		throws NoSuchAssignmentException;

	/**
	 * Removes all the assignments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching assignments
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the assignment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAssignmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching assignment
	 * @throws NoSuchAssignmentException if a matching assignment could not be found
	 */
	public Assignment findByUUID_G(String uuid, long groupId)
		throws NoSuchAssignmentException;

	/**
	 * Returns the assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching assignment, or <code>null</code> if a matching assignment could not be found
	 */
	public Assignment fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching assignment, or <code>null</code> if a matching assignment could not be found
	 */
	public Assignment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the assignment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the assignment that was removed
	 */
	public Assignment removeByUUID_G(String uuid, long groupId)
		throws NoSuchAssignmentException;

	/**
	 * Returns the number of assignments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching assignments
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching assignments
	 */
	public java.util.List<Assignment> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @return the range of matching assignments
	 */
	public java.util.List<Assignment> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching assignments
	 */
	public java.util.List<Assignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching assignments
	 */
	public java.util.List<Assignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assignment
	 * @throws NoSuchAssignmentException if a matching assignment could not be found
	 */
	public Assignment findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Assignment>
				orderByComparator)
		throws NoSuchAssignmentException;

	/**
	 * Returns the first assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	 */
	public Assignment fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator);

	/**
	 * Returns the last assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assignment
	 * @throws NoSuchAssignmentException if a matching assignment could not be found
	 */
	public Assignment findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Assignment>
				orderByComparator)
		throws NoSuchAssignmentException;

	/**
	 * Returns the last assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	 */
	public Assignment fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator);

	/**
	 * Returns the assignments before and after the current assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param assignmentId the primary key of the current assignment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next assignment
	 * @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	 */
	public Assignment[] findByUuid_C_PrevAndNext(
			long assignmentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Assignment>
				orderByComparator)
		throws NoSuchAssignmentException;

	/**
	 * Removes all the assignments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching assignments
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the assignments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching assignments
	 */
	public java.util.List<Assignment> findByGroupId(long groupId);

	/**
	 * Returns a range of all the assignments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @return the range of matching assignments
	 */
	public java.util.List<Assignment> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the assignments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching assignments
	 */
	public java.util.List<Assignment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the assignments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching assignments
	 */
	public java.util.List<Assignment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first assignment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assignment
	 * @throws NoSuchAssignmentException if a matching assignment could not be found
	 */
	public Assignment findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Assignment>
				orderByComparator)
		throws NoSuchAssignmentException;

	/**
	 * Returns the first assignment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assignment, or <code>null</code> if a matching assignment could not be found
	 */
	public Assignment fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator);

	/**
	 * Returns the last assignment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assignment
	 * @throws NoSuchAssignmentException if a matching assignment could not be found
	 */
	public Assignment findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Assignment>
				orderByComparator)
		throws NoSuchAssignmentException;

	/**
	 * Returns the last assignment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assignment, or <code>null</code> if a matching assignment could not be found
	 */
	public Assignment fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator);

	/**
	 * Returns the assignments before and after the current assignment in the ordered set where groupId = &#63;.
	 *
	 * @param assignmentId the primary key of the current assignment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next assignment
	 * @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	 */
	public Assignment[] findByGroupId_PrevAndNext(
			long assignmentId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Assignment>
				orderByComparator)
		throws NoSuchAssignmentException;

	/**
	 * Removes all the assignments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of assignments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching assignments
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the assignment in the entity cache if it is enabled.
	 *
	 * @param assignment the assignment
	 */
	public void cacheResult(Assignment assignment);

	/**
	 * Caches the assignments in the entity cache if it is enabled.
	 *
	 * @param assignments the assignments
	 */
	public void cacheResult(java.util.List<Assignment> assignments);

	/**
	 * Creates a new assignment with the primary key. Does not add the assignment to the database.
	 *
	 * @param assignmentId the primary key for the new assignment
	 * @return the new assignment
	 */
	public Assignment create(long assignmentId);

	/**
	 * Removes the assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assignmentId the primary key of the assignment
	 * @return the assignment that was removed
	 * @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	 */
	public Assignment remove(long assignmentId)
		throws NoSuchAssignmentException;

	public Assignment updateImpl(Assignment assignment);

	/**
	 * Returns the assignment with the primary key or throws a <code>NoSuchAssignmentException</code> if it could not be found.
	 *
	 * @param assignmentId the primary key of the assignment
	 * @return the assignment
	 * @throws NoSuchAssignmentException if a assignment with the primary key could not be found
	 */
	public Assignment findByPrimaryKey(long assignmentId)
		throws NoSuchAssignmentException;

	/**
	 * Returns the assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param assignmentId the primary key of the assignment
	 * @return the assignment, or <code>null</code> if a assignment with the primary key could not be found
	 */
	public Assignment fetchByPrimaryKey(long assignmentId);

	/**
	 * Returns all the assignments.
	 *
	 * @return the assignments
	 */
	public java.util.List<Assignment> findAll();

	/**
	 * Returns a range of all the assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @return the range of assignments
	 */
	public java.util.List<Assignment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of assignments
	 */
	public java.util.List<Assignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of assignments
	 */
	public java.util.List<Assignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Assignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the assignments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of assignments.
	 *
	 * @return the number of assignments
	 */
	public int countAll();

}
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

package com.liferay.training.gradebook.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.gradebook.model.Assignment;

import java.util.List;

/**
 * Provides the remote service utility for Assignment. This utility wraps
 * <code>com.liferay.training.gradebook.service.impl.AssignmentServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentService
 * @generated
 */
public class AssignmentServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.gradebook.service.impl.AssignmentServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Assignment addAssignment(
			long groupId, String title, String description,
			java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addAssignment(
			groupId, title, description, dueDate, serviceContext);
	}

	public static Assignment deleteAssignment(long assignmentId)
		throws PortalException {

		return getService().deleteAssignment(assignmentId);
	}

	public static Assignment getAssignment(long assignmentId)
		throws PortalException {

		return getService().getAssignment(assignmentId);
	}

	public static List<Assignment> getAssignmentsByGroupId(long groupId) {
		return getService().getAssignmentsByGroupId(groupId);
	}

	public static List<Assignment> getAssignmentsByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Assignment> orderByComparator) {

		return getService().getAssignmentsByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	public static long getAssignmentsCountByKeywords(
		long groupId, String keywords) {

		return getService().getAssignmentsCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Assignment updateAssignment(
			long assignmentId, String title, String description,
			java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateAssignment(
			assignmentId, title, description, dueDate, serviceContext);
	}

	public static AssignmentService getService() {
		return _service;
	}

	private static volatile AssignmentService _service;

}
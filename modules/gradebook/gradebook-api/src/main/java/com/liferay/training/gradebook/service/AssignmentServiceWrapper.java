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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AssignmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentService
 * @generated
 */
public class AssignmentServiceWrapper
	implements AssignmentService, ServiceWrapper<AssignmentService> {

	public AssignmentServiceWrapper(AssignmentService assignmentService) {
		_assignmentService = assignmentService;
	}

	@Override
	public com.liferay.training.gradebook.model.Assignment addAssignment(
			long groupId, String title, String description,
			java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assignmentService.addAssignment(
			groupId, title, description, dueDate, serviceContext);
	}

	@Override
	public com.liferay.training.gradebook.model.Assignment deleteAssignment(
			long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assignmentService.deleteAssignment(assignmentId);
	}

	@Override
	public com.liferay.training.gradebook.model.Assignment getAssignment(
			long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assignmentService.getAssignment(assignmentId);
	}

	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment>
		getAssignmentsByGroupId(long groupId) {

		return _assignmentService.getAssignmentsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment>
		getAssignmentsByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.training.gradebook.model.Assignment>
					orderByComparator) {

		return _assignmentService.getAssignmentsByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public long getAssignmentsCountByKeywords(long groupId, String keywords) {
		return _assignmentService.getAssignmentsCountByKeywords(
			groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _assignmentService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.training.gradebook.model.Assignment updateAssignment(
			long assignmentId, String title, String description,
			java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assignmentService.updateAssignment(
			assignmentId, title, description, dueDate, serviceContext);
	}

	@Override
	public AssignmentService getWrappedService() {
		return _assignmentService;
	}

	@Override
	public void setWrappedService(AssignmentService assignmentService) {
		_assignmentService = assignmentService;
	}

	private AssignmentService _assignmentService;

}
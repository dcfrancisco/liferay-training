/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppointmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppointmentService
 * @generated
 */
public class AppointmentServiceWrapper
	implements AppointmentService, ServiceWrapper<AppointmentService> {

	public AppointmentServiceWrapper(AppointmentService appointmentService) {
		_appointmentService = appointmentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appointmentService.getOSGiServiceIdentifier();
	}

	@Override
	public AppointmentService getWrappedService() {
		return _appointmentService;
	}

	@Override
	public void setWrappedService(AppointmentService appointmentService) {
		_appointmentService = appointmentService;
	}

	private AppointmentService _appointmentService;

}
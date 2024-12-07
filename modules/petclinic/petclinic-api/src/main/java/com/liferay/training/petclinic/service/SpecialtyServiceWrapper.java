/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SpecialtyService}.
 *
 * @author Brian Wing Shun Chan
 * @see SpecialtyService
 * @generated
 */
public class SpecialtyServiceWrapper
	implements ServiceWrapper<SpecialtyService>, SpecialtyService {

	public SpecialtyServiceWrapper(SpecialtyService specialtyService) {
		_specialtyService = specialtyService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _specialtyService.getOSGiServiceIdentifier();
	}

	@Override
	public SpecialtyService getWrappedService() {
		return _specialtyService;
	}

	@Override
	public void setWrappedService(SpecialtyService specialtyService) {
		_specialtyService = specialtyService;
	}

	private SpecialtyService _specialtyService;

}
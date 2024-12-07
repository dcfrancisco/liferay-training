/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VetService}.
 *
 * @author Brian Wing Shun Chan
 * @see VetService
 * @generated
 */
public class VetServiceWrapper
	implements ServiceWrapper<VetService>, VetService {

	public VetServiceWrapper(VetService vetService) {
		_vetService = vetService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _vetService.getOSGiServiceIdentifier();
	}

	@Override
	public VetService getWrappedService() {
		return _vetService;
	}

	@Override
	public void setWrappedService(VetService vetService) {
		_vetService = vetService;
	}

	private VetService _vetService;

}
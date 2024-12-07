/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PetService}.
 *
 * @author Brian Wing Shun Chan
 * @see PetService
 * @generated
 */
public class PetServiceWrapper
	implements PetService, ServiceWrapper<PetService> {

	public PetServiceWrapper(PetService petService) {
		_petService = petService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _petService.getOSGiServiceIdentifier();
	}

	@Override
	public PetService getWrappedService() {
		return _petService;
	}

	@Override
	public void setWrappedService(PetService petService) {
		_petService = petService;
	}

	private PetService _petService;

}
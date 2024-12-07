/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OwnerService}.
 *
 * @author Brian Wing Shun Chan
 * @see OwnerService
 * @generated
 */
public class OwnerServiceWrapper
	implements OwnerService, ServiceWrapper<OwnerService> {

	public OwnerServiceWrapper(OwnerService ownerService) {
		_ownerService = ownerService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ownerService.getOSGiServiceIdentifier();
	}

	@Override
	public OwnerService getWrappedService() {
		return _ownerService;
	}

	@Override
	public void setWrappedService(OwnerService ownerService) {
		_ownerService = ownerService;
	}

	private OwnerService _ownerService;

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.training.petclinic.service.base.PetLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.training.petclinic.model.Pet",
	service = AopService.class
)
public class PetLocalServiceImpl extends PetLocalServiceBaseImpl {
}
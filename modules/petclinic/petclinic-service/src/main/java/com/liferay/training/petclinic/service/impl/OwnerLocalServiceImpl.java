/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.training.petclinic.model.Owner;
import com.liferay.training.petclinic.service.base.OwnerLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.liferay.training.petclinic.model.Owner",
        service = AopService.class
)
public class OwnerLocalServiceImpl extends OwnerLocalServiceBaseImpl {
    public List<Owner> getOwnerByLastName(String lastName) {
        return ownerPersistence.findByLastName(lastName);
    }

    @Override
    public List<Owner> getOwnerByLastName() {
        return List.of();
    }
}
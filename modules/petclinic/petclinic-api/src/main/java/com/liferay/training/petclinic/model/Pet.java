/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Pet service. Represents a row in the &quot;PetClinic_Pet&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PetModel
 * @generated
 */
@ImplementationClassName("com.liferay.training.petclinic.model.impl.PetImpl")
@ProviderType
public interface Pet extends PersistedModel, PetModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.training.petclinic.model.impl.PetImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Pet, Long> PET_ID_ACCESSOR =
		new Accessor<Pet, Long>() {

			@Override
			public Long get(Pet pet) {
				return pet.getPetId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Pet> getTypeClass() {
				return Pet.class;
			}

		};

}
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
 * The extended model interface for the Specialty service. Represents a row in the &quot;PetClinic_Specialty&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SpecialtyModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.training.petclinic.model.impl.SpecialtyImpl"
)
@ProviderType
public interface Specialty extends PersistedModel, SpecialtyModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.training.petclinic.model.impl.SpecialtyImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Specialty, Long> SPECIALTY_ID_ACCESSOR =
		new Accessor<Specialty, Long>() {

			@Override
			public Long get(Specialty specialty) {
				return specialty.getSpecialtyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Specialty> getTypeClass() {
				return Specialty.class;
			}

		};

}
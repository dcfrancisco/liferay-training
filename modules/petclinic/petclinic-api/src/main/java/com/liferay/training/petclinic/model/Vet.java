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
 * The extended model interface for the Vet service. Represents a row in the &quot;PetClinic_Vet&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see VetModel
 * @generated
 */
@ImplementationClassName("com.liferay.training.petclinic.model.impl.VetImpl")
@ProviderType
public interface Vet extends PersistedModel, VetModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.training.petclinic.model.impl.VetImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Vet, Long> VET_ID_ACCESSOR =
		new Accessor<Vet, Long>() {

			@Override
			public Long get(Vet vet) {
				return vet.getVetId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Vet> getTypeClass() {
				return Vet.class;
			}

		};

}
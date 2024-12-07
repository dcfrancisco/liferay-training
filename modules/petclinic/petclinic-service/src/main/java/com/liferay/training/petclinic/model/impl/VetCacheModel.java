/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.petclinic.model.Vet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Vet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VetCacheModel implements CacheModel<Vet>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VetCacheModel)) {
			return false;
		}

		VetCacheModel vetCacheModel = (VetCacheModel)object;

		if (vetId == vetCacheModel.vetId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, vetId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{vetId=");
		sb.append(vetId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", specialties=");
		sb.append(specialties);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Vet toEntityModel() {
		VetImpl vetImpl = new VetImpl();

		vetImpl.setVetId(vetId);

		if (firstName == null) {
			vetImpl.setFirstName("");
		}
		else {
			vetImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			vetImpl.setLastName("");
		}
		else {
			vetImpl.setLastName(lastName);
		}

		if (specialties == null) {
			vetImpl.setSpecialties("");
		}
		else {
			vetImpl.setSpecialties(specialties);
		}

		vetImpl.resetOriginalValues();

		return vetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vetId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		specialties = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(vetId);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (specialties == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specialties);
		}
	}

	public long vetId;
	public String firstName;
	public String lastName;
	public String specialties;

}
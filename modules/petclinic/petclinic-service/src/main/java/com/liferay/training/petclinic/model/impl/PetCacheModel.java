/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.petclinic.model.Pet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Pet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PetCacheModel implements CacheModel<Pet>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PetCacheModel)) {
			return false;
		}

		PetCacheModel petCacheModel = (PetCacheModel)object;

		if (petId == petCacheModel.petId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, petId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{petId=");
		sb.append(petId);
		sb.append(", ownerId=");
		sb.append(ownerId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Pet toEntityModel() {
		PetImpl petImpl = new PetImpl();

		petImpl.setPetId(petId);
		petImpl.setOwnerId(ownerId);

		if (name == null) {
			petImpl.setName("");
		}
		else {
			petImpl.setName(name);
		}

		if (birthDate == Long.MIN_VALUE) {
			petImpl.setBirthDate(null);
		}
		else {
			petImpl.setBirthDate(new Date(birthDate));
		}

		if (type == null) {
			petImpl.setType("");
		}
		else {
			petImpl.setType(type);
		}

		petImpl.resetOriginalValues();

		return petImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		petId = objectInput.readLong();

		ownerId = objectInput.readLong();
		name = objectInput.readUTF();
		birthDate = objectInput.readLong();
		type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(petId);

		objectOutput.writeLong(ownerId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(birthDate);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public long petId;
	public long ownerId;
	public String name;
	public long birthDate;
	public String type;

}
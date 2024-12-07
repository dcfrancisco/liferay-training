/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.petclinic.model.Specialty;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Specialty in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SpecialtyCacheModel
	implements CacheModel<Specialty>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecialtyCacheModel)) {
			return false;
		}

		SpecialtyCacheModel specialtyCacheModel = (SpecialtyCacheModel)object;

		if (specialtyId == specialtyCacheModel.specialtyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, specialtyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{specialtyId=");
		sb.append(specialtyId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Specialty toEntityModel() {
		SpecialtyImpl specialtyImpl = new SpecialtyImpl();

		specialtyImpl.setSpecialtyId(specialtyId);

		if (name == null) {
			specialtyImpl.setName("");
		}
		else {
			specialtyImpl.setName(name);
		}

		specialtyImpl.resetOriginalValues();

		return specialtyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		specialtyId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(specialtyId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long specialtyId;
	public String name;

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.petclinic.model.Owner;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Owner in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OwnerCacheModel implements CacheModel<Owner>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OwnerCacheModel)) {
			return false;
		}

		OwnerCacheModel ownerCacheModel = (OwnerCacheModel)object;

		if (ownerId == ownerCacheModel.ownerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ownerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{ownerId=");
		sb.append(ownerId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", address=");
		sb.append(address);
		sb.append(", city=");
		sb.append(city);
		sb.append(", telephone=");
		sb.append(telephone);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Owner toEntityModel() {
		OwnerImpl ownerImpl = new OwnerImpl();

		ownerImpl.setOwnerId(ownerId);

		if (firstName == null) {
			ownerImpl.setFirstName("");
		}
		else {
			ownerImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			ownerImpl.setLastName("");
		}
		else {
			ownerImpl.setLastName(lastName);
		}

		if (address == null) {
			ownerImpl.setAddress("");
		}
		else {
			ownerImpl.setAddress(address);
		}

		if (city == null) {
			ownerImpl.setCity("");
		}
		else {
			ownerImpl.setCity(city);
		}

		if (telephone == null) {
			ownerImpl.setTelephone("");
		}
		else {
			ownerImpl.setTelephone(telephone);
		}

		ownerImpl.resetOriginalValues();

		return ownerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ownerId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		address = objectInput.readUTF();
		city = objectInput.readUTF();
		telephone = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ownerId);

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

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (telephone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telephone);
		}
	}

	public long ownerId;
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String telephone;

}
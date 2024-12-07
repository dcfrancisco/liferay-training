/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.petclinic.model.Appointment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Appointment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppointmentCacheModel
	implements CacheModel<Appointment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppointmentCacheModel)) {
			return false;
		}

		AppointmentCacheModel appointmentCacheModel =
			(AppointmentCacheModel)object;

		if (appointmentId == appointmentCacheModel.appointmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appointmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{appointmentId=");
		sb.append(appointmentId);
		sb.append(", petId=");
		sb.append(petId);
		sb.append(", vetId=");
		sb.append(vetId);
		sb.append(", date=");
		sb.append(date);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Appointment toEntityModel() {
		AppointmentImpl appointmentImpl = new AppointmentImpl();

		appointmentImpl.setAppointmentId(appointmentId);
		appointmentImpl.setPetId(petId);
		appointmentImpl.setVetId(vetId);

		if (date == Long.MIN_VALUE) {
			appointmentImpl.setDate(null);
		}
		else {
			appointmentImpl.setDate(new Date(date));
		}

		if (description == null) {
			appointmentImpl.setDescription("");
		}
		else {
			appointmentImpl.setDescription(description);
		}

		appointmentImpl.resetOriginalValues();

		return appointmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		appointmentId = objectInput.readLong();

		petId = objectInput.readLong();

		vetId = objectInput.readLong();
		date = objectInput.readLong();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(appointmentId);

		objectOutput.writeLong(petId);

		objectOutput.writeLong(vetId);
		objectOutput.writeLong(date);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long appointmentId;
	public long petId;
	public long vetId;
	public long date;
	public String description;

}
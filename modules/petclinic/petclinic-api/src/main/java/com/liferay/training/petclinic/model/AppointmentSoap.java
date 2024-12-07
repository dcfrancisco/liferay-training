/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.petclinic.service.http.AppointmentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AppointmentSoap implements Serializable {

	public static AppointmentSoap toSoapModel(Appointment model) {
		AppointmentSoap soapModel = new AppointmentSoap();

		soapModel.setAppointmentId(model.getAppointmentId());
		soapModel.setPetId(model.getPetId());
		soapModel.setVetId(model.getVetId());
		soapModel.setDate(model.getDate());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static AppointmentSoap[] toSoapModels(Appointment[] models) {
		AppointmentSoap[] soapModels = new AppointmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppointmentSoap[][] toSoapModels(Appointment[][] models) {
		AppointmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AppointmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppointmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppointmentSoap[] toSoapModels(List<Appointment> models) {
		List<AppointmentSoap> soapModels = new ArrayList<AppointmentSoap>(
			models.size());

		for (Appointment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppointmentSoap[soapModels.size()]);
	}

	public AppointmentSoap() {
	}

	public long getPrimaryKey() {
		return _appointmentId;
	}

	public void setPrimaryKey(long pk) {
		setAppointmentId(pk);
	}

	public long getAppointmentId() {
		return _appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		_appointmentId = appointmentId;
	}

	public long getPetId() {
		return _petId;
	}

	public void setPetId(long petId) {
		_petId = petId;
	}

	public long getVetId() {
		return _vetId;
	}

	public void setVetId(long vetId) {
		_vetId = vetId;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _appointmentId;
	private long _petId;
	private long _vetId;
	private Date _date;
	private String _description;

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.petclinic.service.http.VetServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class VetSoap implements Serializable {

	public static VetSoap toSoapModel(Vet model) {
		VetSoap soapModel = new VetSoap();

		soapModel.setVetId(model.getVetId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setSpecialties(model.getSpecialties());

		return soapModel;
	}

	public static VetSoap[] toSoapModels(Vet[] models) {
		VetSoap[] soapModels = new VetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VetSoap[][] toSoapModels(Vet[][] models) {
		VetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VetSoap[] toSoapModels(List<Vet> models) {
		List<VetSoap> soapModels = new ArrayList<VetSoap>(models.size());

		for (Vet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VetSoap[soapModels.size()]);
	}

	public VetSoap() {
	}

	public long getPrimaryKey() {
		return _vetId;
	}

	public void setPrimaryKey(long pk) {
		setVetId(pk);
	}

	public long getVetId() {
		return _vetId;
	}

	public void setVetId(long vetId) {
		_vetId = vetId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getSpecialties() {
		return _specialties;
	}

	public void setSpecialties(String specialties) {
		_specialties = specialties;
	}

	private long _vetId;
	private String _firstName;
	private String _lastName;
	private String _specialties;

}
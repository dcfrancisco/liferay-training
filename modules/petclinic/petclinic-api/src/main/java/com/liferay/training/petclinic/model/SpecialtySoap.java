/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.petclinic.service.http.SpecialtyServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SpecialtySoap implements Serializable {

	public static SpecialtySoap toSoapModel(Specialty model) {
		SpecialtySoap soapModel = new SpecialtySoap();

		soapModel.setSpecialtyId(model.getSpecialtyId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static SpecialtySoap[] toSoapModels(Specialty[] models) {
		SpecialtySoap[] soapModels = new SpecialtySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SpecialtySoap[][] toSoapModels(Specialty[][] models) {
		SpecialtySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SpecialtySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SpecialtySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SpecialtySoap[] toSoapModels(List<Specialty> models) {
		List<SpecialtySoap> soapModels = new ArrayList<SpecialtySoap>(
			models.size());

		for (Specialty model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SpecialtySoap[soapModels.size()]);
	}

	public SpecialtySoap() {
	}

	public long getPrimaryKey() {
		return _specialtyId;
	}

	public void setPrimaryKey(long pk) {
		setSpecialtyId(pk);
	}

	public long getSpecialtyId() {
		return _specialtyId;
	}

	public void setSpecialtyId(long specialtyId) {
		_specialtyId = specialtyId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _specialtyId;
	private String _name;

}
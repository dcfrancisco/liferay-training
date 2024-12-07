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
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.petclinic.service.http.PetServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PetSoap implements Serializable {

	public static PetSoap toSoapModel(Pet model) {
		PetSoap soapModel = new PetSoap();

		soapModel.setPetId(model.getPetId());
		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setName(model.getName());
		soapModel.setBirthDate(model.getBirthDate());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static PetSoap[] toSoapModels(Pet[] models) {
		PetSoap[] soapModels = new PetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PetSoap[][] toSoapModels(Pet[][] models) {
		PetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PetSoap[] toSoapModels(List<Pet> models) {
		List<PetSoap> soapModels = new ArrayList<PetSoap>(models.size());

		for (Pet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PetSoap[soapModels.size()]);
	}

	public PetSoap() {
	}

	public long getPrimaryKey() {
		return _petId;
	}

	public void setPrimaryKey(long pk) {
		setPetId(pk);
	}

	public long getPetId() {
		return _petId;
	}

	public void setPetId(long petId) {
		_petId = petId;
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Date getBirthDate() {
		return _birthDate;
	}

	public void setBirthDate(Date birthDate) {
		_birthDate = birthDate;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private long _petId;
	private long _ownerId;
	private String _name;
	private Date _birthDate;
	private String _type;

}
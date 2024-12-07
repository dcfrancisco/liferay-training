/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.petclinic.service.http.OwnerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OwnerSoap implements Serializable {

	public static OwnerSoap toSoapModel(Owner model) {
		OwnerSoap soapModel = new OwnerSoap();

		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setAddress(model.getAddress());
		soapModel.setCity(model.getCity());
		soapModel.setTelephone(model.getTelephone());

		return soapModel;
	}

	public static OwnerSoap[] toSoapModels(Owner[] models) {
		OwnerSoap[] soapModels = new OwnerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OwnerSoap[][] toSoapModels(Owner[][] models) {
		OwnerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OwnerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OwnerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OwnerSoap[] toSoapModels(List<Owner> models) {
		List<OwnerSoap> soapModels = new ArrayList<OwnerSoap>(models.size());

		for (Owner model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OwnerSoap[soapModels.size()]);
	}

	public OwnerSoap() {
	}

	public long getPrimaryKey() {
		return _ownerId;
	}

	public void setPrimaryKey(long pk) {
		setOwnerId(pk);
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
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

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getTelephone() {
		return _telephone;
	}

	public void setTelephone(String telephone) {
		_telephone = telephone;
	}

	private long _ownerId;
	private String _firstName;
	private String _lastName;
	private String _address;
	private String _city;
	private String _telephone;

}
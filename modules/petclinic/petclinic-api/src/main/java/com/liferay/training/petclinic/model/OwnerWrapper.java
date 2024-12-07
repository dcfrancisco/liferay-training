/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Owner}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Owner
 * @generated
 */
public class OwnerWrapper
	extends BaseModelWrapper<Owner> implements ModelWrapper<Owner>, Owner {

	public OwnerWrapper(Owner owner) {
		super(owner);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ownerId", getOwnerId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("address", getAddress());
		attributes.put("city", getCity());
		attributes.put("telephone", getTelephone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String telephone = (String)attributes.get("telephone");

		if (telephone != null) {
			setTelephone(telephone);
		}
	}

	/**
	 * Returns the address of this owner.
	 *
	 * @return the address of this owner
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the city of this owner.
	 *
	 * @return the city of this owner
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the first name of this owner.
	 *
	 * @return the first name of this owner
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the last name of this owner.
	 *
	 * @return the last name of this owner
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the owner ID of this owner.
	 *
	 * @return the owner ID of this owner
	 */
	@Override
	public long getOwnerId() {
		return model.getOwnerId();
	}

	/**
	 * Returns the primary key of this owner.
	 *
	 * @return the primary key of this owner
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the telephone of this owner.
	 *
	 * @return the telephone of this owner
	 */
	@Override
	public String getTelephone() {
		return model.getTelephone();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this owner.
	 *
	 * @param address the address of this owner
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the city of this owner.
	 *
	 * @param city the city of this owner
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the first name of this owner.
	 *
	 * @param firstName the first name of this owner
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the last name of this owner.
	 *
	 * @param lastName the last name of this owner
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the owner ID of this owner.
	 *
	 * @param ownerId the owner ID of this owner
	 */
	@Override
	public void setOwnerId(long ownerId) {
		model.setOwnerId(ownerId);
	}

	/**
	 * Sets the primary key of this owner.
	 *
	 * @param primaryKey the primary key of this owner
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the telephone of this owner.
	 *
	 * @param telephone the telephone of this owner
	 */
	@Override
	public void setTelephone(String telephone) {
		model.setTelephone(telephone);
	}

	@Override
	protected OwnerWrapper wrap(Owner owner) {
		return new OwnerWrapper(owner);
	}

}
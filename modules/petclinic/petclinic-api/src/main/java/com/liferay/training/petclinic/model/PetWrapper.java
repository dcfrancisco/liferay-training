/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Pet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Pet
 * @generated
 */
public class PetWrapper
	extends BaseModelWrapper<Pet> implements ModelWrapper<Pet>, Pet {

	public PetWrapper(Pet pet) {
		super(pet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("petId", getPetId());
		attributes.put("ownerId", getOwnerId());
		attributes.put("name", getName());
		attributes.put("birthDate", getBirthDate());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long petId = (Long)attributes.get("petId");

		if (petId != null) {
			setPetId(petId);
		}

		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	 * Returns the birth date of this pet.
	 *
	 * @return the birth date of this pet
	 */
	@Override
	public Date getBirthDate() {
		return model.getBirthDate();
	}

	/**
	 * Returns the name of this pet.
	 *
	 * @return the name of this pet
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the owner ID of this pet.
	 *
	 * @return the owner ID of this pet
	 */
	@Override
	public long getOwnerId() {
		return model.getOwnerId();
	}

	/**
	 * Returns the pet ID of this pet.
	 *
	 * @return the pet ID of this pet
	 */
	@Override
	public long getPetId() {
		return model.getPetId();
	}

	/**
	 * Returns the primary key of this pet.
	 *
	 * @return the primary key of this pet
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this pet.
	 *
	 * @return the type of this pet
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the birth date of this pet.
	 *
	 * @param birthDate the birth date of this pet
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		model.setBirthDate(birthDate);
	}

	/**
	 * Sets the name of this pet.
	 *
	 * @param name the name of this pet
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the owner ID of this pet.
	 *
	 * @param ownerId the owner ID of this pet
	 */
	@Override
	public void setOwnerId(long ownerId) {
		model.setOwnerId(ownerId);
	}

	/**
	 * Sets the pet ID of this pet.
	 *
	 * @param petId the pet ID of this pet
	 */
	@Override
	public void setPetId(long petId) {
		model.setPetId(petId);
	}

	/**
	 * Sets the primary key of this pet.
	 *
	 * @param primaryKey the primary key of this pet
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this pet.
	 *
	 * @param type the type of this pet
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected PetWrapper wrap(Pet pet) {
		return new PetWrapper(pet);
	}

}
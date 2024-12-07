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
 * This class is a wrapper for {@link Vet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Vet
 * @generated
 */
public class VetWrapper
	extends BaseModelWrapper<Vet> implements ModelWrapper<Vet>, Vet {

	public VetWrapper(Vet vet) {
		super(vet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vetId", getVetId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("specialties", getSpecialties());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vetId = (Long)attributes.get("vetId");

		if (vetId != null) {
			setVetId(vetId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String specialties = (String)attributes.get("specialties");

		if (specialties != null) {
			setSpecialties(specialties);
		}
	}

	/**
	 * Returns the first name of this vet.
	 *
	 * @return the first name of this vet
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the last name of this vet.
	 *
	 * @return the last name of this vet
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the primary key of this vet.
	 *
	 * @return the primary key of this vet
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the specialties of this vet.
	 *
	 * @return the specialties of this vet
	 */
	@Override
	public String getSpecialties() {
		return model.getSpecialties();
	}

	/**
	 * Returns the vet ID of this vet.
	 *
	 * @return the vet ID of this vet
	 */
	@Override
	public long getVetId() {
		return model.getVetId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the first name of this vet.
	 *
	 * @param firstName the first name of this vet
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the last name of this vet.
	 *
	 * @param lastName the last name of this vet
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the primary key of this vet.
	 *
	 * @param primaryKey the primary key of this vet
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the specialties of this vet.
	 *
	 * @param specialties the specialties of this vet
	 */
	@Override
	public void setSpecialties(String specialties) {
		model.setSpecialties(specialties);
	}

	/**
	 * Sets the vet ID of this vet.
	 *
	 * @param vetId the vet ID of this vet
	 */
	@Override
	public void setVetId(long vetId) {
		model.setVetId(vetId);
	}

	@Override
	protected VetWrapper wrap(Vet vet) {
		return new VetWrapper(vet);
	}

}
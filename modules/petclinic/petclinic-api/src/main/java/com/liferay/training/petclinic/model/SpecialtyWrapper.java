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
 * This class is a wrapper for {@link Specialty}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Specialty
 * @generated
 */
public class SpecialtyWrapper
	extends BaseModelWrapper<Specialty>
	implements ModelWrapper<Specialty>, Specialty {

	public SpecialtyWrapper(Specialty specialty) {
		super(specialty);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("specialtyId", getSpecialtyId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long specialtyId = (Long)attributes.get("specialtyId");

		if (specialtyId != null) {
			setSpecialtyId(specialtyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	 * Returns the name of this specialty.
	 *
	 * @return the name of this specialty
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this specialty.
	 *
	 * @return the primary key of this specialty
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the specialty ID of this specialty.
	 *
	 * @return the specialty ID of this specialty
	 */
	@Override
	public long getSpecialtyId() {
		return model.getSpecialtyId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the name of this specialty.
	 *
	 * @param name the name of this specialty
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this specialty.
	 *
	 * @param primaryKey the primary key of this specialty
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the specialty ID of this specialty.
	 *
	 * @param specialtyId the specialty ID of this specialty
	 */
	@Override
	public void setSpecialtyId(long specialtyId) {
		model.setSpecialtyId(specialtyId);
	}

	@Override
	protected SpecialtyWrapper wrap(Specialty specialty) {
		return new SpecialtyWrapper(specialty);
	}

}
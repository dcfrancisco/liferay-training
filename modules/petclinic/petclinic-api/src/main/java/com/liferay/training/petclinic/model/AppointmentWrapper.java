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
 * This class is a wrapper for {@link Appointment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Appointment
 * @generated
 */
public class AppointmentWrapper
	extends BaseModelWrapper<Appointment>
	implements Appointment, ModelWrapper<Appointment> {

	public AppointmentWrapper(Appointment appointment) {
		super(appointment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("appointmentId", getAppointmentId());
		attributes.put("petId", getPetId());
		attributes.put("vetId", getVetId());
		attributes.put("date", getDate());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long appointmentId = (Long)attributes.get("appointmentId");

		if (appointmentId != null) {
			setAppointmentId(appointmentId);
		}

		Long petId = (Long)attributes.get("petId");

		if (petId != null) {
			setPetId(petId);
		}

		Long vetId = (Long)attributes.get("vetId");

		if (vetId != null) {
			setVetId(vetId);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the appointment ID of this appointment.
	 *
	 * @return the appointment ID of this appointment
	 */
	@Override
	public long getAppointmentId() {
		return model.getAppointmentId();
	}

	/**
	 * Returns the date of this appointment.
	 *
	 * @return the date of this appointment
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the description of this appointment.
	 *
	 * @return the description of this appointment
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the pet ID of this appointment.
	 *
	 * @return the pet ID of this appointment
	 */
	@Override
	public long getPetId() {
		return model.getPetId();
	}

	/**
	 * Returns the primary key of this appointment.
	 *
	 * @return the primary key of this appointment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the vet ID of this appointment.
	 *
	 * @return the vet ID of this appointment
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
	 * Sets the appointment ID of this appointment.
	 *
	 * @param appointmentId the appointment ID of this appointment
	 */
	@Override
	public void setAppointmentId(long appointmentId) {
		model.setAppointmentId(appointmentId);
	}

	/**
	 * Sets the date of this appointment.
	 *
	 * @param date the date of this appointment
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the description of this appointment.
	 *
	 * @param description the description of this appointment
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the pet ID of this appointment.
	 *
	 * @param petId the pet ID of this appointment
	 */
	@Override
	public void setPetId(long petId) {
		model.setPetId(petId);
	}

	/**
	 * Sets the primary key of this appointment.
	 *
	 * @param primaryKey the primary key of this appointment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the vet ID of this appointment.
	 *
	 * @param vetId the vet ID of this appointment
	 */
	@Override
	public void setVetId(long vetId) {
		model.setVetId(vetId);
	}

	@Override
	protected AppointmentWrapper wrap(Appointment appointment) {
		return new AppointmentWrapper(appointment);
	}

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Vet service. Represents a row in the &quot;PetClinic_Vet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.training.petclinic.model.impl.VetModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.training.petclinic.model.impl.VetImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Vet
 * @generated
 */
@ProviderType
public interface VetModel extends BaseModel<Vet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vet model instance should use the {@link Vet} interface instead.
	 */

	/**
	 * Returns the primary key of this vet.
	 *
	 * @return the primary key of this vet
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vet.
	 *
	 * @param primaryKey the primary key of this vet
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the vet ID of this vet.
	 *
	 * @return the vet ID of this vet
	 */
	public long getVetId();

	/**
	 * Sets the vet ID of this vet.
	 *
	 * @param vetId the vet ID of this vet
	 */
	public void setVetId(long vetId);

	/**
	 * Returns the first name of this vet.
	 *
	 * @return the first name of this vet
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this vet.
	 *
	 * @param firstName the first name of this vet
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this vet.
	 *
	 * @return the last name of this vet
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this vet.
	 *
	 * @param lastName the last name of this vet
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the specialties of this vet.
	 *
	 * @return the specialties of this vet
	 */
	@AutoEscape
	public String getSpecialties();

	/**
	 * Sets the specialties of this vet.
	 *
	 * @param specialties the specialties of this vet
	 */
	public void setSpecialties(String specialties);

}
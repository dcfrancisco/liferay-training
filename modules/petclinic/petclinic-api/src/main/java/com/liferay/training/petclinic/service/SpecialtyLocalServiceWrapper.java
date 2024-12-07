/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SpecialtyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SpecialtyLocalService
 * @generated
 */
public class SpecialtyLocalServiceWrapper
	implements ServiceWrapper<SpecialtyLocalService>, SpecialtyLocalService {

	public SpecialtyLocalServiceWrapper(
		SpecialtyLocalService specialtyLocalService) {

		_specialtyLocalService = specialtyLocalService;
	}

	/**
	 * Adds the specialty to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecialtyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specialty the specialty
	 * @return the specialty that was added
	 */
	@Override
	public com.liferay.training.petclinic.model.Specialty addSpecialty(
		com.liferay.training.petclinic.model.Specialty specialty) {

		return _specialtyLocalService.addSpecialty(specialty);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specialtyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new specialty with the primary key. Does not add the specialty to the database.
	 *
	 * @param specialtyId the primary key for the new specialty
	 * @return the new specialty
	 */
	@Override
	public com.liferay.training.petclinic.model.Specialty createSpecialty(
		long specialtyId) {

		return _specialtyLocalService.createSpecialty(specialtyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specialtyLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the specialty with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecialtyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specialtyId the primary key of the specialty
	 * @return the specialty that was removed
	 * @throws PortalException if a specialty with the primary key could not be found
	 */
	@Override
	public com.liferay.training.petclinic.model.Specialty deleteSpecialty(
			long specialtyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specialtyLocalService.deleteSpecialty(specialtyId);
	}

	/**
	 * Deletes the specialty from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecialtyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specialty the specialty
	 * @return the specialty that was removed
	 */
	@Override
	public com.liferay.training.petclinic.model.Specialty deleteSpecialty(
		com.liferay.training.petclinic.model.Specialty specialty) {

		return _specialtyLocalService.deleteSpecialty(specialty);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _specialtyLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _specialtyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.petclinic.model.impl.SpecialtyModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _specialtyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.petclinic.model.impl.SpecialtyModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _specialtyLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _specialtyLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _specialtyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.training.petclinic.model.Specialty fetchSpecialty(
		long specialtyId) {

		return _specialtyLocalService.fetchSpecialty(specialtyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _specialtyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _specialtyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _specialtyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specialtyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the specialties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.petclinic.model.impl.SpecialtyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specialties
	 * @param end the upper bound of the range of specialties (not inclusive)
	 * @return the range of specialties
	 */
	@Override
	public java.util.List<com.liferay.training.petclinic.model.Specialty>
		getSpecialties(int start, int end) {

		return _specialtyLocalService.getSpecialties(start, end);
	}

	/**
	 * Returns the number of specialties.
	 *
	 * @return the number of specialties
	 */
	@Override
	public int getSpecialtiesCount() {
		return _specialtyLocalService.getSpecialtiesCount();
	}

	/**
	 * Returns the specialty with the primary key.
	 *
	 * @param specialtyId the primary key of the specialty
	 * @return the specialty
	 * @throws PortalException if a specialty with the primary key could not be found
	 */
	@Override
	public com.liferay.training.petclinic.model.Specialty getSpecialty(
			long specialtyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _specialtyLocalService.getSpecialty(specialtyId);
	}

	/**
	 * Updates the specialty in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SpecialtyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param specialty the specialty
	 * @return the specialty that was updated
	 */
	@Override
	public com.liferay.training.petclinic.model.Specialty updateSpecialty(
		com.liferay.training.petclinic.model.Specialty specialty) {

		return _specialtyLocalService.updateSpecialty(specialty);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _specialtyLocalService.getBasePersistence();
	}

	@Override
	public SpecialtyLocalService getWrappedService() {
		return _specialtyLocalService;
	}

	@Override
	public void setWrappedService(SpecialtyLocalService specialtyLocalService) {
		_specialtyLocalService = specialtyLocalService;
	}

	private SpecialtyLocalService _specialtyLocalService;

}
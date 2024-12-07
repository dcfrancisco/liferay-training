/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link VetLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VetLocalService
 * @generated
 */
public class VetLocalServiceWrapper
	implements ServiceWrapper<VetLocalService>, VetLocalService {

	public VetLocalServiceWrapper(VetLocalService vetLocalService) {
		_vetLocalService = vetLocalService;
	}

	/**
	 * Adds the vet to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vet the vet
	 * @return the vet that was added
	 */
	@Override
	public com.liferay.training.petclinic.model.Vet addVet(
		com.liferay.training.petclinic.model.Vet vet) {

		return _vetLocalService.addVet(vet);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vetLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new vet with the primary key. Does not add the vet to the database.
	 *
	 * @param vetId the primary key for the new vet
	 * @return the new vet
	 */
	@Override
	public com.liferay.training.petclinic.model.Vet createVet(long vetId) {
		return _vetLocalService.createVet(vetId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vetLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vetId the primary key of the vet
	 * @return the vet that was removed
	 * @throws PortalException if a vet with the primary key could not be found
	 */
	@Override
	public com.liferay.training.petclinic.model.Vet deleteVet(long vetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vetLocalService.deleteVet(vetId);
	}

	/**
	 * Deletes the vet from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vet the vet
	 * @return the vet that was removed
	 */
	@Override
	public com.liferay.training.petclinic.model.Vet deleteVet(
		com.liferay.training.petclinic.model.Vet vet) {

		return _vetLocalService.deleteVet(vet);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vetLocalService.dynamicQuery();
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

		return _vetLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.petclinic.model.impl.VetModelImpl</code>.
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

		return _vetLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.petclinic.model.impl.VetModelImpl</code>.
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

		return _vetLocalService.dynamicQuery(
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

		return _vetLocalService.dynamicQueryCount(dynamicQuery);
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

		return _vetLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.training.petclinic.model.Vet fetchVet(long vetId) {
		return _vetLocalService.fetchVet(vetId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _vetLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _vetLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _vetLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vetLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vet with the primary key.
	 *
	 * @param vetId the primary key of the vet
	 * @return the vet
	 * @throws PortalException if a vet with the primary key could not be found
	 */
	@Override
	public com.liferay.training.petclinic.model.Vet getVet(long vetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vetLocalService.getVet(vetId);
	}

	/**
	 * Returns a range of all the vets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.petclinic.model.impl.VetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vets
	 * @param end the upper bound of the range of vets (not inclusive)
	 * @return the range of vets
	 */
	@Override
	public java.util.List<com.liferay.training.petclinic.model.Vet> getVets(
		int start, int end) {

		return _vetLocalService.getVets(start, end);
	}

	/**
	 * Returns the number of vets.
	 *
	 * @return the number of vets
	 */
	@Override
	public int getVetsCount() {
		return _vetLocalService.getVetsCount();
	}

	/**
	 * Updates the vet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vet the vet
	 * @return the vet that was updated
	 */
	@Override
	public com.liferay.training.petclinic.model.Vet updateVet(
		com.liferay.training.petclinic.model.Vet vet) {

		return _vetLocalService.updateVet(vet);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _vetLocalService.getBasePersistence();
	}

	@Override
	public VetLocalService getWrappedService() {
		return _vetLocalService;
	}

	@Override
	public void setWrappedService(VetLocalService vetLocalService) {
		_vetLocalService = vetLocalService;
	}

	private VetLocalService _vetLocalService;

}
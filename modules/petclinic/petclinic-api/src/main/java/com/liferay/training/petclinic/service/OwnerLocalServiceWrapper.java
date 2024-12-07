/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link OwnerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OwnerLocalService
 * @generated
 */
public class OwnerLocalServiceWrapper
	implements OwnerLocalService, ServiceWrapper<OwnerLocalService> {

	public OwnerLocalServiceWrapper(OwnerLocalService ownerLocalService) {
		_ownerLocalService = ownerLocalService;
	}

	/**
	 * Adds the owner to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OwnerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param owner the owner
	 * @return the owner that was added
	 */
	@Override
	public com.liferay.training.petclinic.model.Owner addOwner(
		com.liferay.training.petclinic.model.Owner owner) {

		return _ownerLocalService.addOwner(owner);
	}

	/**
	 * Creates a new owner with the primary key. Does not add the owner to the database.
	 *
	 * @param ownerId the primary key for the new owner
	 * @return the new owner
	 */
	@Override
	public com.liferay.training.petclinic.model.Owner createOwner(
		long ownerId) {

		return _ownerLocalService.createOwner(ownerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ownerLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the owner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OwnerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ownerId the primary key of the owner
	 * @return the owner that was removed
	 * @throws PortalException if a owner with the primary key could not be found
	 */
	@Override
	public com.liferay.training.petclinic.model.Owner deleteOwner(long ownerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ownerLocalService.deleteOwner(ownerId);
	}

	/**
	 * Deletes the owner from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OwnerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param owner the owner
	 * @return the owner that was removed
	 */
	@Override
	public com.liferay.training.petclinic.model.Owner deleteOwner(
		com.liferay.training.petclinic.model.Owner owner) {

		return _ownerLocalService.deleteOwner(owner);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ownerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ownerLocalService.dynamicQuery();
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

		return _ownerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.petclinic.model.impl.OwnerModelImpl</code>.
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

		return _ownerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.petclinic.model.impl.OwnerModelImpl</code>.
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

		return _ownerLocalService.dynamicQuery(
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

		return _ownerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ownerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.training.petclinic.model.Owner fetchOwner(long ownerId) {
		return _ownerLocalService.fetchOwner(ownerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ownerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ownerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ownerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the owner with the primary key.
	 *
	 * @param ownerId the primary key of the owner
	 * @return the owner
	 * @throws PortalException if a owner with the primary key could not be found
	 */
	@Override
	public com.liferay.training.petclinic.model.Owner getOwner(long ownerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ownerLocalService.getOwner(ownerId);
	}

	@Override
	public java.util.List<com.liferay.training.petclinic.model.Owner>
		getOwnerByLastName() {

		return _ownerLocalService.getOwnerByLastName();
	}

	/**
	 * Returns a range of all the owners.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.petclinic.model.impl.OwnerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of owners
	 * @param end the upper bound of the range of owners (not inclusive)
	 * @return the range of owners
	 */
	@Override
	public java.util.List<com.liferay.training.petclinic.model.Owner> getOwners(
		int start, int end) {

		return _ownerLocalService.getOwners(start, end);
	}

	/**
	 * Returns the number of owners.
	 *
	 * @return the number of owners
	 */
	@Override
	public int getOwnersCount() {
		return _ownerLocalService.getOwnersCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ownerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the owner in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OwnerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param owner the owner
	 * @return the owner that was updated
	 */
	@Override
	public com.liferay.training.petclinic.model.Owner updateOwner(
		com.liferay.training.petclinic.model.Owner owner) {

		return _ownerLocalService.updateOwner(owner);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _ownerLocalService.getBasePersistence();
	}

	@Override
	public OwnerLocalService getWrappedService() {
		return _ownerLocalService;
	}

	@Override
	public void setWrappedService(OwnerLocalService ownerLocalService) {
		_ownerLocalService = ownerLocalService;
	}

	private OwnerLocalService _ownerLocalService;

}
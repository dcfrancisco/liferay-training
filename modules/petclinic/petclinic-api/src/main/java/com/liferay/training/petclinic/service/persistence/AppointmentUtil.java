/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.petclinic.model.Appointment;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the appointment service. This utility wraps <code>com.liferay.training.petclinic.service.persistence.impl.AppointmentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppointmentPersistence
 * @generated
 */
public class AppointmentUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Appointment appointment) {
		getPersistence().clearCache(appointment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Appointment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Appointment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Appointment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Appointment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Appointment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Appointment update(Appointment appointment) {
		return getPersistence().update(appointment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Appointment update(
		Appointment appointment, ServiceContext serviceContext) {

		return getPersistence().update(appointment, serviceContext);
	}

	/**
	 * Returns all the appointments where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @return the matching appointments
	 */
	public static List<Appointment> findByPetId(long petId) {
		return getPersistence().findByPetId(petId);
	}

	/**
	 * Returns a range of all the appointments where petId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppointmentModelImpl</code>.
	 * </p>
	 *
	 * @param petId the pet ID
	 * @param start the lower bound of the range of appointments
	 * @param end the upper bound of the range of appointments (not inclusive)
	 * @return the range of matching appointments
	 */
	public static List<Appointment> findByPetId(
		long petId, int start, int end) {

		return getPersistence().findByPetId(petId, start, end);
	}

	/**
	 * Returns an ordered range of all the appointments where petId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppointmentModelImpl</code>.
	 * </p>
	 *
	 * @param petId the pet ID
	 * @param start the lower bound of the range of appointments
	 * @param end the upper bound of the range of appointments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appointments
	 */
	public static List<Appointment> findByPetId(
		long petId, int start, int end,
		OrderByComparator<Appointment> orderByComparator) {

		return getPersistence().findByPetId(
			petId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appointments where petId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppointmentModelImpl</code>.
	 * </p>
	 *
	 * @param petId the pet ID
	 * @param start the lower bound of the range of appointments
	 * @param end the upper bound of the range of appointments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appointments
	 */
	public static List<Appointment> findByPetId(
		long petId, int start, int end,
		OrderByComparator<Appointment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPetId(
			petId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	public static Appointment findByPetId_First(
			long petId, OrderByComparator<Appointment> orderByComparator)
		throws com.liferay.training.petclinic.exception.
			NoSuchAppointmentException {

		return getPersistence().findByPetId_First(petId, orderByComparator);
	}

	/**
	 * Returns the first appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	public static Appointment fetchByPetId_First(
		long petId, OrderByComparator<Appointment> orderByComparator) {

		return getPersistence().fetchByPetId_First(petId, orderByComparator);
	}

	/**
	 * Returns the last appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	public static Appointment findByPetId_Last(
			long petId, OrderByComparator<Appointment> orderByComparator)
		throws com.liferay.training.petclinic.exception.
			NoSuchAppointmentException {

		return getPersistence().findByPetId_Last(petId, orderByComparator);
	}

	/**
	 * Returns the last appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	public static Appointment fetchByPetId_Last(
		long petId, OrderByComparator<Appointment> orderByComparator) {

		return getPersistence().fetchByPetId_Last(petId, orderByComparator);
	}

	/**
	 * Returns the appointments before and after the current appointment in the ordered set where petId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	public static Appointment[] findByPetId_PrevAndNext(
			long appointmentId, long petId,
			OrderByComparator<Appointment> orderByComparator)
		throws com.liferay.training.petclinic.exception.
			NoSuchAppointmentException {

		return getPersistence().findByPetId_PrevAndNext(
			appointmentId, petId, orderByComparator);
	}

	/**
	 * Removes all the appointments where petId = &#63; from the database.
	 *
	 * @param petId the pet ID
	 */
	public static void removeByPetId(long petId) {
		getPersistence().removeByPetId(petId);
	}

	/**
	 * Returns the number of appointments where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @return the number of matching appointments
	 */
	public static int countByPetId(long petId) {
		return getPersistence().countByPetId(petId);
	}

	/**
	 * Returns all the appointments where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @return the matching appointments
	 */
	public static List<Appointment> findByVetId(long vetId) {
		return getPersistence().findByVetId(vetId);
	}

	/**
	 * Returns a range of all the appointments where vetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppointmentModelImpl</code>.
	 * </p>
	 *
	 * @param vetId the vet ID
	 * @param start the lower bound of the range of appointments
	 * @param end the upper bound of the range of appointments (not inclusive)
	 * @return the range of matching appointments
	 */
	public static List<Appointment> findByVetId(
		long vetId, int start, int end) {

		return getPersistence().findByVetId(vetId, start, end);
	}

	/**
	 * Returns an ordered range of all the appointments where vetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppointmentModelImpl</code>.
	 * </p>
	 *
	 * @param vetId the vet ID
	 * @param start the lower bound of the range of appointments
	 * @param end the upper bound of the range of appointments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appointments
	 */
	public static List<Appointment> findByVetId(
		long vetId, int start, int end,
		OrderByComparator<Appointment> orderByComparator) {

		return getPersistence().findByVetId(
			vetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appointments where vetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppointmentModelImpl</code>.
	 * </p>
	 *
	 * @param vetId the vet ID
	 * @param start the lower bound of the range of appointments
	 * @param end the upper bound of the range of appointments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appointments
	 */
	public static List<Appointment> findByVetId(
		long vetId, int start, int end,
		OrderByComparator<Appointment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVetId(
			vetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	public static Appointment findByVetId_First(
			long vetId, OrderByComparator<Appointment> orderByComparator)
		throws com.liferay.training.petclinic.exception.
			NoSuchAppointmentException {

		return getPersistence().findByVetId_First(vetId, orderByComparator);
	}

	/**
	 * Returns the first appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	public static Appointment fetchByVetId_First(
		long vetId, OrderByComparator<Appointment> orderByComparator) {

		return getPersistence().fetchByVetId_First(vetId, orderByComparator);
	}

	/**
	 * Returns the last appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	public static Appointment findByVetId_Last(
			long vetId, OrderByComparator<Appointment> orderByComparator)
		throws com.liferay.training.petclinic.exception.
			NoSuchAppointmentException {

		return getPersistence().findByVetId_Last(vetId, orderByComparator);
	}

	/**
	 * Returns the last appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	public static Appointment fetchByVetId_Last(
		long vetId, OrderByComparator<Appointment> orderByComparator) {

		return getPersistence().fetchByVetId_Last(vetId, orderByComparator);
	}

	/**
	 * Returns the appointments before and after the current appointment in the ordered set where vetId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	public static Appointment[] findByVetId_PrevAndNext(
			long appointmentId, long vetId,
			OrderByComparator<Appointment> orderByComparator)
		throws com.liferay.training.petclinic.exception.
			NoSuchAppointmentException {

		return getPersistence().findByVetId_PrevAndNext(
			appointmentId, vetId, orderByComparator);
	}

	/**
	 * Removes all the appointments where vetId = &#63; from the database.
	 *
	 * @param vetId the vet ID
	 */
	public static void removeByVetId(long vetId) {
		getPersistence().removeByVetId(vetId);
	}

	/**
	 * Returns the number of appointments where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @return the number of matching appointments
	 */
	public static int countByVetId(long vetId) {
		return getPersistence().countByVetId(vetId);
	}

	/**
	 * Caches the appointment in the entity cache if it is enabled.
	 *
	 * @param appointment the appointment
	 */
	public static void cacheResult(Appointment appointment) {
		getPersistence().cacheResult(appointment);
	}

	/**
	 * Caches the appointments in the entity cache if it is enabled.
	 *
	 * @param appointments the appointments
	 */
	public static void cacheResult(List<Appointment> appointments) {
		getPersistence().cacheResult(appointments);
	}

	/**
	 * Creates a new appointment with the primary key. Does not add the appointment to the database.
	 *
	 * @param appointmentId the primary key for the new appointment
	 * @return the new appointment
	 */
	public static Appointment create(long appointmentId) {
		return getPersistence().create(appointmentId);
	}

	/**
	 * Removes the appointment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appointmentId the primary key of the appointment
	 * @return the appointment that was removed
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	public static Appointment remove(long appointmentId)
		throws com.liferay.training.petclinic.exception.
			NoSuchAppointmentException {

		return getPersistence().remove(appointmentId);
	}

	public static Appointment updateImpl(Appointment appointment) {
		return getPersistence().updateImpl(appointment);
	}

	/**
	 * Returns the appointment with the primary key or throws a <code>NoSuchAppointmentException</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment
	 * @return the appointment
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	public static Appointment findByPrimaryKey(long appointmentId)
		throws com.liferay.training.petclinic.exception.
			NoSuchAppointmentException {

		return getPersistence().findByPrimaryKey(appointmentId);
	}

	/**
	 * Returns the appointment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment
	 * @return the appointment, or <code>null</code> if a appointment with the primary key could not be found
	 */
	public static Appointment fetchByPrimaryKey(long appointmentId) {
		return getPersistence().fetchByPrimaryKey(appointmentId);
	}

	/**
	 * Returns all the appointments.
	 *
	 * @return the appointments
	 */
	public static List<Appointment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the appointments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppointmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appointments
	 * @param end the upper bound of the range of appointments (not inclusive)
	 * @return the range of appointments
	 */
	public static List<Appointment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the appointments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppointmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appointments
	 * @param end the upper bound of the range of appointments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appointments
	 */
	public static List<Appointment> findAll(
		int start, int end, OrderByComparator<Appointment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appointments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppointmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appointments
	 * @param end the upper bound of the range of appointments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appointments
	 */
	public static List<Appointment> findAll(
		int start, int end, OrderByComparator<Appointment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the appointments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of appointments.
	 *
	 * @return the number of appointments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppointmentPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AppointmentPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AppointmentPersistence _persistence;

}
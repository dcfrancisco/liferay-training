/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.petclinic.exception.NoSuchAppointmentException;
import com.liferay.training.petclinic.model.Appointment;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the appointment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppointmentUtil
 * @generated
 */
@ProviderType
public interface AppointmentPersistence extends BasePersistence<Appointment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppointmentUtil} to access the appointment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the appointments where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @return the matching appointments
	 */
	public java.util.List<Appointment> findByPetId(long petId);

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
	public java.util.List<Appointment> findByPetId(
		long petId, int start, int end);

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
	public java.util.List<Appointment> findByPetId(
		long petId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Appointment>
			orderByComparator);

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
	public java.util.List<Appointment> findByPetId(
		long petId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Appointment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	public Appointment findByPetId_First(
			long petId,
			com.liferay.portal.kernel.util.OrderByComparator<Appointment>
				orderByComparator)
		throws NoSuchAppointmentException;

	/**
	 * Returns the first appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	public Appointment fetchByPetId_First(
		long petId,
		com.liferay.portal.kernel.util.OrderByComparator<Appointment>
			orderByComparator);

	/**
	 * Returns the last appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	public Appointment findByPetId_Last(
			long petId,
			com.liferay.portal.kernel.util.OrderByComparator<Appointment>
				orderByComparator)
		throws NoSuchAppointmentException;

	/**
	 * Returns the last appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	public Appointment fetchByPetId_Last(
		long petId,
		com.liferay.portal.kernel.util.OrderByComparator<Appointment>
			orderByComparator);

	/**
	 * Returns the appointments before and after the current appointment in the ordered set where petId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	public Appointment[] findByPetId_PrevAndNext(
			long appointmentId, long petId,
			com.liferay.portal.kernel.util.OrderByComparator<Appointment>
				orderByComparator)
		throws NoSuchAppointmentException;

	/**
	 * Removes all the appointments where petId = &#63; from the database.
	 *
	 * @param petId the pet ID
	 */
	public void removeByPetId(long petId);

	/**
	 * Returns the number of appointments where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @return the number of matching appointments
	 */
	public int countByPetId(long petId);

	/**
	 * Returns all the appointments where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @return the matching appointments
	 */
	public java.util.List<Appointment> findByVetId(long vetId);

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
	public java.util.List<Appointment> findByVetId(
		long vetId, int start, int end);

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
	public java.util.List<Appointment> findByVetId(
		long vetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Appointment>
			orderByComparator);

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
	public java.util.List<Appointment> findByVetId(
		long vetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Appointment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	public Appointment findByVetId_First(
			long vetId,
			com.liferay.portal.kernel.util.OrderByComparator<Appointment>
				orderByComparator)
		throws NoSuchAppointmentException;

	/**
	 * Returns the first appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	public Appointment fetchByVetId_First(
		long vetId,
		com.liferay.portal.kernel.util.OrderByComparator<Appointment>
			orderByComparator);

	/**
	 * Returns the last appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	public Appointment findByVetId_Last(
			long vetId,
			com.liferay.portal.kernel.util.OrderByComparator<Appointment>
				orderByComparator)
		throws NoSuchAppointmentException;

	/**
	 * Returns the last appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	public Appointment fetchByVetId_Last(
		long vetId,
		com.liferay.portal.kernel.util.OrderByComparator<Appointment>
			orderByComparator);

	/**
	 * Returns the appointments before and after the current appointment in the ordered set where vetId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	public Appointment[] findByVetId_PrevAndNext(
			long appointmentId, long vetId,
			com.liferay.portal.kernel.util.OrderByComparator<Appointment>
				orderByComparator)
		throws NoSuchAppointmentException;

	/**
	 * Removes all the appointments where vetId = &#63; from the database.
	 *
	 * @param vetId the vet ID
	 */
	public void removeByVetId(long vetId);

	/**
	 * Returns the number of appointments where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @return the number of matching appointments
	 */
	public int countByVetId(long vetId);

	/**
	 * Caches the appointment in the entity cache if it is enabled.
	 *
	 * @param appointment the appointment
	 */
	public void cacheResult(Appointment appointment);

	/**
	 * Caches the appointments in the entity cache if it is enabled.
	 *
	 * @param appointments the appointments
	 */
	public void cacheResult(java.util.List<Appointment> appointments);

	/**
	 * Creates a new appointment with the primary key. Does not add the appointment to the database.
	 *
	 * @param appointmentId the primary key for the new appointment
	 * @return the new appointment
	 */
	public Appointment create(long appointmentId);

	/**
	 * Removes the appointment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appointmentId the primary key of the appointment
	 * @return the appointment that was removed
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	public Appointment remove(long appointmentId)
		throws NoSuchAppointmentException;

	public Appointment updateImpl(Appointment appointment);

	/**
	 * Returns the appointment with the primary key or throws a <code>NoSuchAppointmentException</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment
	 * @return the appointment
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	public Appointment findByPrimaryKey(long appointmentId)
		throws NoSuchAppointmentException;

	/**
	 * Returns the appointment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment
	 * @return the appointment, or <code>null</code> if a appointment with the primary key could not be found
	 */
	public Appointment fetchByPrimaryKey(long appointmentId);

	/**
	 * Returns all the appointments.
	 *
	 * @return the appointments
	 */
	public java.util.List<Appointment> findAll();

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
	public java.util.List<Appointment> findAll(int start, int end);

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
	public java.util.List<Appointment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Appointment>
			orderByComparator);

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
	public java.util.List<Appointment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Appointment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the appointments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of appointments.
	 *
	 * @return the number of appointments
	 */
	public int countAll();

}
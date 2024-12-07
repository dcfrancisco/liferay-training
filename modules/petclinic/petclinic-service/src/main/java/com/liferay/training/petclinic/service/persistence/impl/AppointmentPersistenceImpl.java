/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.training.petclinic.exception.NoSuchAppointmentException;
import com.liferay.training.petclinic.model.Appointment;
import com.liferay.training.petclinic.model.impl.AppointmentImpl;
import com.liferay.training.petclinic.model.impl.AppointmentModelImpl;
import com.liferay.training.petclinic.service.persistence.AppointmentPersistence;
import com.liferay.training.petclinic.service.persistence.AppointmentUtil;
import com.liferay.training.petclinic.service.persistence.impl.constants.PetClinicPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the appointment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AppointmentPersistence.class)
public class AppointmentPersistenceImpl
	extends BasePersistenceImpl<Appointment> implements AppointmentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppointmentUtil</code> to access the appointment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppointmentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPetId;
	private FinderPath _finderPathWithoutPaginationFindByPetId;
	private FinderPath _finderPathCountByPetId;

	/**
	 * Returns all the appointments where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @return the matching appointments
	 */
	@Override
	public List<Appointment> findByPetId(long petId) {
		return findByPetId(petId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Appointment> findByPetId(long petId, int start, int end) {
		return findByPetId(petId, start, end, null);
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
	@Override
	public List<Appointment> findByPetId(
		long petId, int start, int end,
		OrderByComparator<Appointment> orderByComparator) {

		return findByPetId(petId, start, end, orderByComparator, true);
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
	@Override
	public List<Appointment> findByPetId(
		long petId, int start, int end,
		OrderByComparator<Appointment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPetId;
				finderArgs = new Object[] {petId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPetId;
			finderArgs = new Object[] {petId, start, end, orderByComparator};
		}

		List<Appointment> list = null;

		if (useFinderCache) {
			list = (List<Appointment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Appointment appointment : list) {
					if (petId != appointment.getPetId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_APPOINTMENT_WHERE);

			sb.append(_FINDER_COLUMN_PETID_PETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppointmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(petId);

				list = (List<Appointment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	@Override
	public Appointment findByPetId_First(
			long petId, OrderByComparator<Appointment> orderByComparator)
		throws NoSuchAppointmentException {

		Appointment appointment = fetchByPetId_First(petId, orderByComparator);

		if (appointment != null) {
			return appointment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("petId=");
		sb.append(petId);

		sb.append("}");

		throw new NoSuchAppointmentException(sb.toString());
	}

	/**
	 * Returns the first appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	@Override
	public Appointment fetchByPetId_First(
		long petId, OrderByComparator<Appointment> orderByComparator) {

		List<Appointment> list = findByPetId(petId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	@Override
	public Appointment findByPetId_Last(
			long petId, OrderByComparator<Appointment> orderByComparator)
		throws NoSuchAppointmentException {

		Appointment appointment = fetchByPetId_Last(petId, orderByComparator);

		if (appointment != null) {
			return appointment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("petId=");
		sb.append(petId);

		sb.append("}");

		throw new NoSuchAppointmentException(sb.toString());
	}

	/**
	 * Returns the last appointment in the ordered set where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	@Override
	public Appointment fetchByPetId_Last(
		long petId, OrderByComparator<Appointment> orderByComparator) {

		int count = countByPetId(petId);

		if (count == 0) {
			return null;
		}

		List<Appointment> list = findByPetId(
			petId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Appointment[] findByPetId_PrevAndNext(
			long appointmentId, long petId,
			OrderByComparator<Appointment> orderByComparator)
		throws NoSuchAppointmentException {

		Appointment appointment = findByPrimaryKey(appointmentId);

		Session session = null;

		try {
			session = openSession();

			Appointment[] array = new AppointmentImpl[3];

			array[0] = getByPetId_PrevAndNext(
				session, appointment, petId, orderByComparator, true);

			array[1] = appointment;

			array[2] = getByPetId_PrevAndNext(
				session, appointment, petId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Appointment getByPetId_PrevAndNext(
		Session session, Appointment appointment, long petId,
		OrderByComparator<Appointment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPOINTMENT_WHERE);

		sb.append(_FINDER_COLUMN_PETID_PETID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AppointmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(petId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(appointment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Appointment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appointments where petId = &#63; from the database.
	 *
	 * @param petId the pet ID
	 */
	@Override
	public void removeByPetId(long petId) {
		for (Appointment appointment :
				findByPetId(
					petId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appointment);
		}
	}

	/**
	 * Returns the number of appointments where petId = &#63;.
	 *
	 * @param petId the pet ID
	 * @return the number of matching appointments
	 */
	@Override
	public int countByPetId(long petId) {
		FinderPath finderPath = _finderPathCountByPetId;

		Object[] finderArgs = new Object[] {petId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPOINTMENT_WHERE);

			sb.append(_FINDER_COLUMN_PETID_PETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(petId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PETID_PETID_2 =
		"appointment.petId = ?";

	private FinderPath _finderPathWithPaginationFindByVetId;
	private FinderPath _finderPathWithoutPaginationFindByVetId;
	private FinderPath _finderPathCountByVetId;

	/**
	 * Returns all the appointments where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @return the matching appointments
	 */
	@Override
	public List<Appointment> findByVetId(long vetId) {
		return findByVetId(vetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Appointment> findByVetId(long vetId, int start, int end) {
		return findByVetId(vetId, start, end, null);
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
	@Override
	public List<Appointment> findByVetId(
		long vetId, int start, int end,
		OrderByComparator<Appointment> orderByComparator) {

		return findByVetId(vetId, start, end, orderByComparator, true);
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
	@Override
	public List<Appointment> findByVetId(
		long vetId, int start, int end,
		OrderByComparator<Appointment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVetId;
				finderArgs = new Object[] {vetId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVetId;
			finderArgs = new Object[] {vetId, start, end, orderByComparator};
		}

		List<Appointment> list = null;

		if (useFinderCache) {
			list = (List<Appointment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Appointment appointment : list) {
					if (vetId != appointment.getVetId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_APPOINTMENT_WHERE);

			sb.append(_FINDER_COLUMN_VETID_VETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppointmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(vetId);

				list = (List<Appointment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	@Override
	public Appointment findByVetId_First(
			long vetId, OrderByComparator<Appointment> orderByComparator)
		throws NoSuchAppointmentException {

		Appointment appointment = fetchByVetId_First(vetId, orderByComparator);

		if (appointment != null) {
			return appointment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("vetId=");
		sb.append(vetId);

		sb.append("}");

		throw new NoSuchAppointmentException(sb.toString());
	}

	/**
	 * Returns the first appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	@Override
	public Appointment fetchByVetId_First(
		long vetId, OrderByComparator<Appointment> orderByComparator) {

		List<Appointment> list = findByVetId(vetId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment
	 * @throws NoSuchAppointmentException if a matching appointment could not be found
	 */
	@Override
	public Appointment findByVetId_Last(
			long vetId, OrderByComparator<Appointment> orderByComparator)
		throws NoSuchAppointmentException {

		Appointment appointment = fetchByVetId_Last(vetId, orderByComparator);

		if (appointment != null) {
			return appointment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("vetId=");
		sb.append(vetId);

		sb.append("}");

		throw new NoSuchAppointmentException(sb.toString());
	}

	/**
	 * Returns the last appointment in the ordered set where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment, or <code>null</code> if a matching appointment could not be found
	 */
	@Override
	public Appointment fetchByVetId_Last(
		long vetId, OrderByComparator<Appointment> orderByComparator) {

		int count = countByVetId(vetId);

		if (count == 0) {
			return null;
		}

		List<Appointment> list = findByVetId(
			vetId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Appointment[] findByVetId_PrevAndNext(
			long appointmentId, long vetId,
			OrderByComparator<Appointment> orderByComparator)
		throws NoSuchAppointmentException {

		Appointment appointment = findByPrimaryKey(appointmentId);

		Session session = null;

		try {
			session = openSession();

			Appointment[] array = new AppointmentImpl[3];

			array[0] = getByVetId_PrevAndNext(
				session, appointment, vetId, orderByComparator, true);

			array[1] = appointment;

			array[2] = getByVetId_PrevAndNext(
				session, appointment, vetId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Appointment getByVetId_PrevAndNext(
		Session session, Appointment appointment, long vetId,
		OrderByComparator<Appointment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPOINTMENT_WHERE);

		sb.append(_FINDER_COLUMN_VETID_VETID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AppointmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(vetId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(appointment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Appointment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appointments where vetId = &#63; from the database.
	 *
	 * @param vetId the vet ID
	 */
	@Override
	public void removeByVetId(long vetId) {
		for (Appointment appointment :
				findByVetId(
					vetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appointment);
		}
	}

	/**
	 * Returns the number of appointments where vetId = &#63;.
	 *
	 * @param vetId the vet ID
	 * @return the number of matching appointments
	 */
	@Override
	public int countByVetId(long vetId) {
		FinderPath finderPath = _finderPathCountByVetId;

		Object[] finderArgs = new Object[] {vetId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPOINTMENT_WHERE);

			sb.append(_FINDER_COLUMN_VETID_VETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(vetId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VETID_VETID_2 =
		"appointment.vetId = ?";

	public AppointmentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("date", "date_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Appointment.class);

		setModelImplClass(AppointmentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the appointment in the entity cache if it is enabled.
	 *
	 * @param appointment the appointment
	 */
	@Override
	public void cacheResult(Appointment appointment) {
		entityCache.putResult(
			AppointmentImpl.class, appointment.getPrimaryKey(), appointment);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the appointments in the entity cache if it is enabled.
	 *
	 * @param appointments the appointments
	 */
	@Override
	public void cacheResult(List<Appointment> appointments) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appointments.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Appointment appointment : appointments) {
			if (entityCache.getResult(
					AppointmentImpl.class, appointment.getPrimaryKey()) ==
						null) {

				cacheResult(appointment);
			}
		}
	}

	/**
	 * Clears the cache for all appointments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppointmentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the appointment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Appointment appointment) {
		entityCache.removeResult(AppointmentImpl.class, appointment);
	}

	@Override
	public void clearCache(List<Appointment> appointments) {
		for (Appointment appointment : appointments) {
			entityCache.removeResult(AppointmentImpl.class, appointment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AppointmentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new appointment with the primary key. Does not add the appointment to the database.
	 *
	 * @param appointmentId the primary key for the new appointment
	 * @return the new appointment
	 */
	@Override
	public Appointment create(long appointmentId) {
		Appointment appointment = new AppointmentImpl();

		appointment.setNew(true);
		appointment.setPrimaryKey(appointmentId);

		return appointment;
	}

	/**
	 * Removes the appointment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appointmentId the primary key of the appointment
	 * @return the appointment that was removed
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	@Override
	public Appointment remove(long appointmentId)
		throws NoSuchAppointmentException {

		return remove((Serializable)appointmentId);
	}

	/**
	 * Removes the appointment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appointment
	 * @return the appointment that was removed
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	@Override
	public Appointment remove(Serializable primaryKey)
		throws NoSuchAppointmentException {

		Session session = null;

		try {
			session = openSession();

			Appointment appointment = (Appointment)session.get(
				AppointmentImpl.class, primaryKey);

			if (appointment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppointmentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appointment);
		}
		catch (NoSuchAppointmentException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Appointment removeImpl(Appointment appointment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appointment)) {
				appointment = (Appointment)session.get(
					AppointmentImpl.class, appointment.getPrimaryKeyObj());
			}

			if (appointment != null) {
				session.delete(appointment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appointment != null) {
			clearCache(appointment);
		}

		return appointment;
	}

	@Override
	public Appointment updateImpl(Appointment appointment) {
		boolean isNew = appointment.isNew();

		if (!(appointment instanceof AppointmentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appointment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(appointment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appointment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Appointment implementation " +
					appointment.getClass());
		}

		AppointmentModelImpl appointmentModelImpl =
			(AppointmentModelImpl)appointment;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appointment);
			}
			else {
				appointment = (Appointment)session.merge(appointment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AppointmentImpl.class, appointmentModelImpl, false, true);

		if (isNew) {
			appointment.setNew(false);
		}

		appointment.resetOriginalValues();

		return appointment;
	}

	/**
	 * Returns the appointment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appointment
	 * @return the appointment
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	@Override
	public Appointment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppointmentException {

		Appointment appointment = fetchByPrimaryKey(primaryKey);

		if (appointment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppointmentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appointment;
	}

	/**
	 * Returns the appointment with the primary key or throws a <code>NoSuchAppointmentException</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment
	 * @return the appointment
	 * @throws NoSuchAppointmentException if a appointment with the primary key could not be found
	 */
	@Override
	public Appointment findByPrimaryKey(long appointmentId)
		throws NoSuchAppointmentException {

		return findByPrimaryKey((Serializable)appointmentId);
	}

	/**
	 * Returns the appointment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment
	 * @return the appointment, or <code>null</code> if a appointment with the primary key could not be found
	 */
	@Override
	public Appointment fetchByPrimaryKey(long appointmentId) {
		return fetchByPrimaryKey((Serializable)appointmentId);
	}

	/**
	 * Returns all the appointments.
	 *
	 * @return the appointments
	 */
	@Override
	public List<Appointment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Appointment> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Appointment> findAll(
		int start, int end, OrderByComparator<Appointment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Appointment> findAll(
		int start, int end, OrderByComparator<Appointment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Appointment> list = null;

		if (useFinderCache) {
			list = (List<Appointment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPOINTMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPOINTMENT;

				sql = sql.concat(AppointmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Appointment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the appointments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Appointment appointment : findAll()) {
			remove(appointment);
		}
	}

	/**
	 * Returns the number of appointments.
	 *
	 * @return the number of appointments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPOINTMENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "appointmentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPOINTMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppointmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appointment persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new AppointmentModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Appointment.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByPetId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPetId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"petId"}, true);

		_finderPathWithoutPaginationFindByPetId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPetId",
			new String[] {Long.class.getName()}, new String[] {"petId"}, true);

		_finderPathCountByPetId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPetId",
			new String[] {Long.class.getName()}, new String[] {"petId"}, false);

		_finderPathWithPaginationFindByVetId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVetId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"vetId"}, true);

		_finderPathWithoutPaginationFindByVetId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVetId",
			new String[] {Long.class.getName()}, new String[] {"vetId"}, true);

		_finderPathCountByVetId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVetId",
			new String[] {Long.class.getName()}, new String[] {"vetId"}, false);

		AppointmentUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AppointmentUtil.setPersistence(null);

		entityCache.removeCache(AppointmentImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = PetClinicPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PetClinicPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PetClinicPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_APPOINTMENT =
		"SELECT appointment FROM Appointment appointment";

	private static final String _SQL_SELECT_APPOINTMENT_WHERE =
		"SELECT appointment FROM Appointment appointment WHERE ";

	private static final String _SQL_COUNT_APPOINTMENT =
		"SELECT COUNT(appointment) FROM Appointment appointment";

	private static final String _SQL_COUNT_APPOINTMENT_WHERE =
		"SELECT COUNT(appointment) FROM Appointment appointment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "appointment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Appointment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Appointment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppointmentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"date"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class AppointmentModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			AppointmentModelImpl appointmentModelImpl =
				(AppointmentModelImpl)baseModel;

			long columnBitmask = appointmentModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(appointmentModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						appointmentModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(appointmentModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AppointmentModelImpl appointmentModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = appointmentModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = appointmentModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;
import com.liferay.training.petclinic.exception.NoSuchAppointmentException;
import com.liferay.training.petclinic.model.Appointment;
import com.liferay.training.petclinic.service.AppointmentLocalServiceUtil;
import com.liferay.training.petclinic.service.persistence.AppointmentPersistence;
import com.liferay.training.petclinic.service.persistence.AppointmentUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AppointmentPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"com.liferay.training.petclinic.service"));

	@Before
	public void setUp() {
		_persistence = AppointmentUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Appointment> iterator = _appointments.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Appointment appointment = _persistence.create(pk);

		Assert.assertNotNull(appointment);

		Assert.assertEquals(appointment.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Appointment newAppointment = addAppointment();

		_persistence.remove(newAppointment);

		Appointment existingAppointment = _persistence.fetchByPrimaryKey(
			newAppointment.getPrimaryKey());

		Assert.assertNull(existingAppointment);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAppointment();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Appointment newAppointment = _persistence.create(pk);

		newAppointment.setPetId(RandomTestUtil.nextLong());

		newAppointment.setVetId(RandomTestUtil.nextLong());

		newAppointment.setDate(RandomTestUtil.nextDate());

		newAppointment.setDescription(RandomTestUtil.randomString());

		_appointments.add(_persistence.update(newAppointment));

		Appointment existingAppointment = _persistence.findByPrimaryKey(
			newAppointment.getPrimaryKey());

		Assert.assertEquals(
			existingAppointment.getAppointmentId(),
			newAppointment.getAppointmentId());
		Assert.assertEquals(
			existingAppointment.getPetId(), newAppointment.getPetId());
		Assert.assertEquals(
			existingAppointment.getVetId(), newAppointment.getVetId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAppointment.getDate()),
			Time.getShortTimestamp(newAppointment.getDate()));
		Assert.assertEquals(
			existingAppointment.getDescription(),
			newAppointment.getDescription());
	}

	@Test
	public void testCountByPetId() throws Exception {
		_persistence.countByPetId(RandomTestUtil.nextLong());

		_persistence.countByPetId(0L);
	}

	@Test
	public void testCountByVetId() throws Exception {
		_persistence.countByVetId(RandomTestUtil.nextLong());

		_persistence.countByVetId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Appointment newAppointment = addAppointment();

		Appointment existingAppointment = _persistence.findByPrimaryKey(
			newAppointment.getPrimaryKey());

		Assert.assertEquals(existingAppointment, newAppointment);
	}

	@Test(expected = NoSuchAppointmentException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Appointment> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"PetClinic_Appointment", "appointmentId", true, "petId", true,
			"vetId", true, "date", true, "description", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Appointment newAppointment = addAppointment();

		Appointment existingAppointment = _persistence.fetchByPrimaryKey(
			newAppointment.getPrimaryKey());

		Assert.assertEquals(existingAppointment, newAppointment);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Appointment missingAppointment = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAppointment);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Appointment newAppointment1 = addAppointment();
		Appointment newAppointment2 = addAppointment();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppointment1.getPrimaryKey());
		primaryKeys.add(newAppointment2.getPrimaryKey());

		Map<Serializable, Appointment> appointments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, appointments.size());
		Assert.assertEquals(
			newAppointment1, appointments.get(newAppointment1.getPrimaryKey()));
		Assert.assertEquals(
			newAppointment2, appointments.get(newAppointment2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Appointment> appointments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(appointments.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Appointment newAppointment = addAppointment();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppointment.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Appointment> appointments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, appointments.size());
		Assert.assertEquals(
			newAppointment, appointments.get(newAppointment.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Appointment> appointments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(appointments.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Appointment newAppointment = addAppointment();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAppointment.getPrimaryKey());

		Map<Serializable, Appointment> appointments =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, appointments.size());
		Assert.assertEquals(
			newAppointment, appointments.get(newAppointment.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AppointmentLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Appointment>() {

				@Override
				public void performAction(Appointment appointment) {
					Assert.assertNotNull(appointment);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Appointment newAppointment = addAppointment();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Appointment.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appointmentId", newAppointment.getAppointmentId()));

		List<Appointment> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Appointment existingAppointment = result.get(0);

		Assert.assertEquals(existingAppointment, newAppointment);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Appointment.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appointmentId", RandomTestUtil.nextLong()));

		List<Appointment> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Appointment newAppointment = addAppointment();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Appointment.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("appointmentId"));

		Object newAppointmentId = newAppointment.getAppointmentId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"appointmentId", new Object[] {newAppointmentId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAppointmentId = result.get(0);

		Assert.assertEquals(existingAppointmentId, newAppointmentId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Appointment.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("appointmentId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"appointmentId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Appointment addAppointment() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Appointment appointment = _persistence.create(pk);

		appointment.setPetId(RandomTestUtil.nextLong());

		appointment.setVetId(RandomTestUtil.nextLong());

		appointment.setDate(RandomTestUtil.nextDate());

		appointment.setDescription(RandomTestUtil.randomString());

		_appointments.add(_persistence.update(appointment));

		return appointment;
	}

	private List<Appointment> _appointments = new ArrayList<Appointment>();
	private AppointmentPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
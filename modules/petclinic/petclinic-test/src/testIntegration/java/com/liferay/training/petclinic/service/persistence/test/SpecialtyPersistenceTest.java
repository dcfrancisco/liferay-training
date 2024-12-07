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
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;
import com.liferay.training.petclinic.exception.NoSuchSpecialtyException;
import com.liferay.training.petclinic.model.Specialty;
import com.liferay.training.petclinic.service.SpecialtyLocalServiceUtil;
import com.liferay.training.petclinic.service.persistence.SpecialtyPersistence;
import com.liferay.training.petclinic.service.persistence.SpecialtyUtil;

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
public class SpecialtyPersistenceTest {

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
		_persistence = SpecialtyUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Specialty> iterator = _specialties.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Specialty specialty = _persistence.create(pk);

		Assert.assertNotNull(specialty);

		Assert.assertEquals(specialty.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Specialty newSpecialty = addSpecialty();

		_persistence.remove(newSpecialty);

		Specialty existingSpecialty = _persistence.fetchByPrimaryKey(
			newSpecialty.getPrimaryKey());

		Assert.assertNull(existingSpecialty);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSpecialty();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Specialty newSpecialty = _persistence.create(pk);

		newSpecialty.setName(RandomTestUtil.randomString());

		_specialties.add(_persistence.update(newSpecialty));

		Specialty existingSpecialty = _persistence.findByPrimaryKey(
			newSpecialty.getPrimaryKey());

		Assert.assertEquals(
			existingSpecialty.getSpecialtyId(), newSpecialty.getSpecialtyId());
		Assert.assertEquals(
			existingSpecialty.getName(), newSpecialty.getName());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Specialty newSpecialty = addSpecialty();

		Specialty existingSpecialty = _persistence.findByPrimaryKey(
			newSpecialty.getPrimaryKey());

		Assert.assertEquals(existingSpecialty, newSpecialty);
	}

	@Test(expected = NoSuchSpecialtyException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Specialty> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"PetClinic_Specialty", "specialtyId", true, "name", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Specialty newSpecialty = addSpecialty();

		Specialty existingSpecialty = _persistence.fetchByPrimaryKey(
			newSpecialty.getPrimaryKey());

		Assert.assertEquals(existingSpecialty, newSpecialty);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Specialty missingSpecialty = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSpecialty);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Specialty newSpecialty1 = addSpecialty();
		Specialty newSpecialty2 = addSpecialty();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSpecialty1.getPrimaryKey());
		primaryKeys.add(newSpecialty2.getPrimaryKey());

		Map<Serializable, Specialty> specialties =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, specialties.size());
		Assert.assertEquals(
			newSpecialty1, specialties.get(newSpecialty1.getPrimaryKey()));
		Assert.assertEquals(
			newSpecialty2, specialties.get(newSpecialty2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Specialty> specialties =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(specialties.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Specialty newSpecialty = addSpecialty();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSpecialty.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Specialty> specialties =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, specialties.size());
		Assert.assertEquals(
			newSpecialty, specialties.get(newSpecialty.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Specialty> specialties =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(specialties.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Specialty newSpecialty = addSpecialty();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSpecialty.getPrimaryKey());

		Map<Serializable, Specialty> specialties =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, specialties.size());
		Assert.assertEquals(
			newSpecialty, specialties.get(newSpecialty.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SpecialtyLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Specialty>() {

				@Override
				public void performAction(Specialty specialty) {
					Assert.assertNotNull(specialty);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Specialty newSpecialty = addSpecialty();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Specialty.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"specialtyId", newSpecialty.getSpecialtyId()));

		List<Specialty> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Specialty existingSpecialty = result.get(0);

		Assert.assertEquals(existingSpecialty, newSpecialty);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Specialty.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"specialtyId", RandomTestUtil.nextLong()));

		List<Specialty> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Specialty newSpecialty = addSpecialty();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Specialty.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("specialtyId"));

		Object newSpecialtyId = newSpecialty.getSpecialtyId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"specialtyId", new Object[] {newSpecialtyId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSpecialtyId = result.get(0);

		Assert.assertEquals(existingSpecialtyId, newSpecialtyId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Specialty.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("specialtyId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"specialtyId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Specialty addSpecialty() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Specialty specialty = _persistence.create(pk);

		specialty.setName(RandomTestUtil.randomString());

		_specialties.add(_persistence.update(specialty));

		return specialty;
	}

	private List<Specialty> _specialties = new ArrayList<Specialty>();
	private SpecialtyPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
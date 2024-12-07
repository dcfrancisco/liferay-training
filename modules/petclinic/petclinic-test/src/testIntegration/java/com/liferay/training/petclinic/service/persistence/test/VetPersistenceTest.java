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
import com.liferay.training.petclinic.exception.NoSuchVetException;
import com.liferay.training.petclinic.model.Vet;
import com.liferay.training.petclinic.service.VetLocalServiceUtil;
import com.liferay.training.petclinic.service.persistence.VetPersistence;
import com.liferay.training.petclinic.service.persistence.VetUtil;

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
public class VetPersistenceTest {

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
		_persistence = VetUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Vet> iterator = _vets.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Vet vet = _persistence.create(pk);

		Assert.assertNotNull(vet);

		Assert.assertEquals(vet.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Vet newVet = addVet();

		_persistence.remove(newVet);

		Vet existingVet = _persistence.fetchByPrimaryKey(
			newVet.getPrimaryKey());

		Assert.assertNull(existingVet);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addVet();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Vet newVet = _persistence.create(pk);

		newVet.setFirstName(RandomTestUtil.randomString());

		newVet.setLastName(RandomTestUtil.randomString());

		newVet.setSpecialties(RandomTestUtil.randomString());

		_vets.add(_persistence.update(newVet));

		Vet existingVet = _persistence.findByPrimaryKey(newVet.getPrimaryKey());

		Assert.assertEquals(existingVet.getVetId(), newVet.getVetId());
		Assert.assertEquals(existingVet.getFirstName(), newVet.getFirstName());
		Assert.assertEquals(existingVet.getLastName(), newVet.getLastName());
		Assert.assertEquals(
			existingVet.getSpecialties(), newVet.getSpecialties());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Vet newVet = addVet();

		Vet existingVet = _persistence.findByPrimaryKey(newVet.getPrimaryKey());

		Assert.assertEquals(existingVet, newVet);
	}

	@Test(expected = NoSuchVetException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Vet> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"PetClinic_Vet", "vetId", true, "firstName", true, "lastName", true,
			"specialties", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Vet newVet = addVet();

		Vet existingVet = _persistence.fetchByPrimaryKey(
			newVet.getPrimaryKey());

		Assert.assertEquals(existingVet, newVet);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Vet missingVet = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingVet);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Vet newVet1 = addVet();
		Vet newVet2 = addVet();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVet1.getPrimaryKey());
		primaryKeys.add(newVet2.getPrimaryKey());

		Map<Serializable, Vet> vets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, vets.size());
		Assert.assertEquals(newVet1, vets.get(newVet1.getPrimaryKey()));
		Assert.assertEquals(newVet2, vets.get(newVet2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Vet> vets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(vets.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Vet newVet = addVet();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVet.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Vet> vets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, vets.size());
		Assert.assertEquals(newVet, vets.get(newVet.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Vet> vets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(vets.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Vet newVet = addVet();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVet.getPrimaryKey());

		Map<Serializable, Vet> vets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, vets.size());
		Assert.assertEquals(newVet, vets.get(newVet.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			VetLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Vet>() {

				@Override
				public void performAction(Vet vet) {
					Assert.assertNotNull(vet);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Vet newVet = addVet();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Vet.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("vetId", newVet.getVetId()));

		List<Vet> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Vet existingVet = result.get(0);

		Assert.assertEquals(existingVet, newVet);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Vet.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("vetId", RandomTestUtil.nextLong()));

		List<Vet> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Vet newVet = addVet();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Vet.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("vetId"));

		Object newVetId = newVet.getVetId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("vetId", new Object[] {newVetId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingVetId = result.get(0);

		Assert.assertEquals(existingVetId, newVetId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Vet.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("vetId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"vetId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Vet addVet() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Vet vet = _persistence.create(pk);

		vet.setFirstName(RandomTestUtil.randomString());

		vet.setLastName(RandomTestUtil.randomString());

		vet.setSpecialties(RandomTestUtil.randomString());

		_vets.add(_persistence.update(vet));

		return vet;
	}

	private List<Vet> _vets = new ArrayList<Vet>();
	private VetPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
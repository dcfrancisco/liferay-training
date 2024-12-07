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
import com.liferay.training.petclinic.exception.NoSuchPetException;
import com.liferay.training.petclinic.model.Pet;
import com.liferay.training.petclinic.service.PetLocalServiceUtil;
import com.liferay.training.petclinic.service.persistence.PetPersistence;
import com.liferay.training.petclinic.service.persistence.PetUtil;

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
public class PetPersistenceTest {

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
		_persistence = PetUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Pet> iterator = _pets.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Pet pet = _persistence.create(pk);

		Assert.assertNotNull(pet);

		Assert.assertEquals(pet.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Pet newPet = addPet();

		_persistence.remove(newPet);

		Pet existingPet = _persistence.fetchByPrimaryKey(
			newPet.getPrimaryKey());

		Assert.assertNull(existingPet);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPet();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Pet newPet = _persistence.create(pk);

		newPet.setOwnerId(RandomTestUtil.nextLong());

		newPet.setName(RandomTestUtil.randomString());

		newPet.setBirthDate(RandomTestUtil.nextDate());

		newPet.setType(RandomTestUtil.randomString());

		_pets.add(_persistence.update(newPet));

		Pet existingPet = _persistence.findByPrimaryKey(newPet.getPrimaryKey());

		Assert.assertEquals(existingPet.getPetId(), newPet.getPetId());
		Assert.assertEquals(existingPet.getOwnerId(), newPet.getOwnerId());
		Assert.assertEquals(existingPet.getName(), newPet.getName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPet.getBirthDate()),
			Time.getShortTimestamp(newPet.getBirthDate()));
		Assert.assertEquals(existingPet.getType(), newPet.getType());
	}

	@Test
	public void testCountByOwnerId() throws Exception {
		_persistence.countByOwnerId(RandomTestUtil.nextLong());

		_persistence.countByOwnerId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Pet newPet = addPet();

		Pet existingPet = _persistence.findByPrimaryKey(newPet.getPrimaryKey());

		Assert.assertEquals(existingPet, newPet);
	}

	@Test(expected = NoSuchPetException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Pet> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"PetClinic_Pet", "petId", true, "ownerId", true, "name", true,
			"birthDate", true, "type", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Pet newPet = addPet();

		Pet existingPet = _persistence.fetchByPrimaryKey(
			newPet.getPrimaryKey());

		Assert.assertEquals(existingPet, newPet);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Pet missingPet = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPet);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Pet newPet1 = addPet();
		Pet newPet2 = addPet();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPet1.getPrimaryKey());
		primaryKeys.add(newPet2.getPrimaryKey());

		Map<Serializable, Pet> pets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, pets.size());
		Assert.assertEquals(newPet1, pets.get(newPet1.getPrimaryKey()));
		Assert.assertEquals(newPet2, pets.get(newPet2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Pet> pets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(pets.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Pet newPet = addPet();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPet.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Pet> pets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, pets.size());
		Assert.assertEquals(newPet, pets.get(newPet.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Pet> pets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(pets.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Pet newPet = addPet();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPet.getPrimaryKey());

		Map<Serializable, Pet> pets = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, pets.size());
		Assert.assertEquals(newPet, pets.get(newPet.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PetLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Pet>() {

				@Override
				public void performAction(Pet pet) {
					Assert.assertNotNull(pet);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Pet newPet = addPet();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Pet.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("petId", newPet.getPetId()));

		List<Pet> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Pet existingPet = result.get(0);

		Assert.assertEquals(existingPet, newPet);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Pet.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("petId", RandomTestUtil.nextLong()));

		List<Pet> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Pet newPet = addPet();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Pet.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("petId"));

		Object newPetId = newPet.getPetId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("petId", new Object[] {newPetId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPetId = result.get(0);

		Assert.assertEquals(existingPetId, newPetId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Pet.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("petId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"petId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Pet addPet() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Pet pet = _persistence.create(pk);

		pet.setOwnerId(RandomTestUtil.nextLong());

		pet.setName(RandomTestUtil.randomString());

		pet.setBirthDate(RandomTestUtil.nextDate());

		pet.setType(RandomTestUtil.randomString());

		_pets.add(_persistence.update(pet));

		return pet;
	}

	private List<Pet> _pets = new ArrayList<Pet>();
	private PetPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
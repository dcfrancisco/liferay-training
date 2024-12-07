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
import com.liferay.training.petclinic.exception.NoSuchOwnerException;
import com.liferay.training.petclinic.model.Owner;
import com.liferay.training.petclinic.service.OwnerLocalServiceUtil;
import com.liferay.training.petclinic.service.persistence.OwnerPersistence;
import com.liferay.training.petclinic.service.persistence.OwnerUtil;

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
public class OwnerPersistenceTest {

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
		_persistence = OwnerUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Owner> iterator = _owners.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Owner owner = _persistence.create(pk);

		Assert.assertNotNull(owner);

		Assert.assertEquals(owner.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Owner newOwner = addOwner();

		_persistence.remove(newOwner);

		Owner existingOwner = _persistence.fetchByPrimaryKey(
			newOwner.getPrimaryKey());

		Assert.assertNull(existingOwner);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addOwner();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Owner newOwner = _persistence.create(pk);

		newOwner.setFirstName(RandomTestUtil.randomString());

		newOwner.setLastName(RandomTestUtil.randomString());

		newOwner.setAddress(RandomTestUtil.randomString());

		newOwner.setCity(RandomTestUtil.randomString());

		newOwner.setTelephone(RandomTestUtil.randomString());

		_owners.add(_persistence.update(newOwner));

		Owner existingOwner = _persistence.findByPrimaryKey(
			newOwner.getPrimaryKey());

		Assert.assertEquals(existingOwner.getOwnerId(), newOwner.getOwnerId());
		Assert.assertEquals(
			existingOwner.getFirstName(), newOwner.getFirstName());
		Assert.assertEquals(
			existingOwner.getLastName(), newOwner.getLastName());
		Assert.assertEquals(existingOwner.getAddress(), newOwner.getAddress());
		Assert.assertEquals(existingOwner.getCity(), newOwner.getCity());
		Assert.assertEquals(
			existingOwner.getTelephone(), newOwner.getTelephone());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Owner newOwner = addOwner();

		Owner existingOwner = _persistence.findByPrimaryKey(
			newOwner.getPrimaryKey());

		Assert.assertEquals(existingOwner, newOwner);
	}

	@Test(expected = NoSuchOwnerException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Owner> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"PetClinic_Owner", "ownerId", true, "firstName", true, "lastName",
			true, "address", true, "city", true, "telephone", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Owner newOwner = addOwner();

		Owner existingOwner = _persistence.fetchByPrimaryKey(
			newOwner.getPrimaryKey());

		Assert.assertEquals(existingOwner, newOwner);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Owner missingOwner = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingOwner);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Owner newOwner1 = addOwner();
		Owner newOwner2 = addOwner();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOwner1.getPrimaryKey());
		primaryKeys.add(newOwner2.getPrimaryKey());

		Map<Serializable, Owner> owners = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, owners.size());
		Assert.assertEquals(newOwner1, owners.get(newOwner1.getPrimaryKey()));
		Assert.assertEquals(newOwner2, owners.get(newOwner2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Owner> owners = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(owners.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Owner newOwner = addOwner();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOwner.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Owner> owners = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, owners.size());
		Assert.assertEquals(newOwner, owners.get(newOwner.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Owner> owners = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(owners.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Owner newOwner = addOwner();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOwner.getPrimaryKey());

		Map<Serializable, Owner> owners = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, owners.size());
		Assert.assertEquals(newOwner, owners.get(newOwner.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			OwnerLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Owner>() {

				@Override
				public void performAction(Owner owner) {
					Assert.assertNotNull(owner);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Owner newOwner = addOwner();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Owner.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ownerId", newOwner.getOwnerId()));

		List<Owner> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Owner existingOwner = result.get(0);

		Assert.assertEquals(existingOwner, newOwner);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Owner.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ownerId", RandomTestUtil.nextLong()));

		List<Owner> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Owner newOwner = addOwner();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Owner.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ownerId"));

		Object newOwnerId = newOwner.getOwnerId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("ownerId", new Object[] {newOwnerId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingOwnerId = result.get(0);

		Assert.assertEquals(existingOwnerId, newOwnerId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Owner.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ownerId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ownerId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Owner addOwner() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Owner owner = _persistence.create(pk);

		owner.setFirstName(RandomTestUtil.randomString());

		owner.setLastName(RandomTestUtil.randomString());

		owner.setAddress(RandomTestUtil.randomString());

		owner.setCity(RandomTestUtil.randomString());

		owner.setTelephone(RandomTestUtil.randomString());

		_owners.add(_persistence.update(owner));

		return owner;
	}

	private List<Owner> _owners = new ArrayList<Owner>();
	private OwnerPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
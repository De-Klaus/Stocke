/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.petko.stocke.service.persistence.test;

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

import com.petko.stocke.exception.NoSuchStatusModelException;
import com.petko.stocke.model.StatusModel;
import com.petko.stocke.service.StatusModelLocalServiceUtil;
import com.petko.stocke.service.persistence.StatusModelPersistence;
import com.petko.stocke.service.persistence.StatusModelUtil;

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
public class StatusModelPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.petko.stocke.service"));

	@Before
	public void setUp() {
		_persistence = StatusModelUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<StatusModel> iterator = _statusModels.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatusModel statusModel = _persistence.create(pk);

		Assert.assertNotNull(statusModel);

		Assert.assertEquals(statusModel.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		StatusModel newStatusModel = addStatusModel();

		_persistence.remove(newStatusModel);

		StatusModel existingStatusModel = _persistence.fetchByPrimaryKey(
			newStatusModel.getPrimaryKey());

		Assert.assertNull(existingStatusModel);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addStatusModel();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatusModel newStatusModel = _persistence.create(pk);

		newStatusModel.setCaseModelId(RandomTestUtil.nextLong());

		newStatusModel.setStatus(RandomTestUtil.randomString());

		newStatusModel.setInternal(RandomTestUtil.randomBoolean());

		newStatusModel.setMessage(RandomTestUtil.randomString());

		newStatusModel.setNotification(RandomTestUtil.randomBoolean());

		newStatusModel.setNotificationCount(RandomTestUtil.nextLong());

		newStatusModel.setNotificationType(RandomTestUtil.randomBoolean());

		_statusModels.add(_persistence.update(newStatusModel));

		StatusModel existingStatusModel = _persistence.findByPrimaryKey(
			newStatusModel.getPrimaryKey());

		Assert.assertEquals(
			existingStatusModel.getId(), newStatusModel.getId());
		Assert.assertEquals(
			existingStatusModel.getCaseModelId(),
			newStatusModel.getCaseModelId());
		Assert.assertEquals(
			existingStatusModel.getStatus(), newStatusModel.getStatus());
		Assert.assertEquals(
			existingStatusModel.isInternal(), newStatusModel.isInternal());
		Assert.assertEquals(
			existingStatusModel.getMessage(), newStatusModel.getMessage());
		Assert.assertEquals(
			existingStatusModel.isNotification(),
			newStatusModel.isNotification());
		Assert.assertEquals(
			existingStatusModel.getNotificationCount(),
			newStatusModel.getNotificationCount());
		Assert.assertEquals(
			existingStatusModel.isNotificationType(),
			newStatusModel.isNotificationType());
	}

	@Test
	public void testCountBycaseModelId() throws Exception {
		_persistence.countBycaseModelId(RandomTestUtil.nextLong());

		_persistence.countBycaseModelId(0L);
	}

	@Test
	public void testCountBycaseModelIdInternal() throws Exception {
		_persistence.countBycaseModelIdInternal(
			RandomTestUtil.nextLong(), RandomTestUtil.randomBoolean());

		_persistence.countBycaseModelIdInternal(
			0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		StatusModel newStatusModel = addStatusModel();

		StatusModel existingStatusModel = _persistence.findByPrimaryKey(
			newStatusModel.getPrimaryKey());

		Assert.assertEquals(existingStatusModel, newStatusModel);
	}

	@Test(expected = NoSuchStatusModelException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<StatusModel> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"stocke_StatusModel", "id", true, "CaseModelId", true, "Status",
			true, "Internal", true, "Message", true, "Notification", true,
			"NotificationCount", true, "NotificationType", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		StatusModel newStatusModel = addStatusModel();

		StatusModel existingStatusModel = _persistence.fetchByPrimaryKey(
			newStatusModel.getPrimaryKey());

		Assert.assertEquals(existingStatusModel, newStatusModel);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatusModel missingStatusModel = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingStatusModel);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		StatusModel newStatusModel1 = addStatusModel();
		StatusModel newStatusModel2 = addStatusModel();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStatusModel1.getPrimaryKey());
		primaryKeys.add(newStatusModel2.getPrimaryKey());

		Map<Serializable, StatusModel> statusModels =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, statusModels.size());
		Assert.assertEquals(
			newStatusModel1, statusModels.get(newStatusModel1.getPrimaryKey()));
		Assert.assertEquals(
			newStatusModel2, statusModels.get(newStatusModel2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, StatusModel> statusModels =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(statusModels.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		StatusModel newStatusModel = addStatusModel();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStatusModel.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, StatusModel> statusModels =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, statusModels.size());
		Assert.assertEquals(
			newStatusModel, statusModels.get(newStatusModel.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, StatusModel> statusModels =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(statusModels.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		StatusModel newStatusModel = addStatusModel();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStatusModel.getPrimaryKey());

		Map<Serializable, StatusModel> statusModels =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, statusModels.size());
		Assert.assertEquals(
			newStatusModel, statusModels.get(newStatusModel.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			StatusModelLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<StatusModel>() {

				@Override
				public void performAction(StatusModel statusModel) {
					Assert.assertNotNull(statusModel);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		StatusModel newStatusModel = addStatusModel();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatusModel.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newStatusModel.getId()));

		List<StatusModel> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		StatusModel existingStatusModel = result.get(0);

		Assert.assertEquals(existingStatusModel, newStatusModel);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatusModel.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<StatusModel> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		StatusModel newStatusModel = addStatusModel();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatusModel.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newStatusModel.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatusModel.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected StatusModel addStatusModel() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatusModel statusModel = _persistence.create(pk);

		statusModel.setCaseModelId(RandomTestUtil.nextLong());

		statusModel.setStatus(RandomTestUtil.randomString());

		statusModel.setInternal(RandomTestUtil.randomBoolean());

		statusModel.setMessage(RandomTestUtil.randomString());

		statusModel.setNotification(RandomTestUtil.randomBoolean());

		statusModel.setNotificationCount(RandomTestUtil.nextLong());

		statusModel.setNotificationType(RandomTestUtil.randomBoolean());

		_statusModels.add(_persistence.update(statusModel));

		return statusModel;
	}

	private List<StatusModel> _statusModels = new ArrayList<StatusModel>();
	private StatusModelPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
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

import com.petko.stocke.exception.NoSuchStatusCaseException;
import com.petko.stocke.model.StatusCase;
import com.petko.stocke.service.StatusCaseLocalServiceUtil;
import com.petko.stocke.service.persistence.StatusCasePersistence;
import com.petko.stocke.service.persistence.StatusCaseUtil;

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
public class StatusCasePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.petko.stocke.service"));

	@Before
	public void setUp() {
		_persistence = StatusCaseUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<StatusCase> iterator = _statusCases.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatusCase statusCase = _persistence.create(pk);

		Assert.assertNotNull(statusCase);

		Assert.assertEquals(statusCase.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		StatusCase newStatusCase = addStatusCase();

		_persistence.remove(newStatusCase);

		StatusCase existingStatusCase = _persistence.fetchByPrimaryKey(
			newStatusCase.getPrimaryKey());

		Assert.assertNull(existingStatusCase);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addStatusCase();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatusCase newStatusCase = _persistence.create(pk);

		newStatusCase.setCaseModelId(RandomTestUtil.nextLong());

		newStatusCase.setStatus(RandomTestUtil.randomString());

		newStatusCase.setInternal(RandomTestUtil.randomBoolean());

		newStatusCase.setMessage(RandomTestUtil.randomString());

		newStatusCase.setNotification(RandomTestUtil.randomBoolean());

		newStatusCase.setNotificationCount(RandomTestUtil.nextLong());

		newStatusCase.setNotificationType(RandomTestUtil.randomBoolean());

		_statusCases.add(_persistence.update(newStatusCase));

		StatusCase existingStatusCase = _persistence.findByPrimaryKey(
			newStatusCase.getPrimaryKey());

		Assert.assertEquals(existingStatusCase.getId(), newStatusCase.getId());
		Assert.assertEquals(
			existingStatusCase.getCaseModelId(),
			newStatusCase.getCaseModelId());
		Assert.assertEquals(
			existingStatusCase.getStatus(), newStatusCase.getStatus());
		Assert.assertEquals(
			existingStatusCase.isInternal(), newStatusCase.isInternal());
		Assert.assertEquals(
			existingStatusCase.getMessage(), newStatusCase.getMessage());
		Assert.assertEquals(
			existingStatusCase.isNotification(),
			newStatusCase.isNotification());
		Assert.assertEquals(
			existingStatusCase.getNotificationCount(),
			newStatusCase.getNotificationCount());
		Assert.assertEquals(
			existingStatusCase.isNotificationType(),
			newStatusCase.isNotificationType());
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
		StatusCase newStatusCase = addStatusCase();

		StatusCase existingStatusCase = _persistence.findByPrimaryKey(
			newStatusCase.getPrimaryKey());

		Assert.assertEquals(existingStatusCase, newStatusCase);
	}

	@Test(expected = NoSuchStatusCaseException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<StatusCase> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"stocke_StatusCase", "id", true, "CaseModelId", true, "Status",
			true, "Internal", true, "Message", true, "Notification", true,
			"NotificationCount", true, "NotificationType", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		StatusCase newStatusCase = addStatusCase();

		StatusCase existingStatusCase = _persistence.fetchByPrimaryKey(
			newStatusCase.getPrimaryKey());

		Assert.assertEquals(existingStatusCase, newStatusCase);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatusCase missingStatusCase = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingStatusCase);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		StatusCase newStatusCase1 = addStatusCase();
		StatusCase newStatusCase2 = addStatusCase();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStatusCase1.getPrimaryKey());
		primaryKeys.add(newStatusCase2.getPrimaryKey());

		Map<Serializable, StatusCase> statusCases =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, statusCases.size());
		Assert.assertEquals(
			newStatusCase1, statusCases.get(newStatusCase1.getPrimaryKey()));
		Assert.assertEquals(
			newStatusCase2, statusCases.get(newStatusCase2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, StatusCase> statusCases =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(statusCases.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		StatusCase newStatusCase = addStatusCase();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStatusCase.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, StatusCase> statusCases =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, statusCases.size());
		Assert.assertEquals(
			newStatusCase, statusCases.get(newStatusCase.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, StatusCase> statusCases =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(statusCases.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		StatusCase newStatusCase = addStatusCase();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newStatusCase.getPrimaryKey());

		Map<Serializable, StatusCase> statusCases =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, statusCases.size());
		Assert.assertEquals(
			newStatusCase, statusCases.get(newStatusCase.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			StatusCaseLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<StatusCase>() {

				@Override
				public void performAction(StatusCase statusCase) {
					Assert.assertNotNull(statusCase);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		StatusCase newStatusCase = addStatusCase();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatusCase.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newStatusCase.getId()));

		List<StatusCase> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		StatusCase existingStatusCase = result.get(0);

		Assert.assertEquals(existingStatusCase, newStatusCase);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatusCase.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<StatusCase> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		StatusCase newStatusCase = addStatusCase();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			StatusCase.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newStatusCase.getId();

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
			StatusCase.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected StatusCase addStatusCase() throws Exception {
		long pk = RandomTestUtil.nextLong();

		StatusCase statusCase = _persistence.create(pk);

		statusCase.setCaseModelId(RandomTestUtil.nextLong());

		statusCase.setStatus(RandomTestUtil.randomString());

		statusCase.setInternal(RandomTestUtil.randomBoolean());

		statusCase.setMessage(RandomTestUtil.randomString());

		statusCase.setNotification(RandomTestUtil.randomBoolean());

		statusCase.setNotificationCount(RandomTestUtil.nextLong());

		statusCase.setNotificationType(RandomTestUtil.randomBoolean());

		_statusCases.add(_persistence.update(statusCase));

		return statusCase;
	}

	private List<StatusCase> _statusCases = new ArrayList<StatusCase>();
	private StatusCasePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
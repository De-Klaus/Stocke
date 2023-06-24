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
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.petko.stocke.exception.NoSuchCaseApplicationException;
import com.petko.stocke.model.CaseApplication;
import com.petko.stocke.service.CaseApplicationLocalServiceUtil;
import com.petko.stocke.service.persistence.CaseApplicationPersistence;
import com.petko.stocke.service.persistence.CaseApplicationUtil;

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
public class CaseApplicationPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.petko.stocke.service"));

	@Before
	public void setUp() {
		_persistence = CaseApplicationUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CaseApplication> iterator = _caseApplications.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CaseApplication caseApplication = _persistence.create(pk);

		Assert.assertNotNull(caseApplication);

		Assert.assertEquals(caseApplication.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CaseApplication newCaseApplication = addCaseApplication();

		_persistence.remove(newCaseApplication);

		CaseApplication existingCaseApplication =
			_persistence.fetchByPrimaryKey(newCaseApplication.getPrimaryKey());

		Assert.assertNull(existingCaseApplication);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCaseApplication();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CaseApplication newCaseApplication = _persistence.create(pk);

		newCaseApplication.setAdditionalFields(RandomTestUtil.randomString());

		newCaseApplication.setStatus(RandomTestUtil.randomString());

		newCaseApplication.setCaseModelId();

		newCaseApplication.setOwnerId(RandomTestUtil.nextLong());

		newCaseApplication.setActive(RandomTestUtil.randomBoolean());

		newCaseApplication.setArchive(RandomTestUtil.randomBoolean());

		newCaseApplication.setHidden(RandomTestUtil.randomBoolean());

		newCaseApplication.setType(RandomTestUtil.nextLong());

		newCaseApplication.setStartDate(RandomTestUtil.nextDate());

		newCaseApplication.setEndDate(RandomTestUtil.nextDate());

		_caseApplications.add(_persistence.update(newCaseApplication));

		CaseApplication existingCaseApplication = _persistence.findByPrimaryKey(
			newCaseApplication.getPrimaryKey());

		Assert.assertEquals(
			existingCaseApplication.getId(), newCaseApplication.getId());
		Assert.assertEquals(
			existingCaseApplication.getAdditionalFields(),
			newCaseApplication.getAdditionalFields());
		Assert.assertEquals(
			existingCaseApplication.getStatus(),
			newCaseApplication.getStatus());
		Assert.assertEquals(
			existingCaseApplication.getCaseModelId(),
			newCaseApplication.getCaseModelId());
		Assert.assertEquals(
			existingCaseApplication.getOwnerId(),
			newCaseApplication.getOwnerId());
		Assert.assertEquals(
			existingCaseApplication.isActive(), newCaseApplication.isActive());
		Assert.assertEquals(
			existingCaseApplication.isArchive(),
			newCaseApplication.isArchive());
		Assert.assertEquals(
			existingCaseApplication.isHidden(), newCaseApplication.isHidden());
		Assert.assertEquals(
			existingCaseApplication.getType(), newCaseApplication.getType());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCaseApplication.getStartDate()),
			Time.getShortTimestamp(newCaseApplication.getStartDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCaseApplication.getEndDate()),
			Time.getShortTimestamp(newCaseApplication.getEndDate()));
	}

	@Test
	public void testCountBybyCaseModelId() throws Exception {
		_persistence.countBybyCaseModelId((Long)null);

		_persistence.countBybyCaseModelId((Long)null);
	}

	@Test
	public void testCountByActive() throws Exception {
		_persistence.countByActive(RandomTestUtil.randomBoolean(), (Long)null);

		_persistence.countByActive(RandomTestUtil.randomBoolean(), (Long)null);
	}

	@Test
	public void testCountByArchive() throws Exception {
		_persistence.countByArchive(RandomTestUtil.randomBoolean(), (Long)null);

		_persistence.countByArchive(RandomTestUtil.randomBoolean(), (Long)null);
	}

	@Test
	public void testCountByHidden() throws Exception {
		_persistence.countByHidden(RandomTestUtil.randomBoolean(), (Long)null);

		_persistence.countByHidden(RandomTestUtil.randomBoolean(), (Long)null);
	}

	@Test
	public void testCountByStatusCase() throws Exception {
		_persistence.countByStatusCase((Long)null, "");

		_persistence.countByStatusCase((Long)null, "null");

		_persistence.countByStatusCase((Long)null, (String)null);
	}

	@Test
	public void testCountByStartDate() throws Exception {
		_persistence.countByStartDate((Long)null, RandomTestUtil.nextDate());

		_persistence.countByStartDate((Long)null, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByEndDate() throws Exception {
		_persistence.countByEndDate((Long)null, RandomTestUtil.nextDate());

		_persistence.countByEndDate((Long)null, RandomTestUtil.nextDate());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CaseApplication newCaseApplication = addCaseApplication();

		CaseApplication existingCaseApplication = _persistence.findByPrimaryKey(
			newCaseApplication.getPrimaryKey());

		Assert.assertEquals(existingCaseApplication, newCaseApplication);
	}

	@Test(expected = NoSuchCaseApplicationException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CaseApplication> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"stocke_CaseApplication", "id", true, "AdditionalFields", true,
			"Status", true, "CaseModelId", true, "OwnerId", true, "Active",
			true, "Archive", true, "Hidden", true, "Type", true, "StartDate",
			true, "EndDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CaseApplication newCaseApplication = addCaseApplication();

		CaseApplication existingCaseApplication =
			_persistence.fetchByPrimaryKey(newCaseApplication.getPrimaryKey());

		Assert.assertEquals(existingCaseApplication, newCaseApplication);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CaseApplication missingCaseApplication = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingCaseApplication);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CaseApplication newCaseApplication1 = addCaseApplication();
		CaseApplication newCaseApplication2 = addCaseApplication();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCaseApplication1.getPrimaryKey());
		primaryKeys.add(newCaseApplication2.getPrimaryKey());

		Map<Serializable, CaseApplication> caseApplications =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, caseApplications.size());
		Assert.assertEquals(
			newCaseApplication1,
			caseApplications.get(newCaseApplication1.getPrimaryKey()));
		Assert.assertEquals(
			newCaseApplication2,
			caseApplications.get(newCaseApplication2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CaseApplication> caseApplications =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(caseApplications.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CaseApplication newCaseApplication = addCaseApplication();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCaseApplication.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CaseApplication> caseApplications =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, caseApplications.size());
		Assert.assertEquals(
			newCaseApplication,
			caseApplications.get(newCaseApplication.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CaseApplication> caseApplications =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(caseApplications.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CaseApplication newCaseApplication = addCaseApplication();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCaseApplication.getPrimaryKey());

		Map<Serializable, CaseApplication> caseApplications =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, caseApplications.size());
		Assert.assertEquals(
			newCaseApplication,
			caseApplications.get(newCaseApplication.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CaseApplicationLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CaseApplication>() {

				@Override
				public void performAction(CaseApplication caseApplication) {
					Assert.assertNotNull(caseApplication);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CaseApplication newCaseApplication = addCaseApplication();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CaseApplication.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newCaseApplication.getId()));

		List<CaseApplication> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CaseApplication existingCaseApplication = result.get(0);

		Assert.assertEquals(existingCaseApplication, newCaseApplication);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CaseApplication.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<CaseApplication> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CaseApplication newCaseApplication = addCaseApplication();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CaseApplication.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newCaseApplication.getId();

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
			CaseApplication.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected CaseApplication addCaseApplication() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CaseApplication caseApplication = _persistence.create(pk);

		caseApplication.setAdditionalFields(RandomTestUtil.randomString());

		caseApplication.setStatus(RandomTestUtil.randomString());

		caseApplication.setCaseModelId();

		caseApplication.setOwnerId(RandomTestUtil.nextLong());

		caseApplication.setActive(RandomTestUtil.randomBoolean());

		caseApplication.setArchive(RandomTestUtil.randomBoolean());

		caseApplication.setHidden(RandomTestUtil.randomBoolean());

		caseApplication.setType(RandomTestUtil.nextLong());

		caseApplication.setStartDate(RandomTestUtil.nextDate());

		caseApplication.setEndDate(RandomTestUtil.nextDate());

		_caseApplications.add(_persistence.update(caseApplication));

		return caseApplication;
	}

	private List<CaseApplication> _caseApplications =
		new ArrayList<CaseApplication>();
	private CaseApplicationPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
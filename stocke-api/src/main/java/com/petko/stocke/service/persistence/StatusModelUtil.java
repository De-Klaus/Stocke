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

package com.petko.stocke.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.petko.stocke.model.StatusModel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the status model service. This utility wraps <code>com.petko.stocke.service.persistence.impl.StatusModelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author petko
 * @see StatusModelPersistence
 * @generated
 */
public class StatusModelUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(StatusModel statusModel) {
		getPersistence().clearCache(statusModel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, StatusModel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StatusModel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatusModel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatusModel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StatusModel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StatusModel update(StatusModel statusModel) {
		return getPersistence().update(statusModel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StatusModel update(
		StatusModel statusModel, ServiceContext serviceContext) {

		return getPersistence().update(statusModel, serviceContext);
	}

	/**
	 * Returns all the status models where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the matching status models
	 */
	public static List<StatusModel> findBycaseModelId(long CaseModelId) {
		return getPersistence().findBycaseModelId(CaseModelId);
	}

	/**
	 * Returns a range of all the status models where CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of status models
	 * @param end the upper bound of the range of status models (not inclusive)
	 * @return the range of matching status models
	 */
	public static List<StatusModel> findBycaseModelId(
		long CaseModelId, int start, int end) {

		return getPersistence().findBycaseModelId(CaseModelId, start, end);
	}

	/**
	 * Returns an ordered range of all the status models where CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of status models
	 * @param end the upper bound of the range of status models (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching status models
	 */
	public static List<StatusModel> findBycaseModelId(
		long CaseModelId, int start, int end,
		OrderByComparator<StatusModel> orderByComparator) {

		return getPersistence().findBycaseModelId(
			CaseModelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the status models where CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of status models
	 * @param end the upper bound of the range of status models (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching status models
	 */
	public static List<StatusModel> findBycaseModelId(
		long CaseModelId, int start, int end,
		OrderByComparator<StatusModel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycaseModelId(
			CaseModelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	public static StatusModel findBycaseModelId_First(
			long CaseModelId, OrderByComparator<StatusModel> orderByComparator)
		throws com.petko.stocke.exception.NoSuchStatusModelException {

		return getPersistence().findBycaseModelId_First(
			CaseModelId, orderByComparator);
	}

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model, or <code>null</code> if a matching status model could not be found
	 */
	public static StatusModel fetchBycaseModelId_First(
		long CaseModelId, OrderByComparator<StatusModel> orderByComparator) {

		return getPersistence().fetchBycaseModelId_First(
			CaseModelId, orderByComparator);
	}

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	public static StatusModel findBycaseModelId_Last(
			long CaseModelId, OrderByComparator<StatusModel> orderByComparator)
		throws com.petko.stocke.exception.NoSuchStatusModelException {

		return getPersistence().findBycaseModelId_Last(
			CaseModelId, orderByComparator);
	}

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model, or <code>null</code> if a matching status model could not be found
	 */
	public static StatusModel fetchBycaseModelId_Last(
		long CaseModelId, OrderByComparator<StatusModel> orderByComparator) {

		return getPersistence().fetchBycaseModelId_Last(
			CaseModelId, orderByComparator);
	}

	/**
	 * Returns the status models before and after the current status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current status model
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next status model
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	public static StatusModel[] findBycaseModelId_PrevAndNext(
			long id, long CaseModelId,
			OrderByComparator<StatusModel> orderByComparator)
		throws com.petko.stocke.exception.NoSuchStatusModelException {

		return getPersistence().findBycaseModelId_PrevAndNext(
			id, CaseModelId, orderByComparator);
	}

	/**
	 * Removes all the status models where CaseModelId = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 */
	public static void removeBycaseModelId(long CaseModelId) {
		getPersistence().removeBycaseModelId(CaseModelId);
	}

	/**
	 * Returns the number of status models where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the number of matching status models
	 */
	public static int countBycaseModelId(long CaseModelId) {
		return getPersistence().countBycaseModelId(CaseModelId);
	}

	/**
	 * Returns all the status models where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @return the matching status models
	 */
	public static List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal) {

		return getPersistence().findBycaseModelIdInternal(
			CaseModelId, Internal);
	}

	/**
	 * Returns a range of all the status models where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param start the lower bound of the range of status models
	 * @param end the upper bound of the range of status models (not inclusive)
	 * @return the range of matching status models
	 */
	public static List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal, int start, int end) {

		return getPersistence().findBycaseModelIdInternal(
			CaseModelId, Internal, start, end);
	}

	/**
	 * Returns an ordered range of all the status models where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param start the lower bound of the range of status models
	 * @param end the upper bound of the range of status models (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching status models
	 */
	public static List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal, int start, int end,
		OrderByComparator<StatusModel> orderByComparator) {

		return getPersistence().findBycaseModelIdInternal(
			CaseModelId, Internal, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the status models where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param start the lower bound of the range of status models
	 * @param end the upper bound of the range of status models (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching status models
	 */
	public static List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal, int start, int end,
		OrderByComparator<StatusModel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycaseModelIdInternal(
			CaseModelId, Internal, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	public static StatusModel findBycaseModelIdInternal_First(
			long CaseModelId, boolean Internal,
			OrderByComparator<StatusModel> orderByComparator)
		throws com.petko.stocke.exception.NoSuchStatusModelException {

		return getPersistence().findBycaseModelIdInternal_First(
			CaseModelId, Internal, orderByComparator);
	}

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model, or <code>null</code> if a matching status model could not be found
	 */
	public static StatusModel fetchBycaseModelIdInternal_First(
		long CaseModelId, boolean Internal,
		OrderByComparator<StatusModel> orderByComparator) {

		return getPersistence().fetchBycaseModelIdInternal_First(
			CaseModelId, Internal, orderByComparator);
	}

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	public static StatusModel findBycaseModelIdInternal_Last(
			long CaseModelId, boolean Internal,
			OrderByComparator<StatusModel> orderByComparator)
		throws com.petko.stocke.exception.NoSuchStatusModelException {

		return getPersistence().findBycaseModelIdInternal_Last(
			CaseModelId, Internal, orderByComparator);
	}

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model, or <code>null</code> if a matching status model could not be found
	 */
	public static StatusModel fetchBycaseModelIdInternal_Last(
		long CaseModelId, boolean Internal,
		OrderByComparator<StatusModel> orderByComparator) {

		return getPersistence().fetchBycaseModelIdInternal_Last(
			CaseModelId, Internal, orderByComparator);
	}

	/**
	 * Returns the status models before and after the current status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param id the primary key of the current status model
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next status model
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	public static StatusModel[] findBycaseModelIdInternal_PrevAndNext(
			long id, long CaseModelId, boolean Internal,
			OrderByComparator<StatusModel> orderByComparator)
		throws com.petko.stocke.exception.NoSuchStatusModelException {

		return getPersistence().findBycaseModelIdInternal_PrevAndNext(
			id, CaseModelId, Internal, orderByComparator);
	}

	/**
	 * Removes all the status models where CaseModelId = &#63; and Internal = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 */
	public static void removeBycaseModelIdInternal(
		long CaseModelId, boolean Internal) {

		getPersistence().removeBycaseModelIdInternal(CaseModelId, Internal);
	}

	/**
	 * Returns the number of status models where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @return the number of matching status models
	 */
	public static int countBycaseModelIdInternal(
		long CaseModelId, boolean Internal) {

		return getPersistence().countBycaseModelIdInternal(
			CaseModelId, Internal);
	}

	/**
	 * Caches the status model in the entity cache if it is enabled.
	 *
	 * @param statusModel the status model
	 */
	public static void cacheResult(StatusModel statusModel) {
		getPersistence().cacheResult(statusModel);
	}

	/**
	 * Caches the status models in the entity cache if it is enabled.
	 *
	 * @param statusModels the status models
	 */
	public static void cacheResult(List<StatusModel> statusModels) {
		getPersistence().cacheResult(statusModels);
	}

	/**
	 * Creates a new status model with the primary key. Does not add the status model to the database.
	 *
	 * @param id the primary key for the new status model
	 * @return the new status model
	 */
	public static StatusModel create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the status model with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the status model
	 * @return the status model that was removed
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	public static StatusModel remove(long id)
		throws com.petko.stocke.exception.NoSuchStatusModelException {

		return getPersistence().remove(id);
	}

	public static StatusModel updateImpl(StatusModel statusModel) {
		return getPersistence().updateImpl(statusModel);
	}

	/**
	 * Returns the status model with the primary key or throws a <code>NoSuchStatusModelException</code> if it could not be found.
	 *
	 * @param id the primary key of the status model
	 * @return the status model
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	public static StatusModel findByPrimaryKey(long id)
		throws com.petko.stocke.exception.NoSuchStatusModelException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the status model with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the status model
	 * @return the status model, or <code>null</code> if a status model with the primary key could not be found
	 */
	public static StatusModel fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the status models.
	 *
	 * @return the status models
	 */
	public static List<StatusModel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the status models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of status models
	 * @param end the upper bound of the range of status models (not inclusive)
	 * @return the range of status models
	 */
	public static List<StatusModel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the status models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of status models
	 * @param end the upper bound of the range of status models (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of status models
	 */
	public static List<StatusModel> findAll(
		int start, int end, OrderByComparator<StatusModel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the status models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of status models
	 * @param end the upper bound of the range of status models (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of status models
	 */
	public static List<StatusModel> findAll(
		int start, int end, OrderByComparator<StatusModel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the status models from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of status models.
	 *
	 * @return the number of status models
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StatusModelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StatusModelPersistence, StatusModelPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StatusModelPersistence.class);

		ServiceTracker<StatusModelPersistence, StatusModelPersistence>
			serviceTracker =
				new ServiceTracker
					<StatusModelPersistence, StatusModelPersistence>(
						bundle.getBundleContext(), StatusModelPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
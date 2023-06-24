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

import com.petko.stocke.model.CaseApplication;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the case application service. This utility wraps <code>com.petko.stocke.service.persistence.impl.CaseApplicationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author petko
 * @see CaseApplicationPersistence
 * @generated
 */
public class CaseApplicationUtil {

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
	public static void clearCache(CaseApplication caseApplication) {
		getPersistence().clearCache(caseApplication);
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
	public static Map<Serializable, CaseApplication> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CaseApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CaseApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CaseApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CaseApplication update(CaseApplication caseApplication) {
		return getPersistence().update(caseApplication);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CaseApplication update(
		CaseApplication caseApplication, ServiceContext serviceContext) {

		return getPersistence().update(caseApplication, serviceContext);
	}

	/**
	 * Returns all the case applications where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	public static List<CaseApplication> findBybyCaseModelId(Long CaseModelId) {
		return getPersistence().findBybyCaseModelId(CaseModelId);
	}

	/**
	 * Returns a range of all the case applications where CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	public static List<CaseApplication> findBybyCaseModelId(
		Long CaseModelId, int start, int end) {

		return getPersistence().findBybyCaseModelId(CaseModelId, start, end);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findBybyCaseModelId(
		Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().findBybyCaseModelId(
			CaseModelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findBybyCaseModelId(
		Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBybyCaseModelId(
			CaseModelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findBybyCaseModelId_First(
			Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findBybyCaseModelId_First(
			CaseModelId, orderByComparator);
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchBybyCaseModelId_First(
		Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchBybyCaseModelId_First(
			CaseModelId, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findBybyCaseModelId_Last(
			Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findBybyCaseModelId_Last(
			CaseModelId, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchBybyCaseModelId_Last(
		Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchBybyCaseModelId_Last(
			CaseModelId, orderByComparator);
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public static CaseApplication[] findBybyCaseModelId_PrevAndNext(
			long id, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findBybyCaseModelId_PrevAndNext(
			id, CaseModelId, orderByComparator);
	}

	/**
	 * Removes all the case applications where CaseModelId = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 */
	public static void removeBybyCaseModelId(Long CaseModelId) {
		getPersistence().removeBybyCaseModelId(CaseModelId);
	}

	/**
	 * Returns the number of case applications where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	public static int countBybyCaseModelId(Long CaseModelId) {
		return getPersistence().countBybyCaseModelId(CaseModelId);
	}

	/**
	 * Returns all the case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	public static List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId) {

		return getPersistence().findByActive(Active, CaseModelId);
	}

	/**
	 * Returns a range of all the case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	public static List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId, int start, int end) {

		return getPersistence().findByActive(Active, CaseModelId, start, end);
	}

	/**
	 * Returns an ordered range of all the case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().findByActive(
			Active, CaseModelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByActive(
			Active, CaseModelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByActive_First(
			boolean Active, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByActive_First(
			Active, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the first case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByActive_First(
		boolean Active, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByActive_First(
			Active, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByActive_Last(
			boolean Active, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByActive_Last(
			Active, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByActive_Last(
		boolean Active, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByActive_Last(
			Active, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public static CaseApplication[] findByActive_PrevAndNext(
			long id, boolean Active, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByActive_PrevAndNext(
			id, Active, CaseModelId, orderByComparator);
	}

	/**
	 * Removes all the case applications where Active = &#63; and CaseModelId = &#63; from the database.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 */
	public static void removeByActive(boolean Active, Long CaseModelId) {
		getPersistence().removeByActive(Active, CaseModelId);
	}

	/**
	 * Returns the number of case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	public static int countByActive(boolean Active, Long CaseModelId) {
		return getPersistence().countByActive(Active, CaseModelId);
	}

	/**
	 * Returns all the case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	public static List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId) {

		return getPersistence().findByArchive(Archive, CaseModelId);
	}

	/**
	 * Returns a range of all the case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	public static List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId, int start, int end) {

		return getPersistence().findByArchive(Archive, CaseModelId, start, end);
	}

	/**
	 * Returns an ordered range of all the case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().findByArchive(
			Archive, CaseModelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByArchive(
			Archive, CaseModelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByArchive_First(
			boolean Archive, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByArchive_First(
			Archive, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the first case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByArchive_First(
		boolean Archive, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByArchive_First(
			Archive, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByArchive_Last(
			boolean Archive, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByArchive_Last(
			Archive, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByArchive_Last(
		boolean Archive, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByArchive_Last(
			Archive, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public static CaseApplication[] findByArchive_PrevAndNext(
			long id, boolean Archive, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByArchive_PrevAndNext(
			id, Archive, CaseModelId, orderByComparator);
	}

	/**
	 * Removes all the case applications where Archive = &#63; and CaseModelId = &#63; from the database.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 */
	public static void removeByArchive(boolean Archive, Long CaseModelId) {
		getPersistence().removeByArchive(Archive, CaseModelId);
	}

	/**
	 * Returns the number of case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	public static int countByArchive(boolean Archive, Long CaseModelId) {
		return getPersistence().countByArchive(Archive, CaseModelId);
	}

	/**
	 * Returns all the case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	public static List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId) {

		return getPersistence().findByHidden(Hidden, CaseModelId);
	}

	/**
	 * Returns a range of all the case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	public static List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId, int start, int end) {

		return getPersistence().findByHidden(Hidden, CaseModelId, start, end);
	}

	/**
	 * Returns an ordered range of all the case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().findByHidden(
			Hidden, CaseModelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByHidden(
			Hidden, CaseModelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByHidden_First(
			boolean Hidden, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByHidden_First(
			Hidden, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the first case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByHidden_First(
		boolean Hidden, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByHidden_First(
			Hidden, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByHidden_Last(
			boolean Hidden, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByHidden_Last(
			Hidden, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByHidden_Last(
		boolean Hidden, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByHidden_Last(
			Hidden, CaseModelId, orderByComparator);
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public static CaseApplication[] findByHidden_PrevAndNext(
			long id, boolean Hidden, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByHidden_PrevAndNext(
			id, Hidden, CaseModelId, orderByComparator);
	}

	/**
	 * Removes all the case applications where Hidden = &#63; and CaseModelId = &#63; from the database.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 */
	public static void removeByHidden(boolean Hidden, Long CaseModelId) {
		getPersistence().removeByHidden(Hidden, CaseModelId);
	}

	/**
	 * Returns the number of case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	public static int countByHidden(boolean Hidden, Long CaseModelId) {
		return getPersistence().countByHidden(Hidden, CaseModelId);
	}

	/**
	 * Returns all the case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @return the matching case applications
	 */
	public static List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status) {

		return getPersistence().findByStatusCase(CaseModelId, Status);
	}

	/**
	 * Returns a range of all the case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	public static List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status, int start, int end) {

		return getPersistence().findByStatusCase(
			CaseModelId, Status, start, end);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().findByStatusCase(
			CaseModelId, Status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatusCase(
			CaseModelId, Status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByStatusCase_First(
			Long CaseModelId, String Status,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByStatusCase_First(
			CaseModelId, Status, orderByComparator);
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByStatusCase_First(
		Long CaseModelId, String Status,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByStatusCase_First(
			CaseModelId, Status, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByStatusCase_Last(
			Long CaseModelId, String Status,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByStatusCase_Last(
			CaseModelId, Status, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByStatusCase_Last(
		Long CaseModelId, String Status,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByStatusCase_Last(
			CaseModelId, Status, orderByComparator);
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public static CaseApplication[] findByStatusCase_PrevAndNext(
			long id, Long CaseModelId, String Status,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByStatusCase_PrevAndNext(
			id, CaseModelId, Status, orderByComparator);
	}

	/**
	 * Removes all the case applications where CaseModelId = &#63; and Status = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 */
	public static void removeByStatusCase(Long CaseModelId, String Status) {
		getPersistence().removeByStatusCase(CaseModelId, Status);
	}

	/**
	 * Returns the number of case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @return the number of matching case applications
	 */
	public static int countByStatusCase(Long CaseModelId, String Status) {
		return getPersistence().countByStatusCase(CaseModelId, Status);
	}

	/**
	 * Returns all the case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @return the matching case applications
	 */
	public static List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate) {

		return getPersistence().findByStartDate(CaseModelId, StartDate);
	}

	/**
	 * Returns a range of all the case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	public static List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate, int start, int end) {

		return getPersistence().findByStartDate(
			CaseModelId, StartDate, start, end);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().findByStartDate(
			CaseModelId, StartDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStartDate(
			CaseModelId, StartDate, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByStartDate_First(
			Long CaseModelId, Date StartDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByStartDate_First(
			CaseModelId, StartDate, orderByComparator);
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByStartDate_First(
		Long CaseModelId, Date StartDate,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByStartDate_First(
			CaseModelId, StartDate, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByStartDate_Last(
			Long CaseModelId, Date StartDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByStartDate_Last(
			CaseModelId, StartDate, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByStartDate_Last(
		Long CaseModelId, Date StartDate,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByStartDate_Last(
			CaseModelId, StartDate, orderByComparator);
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public static CaseApplication[] findByStartDate_PrevAndNext(
			long id, Long CaseModelId, Date StartDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByStartDate_PrevAndNext(
			id, CaseModelId, StartDate, orderByComparator);
	}

	/**
	 * Removes all the case applications where CaseModelId = &#63; and StartDate = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 */
	public static void removeByStartDate(Long CaseModelId, Date StartDate) {
		getPersistence().removeByStartDate(CaseModelId, StartDate);
	}

	/**
	 * Returns the number of case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @return the number of matching case applications
	 */
	public static int countByStartDate(Long CaseModelId, Date StartDate) {
		return getPersistence().countByStartDate(CaseModelId, StartDate);
	}

	/**
	 * Returns all the case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @return the matching case applications
	 */
	public static List<CaseApplication> findByEndDate(
		Long CaseModelId, Date EndDate) {

		return getPersistence().findByEndDate(CaseModelId, EndDate);
	}

	/**
	 * Returns a range of all the case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	public static List<CaseApplication> findByEndDate(
		Long CaseModelId, Date EndDate, int start, int end) {

		return getPersistence().findByEndDate(CaseModelId, EndDate, start, end);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByEndDate(
		Long CaseModelId, Date EndDate, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().findByEndDate(
			CaseModelId, EndDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	public static List<CaseApplication> findByEndDate(
		Long CaseModelId, Date EndDate, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEndDate(
			CaseModelId, EndDate, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByEndDate_First(
			Long CaseModelId, Date EndDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByEndDate_First(
			CaseModelId, EndDate, orderByComparator);
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByEndDate_First(
		Long CaseModelId, Date EndDate,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByEndDate_First(
			CaseModelId, EndDate, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public static CaseApplication findByEndDate_Last(
			Long CaseModelId, Date EndDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByEndDate_Last(
			CaseModelId, EndDate, orderByComparator);
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public static CaseApplication fetchByEndDate_Last(
		Long CaseModelId, Date EndDate,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().fetchByEndDate_Last(
			CaseModelId, EndDate, orderByComparator);
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public static CaseApplication[] findByEndDate_PrevAndNext(
			long id, Long CaseModelId, Date EndDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByEndDate_PrevAndNext(
			id, CaseModelId, EndDate, orderByComparator);
	}

	/**
	 * Removes all the case applications where CaseModelId = &#63; and EndDate = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 */
	public static void removeByEndDate(Long CaseModelId, Date EndDate) {
		getPersistence().removeByEndDate(CaseModelId, EndDate);
	}

	/**
	 * Returns the number of case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @return the number of matching case applications
	 */
	public static int countByEndDate(Long CaseModelId, Date EndDate) {
		return getPersistence().countByEndDate(CaseModelId, EndDate);
	}

	/**
	 * Caches the case application in the entity cache if it is enabled.
	 *
	 * @param caseApplication the case application
	 */
	public static void cacheResult(CaseApplication caseApplication) {
		getPersistence().cacheResult(caseApplication);
	}

	/**
	 * Caches the case applications in the entity cache if it is enabled.
	 *
	 * @param caseApplications the case applications
	 */
	public static void cacheResult(List<CaseApplication> caseApplications) {
		getPersistence().cacheResult(caseApplications);
	}

	/**
	 * Creates a new case application with the primary key. Does not add the case application to the database.
	 *
	 * @param id the primary key for the new case application
	 * @return the new case application
	 */
	public static CaseApplication create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the case application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the case application
	 * @return the case application that was removed
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public static CaseApplication remove(long id)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().remove(id);
	}

	public static CaseApplication updateImpl(CaseApplication caseApplication) {
		return getPersistence().updateImpl(caseApplication);
	}

	/**
	 * Returns the case application with the primary key or throws a <code>NoSuchCaseApplicationException</code> if it could not be found.
	 *
	 * @param id the primary key of the case application
	 * @return the case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public static CaseApplication findByPrimaryKey(long id)
		throws com.petko.stocke.exception.NoSuchCaseApplicationException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the case application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the case application
	 * @return the case application, or <code>null</code> if a case application with the primary key could not be found
	 */
	public static CaseApplication fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the case applications.
	 *
	 * @return the case applications
	 */
	public static List<CaseApplication> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the case applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of case applications
	 */
	public static List<CaseApplication> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the case applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of case applications
	 */
	public static List<CaseApplication> findAll(
		int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the case applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of case applications
	 */
	public static List<CaseApplication> findAll(
		int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the case applications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of case applications.
	 *
	 * @return the number of case applications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CaseApplicationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CaseApplicationPersistence, CaseApplicationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CaseApplicationPersistence.class);

		ServiceTracker<CaseApplicationPersistence, CaseApplicationPersistence>
			serviceTracker =
				new ServiceTracker
					<CaseApplicationPersistence, CaseApplicationPersistence>(
						bundle.getBundleContext(),
						CaseApplicationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
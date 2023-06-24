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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.petko.stocke.exception.NoSuchCaseApplicationException;
import com.petko.stocke.model.CaseApplication;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the case application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author petko
 * @see CaseApplicationUtil
 * @generated
 */
@ProviderType
public interface CaseApplicationPersistence
	extends BasePersistence<CaseApplication> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CaseApplicationUtil} to access the case application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the case applications where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	public java.util.List<CaseApplication> findBybyCaseModelId(
		Long CaseModelId);

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
	public java.util.List<CaseApplication> findBybyCaseModelId(
		Long CaseModelId, int start, int end);

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
	public java.util.List<CaseApplication> findBybyCaseModelId(
		Long CaseModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public java.util.List<CaseApplication> findBybyCaseModelId(
		Long CaseModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findBybyCaseModelId_First(
			Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchBybyCaseModelId_First(
		Long CaseModelId,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findBybyCaseModelId_Last(
			Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchBybyCaseModelId_Last(
		Long CaseModelId,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

	/**
	 * Returns the case applications before and after the current case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public CaseApplication[] findBybyCaseModelId_PrevAndNext(
			long id, Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Removes all the case applications where CaseModelId = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 */
	public void removeBybyCaseModelId(Long CaseModelId);

	/**
	 * Returns the number of case applications where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	public int countBybyCaseModelId(Long CaseModelId);

	/**
	 * Returns all the case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	public java.util.List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId);

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
	public java.util.List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId, int start, int end);

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
	public java.util.List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public java.util.List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByActive_First(
			boolean Active, Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the first case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByActive_First(
		boolean Active, Long CaseModelId,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

	/**
	 * Returns the last case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByActive_Last(
			boolean Active, Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the last case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByActive_Last(
		boolean Active, Long CaseModelId,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public CaseApplication[] findByActive_PrevAndNext(
			long id, boolean Active, Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Removes all the case applications where Active = &#63; and CaseModelId = &#63; from the database.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 */
	public void removeByActive(boolean Active, Long CaseModelId);

	/**
	 * Returns the number of case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	public int countByActive(boolean Active, Long CaseModelId);

	/**
	 * Returns all the case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	public java.util.List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId);

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
	public java.util.List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId, int start, int end);

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
	public java.util.List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public java.util.List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByArchive_First(
			boolean Archive, Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the first case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByArchive_First(
		boolean Archive, Long CaseModelId,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

	/**
	 * Returns the last case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByArchive_Last(
			boolean Archive, Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the last case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByArchive_Last(
		boolean Archive, Long CaseModelId,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public CaseApplication[] findByArchive_PrevAndNext(
			long id, boolean Archive, Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Removes all the case applications where Archive = &#63; and CaseModelId = &#63; from the database.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 */
	public void removeByArchive(boolean Archive, Long CaseModelId);

	/**
	 * Returns the number of case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	public int countByArchive(boolean Archive, Long CaseModelId);

	/**
	 * Returns all the case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	public java.util.List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId);

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
	public java.util.List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId, int start, int end);

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
	public java.util.List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public java.util.List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByHidden_First(
			boolean Hidden, Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the first case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByHidden_First(
		boolean Hidden, Long CaseModelId,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

	/**
	 * Returns the last case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByHidden_Last(
			boolean Hidden, Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the last case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByHidden_Last(
		boolean Hidden, Long CaseModelId,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public CaseApplication[] findByHidden_PrevAndNext(
			long id, boolean Hidden, Long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Removes all the case applications where Hidden = &#63; and CaseModelId = &#63; from the database.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 */
	public void removeByHidden(boolean Hidden, Long CaseModelId);

	/**
	 * Returns the number of case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	public int countByHidden(boolean Hidden, Long CaseModelId);

	/**
	 * Returns all the case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @return the matching case applications
	 */
	public java.util.List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status);

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
	public java.util.List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status, int start, int end);

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
	public java.util.List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public java.util.List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByStatusCase_First(
			Long CaseModelId, String Status,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByStatusCase_First(
		Long CaseModelId, String Status,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByStatusCase_Last(
			Long CaseModelId, String Status,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByStatusCase_Last(
		Long CaseModelId, String Status,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public CaseApplication[] findByStatusCase_PrevAndNext(
			long id, Long CaseModelId, String Status,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Removes all the case applications where CaseModelId = &#63; and Status = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 */
	public void removeByStatusCase(Long CaseModelId, String Status);

	/**
	 * Returns the number of case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @return the number of matching case applications
	 */
	public int countByStatusCase(Long CaseModelId, String Status);

	/**
	 * Returns all the case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @return the matching case applications
	 */
	public java.util.List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate);

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
	public java.util.List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate, int start, int end);

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
	public java.util.List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public java.util.List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByStartDate_First(
			Long CaseModelId, Date StartDate,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByStartDate_First(
		Long CaseModelId, Date StartDate,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByStartDate_Last(
			Long CaseModelId, Date StartDate,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByStartDate_Last(
		Long CaseModelId, Date StartDate,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public CaseApplication[] findByStartDate_PrevAndNext(
			long id, Long CaseModelId, Date StartDate,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Removes all the case applications where CaseModelId = &#63; and StartDate = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 */
	public void removeByStartDate(Long CaseModelId, Date StartDate);

	/**
	 * Returns the number of case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @return the number of matching case applications
	 */
	public int countByStartDate(Long CaseModelId, Date StartDate);

	/**
	 * Returns all the case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @return the matching case applications
	 */
	public java.util.List<CaseApplication> findByEndDate(
		Long CaseModelId, Date EndDate);

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
	public java.util.List<CaseApplication> findByEndDate(
		Long CaseModelId, Date EndDate, int start, int end);

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
	public java.util.List<CaseApplication> findByEndDate(
		Long CaseModelId, Date EndDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public java.util.List<CaseApplication> findByEndDate(
		Long CaseModelId, Date EndDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByEndDate_First(
			Long CaseModelId, Date EndDate,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByEndDate_First(
		Long CaseModelId, Date EndDate,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	public CaseApplication findByEndDate_Last(
			Long CaseModelId, Date EndDate,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	public CaseApplication fetchByEndDate_Last(
		Long CaseModelId, Date EndDate,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public CaseApplication[] findByEndDate_PrevAndNext(
			long id, Long CaseModelId, Date EndDate,
			com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
				orderByComparator)
		throws NoSuchCaseApplicationException;

	/**
	 * Removes all the case applications where CaseModelId = &#63; and EndDate = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 */
	public void removeByEndDate(Long CaseModelId, Date EndDate);

	/**
	 * Returns the number of case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @return the number of matching case applications
	 */
	public int countByEndDate(Long CaseModelId, Date EndDate);

	/**
	 * Caches the case application in the entity cache if it is enabled.
	 *
	 * @param caseApplication the case application
	 */
	public void cacheResult(CaseApplication caseApplication);

	/**
	 * Caches the case applications in the entity cache if it is enabled.
	 *
	 * @param caseApplications the case applications
	 */
	public void cacheResult(java.util.List<CaseApplication> caseApplications);

	/**
	 * Creates a new case application with the primary key. Does not add the case application to the database.
	 *
	 * @param id the primary key for the new case application
	 * @return the new case application
	 */
	public CaseApplication create(long id);

	/**
	 * Removes the case application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the case application
	 * @return the case application that was removed
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public CaseApplication remove(long id)
		throws NoSuchCaseApplicationException;

	public CaseApplication updateImpl(CaseApplication caseApplication);

	/**
	 * Returns the case application with the primary key or throws a <code>NoSuchCaseApplicationException</code> if it could not be found.
	 *
	 * @param id the primary key of the case application
	 * @return the case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	public CaseApplication findByPrimaryKey(long id)
		throws NoSuchCaseApplicationException;

	/**
	 * Returns the case application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the case application
	 * @return the case application, or <code>null</code> if a case application with the primary key could not be found
	 */
	public CaseApplication fetchByPrimaryKey(long id);

	/**
	 * Returns all the case applications.
	 *
	 * @return the case applications
	 */
	public java.util.List<CaseApplication> findAll();

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
	public java.util.List<CaseApplication> findAll(int start, int end);

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
	public java.util.List<CaseApplication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator);

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
	public java.util.List<CaseApplication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseApplication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the case applications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of case applications.
	 *
	 * @return the number of case applications
	 */
	public int countAll();

}
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

import com.petko.stocke.exception.NoSuchStatusModelException;
import com.petko.stocke.model.StatusModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the status model service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author petko
 * @see StatusModelUtil
 * @generated
 */
@ProviderType
public interface StatusModelPersistence extends BasePersistence<StatusModel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatusModelUtil} to access the status model persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the status models where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the matching status models
	 */
	public java.util.List<StatusModel> findBycaseModelId(long CaseModelId);

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
	public java.util.List<StatusModel> findBycaseModelId(
		long CaseModelId, int start, int end);

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
	public java.util.List<StatusModel> findBycaseModelId(
		long CaseModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
			orderByComparator);

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
	public java.util.List<StatusModel> findBycaseModelId(
		long CaseModelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	public StatusModel findBycaseModelId_First(
			long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
				orderByComparator)
		throws NoSuchStatusModelException;

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model, or <code>null</code> if a matching status model could not be found
	 */
	public StatusModel fetchBycaseModelId_First(
		long CaseModelId,
		com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
			orderByComparator);

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	public StatusModel findBycaseModelId_Last(
			long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
				orderByComparator)
		throws NoSuchStatusModelException;

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model, or <code>null</code> if a matching status model could not be found
	 */
	public StatusModel fetchBycaseModelId_Last(
		long CaseModelId,
		com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
			orderByComparator);

	/**
	 * Returns the status models before and after the current status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current status model
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next status model
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	public StatusModel[] findBycaseModelId_PrevAndNext(
			long id, long CaseModelId,
			com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
				orderByComparator)
		throws NoSuchStatusModelException;

	/**
	 * Removes all the status models where CaseModelId = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 */
	public void removeBycaseModelId(long CaseModelId);

	/**
	 * Returns the number of status models where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the number of matching status models
	 */
	public int countBycaseModelId(long CaseModelId);

	/**
	 * Returns all the status models where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @return the matching status models
	 */
	public java.util.List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal);

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
	public java.util.List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal, int start, int end);

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
	public java.util.List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
			orderByComparator);

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
	public java.util.List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	public StatusModel findBycaseModelIdInternal_First(
			long CaseModelId, boolean Internal,
			com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
				orderByComparator)
		throws NoSuchStatusModelException;

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model, or <code>null</code> if a matching status model could not be found
	 */
	public StatusModel fetchBycaseModelIdInternal_First(
		long CaseModelId, boolean Internal,
		com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
			orderByComparator);

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	public StatusModel findBycaseModelIdInternal_Last(
			long CaseModelId, boolean Internal,
			com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
				orderByComparator)
		throws NoSuchStatusModelException;

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model, or <code>null</code> if a matching status model could not be found
	 */
	public StatusModel fetchBycaseModelIdInternal_Last(
		long CaseModelId, boolean Internal,
		com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
			orderByComparator);

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
	public StatusModel[] findBycaseModelIdInternal_PrevAndNext(
			long id, long CaseModelId, boolean Internal,
			com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
				orderByComparator)
		throws NoSuchStatusModelException;

	/**
	 * Removes all the status models where CaseModelId = &#63; and Internal = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 */
	public void removeBycaseModelIdInternal(long CaseModelId, boolean Internal);

	/**
	 * Returns the number of status models where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @return the number of matching status models
	 */
	public int countBycaseModelIdInternal(long CaseModelId, boolean Internal);

	/**
	 * Caches the status model in the entity cache if it is enabled.
	 *
	 * @param statusModel the status model
	 */
	public void cacheResult(StatusModel statusModel);

	/**
	 * Caches the status models in the entity cache if it is enabled.
	 *
	 * @param statusModels the status models
	 */
	public void cacheResult(java.util.List<StatusModel> statusModels);

	/**
	 * Creates a new status model with the primary key. Does not add the status model to the database.
	 *
	 * @param id the primary key for the new status model
	 * @return the new status model
	 */
	public StatusModel create(long id);

	/**
	 * Removes the status model with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the status model
	 * @return the status model that was removed
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	public StatusModel remove(long id) throws NoSuchStatusModelException;

	public StatusModel updateImpl(StatusModel statusModel);

	/**
	 * Returns the status model with the primary key or throws a <code>NoSuchStatusModelException</code> if it could not be found.
	 *
	 * @param id the primary key of the status model
	 * @return the status model
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	public StatusModel findByPrimaryKey(long id)
		throws NoSuchStatusModelException;

	/**
	 * Returns the status model with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the status model
	 * @return the status model, or <code>null</code> if a status model with the primary key could not be found
	 */
	public StatusModel fetchByPrimaryKey(long id);

	/**
	 * Returns all the status models.
	 *
	 * @return the status models
	 */
	public java.util.List<StatusModel> findAll();

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
	public java.util.List<StatusModel> findAll(int start, int end);

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
	public java.util.List<StatusModel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
			orderByComparator);

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
	public java.util.List<StatusModel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatusModel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the status models from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of status models.
	 *
	 * @return the number of status models
	 */
	public int countAll();

}
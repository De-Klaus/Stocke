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

package com.petko.stocke.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StatusModelLocalService}.
 *
 * @author petko
 * @see StatusModelLocalService
 * @generated
 */
public class StatusModelLocalServiceWrapper
	implements ServiceWrapper<StatusModelLocalService>,
			   StatusModelLocalService {

	public StatusModelLocalServiceWrapper(
		StatusModelLocalService statusModelLocalService) {

		_statusModelLocalService = statusModelLocalService;
	}

	/**
	 * Adds the status model to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatusModelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param statusModel the status model
	 * @return the status model that was added
	 */
	@Override
	public com.petko.stocke.model.StatusModel addStatusModel(
		com.petko.stocke.model.StatusModel statusModel) {

		return _statusModelLocalService.addStatusModel(statusModel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statusModelLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new status model with the primary key. Does not add the status model to the database.
	 *
	 * @param id the primary key for the new status model
	 * @return the new status model
	 */
	@Override
	public com.petko.stocke.model.StatusModel createStatusModel(long id) {
		return _statusModelLocalService.createStatusModel(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statusModelLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the status model with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatusModelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the status model
	 * @return the status model that was removed
	 * @throws PortalException if a status model with the primary key could not be found
	 */
	@Override
	public com.petko.stocke.model.StatusModel deleteStatusModel(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statusModelLocalService.deleteStatusModel(id);
	}

	/**
	 * Deletes the status model from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatusModelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param statusModel the status model
	 * @return the status model that was removed
	 */
	@Override
	public com.petko.stocke.model.StatusModel deleteStatusModel(
		com.petko.stocke.model.StatusModel statusModel) {

		return _statusModelLocalService.deleteStatusModel(statusModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statusModelLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _statusModelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.petko.stocke.model.impl.StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _statusModelLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.petko.stocke.model.impl.StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _statusModelLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _statusModelLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _statusModelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.petko.stocke.model.StatusModel fetchStatusModel(long id) {
		return _statusModelLocalService.fetchStatusModel(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _statusModelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _statusModelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _statusModelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statusModelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the status model with the primary key.
	 *
	 * @param id the primary key of the status model
	 * @return the status model
	 * @throws PortalException if a status model with the primary key could not be found
	 */
	@Override
	public com.petko.stocke.model.StatusModel getStatusModel(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statusModelLocalService.getStatusModel(id);
	}

	/**
	 * Returns a range of all the status models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.petko.stocke.model.impl.StatusModelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of status models
	 * @param end the upper bound of the range of status models (not inclusive)
	 * @return the range of status models
	 */
	@Override
	public java.util.List<com.petko.stocke.model.StatusModel> getStatusModels(
		int start, int end) {

		return _statusModelLocalService.getStatusModels(start, end);
	}

	/**
	 * Returns the number of status models.
	 *
	 * @return the number of status models
	 */
	@Override
	public int getStatusModelsCount() {
		return _statusModelLocalService.getStatusModelsCount();
	}

	/**
	 * Updates the status model in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatusModelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param statusModel the status model
	 * @return the status model that was updated
	 */
	@Override
	public com.petko.stocke.model.StatusModel updateStatusModel(
		com.petko.stocke.model.StatusModel statusModel) {

		return _statusModelLocalService.updateStatusModel(statusModel);
	}

	@Override
	public StatusModelLocalService getWrappedService() {
		return _statusModelLocalService;
	}

	@Override
	public void setWrappedService(
		StatusModelLocalService statusModelLocalService) {

		_statusModelLocalService = statusModelLocalService;
	}

	private StatusModelLocalService _statusModelLocalService;

}
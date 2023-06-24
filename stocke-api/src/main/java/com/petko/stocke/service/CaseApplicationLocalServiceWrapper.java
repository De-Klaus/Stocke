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
 * Provides a wrapper for {@link CaseApplicationLocalService}.
 *
 * @author petko
 * @see CaseApplicationLocalService
 * @generated
 */
public class CaseApplicationLocalServiceWrapper
	implements CaseApplicationLocalService,
			   ServiceWrapper<CaseApplicationLocalService> {

	public CaseApplicationLocalServiceWrapper(
		CaseApplicationLocalService caseApplicationLocalService) {

		_caseApplicationLocalService = caseApplicationLocalService;
	}

	/**
	 * Adds the case application to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CaseApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param caseApplication the case application
	 * @return the case application that was added
	 */
	@Override
	public com.petko.stocke.model.CaseApplication addCaseApplication(
		com.petko.stocke.model.CaseApplication caseApplication) {

		return _caseApplicationLocalService.addCaseApplication(caseApplication);
	}

	/**
	 * Creates a new case application with the primary key. Does not add the case application to the database.
	 *
	 * @param id the primary key for the new case application
	 * @return the new case application
	 */
	@Override
	public com.petko.stocke.model.CaseApplication createCaseApplication(
		long id) {

		return _caseApplicationLocalService.createCaseApplication(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _caseApplicationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the case application from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CaseApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param caseApplication the case application
	 * @return the case application that was removed
	 */
	@Override
	public com.petko.stocke.model.CaseApplication deleteCaseApplication(
		com.petko.stocke.model.CaseApplication caseApplication) {

		return _caseApplicationLocalService.deleteCaseApplication(
			caseApplication);
	}

	/**
	 * Deletes the case application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CaseApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the case application
	 * @return the case application that was removed
	 * @throws PortalException if a case application with the primary key could not be found
	 */
	@Override
	public com.petko.stocke.model.CaseApplication deleteCaseApplication(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _caseApplicationLocalService.deleteCaseApplication(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _caseApplicationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _caseApplicationLocalService.dynamicQuery();
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

		return _caseApplicationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.petko.stocke.model.impl.CaseApplicationModelImpl</code>.
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

		return _caseApplicationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.petko.stocke.model.impl.CaseApplicationModelImpl</code>.
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

		return _caseApplicationLocalService.dynamicQuery(
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

		return _caseApplicationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _caseApplicationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.petko.stocke.model.CaseApplication fetchCaseApplication(
		long id) {

		return _caseApplicationLocalService.fetchCaseApplication(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _caseApplicationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the case application with the primary key.
	 *
	 * @param id the primary key of the case application
	 * @return the case application
	 * @throws PortalException if a case application with the primary key could not be found
	 */
	@Override
	public com.petko.stocke.model.CaseApplication getCaseApplication(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _caseApplicationLocalService.getCaseApplication(id);
	}

	/**
	 * Returns a range of all the case applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.petko.stocke.model.impl.CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of case applications
	 */
	@Override
	public java.util.List<com.petko.stocke.model.CaseApplication>
		getCaseApplications(int start, int end) {

		return _caseApplicationLocalService.getCaseApplications(start, end);
	}

	/**
	 * Returns the number of case applications.
	 *
	 * @return the number of case applications
	 */
	@Override
	public int getCaseApplicationsCount() {
		return _caseApplicationLocalService.getCaseApplicationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _caseApplicationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _caseApplicationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _caseApplicationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the case application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CaseApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param caseApplication the case application
	 * @return the case application that was updated
	 */
	@Override
	public com.petko.stocke.model.CaseApplication updateCaseApplication(
		com.petko.stocke.model.CaseApplication caseApplication) {

		return _caseApplicationLocalService.updateCaseApplication(
			caseApplication);
	}

	@Override
	public CaseApplicationLocalService getWrappedService() {
		return _caseApplicationLocalService;
	}

	@Override
	public void setWrappedService(
		CaseApplicationLocalService caseApplicationLocalService) {

		_caseApplicationLocalService = caseApplicationLocalService;
	}

	private CaseApplicationLocalService _caseApplicationLocalService;

}
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

package com.petko.stocke.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CaseApplication}.
 * </p>
 *
 * @author petko
 * @see CaseApplication
 * @generated
 */
public class CaseApplicationWrapper
	extends BaseModelWrapper<CaseApplication>
	implements CaseApplication, ModelWrapper<CaseApplication> {

	public CaseApplicationWrapper(CaseApplication caseApplication) {
		super(caseApplication);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("AdditionalFields", getAdditionalFields());
		attributes.put("Status", getStatus());
		attributes.put("CaseModelId", getCaseModelId());
		attributes.put("OwnerId", getOwnerId());
		attributes.put("Active", isActive());
		attributes.put("Archive", isArchive());
		attributes.put("Hidden", isHidden());
		attributes.put("Type", getType());
		attributes.put("StartDate", getStartDate());
		attributes.put("EndDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String AdditionalFields = (String)attributes.get("AdditionalFields");

		if (AdditionalFields != null) {
			setAdditionalFields(AdditionalFields);
		}

		String Status = (String)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		Long CaseModelId = (Long)attributes.get("CaseModelId");

		if (CaseModelId != null) {
			setCaseModelId(CaseModelId);
		}

		Long OwnerId = (Long)attributes.get("OwnerId");

		if (OwnerId != null) {
			setOwnerId(OwnerId);
		}

		Boolean Active = (Boolean)attributes.get("Active");

		if (Active != null) {
			setActive(Active);
		}

		Boolean Archive = (Boolean)attributes.get("Archive");

		if (Archive != null) {
			setArchive(Archive);
		}

		Boolean Hidden = (Boolean)attributes.get("Hidden");

		if (Hidden != null) {
			setHidden(Hidden);
		}

		Long Type = (Long)attributes.get("Type");

		if (Type != null) {
			setType(Type);
		}

		Date StartDate = (Date)attributes.get("StartDate");

		if (StartDate != null) {
			setStartDate(StartDate);
		}

		Date EndDate = (Date)attributes.get("EndDate");

		if (EndDate != null) {
			setEndDate(EndDate);
		}
	}

	/**
	 * Returns the active of this case application.
	 *
	 * @return the active of this case application
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the additional fields of this case application.
	 *
	 * @return the additional fields of this case application
	 */
	@Override
	public String getAdditionalFields() {
		return model.getAdditionalFields();
	}

	/**
	 * Returns the archive of this case application.
	 *
	 * @return the archive of this case application
	 */
	@Override
	public boolean getArchive() {
		return model.getArchive();
	}

	/**
	 * Returns the case model ID of this case application.
	 *
	 * @return the case model ID of this case application
	 */
	@Override
	public Long getCaseModelId() {
		return model.getCaseModelId();
	}

	/**
	 * Returns the end date of this case application.
	 *
	 * @return the end date of this case application
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the hidden of this case application.
	 *
	 * @return the hidden of this case application
	 */
	@Override
	public boolean getHidden() {
		return model.getHidden();
	}

	/**
	 * Returns the ID of this case application.
	 *
	 * @return the ID of this case application
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the owner ID of this case application.
	 *
	 * @return the owner ID of this case application
	 */
	@Override
	public long getOwnerId() {
		return model.getOwnerId();
	}

	/**
	 * Returns the primary key of this case application.
	 *
	 * @return the primary key of this case application
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this case application.
	 *
	 * @return the start date of this case application
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this case application.
	 *
	 * @return the status of this case application
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the type of this case application.
	 *
	 * @return the type of this case application
	 */
	@Override
	public long getType() {
		return model.getType();
	}

	/**
	 * Returns <code>true</code> if this case application is active.
	 *
	 * @return <code>true</code> if this case application is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this case application is archive.
	 *
	 * @return <code>true</code> if this case application is archive; <code>false</code> otherwise
	 */
	@Override
	public boolean isArchive() {
		return model.isArchive();
	}

	/**
	 * Returns <code>true</code> if this case application is hidden.
	 *
	 * @return <code>true</code> if this case application is hidden; <code>false</code> otherwise
	 */
	@Override
	public boolean isHidden() {
		return model.isHidden();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this case application is active.
	 *
	 * @param Active the active of this case application
	 */
	@Override
	public void setActive(boolean Active) {
		model.setActive(Active);
	}

	/**
	 * Sets the additional fields of this case application.
	 *
	 * @param AdditionalFields the additional fields of this case application
	 */
	@Override
	public void setAdditionalFields(String AdditionalFields) {
		model.setAdditionalFields(AdditionalFields);
	}

	/**
	 * Sets whether this case application is archive.
	 *
	 * @param Archive the archive of this case application
	 */
	@Override
	public void setArchive(boolean Archive) {
		model.setArchive(Archive);
	}

	/**
	 * Sets the case model ID of this case application.
	 *
	 * @param CaseModelId the case model ID of this case application
	 */
	@Override
	public void setCaseModelId(Long CaseModelId) {
		model.setCaseModelId(CaseModelId);
	}

	/**
	 * Sets the end date of this case application.
	 *
	 * @param EndDate the end date of this case application
	 */
	@Override
	public void setEndDate(Date EndDate) {
		model.setEndDate(EndDate);
	}

	/**
	 * Sets whether this case application is hidden.
	 *
	 * @param Hidden the hidden of this case application
	 */
	@Override
	public void setHidden(boolean Hidden) {
		model.setHidden(Hidden);
	}

	/**
	 * Sets the ID of this case application.
	 *
	 * @param id the ID of this case application
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the owner ID of this case application.
	 *
	 * @param OwnerId the owner ID of this case application
	 */
	@Override
	public void setOwnerId(long OwnerId) {
		model.setOwnerId(OwnerId);
	}

	/**
	 * Sets the primary key of this case application.
	 *
	 * @param primaryKey the primary key of this case application
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this case application.
	 *
	 * @param StartDate the start date of this case application
	 */
	@Override
	public void setStartDate(Date StartDate) {
		model.setStartDate(StartDate);
	}

	/**
	 * Sets the status of this case application.
	 *
	 * @param Status the status of this case application
	 */
	@Override
	public void setStatus(String Status) {
		model.setStatus(Status);
	}

	/**
	 * Sets the type of this case application.
	 *
	 * @param Type the type of this case application
	 */
	@Override
	public void setType(long Type) {
		model.setType(Type);
	}

	@Override
	protected CaseApplicationWrapper wrap(CaseApplication caseApplication) {
		return new CaseApplicationWrapper(caseApplication);
	}

}
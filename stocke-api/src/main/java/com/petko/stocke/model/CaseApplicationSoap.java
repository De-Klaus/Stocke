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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author petko
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CaseApplicationSoap implements Serializable {

	public static CaseApplicationSoap toSoapModel(CaseApplication model) {
		CaseApplicationSoap soapModel = new CaseApplicationSoap();

		soapModel.setId(model.getId());
		soapModel.setAdditionalFields(model.getAdditionalFields());
		soapModel.setStatus(model.getStatus());
		soapModel.setCaseModelId(model.getCaseModelId());
		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setActive(model.isActive());
		soapModel.setArchive(model.isArchive());
		soapModel.setHidden(model.isHidden());
		soapModel.setType(model.getType());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static CaseApplicationSoap[] toSoapModels(CaseApplication[] models) {
		CaseApplicationSoap[] soapModels =
			new CaseApplicationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CaseApplicationSoap[][] toSoapModels(
		CaseApplication[][] models) {

		CaseApplicationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CaseApplicationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CaseApplicationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CaseApplicationSoap[] toSoapModels(
		List<CaseApplication> models) {

		List<CaseApplicationSoap> soapModels =
			new ArrayList<CaseApplicationSoap>(models.size());

		for (CaseApplication model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CaseApplicationSoap[soapModels.size()]);
	}

	public CaseApplicationSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getAdditionalFields() {
		return _AdditionalFields;
	}

	public void setAdditionalFields(String AdditionalFields) {
		_AdditionalFields = AdditionalFields;
	}

	public String getStatus() {
		return _Status;
	}

	public void setStatus(String Status) {
		_Status = Status;
	}

	public Long getCaseModelId() {
		return _CaseModelId;
	}

	public void setCaseModelId(Long CaseModelId) {
		_CaseModelId = CaseModelId;
	}

	public long getOwnerId() {
		return _OwnerId;
	}

	public void setOwnerId(long OwnerId) {
		_OwnerId = OwnerId;
	}

	public boolean getActive() {
		return _Active;
	}

	public boolean isActive() {
		return _Active;
	}

	public void setActive(boolean Active) {
		_Active = Active;
	}

	public boolean getArchive() {
		return _Archive;
	}

	public boolean isArchive() {
		return _Archive;
	}

	public void setArchive(boolean Archive) {
		_Archive = Archive;
	}

	public boolean getHidden() {
		return _Hidden;
	}

	public boolean isHidden() {
		return _Hidden;
	}

	public void setHidden(boolean Hidden) {
		_Hidden = Hidden;
	}

	public long getType() {
		return _Type;
	}

	public void setType(long Type) {
		_Type = Type;
	}

	public Date getStartDate() {
		return _StartDate;
	}

	public void setStartDate(Date StartDate) {
		_StartDate = StartDate;
	}

	public Date getEndDate() {
		return _EndDate;
	}

	public void setEndDate(Date EndDate) {
		_EndDate = EndDate;
	}

	private long _id;
	private String _AdditionalFields;
	private String _Status;
	private Long _CaseModelId;
	private long _OwnerId;
	private boolean _Active;
	private boolean _Archive;
	private boolean _Hidden;
	private long _Type;
	private Date _StartDate;
	private Date _EndDate;

}
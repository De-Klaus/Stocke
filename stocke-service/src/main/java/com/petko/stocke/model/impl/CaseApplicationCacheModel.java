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

package com.petko.stocke.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.petko.stocke.model.CaseApplication;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CaseApplication in entity cache.
 *
 * @author petko
 * @generated
 */
public class CaseApplicationCacheModel
	implements CacheModel<CaseApplication>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CaseApplicationCacheModel)) {
			return false;
		}

		CaseApplicationCacheModel caseApplicationCacheModel =
			(CaseApplicationCacheModel)object;

		if (id == caseApplicationCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", AdditionalFields=");
		sb.append(AdditionalFields);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", CaseModelId=");
		sb.append(CaseModelId);
		sb.append(", OwnerId=");
		sb.append(OwnerId);
		sb.append(", Active=");
		sb.append(Active);
		sb.append(", Archive=");
		sb.append(Archive);
		sb.append(", Hidden=");
		sb.append(Hidden);
		sb.append(", Type=");
		sb.append(Type);
		sb.append(", StartDate=");
		sb.append(StartDate);
		sb.append(", EndDate=");
		sb.append(EndDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CaseApplication toEntityModel() {
		CaseApplicationImpl caseApplicationImpl = new CaseApplicationImpl();

		caseApplicationImpl.setId(id);

		if (AdditionalFields == null) {
			caseApplicationImpl.setAdditionalFields("");
		}
		else {
			caseApplicationImpl.setAdditionalFields(AdditionalFields);
		}

		if (Status == null) {
			caseApplicationImpl.setStatus("");
		}
		else {
			caseApplicationImpl.setStatus(Status);
		}

		caseApplicationImpl.setCaseModelId(CaseModelId);
		caseApplicationImpl.setOwnerId(OwnerId);
		caseApplicationImpl.setActive(Active);
		caseApplicationImpl.setArchive(Archive);
		caseApplicationImpl.setHidden(Hidden);
		caseApplicationImpl.setType(Type);

		if (StartDate == Long.MIN_VALUE) {
			caseApplicationImpl.setStartDate(null);
		}
		else {
			caseApplicationImpl.setStartDate(new Date(StartDate));
		}

		if (EndDate == Long.MIN_VALUE) {
			caseApplicationImpl.setEndDate(null);
		}
		else {
			caseApplicationImpl.setEndDate(new Date(EndDate));
		}

		caseApplicationImpl.resetOriginalValues();

		return caseApplicationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		AdditionalFields = objectInput.readUTF();
		Status = objectInput.readUTF();

		CaseModelId = objectInput.readLong();

		OwnerId = objectInput.readLong();

		Active = objectInput.readBoolean();

		Archive = objectInput.readBoolean();

		Hidden = objectInput.readBoolean();

		Type = objectInput.readLong();
		StartDate = objectInput.readLong();
		EndDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (AdditionalFields == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(AdditionalFields);
		}

		if (Status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Status);
		}

		objectOutput.writeLong(CaseModelId);

		objectOutput.writeLong(OwnerId);

		objectOutput.writeBoolean(Active);

		objectOutput.writeBoolean(Archive);

		objectOutput.writeBoolean(Hidden);

		objectOutput.writeLong(Type);
		objectOutput.writeLong(StartDate);
		objectOutput.writeLong(EndDate);
	}

	public long id;
	public String AdditionalFields;
	public String Status;
	public long CaseModelId;
	public long OwnerId;
	public boolean Active;
	public boolean Archive;
	public boolean Hidden;
	public long Type;
	public long StartDate;
	public long EndDate;

}
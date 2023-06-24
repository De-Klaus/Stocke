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

import com.petko.stocke.model.StatusModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatusModel in entity cache.
 *
 * @author petko
 * @generated
 */
public class StatusModelCacheModel
	implements CacheModel<StatusModel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StatusModelCacheModel)) {
			return false;
		}

		StatusModelCacheModel statusModelCacheModel =
			(StatusModelCacheModel)object;

		if (id == statusModelCacheModel.id) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", CaseModelId=");
		sb.append(CaseModelId);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", Internal=");
		sb.append(Internal);
		sb.append(", Message=");
		sb.append(Message);
		sb.append(", Notification=");
		sb.append(Notification);
		sb.append(", NotificationCount=");
		sb.append(NotificationCount);
		sb.append(", NotificationType=");
		sb.append(NotificationType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatusModel toEntityModel() {
		StatusModelImpl statusModelImpl = new StatusModelImpl();

		statusModelImpl.setId(id);
		statusModelImpl.setCaseModelId(CaseModelId);

		if (Status == null) {
			statusModelImpl.setStatus("");
		}
		else {
			statusModelImpl.setStatus(Status);
		}

		statusModelImpl.setInternal(Internal);

		if (Message == null) {
			statusModelImpl.setMessage("");
		}
		else {
			statusModelImpl.setMessage(Message);
		}

		statusModelImpl.setNotification(Notification);
		statusModelImpl.setNotificationCount(NotificationCount);
		statusModelImpl.setNotificationType(NotificationType);

		statusModelImpl.resetOriginalValues();

		return statusModelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		CaseModelId = objectInput.readLong();
		Status = objectInput.readUTF();

		Internal = objectInput.readBoolean();
		Message = objectInput.readUTF();

		Notification = objectInput.readBoolean();

		NotificationCount = objectInput.readLong();

		NotificationType = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(CaseModelId);

		if (Status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Status);
		}

		objectOutput.writeBoolean(Internal);

		if (Message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Message);
		}

		objectOutput.writeBoolean(Notification);

		objectOutput.writeLong(NotificationCount);

		objectOutput.writeBoolean(NotificationType);
	}

	public long id;
	public long CaseModelId;
	public String Status;
	public boolean Internal;
	public String Message;
	public boolean Notification;
	public long NotificationCount;
	public boolean NotificationType;

}
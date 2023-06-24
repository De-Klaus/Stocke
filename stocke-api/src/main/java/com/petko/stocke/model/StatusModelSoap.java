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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author petko
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class StatusModelSoap implements Serializable {

	public static StatusModelSoap toSoapModel(StatusModel model) {
		StatusModelSoap soapModel = new StatusModelSoap();

		soapModel.setId(model.getId());
		soapModel.setCaseModelId(model.getCaseModelId());
		soapModel.setStatus(model.getStatus());
		soapModel.setInternal(model.isInternal());
		soapModel.setMessage(model.getMessage());
		soapModel.setNotification(model.isNotification());
		soapModel.setNotificationCount(model.getNotificationCount());
		soapModel.setNotificationType(model.isNotificationType());

		return soapModel;
	}

	public static StatusModelSoap[] toSoapModels(StatusModel[] models) {
		StatusModelSoap[] soapModels = new StatusModelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatusModelSoap[][] toSoapModels(StatusModel[][] models) {
		StatusModelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatusModelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatusModelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatusModelSoap[] toSoapModels(List<StatusModel> models) {
		List<StatusModelSoap> soapModels = new ArrayList<StatusModelSoap>(
			models.size());

		for (StatusModel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatusModelSoap[soapModels.size()]);
	}

	public StatusModelSoap() {
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

	public long getCaseModelId() {
		return _CaseModelId;
	}

	public void setCaseModelId(long CaseModelId) {
		_CaseModelId = CaseModelId;
	}

	public String getStatus() {
		return _Status;
	}

	public void setStatus(String Status) {
		_Status = Status;
	}

	public boolean getInternal() {
		return _Internal;
	}

	public boolean isInternal() {
		return _Internal;
	}

	public void setInternal(boolean Internal) {
		_Internal = Internal;
	}

	public String getMessage() {
		return _Message;
	}

	public void setMessage(String Message) {
		_Message = Message;
	}

	public boolean getNotification() {
		return _Notification;
	}

	public boolean isNotification() {
		return _Notification;
	}

	public void setNotification(boolean Notification) {
		_Notification = Notification;
	}

	public long getNotificationCount() {
		return _NotificationCount;
	}

	public void setNotificationCount(long NotificationCount) {
		_NotificationCount = NotificationCount;
	}

	public boolean getNotificationType() {
		return _NotificationType;
	}

	public boolean isNotificationType() {
		return _NotificationType;
	}

	public void setNotificationType(boolean NotificationType) {
		_NotificationType = NotificationType;
	}

	private long _id;
	private long _CaseModelId;
	private String _Status;
	private boolean _Internal;
	private String _Message;
	private boolean _Notification;
	private long _NotificationCount;
	private boolean _NotificationType;

}
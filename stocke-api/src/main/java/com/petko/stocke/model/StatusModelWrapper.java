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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StatusModel}.
 * </p>
 *
 * @author petko
 * @see StatusModel
 * @generated
 */
public class StatusModelWrapper
	extends BaseModelWrapper<StatusModel>
	implements ModelWrapper<StatusModel>, StatusModel {

	public StatusModelWrapper(StatusModel statusModel) {
		super(statusModel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("CaseModelId", getCaseModelId());
		attributes.put("Status", getStatus());
		attributes.put("Internal", isInternal());
		attributes.put("Message", getMessage());
		attributes.put("Notification", isNotification());
		attributes.put("NotificationCount", getNotificationCount());
		attributes.put("NotificationType", isNotificationType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long CaseModelId = (Long)attributes.get("CaseModelId");

		if (CaseModelId != null) {
			setCaseModelId(CaseModelId);
		}

		String Status = (String)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		Boolean Internal = (Boolean)attributes.get("Internal");

		if (Internal != null) {
			setInternal(Internal);
		}

		String Message = (String)attributes.get("Message");

		if (Message != null) {
			setMessage(Message);
		}

		Boolean Notification = (Boolean)attributes.get("Notification");

		if (Notification != null) {
			setNotification(Notification);
		}

		Long NotificationCount = (Long)attributes.get("NotificationCount");

		if (NotificationCount != null) {
			setNotificationCount(NotificationCount);
		}

		Boolean NotificationType = (Boolean)attributes.get("NotificationType");

		if (NotificationType != null) {
			setNotificationType(NotificationType);
		}
	}

	/**
	 * Returns the case model ID of this status model.
	 *
	 * @return the case model ID of this status model
	 */
	@Override
	public long getCaseModelId() {
		return model.getCaseModelId();
	}

	/**
	 * Returns the ID of this status model.
	 *
	 * @return the ID of this status model
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the internal of this status model.
	 *
	 * @return the internal of this status model
	 */
	@Override
	public boolean getInternal() {
		return model.getInternal();
	}

	/**
	 * Returns the message of this status model.
	 *
	 * @return the message of this status model
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the notification of this status model.
	 *
	 * @return the notification of this status model
	 */
	@Override
	public boolean getNotification() {
		return model.getNotification();
	}

	/**
	 * Returns the notification count of this status model.
	 *
	 * @return the notification count of this status model
	 */
	@Override
	public long getNotificationCount() {
		return model.getNotificationCount();
	}

	/**
	 * Returns the notification type of this status model.
	 *
	 * @return the notification type of this status model
	 */
	@Override
	public boolean getNotificationType() {
		return model.getNotificationType();
	}

	/**
	 * Returns the primary key of this status model.
	 *
	 * @return the primary key of this status model
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this status model.
	 *
	 * @return the status of this status model
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns <code>true</code> if this status model is internal.
	 *
	 * @return <code>true</code> if this status model is internal; <code>false</code> otherwise
	 */
	@Override
	public boolean isInternal() {
		return model.isInternal();
	}

	/**
	 * Returns <code>true</code> if this status model is notification.
	 *
	 * @return <code>true</code> if this status model is notification; <code>false</code> otherwise
	 */
	@Override
	public boolean isNotification() {
		return model.isNotification();
	}

	/**
	 * Returns <code>true</code> if this status model is notification type.
	 *
	 * @return <code>true</code> if this status model is notification type; <code>false</code> otherwise
	 */
	@Override
	public boolean isNotificationType() {
		return model.isNotificationType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the case model ID of this status model.
	 *
	 * @param CaseModelId the case model ID of this status model
	 */
	@Override
	public void setCaseModelId(long CaseModelId) {
		model.setCaseModelId(CaseModelId);
	}

	/**
	 * Sets the ID of this status model.
	 *
	 * @param id the ID of this status model
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets whether this status model is internal.
	 *
	 * @param Internal the internal of this status model
	 */
	@Override
	public void setInternal(boolean Internal) {
		model.setInternal(Internal);
	}

	/**
	 * Sets the message of this status model.
	 *
	 * @param Message the message of this status model
	 */
	@Override
	public void setMessage(String Message) {
		model.setMessage(Message);
	}

	/**
	 * Sets whether this status model is notification.
	 *
	 * @param Notification the notification of this status model
	 */
	@Override
	public void setNotification(boolean Notification) {
		model.setNotification(Notification);
	}

	/**
	 * Sets the notification count of this status model.
	 *
	 * @param NotificationCount the notification count of this status model
	 */
	@Override
	public void setNotificationCount(long NotificationCount) {
		model.setNotificationCount(NotificationCount);
	}

	/**
	 * Sets whether this status model is notification type.
	 *
	 * @param NotificationType the notification type of this status model
	 */
	@Override
	public void setNotificationType(boolean NotificationType) {
		model.setNotificationType(NotificationType);
	}

	/**
	 * Sets the primary key of this status model.
	 *
	 * @param primaryKey the primary key of this status model
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this status model.
	 *
	 * @param Status the status of this status model
	 */
	@Override
	public void setStatus(String Status) {
		model.setStatus(Status);
	}

	@Override
	protected StatusModelWrapper wrap(StatusModel statusModel) {
		return new StatusModelWrapper(statusModel);
	}

}
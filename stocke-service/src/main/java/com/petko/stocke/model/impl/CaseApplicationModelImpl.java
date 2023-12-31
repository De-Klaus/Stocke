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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.petko.stocke.model.CaseApplication;
import com.petko.stocke.model.CaseApplicationModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CaseApplication service. Represents a row in the &quot;stocke_CaseApplication&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CaseApplicationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CaseApplicationImpl}.
 * </p>
 *
 * @author petko
 * @see CaseApplicationImpl
 * @generated
 */
public class CaseApplicationModelImpl
	extends BaseModelImpl<CaseApplication> implements CaseApplicationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a case application model instance should use the <code>CaseApplication</code> interface instead.
	 */
	public static final String TABLE_NAME = "stocke_CaseApplication";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"AdditionalFields", Types.VARCHAR},
		{"Status", Types.VARCHAR}, {"CaseModelId", Types.BIGINT},
		{"OwnerId", Types.BIGINT}, {"Active", Types.BOOLEAN},
		{"Archive", Types.BOOLEAN}, {"Hidden", Types.BOOLEAN},
		{"Type", Types.BIGINT}, {"StartDate", Types.TIMESTAMP},
		{"EndDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("AdditionalFields", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CaseModelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("OwnerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("Active", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("Archive", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("Hidden", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("Type", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("StartDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("EndDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table stocke_CaseApplication (id_ LONG not null primary key,AdditionalFields VARCHAR(75) null,Status VARCHAR(75) null,CaseModelId LONG,OwnerId LONG,Active BOOLEAN,Archive BOOLEAN,Hidden BOOLEAN,Type LONG,StartDate DATE null,EndDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table stocke_CaseApplication";

	public static final String ORDER_BY_JPQL =
		" ORDER BY caseApplication.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY stocke_CaseApplication.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ACTIVE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ARCHIVE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CASEMODELID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ENDDATE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long HIDDEN_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long STARTDATE_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public CaseApplicationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CaseApplication.class;
	}

	@Override
	public String getModelClassName() {
		return CaseApplication.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CaseApplication, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CaseApplication, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CaseApplication, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CaseApplication)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CaseApplication, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CaseApplication, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CaseApplication)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CaseApplication, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CaseApplication, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CaseApplication>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CaseApplication.class.getClassLoader(), CaseApplication.class,
			ModelWrapper.class);

		try {
			Constructor<CaseApplication> constructor =
				(Constructor<CaseApplication>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CaseApplication, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CaseApplication, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CaseApplication, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CaseApplication, Object>>();
		Map<String, BiConsumer<CaseApplication, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CaseApplication, ?>>();

		attributeGetterFunctions.put("id", CaseApplication::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<CaseApplication, Long>)CaseApplication::setId);
		attributeGetterFunctions.put(
			"AdditionalFields", CaseApplication::getAdditionalFields);
		attributeSetterBiConsumers.put(
			"AdditionalFields",
			(BiConsumer<CaseApplication, String>)
				CaseApplication::setAdditionalFields);
		attributeGetterFunctions.put("Status", CaseApplication::getStatus);
		attributeSetterBiConsumers.put(
			"Status",
			(BiConsumer<CaseApplication, String>)CaseApplication::setStatus);
		attributeGetterFunctions.put(
			"CaseModelId", CaseApplication::getCaseModelId);
		attributeSetterBiConsumers.put(
			"CaseModelId",
			(BiConsumer<CaseApplication, Long>)CaseApplication::setCaseModelId);
		attributeGetterFunctions.put("OwnerId", CaseApplication::getOwnerId);
		attributeSetterBiConsumers.put(
			"OwnerId",
			(BiConsumer<CaseApplication, Long>)CaseApplication::setOwnerId);
		attributeGetterFunctions.put("Active", CaseApplication::getActive);
		attributeSetterBiConsumers.put(
			"Active",
			(BiConsumer<CaseApplication, Boolean>)CaseApplication::setActive);
		attributeGetterFunctions.put("Archive", CaseApplication::getArchive);
		attributeSetterBiConsumers.put(
			"Archive",
			(BiConsumer<CaseApplication, Boolean>)CaseApplication::setArchive);
		attributeGetterFunctions.put("Hidden", CaseApplication::getHidden);
		attributeSetterBiConsumers.put(
			"Hidden",
			(BiConsumer<CaseApplication, Boolean>)CaseApplication::setHidden);
		attributeGetterFunctions.put("Type", CaseApplication::getType);
		attributeSetterBiConsumers.put(
			"Type",
			(BiConsumer<CaseApplication, Long>)CaseApplication::setType);
		attributeGetterFunctions.put(
			"StartDate", CaseApplication::getStartDate);
		attributeSetterBiConsumers.put(
			"StartDate",
			(BiConsumer<CaseApplication, Date>)CaseApplication::setStartDate);
		attributeGetterFunctions.put("EndDate", CaseApplication::getEndDate);
		attributeSetterBiConsumers.put(
			"EndDate",
			(BiConsumer<CaseApplication, Date>)CaseApplication::setEndDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
	}

	@Override
	public String getAdditionalFields() {
		if (_AdditionalFields == null) {
			return "";
		}
		else {
			return _AdditionalFields;
		}
	}

	@Override
	public void setAdditionalFields(String AdditionalFields) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_AdditionalFields = AdditionalFields;
	}

	@Override
	public String getStatus() {
		if (_Status == null) {
			return "";
		}
		else {
			return _Status;
		}
	}

	@Override
	public void setStatus(String Status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_Status = Status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalStatus() {
		return getColumnOriginalValue("Status");
	}

	@Override
	public Long getCaseModelId() {
		return _CaseModelId;
	}

	@Override
	public void setCaseModelId(Long CaseModelId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_CaseModelId = CaseModelId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Long getOriginalCaseModelId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("CaseModelId"));
	}

	@Override
	public long getOwnerId() {
		return _OwnerId;
	}

	@Override
	public void setOwnerId(long OwnerId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_OwnerId = OwnerId;
	}

	@Override
	public boolean getActive() {
		return _Active;
	}

	@Override
	public boolean isActive() {
		return _Active;
	}

	@Override
	public void setActive(boolean Active) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_Active = Active;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalActive() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("Active"));
	}

	@Override
	public boolean getArchive() {
		return _Archive;
	}

	@Override
	public boolean isArchive() {
		return _Archive;
	}

	@Override
	public void setArchive(boolean Archive) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_Archive = Archive;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalArchive() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("Archive"));
	}

	@Override
	public boolean getHidden() {
		return _Hidden;
	}

	@Override
	public boolean isHidden() {
		return _Hidden;
	}

	@Override
	public void setHidden(boolean Hidden) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_Hidden = Hidden;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalHidden() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("Hidden"));
	}

	@Override
	public long getType() {
		return _Type;
	}

	@Override
	public void setType(long Type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_Type = Type;
	}

	@Override
	public Date getStartDate() {
		return _StartDate;
	}

	@Override
	public void setStartDate(Date StartDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_StartDate = StartDate;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Date getOriginalStartDate() {
		return getColumnOriginalValue("StartDate");
	}

	@Override
	public Date getEndDate() {
		return _EndDate;
	}

	@Override
	public void setEndDate(Date EndDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_EndDate = EndDate;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Date getOriginalEndDate() {
		return getColumnOriginalValue("EndDate");
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CaseApplication.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CaseApplication toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CaseApplication>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CaseApplicationImpl caseApplicationImpl = new CaseApplicationImpl();

		caseApplicationImpl.setId(getId());
		caseApplicationImpl.setAdditionalFields(getAdditionalFields());
		caseApplicationImpl.setStatus(getStatus());
		caseApplicationImpl.setCaseModelId(getCaseModelId());
		caseApplicationImpl.setOwnerId(getOwnerId());
		caseApplicationImpl.setActive(isActive());
		caseApplicationImpl.setArchive(isArchive());
		caseApplicationImpl.setHidden(isHidden());
		caseApplicationImpl.setType(getType());
		caseApplicationImpl.setStartDate(getStartDate());
		caseApplicationImpl.setEndDate(getEndDate());

		caseApplicationImpl.resetOriginalValues();

		return caseApplicationImpl;
	}

	@Override
	public int compareTo(CaseApplication caseApplication) {
		long primaryKey = caseApplication.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CaseApplication)) {
			return false;
		}

		CaseApplication caseApplication = (CaseApplication)object;

		long primaryKey = caseApplication.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CaseApplication> toCacheModel() {
		CaseApplicationCacheModel caseApplicationCacheModel =
			new CaseApplicationCacheModel();

		caseApplicationCacheModel.id = getId();

		caseApplicationCacheModel.AdditionalFields = getAdditionalFields();

		String AdditionalFields = caseApplicationCacheModel.AdditionalFields;

		if ((AdditionalFields != null) && (AdditionalFields.length() == 0)) {
			caseApplicationCacheModel.AdditionalFields = null;
		}

		caseApplicationCacheModel.Status = getStatus();

		String Status = caseApplicationCacheModel.Status;

		if ((Status != null) && (Status.length() == 0)) {
			caseApplicationCacheModel.Status = null;
		}

		Long CaseModelId = getCaseModelId();

		if (CaseModelId != null) {
			caseApplicationCacheModel.CaseModelId = CaseModelId;
		}

		caseApplicationCacheModel.OwnerId = getOwnerId();

		caseApplicationCacheModel.Active = isActive();

		caseApplicationCacheModel.Archive = isArchive();

		caseApplicationCacheModel.Hidden = isHidden();

		caseApplicationCacheModel.Type = getType();

		Date StartDate = getStartDate();

		if (StartDate != null) {
			caseApplicationCacheModel.StartDate = StartDate.getTime();
		}
		else {
			caseApplicationCacheModel.StartDate = Long.MIN_VALUE;
		}

		Date EndDate = getEndDate();

		if (EndDate != null) {
			caseApplicationCacheModel.EndDate = EndDate.getTime();
		}
		else {
			caseApplicationCacheModel.EndDate = Long.MIN_VALUE;
		}

		return caseApplicationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CaseApplication, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CaseApplication, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CaseApplication, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CaseApplication)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CaseApplication, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CaseApplication, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CaseApplication, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CaseApplication)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CaseApplication>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

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

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CaseApplication, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CaseApplication)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("id_", _id);
		_columnOriginalValues.put("AdditionalFields", _AdditionalFields);
		_columnOriginalValues.put("Status", _Status);
		_columnOriginalValues.put("CaseModelId", _CaseModelId);
		_columnOriginalValues.put("OwnerId", _OwnerId);
		_columnOriginalValues.put("Active", _Active);
		_columnOriginalValues.put("Archive", _Archive);
		_columnOriginalValues.put("Hidden", _Hidden);
		_columnOriginalValues.put("Type", _Type);
		_columnOriginalValues.put("StartDate", _StartDate);
		_columnOriginalValues.put("EndDate", _EndDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("id_", "id");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("id_", 1L);

		columnBitmasks.put("AdditionalFields", 2L);

		columnBitmasks.put("Status", 4L);

		columnBitmasks.put("CaseModelId", 8L);

		columnBitmasks.put("OwnerId", 16L);

		columnBitmasks.put("Active", 32L);

		columnBitmasks.put("Archive", 64L);

		columnBitmasks.put("Hidden", 128L);

		columnBitmasks.put("Type", 256L);

		columnBitmasks.put("StartDate", 512L);

		columnBitmasks.put("EndDate", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CaseApplication _escapedModel;

}
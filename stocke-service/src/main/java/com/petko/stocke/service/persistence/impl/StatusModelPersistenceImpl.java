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

package com.petko.stocke.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import com.petko.stocke.exception.NoSuchStatusModelException;
import com.petko.stocke.model.StatusModel;
import com.petko.stocke.model.impl.StatusModelImpl;
import com.petko.stocke.model.impl.StatusModelModelImpl;
import com.petko.stocke.service.persistence.StatusModelPersistence;
import com.petko.stocke.service.persistence.impl.constants.stockePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the status model service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author petko
 * @generated
 */
@Component(service = StatusModelPersistence.class)
public class StatusModelPersistenceImpl
	extends BasePersistenceImpl<StatusModel> implements StatusModelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StatusModelUtil</code> to access the status model persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StatusModelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBycaseModelId;
	private FinderPath _finderPathWithoutPaginationFindBycaseModelId;
	private FinderPath _finderPathCountBycaseModelId;

	/**
	 * Returns all the status models where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the matching status models
	 */
	@Override
	public List<StatusModel> findBycaseModelId(long CaseModelId) {
		return findBycaseModelId(
			CaseModelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StatusModel> findBycaseModelId(
		long CaseModelId, int start, int end) {

		return findBycaseModelId(CaseModelId, start, end, null);
	}

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
	@Override
	public List<StatusModel> findBycaseModelId(
		long CaseModelId, int start, int end,
		OrderByComparator<StatusModel> orderByComparator) {

		return findBycaseModelId(
			CaseModelId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<StatusModel> findBycaseModelId(
		long CaseModelId, int start, int end,
		OrderByComparator<StatusModel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycaseModelId;
				finderArgs = new Object[] {CaseModelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycaseModelId;
			finderArgs = new Object[] {
				CaseModelId, start, end, orderByComparator
			};
		}

		List<StatusModel> list = null;

		if (useFinderCache) {
			list = (List<StatusModel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StatusModel statusModel : list) {
					if (CaseModelId != statusModel.getCaseModelId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_STATUSMODEL_WHERE);

			sb.append(_FINDER_COLUMN_CASEMODELID_CASEMODELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StatusModelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId);

				list = (List<StatusModel>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	@Override
	public StatusModel findBycaseModelId_First(
			long CaseModelId, OrderByComparator<StatusModel> orderByComparator)
		throws NoSuchStatusModelException {

		StatusModel statusModel = fetchBycaseModelId_First(
			CaseModelId, orderByComparator);

		if (statusModel != null) {
			return statusModel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append("}");

		throw new NoSuchStatusModelException(sb.toString());
	}

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model, or <code>null</code> if a matching status model could not be found
	 */
	@Override
	public StatusModel fetchBycaseModelId_First(
		long CaseModelId, OrderByComparator<StatusModel> orderByComparator) {

		List<StatusModel> list = findBycaseModelId(
			CaseModelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	@Override
	public StatusModel findBycaseModelId_Last(
			long CaseModelId, OrderByComparator<StatusModel> orderByComparator)
		throws NoSuchStatusModelException {

		StatusModel statusModel = fetchBycaseModelId_Last(
			CaseModelId, orderByComparator);

		if (statusModel != null) {
			return statusModel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append("}");

		throw new NoSuchStatusModelException(sb.toString());
	}

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model, or <code>null</code> if a matching status model could not be found
	 */
	@Override
	public StatusModel fetchBycaseModelId_Last(
		long CaseModelId, OrderByComparator<StatusModel> orderByComparator) {

		int count = countBycaseModelId(CaseModelId);

		if (count == 0) {
			return null;
		}

		List<StatusModel> list = findBycaseModelId(
			CaseModelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the status models before and after the current status model in the ordered set where CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current status model
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next status model
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	@Override
	public StatusModel[] findBycaseModelId_PrevAndNext(
			long id, long CaseModelId,
			OrderByComparator<StatusModel> orderByComparator)
		throws NoSuchStatusModelException {

		StatusModel statusModel = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StatusModel[] array = new StatusModelImpl[3];

			array[0] = getBycaseModelId_PrevAndNext(
				session, statusModel, CaseModelId, orderByComparator, true);

			array[1] = statusModel;

			array[2] = getBycaseModelId_PrevAndNext(
				session, statusModel, CaseModelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatusModel getBycaseModelId_PrevAndNext(
		Session session, StatusModel statusModel, long CaseModelId,
		OrderByComparator<StatusModel> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STATUSMODEL_WHERE);

		sb.append(_FINDER_COLUMN_CASEMODELID_CASEMODELID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StatusModelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(CaseModelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(statusModel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StatusModel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the status models where CaseModelId = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 */
	@Override
	public void removeBycaseModelId(long CaseModelId) {
		for (StatusModel statusModel :
				findBycaseModelId(
					CaseModelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(statusModel);
		}
	}

	/**
	 * Returns the number of status models where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the number of matching status models
	 */
	@Override
	public int countBycaseModelId(long CaseModelId) {
		FinderPath finderPath = _finderPathCountBycaseModelId;

		Object[] finderArgs = new Object[] {CaseModelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATUSMODEL_WHERE);

			sb.append(_FINDER_COLUMN_CASEMODELID_CASEMODELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CASEMODELID_CASEMODELID_2 =
		"statusModel.CaseModelId = ?";

	private FinderPath _finderPathWithPaginationFindBycaseModelIdInternal;
	private FinderPath _finderPathWithoutPaginationFindBycaseModelIdInternal;
	private FinderPath _finderPathCountBycaseModelIdInternal;

	/**
	 * Returns all the status models where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @return the matching status models
	 */
	@Override
	public List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal) {

		return findBycaseModelIdInternal(
			CaseModelId, Internal, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal, int start, int end) {

		return findBycaseModelIdInternal(
			CaseModelId, Internal, start, end, null);
	}

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
	@Override
	public List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal, int start, int end,
		OrderByComparator<StatusModel> orderByComparator) {

		return findBycaseModelIdInternal(
			CaseModelId, Internal, start, end, orderByComparator, true);
	}

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
	@Override
	public List<StatusModel> findBycaseModelIdInternal(
		long CaseModelId, boolean Internal, int start, int end,
		OrderByComparator<StatusModel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBycaseModelIdInternal;
				finderArgs = new Object[] {CaseModelId, Internal};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycaseModelIdInternal;
			finderArgs = new Object[] {
				CaseModelId, Internal, start, end, orderByComparator
			};
		}

		List<StatusModel> list = null;

		if (useFinderCache) {
			list = (List<StatusModel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StatusModel statusModel : list) {
					if ((CaseModelId != statusModel.getCaseModelId()) ||
						(Internal != statusModel.isInternal())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_STATUSMODEL_WHERE);

			sb.append(_FINDER_COLUMN_CASEMODELIDINTERNAL_CASEMODELID_2);

			sb.append(_FINDER_COLUMN_CASEMODELIDINTERNAL_INTERNAL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StatusModelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId);

				queryPos.add(Internal);

				list = (List<StatusModel>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	@Override
	public StatusModel findBycaseModelIdInternal_First(
			long CaseModelId, boolean Internal,
			OrderByComparator<StatusModel> orderByComparator)
		throws NoSuchStatusModelException {

		StatusModel statusModel = fetchBycaseModelIdInternal_First(
			CaseModelId, Internal, orderByComparator);

		if (statusModel != null) {
			return statusModel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append(", Internal=");
		sb.append(Internal);

		sb.append("}");

		throw new NoSuchStatusModelException(sb.toString());
	}

	/**
	 * Returns the first status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching status model, or <code>null</code> if a matching status model could not be found
	 */
	@Override
	public StatusModel fetchBycaseModelIdInternal_First(
		long CaseModelId, boolean Internal,
		OrderByComparator<StatusModel> orderByComparator) {

		List<StatusModel> list = findBycaseModelIdInternal(
			CaseModelId, Internal, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model
	 * @throws NoSuchStatusModelException if a matching status model could not be found
	 */
	@Override
	public StatusModel findBycaseModelIdInternal_Last(
			long CaseModelId, boolean Internal,
			OrderByComparator<StatusModel> orderByComparator)
		throws NoSuchStatusModelException {

		StatusModel statusModel = fetchBycaseModelIdInternal_Last(
			CaseModelId, Internal, orderByComparator);

		if (statusModel != null) {
			return statusModel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append(", Internal=");
		sb.append(Internal);

		sb.append("}");

		throw new NoSuchStatusModelException(sb.toString());
	}

	/**
	 * Returns the last status model in the ordered set where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching status model, or <code>null</code> if a matching status model could not be found
	 */
	@Override
	public StatusModel fetchBycaseModelIdInternal_Last(
		long CaseModelId, boolean Internal,
		OrderByComparator<StatusModel> orderByComparator) {

		int count = countBycaseModelIdInternal(CaseModelId, Internal);

		if (count == 0) {
			return null;
		}

		List<StatusModel> list = findBycaseModelIdInternal(
			CaseModelId, Internal, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public StatusModel[] findBycaseModelIdInternal_PrevAndNext(
			long id, long CaseModelId, boolean Internal,
			OrderByComparator<StatusModel> orderByComparator)
		throws NoSuchStatusModelException {

		StatusModel statusModel = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StatusModel[] array = new StatusModelImpl[3];

			array[0] = getBycaseModelIdInternal_PrevAndNext(
				session, statusModel, CaseModelId, Internal, orderByComparator,
				true);

			array[1] = statusModel;

			array[2] = getBycaseModelIdInternal_PrevAndNext(
				session, statusModel, CaseModelId, Internal, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StatusModel getBycaseModelIdInternal_PrevAndNext(
		Session session, StatusModel statusModel, long CaseModelId,
		boolean Internal, OrderByComparator<StatusModel> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_STATUSMODEL_WHERE);

		sb.append(_FINDER_COLUMN_CASEMODELIDINTERNAL_CASEMODELID_2);

		sb.append(_FINDER_COLUMN_CASEMODELIDINTERNAL_INTERNAL_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StatusModelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(CaseModelId);

		queryPos.add(Internal);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(statusModel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StatusModel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the status models where CaseModelId = &#63; and Internal = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 */
	@Override
	public void removeBycaseModelIdInternal(
		long CaseModelId, boolean Internal) {

		for (StatusModel statusModel :
				findBycaseModelIdInternal(
					CaseModelId, Internal, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(statusModel);
		}
	}

	/**
	 * Returns the number of status models where CaseModelId = &#63; and Internal = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Internal the internal
	 * @return the number of matching status models
	 */
	@Override
	public int countBycaseModelIdInternal(long CaseModelId, boolean Internal) {
		FinderPath finderPath = _finderPathCountBycaseModelIdInternal;

		Object[] finderArgs = new Object[] {CaseModelId, Internal};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STATUSMODEL_WHERE);

			sb.append(_FINDER_COLUMN_CASEMODELIDINTERNAL_CASEMODELID_2);

			sb.append(_FINDER_COLUMN_CASEMODELIDINTERNAL_INTERNAL_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId);

				queryPos.add(Internal);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_CASEMODELIDINTERNAL_CASEMODELID_2 =
			"statusModel.CaseModelId = ? AND ";

	private static final String _FINDER_COLUMN_CASEMODELIDINTERNAL_INTERNAL_2 =
		"statusModel.Internal = ?";

	public StatusModelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(StatusModel.class);

		setModelImplClass(StatusModelImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the status model in the entity cache if it is enabled.
	 *
	 * @param statusModel the status model
	 */
	@Override
	public void cacheResult(StatusModel statusModel) {
		entityCache.putResult(
			StatusModelImpl.class, statusModel.getPrimaryKey(), statusModel);
	}

	/**
	 * Caches the status models in the entity cache if it is enabled.
	 *
	 * @param statusModels the status models
	 */
	@Override
	public void cacheResult(List<StatusModel> statusModels) {
		for (StatusModel statusModel : statusModels) {
			if (entityCache.getResult(
					StatusModelImpl.class, statusModel.getPrimaryKey()) ==
						null) {

				cacheResult(statusModel);
			}
		}
	}

	/**
	 * Clears the cache for all status models.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatusModelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the status model.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatusModel statusModel) {
		entityCache.removeResult(StatusModelImpl.class, statusModel);
	}

	@Override
	public void clearCache(List<StatusModel> statusModels) {
		for (StatusModel statusModel : statusModels) {
			entityCache.removeResult(StatusModelImpl.class, statusModel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StatusModelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new status model with the primary key. Does not add the status model to the database.
	 *
	 * @param id the primary key for the new status model
	 * @return the new status model
	 */
	@Override
	public StatusModel create(long id) {
		StatusModel statusModel = new StatusModelImpl();

		statusModel.setNew(true);
		statusModel.setPrimaryKey(id);

		return statusModel;
	}

	/**
	 * Removes the status model with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the status model
	 * @return the status model that was removed
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	@Override
	public StatusModel remove(long id) throws NoSuchStatusModelException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the status model with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the status model
	 * @return the status model that was removed
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	@Override
	public StatusModel remove(Serializable primaryKey)
		throws NoSuchStatusModelException {

		Session session = null;

		try {
			session = openSession();

			StatusModel statusModel = (StatusModel)session.get(
				StatusModelImpl.class, primaryKey);

			if (statusModel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatusModelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(statusModel);
		}
		catch (NoSuchStatusModelException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected StatusModel removeImpl(StatusModel statusModel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statusModel)) {
				statusModel = (StatusModel)session.get(
					StatusModelImpl.class, statusModel.getPrimaryKeyObj());
			}

			if (statusModel != null) {
				session.delete(statusModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (statusModel != null) {
			clearCache(statusModel);
		}

		return statusModel;
	}

	@Override
	public StatusModel updateImpl(StatusModel statusModel) {
		boolean isNew = statusModel.isNew();

		if (!(statusModel instanceof StatusModelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(statusModel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(statusModel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in statusModel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StatusModel implementation " +
					statusModel.getClass());
		}

		StatusModelModelImpl statusModelModelImpl =
			(StatusModelModelImpl)statusModel;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(statusModel);
			}
			else {
				statusModel = (StatusModel)session.merge(statusModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			StatusModelImpl.class, statusModelModelImpl, false, true);

		if (isNew) {
			statusModel.setNew(false);
		}

		statusModel.resetOriginalValues();

		return statusModel;
	}

	/**
	 * Returns the status model with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the status model
	 * @return the status model
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	@Override
	public StatusModel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatusModelException {

		StatusModel statusModel = fetchByPrimaryKey(primaryKey);

		if (statusModel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatusModelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return statusModel;
	}

	/**
	 * Returns the status model with the primary key or throws a <code>NoSuchStatusModelException</code> if it could not be found.
	 *
	 * @param id the primary key of the status model
	 * @return the status model
	 * @throws NoSuchStatusModelException if a status model with the primary key could not be found
	 */
	@Override
	public StatusModel findByPrimaryKey(long id)
		throws NoSuchStatusModelException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the status model with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the status model
	 * @return the status model, or <code>null</code> if a status model with the primary key could not be found
	 */
	@Override
	public StatusModel fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the status models.
	 *
	 * @return the status models
	 */
	@Override
	public List<StatusModel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StatusModel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<StatusModel> findAll(
		int start, int end, OrderByComparator<StatusModel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<StatusModel> findAll(
		int start, int end, OrderByComparator<StatusModel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<StatusModel> list = null;

		if (useFinderCache) {
			list = (List<StatusModel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STATUSMODEL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STATUSMODEL;

				sql = sql.concat(StatusModelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StatusModel>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the status models from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StatusModel statusModel : findAll()) {
			remove(statusModel);
		}
	}

	/**
	 * Returns the number of status models.
	 *
	 * @return the number of status models
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STATUSMODEL);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STATUSMODEL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StatusModelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the status model persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new StatusModelModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", StatusModel.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindBycaseModelId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycaseModelId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"CaseModelId"}, true);

		_finderPathWithoutPaginationFindBycaseModelId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycaseModelId",
			new String[] {Long.class.getName()}, new String[] {"CaseModelId"},
			true);

		_finderPathCountBycaseModelId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycaseModelId",
			new String[] {Long.class.getName()}, new String[] {"CaseModelId"},
			false);

		_finderPathWithPaginationFindBycaseModelIdInternal = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycaseModelIdInternal",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"CaseModelId", "Internal"}, true);

		_finderPathWithoutPaginationFindBycaseModelIdInternal =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBycaseModelIdInternal",
				new String[] {Long.class.getName(), Boolean.class.getName()},
				new String[] {"CaseModelId", "Internal"}, true);

		_finderPathCountBycaseModelIdInternal = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycaseModelIdInternal",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"CaseModelId", "Internal"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StatusModelImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = stockePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = stockePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = stockePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STATUSMODEL =
		"SELECT statusModel FROM StatusModel statusModel";

	private static final String _SQL_SELECT_STATUSMODEL_WHERE =
		"SELECT statusModel FROM StatusModel statusModel WHERE ";

	private static final String _SQL_COUNT_STATUSMODEL =
		"SELECT COUNT(statusModel) FROM StatusModel statusModel";

	private static final String _SQL_COUNT_STATUSMODEL_WHERE =
		"SELECT COUNT(statusModel) FROM StatusModel statusModel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "statusModel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StatusModel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StatusModel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StatusModelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class StatusModelModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			StatusModelModelImpl statusModelModelImpl =
				(StatusModelModelImpl)baseModel;

			long columnBitmask = statusModelModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(statusModelModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						statusModelModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(statusModelModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			StatusModelModelImpl statusModelModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = statusModelModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = statusModelModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}
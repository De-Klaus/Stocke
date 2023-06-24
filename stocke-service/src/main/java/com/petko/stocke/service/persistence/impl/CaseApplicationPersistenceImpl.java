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

import com.petko.stocke.exception.NoSuchCaseApplicationException;
import com.petko.stocke.model.CaseApplication;
import com.petko.stocke.model.impl.CaseApplicationImpl;
import com.petko.stocke.model.impl.CaseApplicationModelImpl;
import com.petko.stocke.service.persistence.CaseApplicationPersistence;
import com.petko.stocke.service.persistence.impl.constants.stockePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
 * The persistence implementation for the case application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author petko
 * @generated
 */
@Component(service = CaseApplicationPersistence.class)
public class CaseApplicationPersistenceImpl
	extends BasePersistenceImpl<CaseApplication>
	implements CaseApplicationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CaseApplicationUtil</code> to access the case application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CaseApplicationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBybyCaseModelId;
	private FinderPath _finderPathWithoutPaginationFindBybyCaseModelId;
	private FinderPath _finderPathCountBybyCaseModelId;

	/**
	 * Returns all the case applications where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	@Override
	public List<CaseApplication> findBybyCaseModelId(Long CaseModelId) {
		return findBybyCaseModelId(
			CaseModelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case applications where CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	@Override
	public List<CaseApplication> findBybyCaseModelId(
		Long CaseModelId, int start, int end) {

		return findBybyCaseModelId(CaseModelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findBybyCaseModelId(
		Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return findBybyCaseModelId(
			CaseModelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findBybyCaseModelId(
		Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBybyCaseModelId;
				finderArgs = new Object[] {CaseModelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBybyCaseModelId;
			finderArgs = new Object[] {
				CaseModelId, start, end, orderByComparator
			};
		}

		List<CaseApplication> list = null;

		if (useFinderCache) {
			list = (List<CaseApplication>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CaseApplication caseApplication : list) {
					if (!Objects.equals(
							CaseModelId, caseApplication.getCaseModelId())) {

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

			sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_BYCASEMODELID_CASEMODELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId.longValue());

				list = (List<CaseApplication>)QueryUtil.list(
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
	 * Returns the first case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findBybyCaseModelId_First(
			Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchBybyCaseModelId_First(
			CaseModelId, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchBybyCaseModelId_First(
		Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		List<CaseApplication> list = findBybyCaseModelId(
			CaseModelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findBybyCaseModelId_Last(
			Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchBybyCaseModelId_Last(
			CaseModelId, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchBybyCaseModelId_Last(
		Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		int count = countBybyCaseModelId(CaseModelId);

		if (count == 0) {
			return null;
		}

		List<CaseApplication> list = findBybyCaseModelId(
			CaseModelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication[] findBybyCaseModelId_PrevAndNext(
			long id, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CaseApplication[] array = new CaseApplicationImpl[3];

			array[0] = getBybyCaseModelId_PrevAndNext(
				session, caseApplication, CaseModelId, orderByComparator, true);

			array[1] = caseApplication;

			array[2] = getBybyCaseModelId_PrevAndNext(
				session, caseApplication, CaseModelId, orderByComparator,
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

	protected CaseApplication getBybyCaseModelId_PrevAndNext(
		Session session, CaseApplication caseApplication, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

		sb.append(_FINDER_COLUMN_BYCASEMODELID_CASEMODELID_2);

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
			sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(CaseModelId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						caseApplication)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CaseApplication> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case applications where CaseModelId = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 */
	@Override
	public void removeBybyCaseModelId(Long CaseModelId) {
		for (CaseApplication caseApplication :
				findBybyCaseModelId(
					CaseModelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(caseApplication);
		}
	}

	/**
	 * Returns the number of case applications where CaseModelId = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	@Override
	public int countBybyCaseModelId(Long CaseModelId) {
		FinderPath finderPath = _finderPathCountBybyCaseModelId;

		Object[] finderArgs = new Object[] {CaseModelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_BYCASEMODELID_CASEMODELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId.longValue());

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

	private static final String _FINDER_COLUMN_BYCASEMODELID_CASEMODELID_2 =
		"caseApplication.CaseModelId = ?";

	private FinderPath _finderPathWithPaginationFindByActive;
	private FinderPath _finderPathWithoutPaginationFindByActive;
	private FinderPath _finderPathCountByActive;

	/**
	 * Returns all the case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	@Override
	public List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId) {

		return findByActive(
			Active, CaseModelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId, int start, int end) {

		return findByActive(Active, CaseModelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return findByActive(
			Active, CaseModelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByActive(
		boolean Active, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByActive;
				finderArgs = new Object[] {Active, CaseModelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByActive;
			finderArgs = new Object[] {
				Active, CaseModelId, start, end, orderByComparator
			};
		}

		List<CaseApplication> list = null;

		if (useFinderCache) {
			list = (List<CaseApplication>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CaseApplication caseApplication : list) {
					if ((Active != caseApplication.isActive()) ||
						!Objects.equals(
							CaseModelId, caseApplication.getCaseModelId())) {

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

			sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			sb.append(_FINDER_COLUMN_ACTIVE_CASEMODELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(Active);

				queryPos.add(CaseModelId.longValue());

				list = (List<CaseApplication>)QueryUtil.list(
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
	 * Returns the first case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByActive_First(
			boolean Active, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByActive_First(
			Active, CaseModelId, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Active=");
		sb.append(Active);

		sb.append(", CaseModelId=");
		sb.append(CaseModelId);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the first case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByActive_First(
		boolean Active, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		List<CaseApplication> list = findByActive(
			Active, CaseModelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByActive_Last(
			boolean Active, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByActive_Last(
			Active, CaseModelId, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Active=");
		sb.append(Active);

		sb.append(", CaseModelId=");
		sb.append(CaseModelId);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the last case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByActive_Last(
		boolean Active, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		int count = countByActive(Active, CaseModelId);

		if (count == 0) {
			return null;
		}

		List<CaseApplication> list = findByActive(
			Active, CaseModelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication[] findByActive_PrevAndNext(
			long id, boolean Active, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CaseApplication[] array = new CaseApplicationImpl[3];

			array[0] = getByActive_PrevAndNext(
				session, caseApplication, Active, CaseModelId,
				orderByComparator, true);

			array[1] = caseApplication;

			array[2] = getByActive_PrevAndNext(
				session, caseApplication, Active, CaseModelId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CaseApplication getByActive_PrevAndNext(
		Session session, CaseApplication caseApplication, boolean Active,
		Long CaseModelId, OrderByComparator<CaseApplication> orderByComparator,
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

		sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

		sb.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

		sb.append(_FINDER_COLUMN_ACTIVE_CASEMODELID_2);

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
			sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(Active);

		queryPos.add(CaseModelId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						caseApplication)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CaseApplication> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case applications where Active = &#63; and CaseModelId = &#63; from the database.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 */
	@Override
	public void removeByActive(boolean Active, Long CaseModelId) {
		for (CaseApplication caseApplication :
				findByActive(
					Active, CaseModelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(caseApplication);
		}
	}

	/**
	 * Returns the number of case applications where Active = &#63; and CaseModelId = &#63;.
	 *
	 * @param Active the active
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	@Override
	public int countByActive(boolean Active, Long CaseModelId) {
		FinderPath finderPath = _finderPathCountByActive;

		Object[] finderArgs = new Object[] {Active, CaseModelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			sb.append(_FINDER_COLUMN_ACTIVE_CASEMODELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(Active);

				queryPos.add(CaseModelId.longValue());

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 =
		"caseApplication.Active = ? AND ";

	private static final String _FINDER_COLUMN_ACTIVE_CASEMODELID_2 =
		"caseApplication.CaseModelId = ?";

	private FinderPath _finderPathWithPaginationFindByArchive;
	private FinderPath _finderPathWithoutPaginationFindByArchive;
	private FinderPath _finderPathCountByArchive;

	/**
	 * Returns all the case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	@Override
	public List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId) {

		return findByArchive(
			Archive, CaseModelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId, int start, int end) {

		return findByArchive(Archive, CaseModelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return findByArchive(
			Archive, CaseModelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByArchive(
		boolean Archive, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByArchive;
				finderArgs = new Object[] {Archive, CaseModelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByArchive;
			finderArgs = new Object[] {
				Archive, CaseModelId, start, end, orderByComparator
			};
		}

		List<CaseApplication> list = null;

		if (useFinderCache) {
			list = (List<CaseApplication>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CaseApplication caseApplication : list) {
					if ((Archive != caseApplication.isArchive()) ||
						!Objects.equals(
							CaseModelId, caseApplication.getCaseModelId())) {

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

			sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_2);

			sb.append(_FINDER_COLUMN_ARCHIVE_CASEMODELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(Archive);

				queryPos.add(CaseModelId.longValue());

				list = (List<CaseApplication>)QueryUtil.list(
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
	 * Returns the first case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByArchive_First(
			boolean Archive, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByArchive_First(
			Archive, CaseModelId, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Archive=");
		sb.append(Archive);

		sb.append(", CaseModelId=");
		sb.append(CaseModelId);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the first case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByArchive_First(
		boolean Archive, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		List<CaseApplication> list = findByArchive(
			Archive, CaseModelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByArchive_Last(
			boolean Archive, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByArchive_Last(
			Archive, CaseModelId, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Archive=");
		sb.append(Archive);

		sb.append(", CaseModelId=");
		sb.append(CaseModelId);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the last case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByArchive_Last(
		boolean Archive, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		int count = countByArchive(Archive, CaseModelId);

		if (count == 0) {
			return null;
		}

		List<CaseApplication> list = findByArchive(
			Archive, CaseModelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication[] findByArchive_PrevAndNext(
			long id, boolean Archive, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CaseApplication[] array = new CaseApplicationImpl[3];

			array[0] = getByArchive_PrevAndNext(
				session, caseApplication, Archive, CaseModelId,
				orderByComparator, true);

			array[1] = caseApplication;

			array[2] = getByArchive_PrevAndNext(
				session, caseApplication, Archive, CaseModelId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CaseApplication getByArchive_PrevAndNext(
		Session session, CaseApplication caseApplication, boolean Archive,
		Long CaseModelId, OrderByComparator<CaseApplication> orderByComparator,
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

		sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

		sb.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_2);

		sb.append(_FINDER_COLUMN_ARCHIVE_CASEMODELID_2);

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
			sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(Archive);

		queryPos.add(CaseModelId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						caseApplication)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CaseApplication> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case applications where Archive = &#63; and CaseModelId = &#63; from the database.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 */
	@Override
	public void removeByArchive(boolean Archive, Long CaseModelId) {
		for (CaseApplication caseApplication :
				findByArchive(
					Archive, CaseModelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(caseApplication);
		}
	}

	/**
	 * Returns the number of case applications where Archive = &#63; and CaseModelId = &#63;.
	 *
	 * @param Archive the archive
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	@Override
	public int countByArchive(boolean Archive, Long CaseModelId) {
		FinderPath finderPath = _finderPathCountByArchive;

		Object[] finderArgs = new Object[] {Archive, CaseModelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_2);

			sb.append(_FINDER_COLUMN_ARCHIVE_CASEMODELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(Archive);

				queryPos.add(CaseModelId.longValue());

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

	private static final String _FINDER_COLUMN_ARCHIVE_ARCHIVE_2 =
		"caseApplication.Archive = ? AND ";

	private static final String _FINDER_COLUMN_ARCHIVE_CASEMODELID_2 =
		"caseApplication.CaseModelId = ?";

	private FinderPath _finderPathWithPaginationFindByHidden;
	private FinderPath _finderPathWithoutPaginationFindByHidden;
	private FinderPath _finderPathCountByHidden;

	/**
	 * Returns all the case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @return the matching case applications
	 */
	@Override
	public List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId) {

		return findByHidden(
			Hidden, CaseModelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId, int start, int end) {

		return findByHidden(Hidden, CaseModelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return findByHidden(
			Hidden, CaseModelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByHidden(
		boolean Hidden, Long CaseModelId, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByHidden;
				finderArgs = new Object[] {Hidden, CaseModelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByHidden;
			finderArgs = new Object[] {
				Hidden, CaseModelId, start, end, orderByComparator
			};
		}

		List<CaseApplication> list = null;

		if (useFinderCache) {
			list = (List<CaseApplication>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CaseApplication caseApplication : list) {
					if ((Hidden != caseApplication.isHidden()) ||
						!Objects.equals(
							CaseModelId, caseApplication.getCaseModelId())) {

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

			sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_HIDDEN_HIDDEN_2);

			sb.append(_FINDER_COLUMN_HIDDEN_CASEMODELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(Hidden);

				queryPos.add(CaseModelId.longValue());

				list = (List<CaseApplication>)QueryUtil.list(
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
	 * Returns the first case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByHidden_First(
			boolean Hidden, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByHidden_First(
			Hidden, CaseModelId, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Hidden=");
		sb.append(Hidden);

		sb.append(", CaseModelId=");
		sb.append(CaseModelId);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the first case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByHidden_First(
		boolean Hidden, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		List<CaseApplication> list = findByHidden(
			Hidden, CaseModelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByHidden_Last(
			boolean Hidden, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByHidden_Last(
			Hidden, CaseModelId, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Hidden=");
		sb.append(Hidden);

		sb.append(", CaseModelId=");
		sb.append(CaseModelId);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the last case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByHidden_Last(
		boolean Hidden, Long CaseModelId,
		OrderByComparator<CaseApplication> orderByComparator) {

		int count = countByHidden(Hidden, CaseModelId);

		if (count == 0) {
			return null;
		}

		List<CaseApplication> list = findByHidden(
			Hidden, CaseModelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication[] findByHidden_PrevAndNext(
			long id, boolean Hidden, Long CaseModelId,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CaseApplication[] array = new CaseApplicationImpl[3];

			array[0] = getByHidden_PrevAndNext(
				session, caseApplication, Hidden, CaseModelId,
				orderByComparator, true);

			array[1] = caseApplication;

			array[2] = getByHidden_PrevAndNext(
				session, caseApplication, Hidden, CaseModelId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CaseApplication getByHidden_PrevAndNext(
		Session session, CaseApplication caseApplication, boolean Hidden,
		Long CaseModelId, OrderByComparator<CaseApplication> orderByComparator,
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

		sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

		sb.append(_FINDER_COLUMN_HIDDEN_HIDDEN_2);

		sb.append(_FINDER_COLUMN_HIDDEN_CASEMODELID_2);

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
			sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(Hidden);

		queryPos.add(CaseModelId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						caseApplication)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CaseApplication> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case applications where Hidden = &#63; and CaseModelId = &#63; from the database.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 */
	@Override
	public void removeByHidden(boolean Hidden, Long CaseModelId) {
		for (CaseApplication caseApplication :
				findByHidden(
					Hidden, CaseModelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(caseApplication);
		}
	}

	/**
	 * Returns the number of case applications where Hidden = &#63; and CaseModelId = &#63;.
	 *
	 * @param Hidden the hidden
	 * @param CaseModelId the case model ID
	 * @return the number of matching case applications
	 */
	@Override
	public int countByHidden(boolean Hidden, Long CaseModelId) {
		FinderPath finderPath = _finderPathCountByHidden;

		Object[] finderArgs = new Object[] {Hidden, CaseModelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_HIDDEN_HIDDEN_2);

			sb.append(_FINDER_COLUMN_HIDDEN_CASEMODELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(Hidden);

				queryPos.add(CaseModelId.longValue());

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

	private static final String _FINDER_COLUMN_HIDDEN_HIDDEN_2 =
		"caseApplication.Hidden = ? AND ";

	private static final String _FINDER_COLUMN_HIDDEN_CASEMODELID_2 =
		"caseApplication.CaseModelId = ?";

	private FinderPath _finderPathWithPaginationFindByStatusCase;
	private FinderPath _finderPathWithoutPaginationFindByStatusCase;
	private FinderPath _finderPathCountByStatusCase;

	/**
	 * Returns all the case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @return the matching case applications
	 */
	@Override
	public List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status) {

		return findByStatusCase(
			CaseModelId, Status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status, int start, int end) {

		return findByStatusCase(CaseModelId, Status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return findByStatusCase(
			CaseModelId, Status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByStatusCase(
		Long CaseModelId, String Status, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		Status = Objects.toString(Status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatusCase;
				finderArgs = new Object[] {CaseModelId, Status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatusCase;
			finderArgs = new Object[] {
				CaseModelId, Status, start, end, orderByComparator
			};
		}

		List<CaseApplication> list = null;

		if (useFinderCache) {
			list = (List<CaseApplication>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CaseApplication caseApplication : list) {
					if (!Objects.equals(
							CaseModelId, caseApplication.getCaseModelId()) ||
						!Status.equals(caseApplication.getStatus())) {

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

			sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_STATUSCASE_CASEMODELID_2);

			boolean bindStatus = false;

			if (Status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUSCASE_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUSCASE_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId.longValue());

				if (bindStatus) {
					queryPos.add(Status);
				}

				list = (List<CaseApplication>)QueryUtil.list(
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
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByStatusCase_First(
			Long CaseModelId, String Status,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByStatusCase_First(
			CaseModelId, Status, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append(", Status=");
		sb.append(Status);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByStatusCase_First(
		Long CaseModelId, String Status,
		OrderByComparator<CaseApplication> orderByComparator) {

		List<CaseApplication> list = findByStatusCase(
			CaseModelId, Status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByStatusCase_Last(
			Long CaseModelId, String Status,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByStatusCase_Last(
			CaseModelId, Status, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append(", Status=");
		sb.append(Status);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByStatusCase_Last(
		Long CaseModelId, String Status,
		OrderByComparator<CaseApplication> orderByComparator) {

		int count = countByStatusCase(CaseModelId, Status);

		if (count == 0) {
			return null;
		}

		List<CaseApplication> list = findByStatusCase(
			CaseModelId, Status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication[] findByStatusCase_PrevAndNext(
			long id, Long CaseModelId, String Status,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		Status = Objects.toString(Status, "");

		CaseApplication caseApplication = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CaseApplication[] array = new CaseApplicationImpl[3];

			array[0] = getByStatusCase_PrevAndNext(
				session, caseApplication, CaseModelId, Status,
				orderByComparator, true);

			array[1] = caseApplication;

			array[2] = getByStatusCase_PrevAndNext(
				session, caseApplication, CaseModelId, Status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CaseApplication getByStatusCase_PrevAndNext(
		Session session, CaseApplication caseApplication, Long CaseModelId,
		String Status, OrderByComparator<CaseApplication> orderByComparator,
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

		sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

		sb.append(_FINDER_COLUMN_STATUSCASE_CASEMODELID_2);

		boolean bindStatus = false;

		if (Status.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATUSCASE_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_STATUSCASE_STATUS_2);
		}

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
			sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(CaseModelId.longValue());

		if (bindStatus) {
			queryPos.add(Status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						caseApplication)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CaseApplication> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case applications where CaseModelId = &#63; and Status = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 */
	@Override
	public void removeByStatusCase(Long CaseModelId, String Status) {
		for (CaseApplication caseApplication :
				findByStatusCase(
					CaseModelId, Status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(caseApplication);
		}
	}

	/**
	 * Returns the number of case applications where CaseModelId = &#63; and Status = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param Status the status
	 * @return the number of matching case applications
	 */
	@Override
	public int countByStatusCase(Long CaseModelId, String Status) {
		Status = Objects.toString(Status, "");

		FinderPath finderPath = _finderPathCountByStatusCase;

		Object[] finderArgs = new Object[] {CaseModelId, Status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_STATUSCASE_CASEMODELID_2);

			boolean bindStatus = false;

			if (Status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUSCASE_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUSCASE_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId.longValue());

				if (bindStatus) {
					queryPos.add(Status);
				}

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

	private static final String _FINDER_COLUMN_STATUSCASE_CASEMODELID_2 =
		"caseApplication.CaseModelId = ? AND ";

	private static final String _FINDER_COLUMN_STATUSCASE_STATUS_2 =
		"caseApplication.Status = ?";

	private static final String _FINDER_COLUMN_STATUSCASE_STATUS_3 =
		"(caseApplication.Status IS NULL OR caseApplication.Status = '')";

	private FinderPath _finderPathWithPaginationFindByStartDate;
	private FinderPath _finderPathWithoutPaginationFindByStartDate;
	private FinderPath _finderPathCountByStartDate;

	/**
	 * Returns all the case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @return the matching case applications
	 */
	@Override
	public List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate) {

		return findByStartDate(
			CaseModelId, StartDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate, int start, int end) {

		return findByStartDate(CaseModelId, StartDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return findByStartDate(
			CaseModelId, StartDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByStartDate(
		Long CaseModelId, Date StartDate, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStartDate;
				finderArgs = new Object[] {CaseModelId, _getTime(StartDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStartDate;
			finderArgs = new Object[] {
				CaseModelId, _getTime(StartDate), start, end, orderByComparator
			};
		}

		List<CaseApplication> list = null;

		if (useFinderCache) {
			list = (List<CaseApplication>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CaseApplication caseApplication : list) {
					if (!Objects.equals(
							CaseModelId, caseApplication.getCaseModelId()) ||
						!Objects.equals(
							StartDate, caseApplication.getStartDate())) {

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

			sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_STARTDATE_CASEMODELID_2);

			boolean bindStartDate = false;

			if (StartDate == null) {
				sb.append(_FINDER_COLUMN_STARTDATE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_STARTDATE_STARTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId.longValue());

				if (bindStartDate) {
					queryPos.add(new Timestamp(StartDate.getTime()));
				}

				list = (List<CaseApplication>)QueryUtil.list(
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
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByStartDate_First(
			Long CaseModelId, Date StartDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByStartDate_First(
			CaseModelId, StartDate, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append(", StartDate=");
		sb.append(StartDate);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByStartDate_First(
		Long CaseModelId, Date StartDate,
		OrderByComparator<CaseApplication> orderByComparator) {

		List<CaseApplication> list = findByStartDate(
			CaseModelId, StartDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByStartDate_Last(
			Long CaseModelId, Date StartDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByStartDate_Last(
			CaseModelId, StartDate, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append(", StartDate=");
		sb.append(StartDate);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByStartDate_Last(
		Long CaseModelId, Date StartDate,
		OrderByComparator<CaseApplication> orderByComparator) {

		int count = countByStartDate(CaseModelId, StartDate);

		if (count == 0) {
			return null;
		}

		List<CaseApplication> list = findByStartDate(
			CaseModelId, StartDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication[] findByStartDate_PrevAndNext(
			long id, Long CaseModelId, Date StartDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CaseApplication[] array = new CaseApplicationImpl[3];

			array[0] = getByStartDate_PrevAndNext(
				session, caseApplication, CaseModelId, StartDate,
				orderByComparator, true);

			array[1] = caseApplication;

			array[2] = getByStartDate_PrevAndNext(
				session, caseApplication, CaseModelId, StartDate,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CaseApplication getByStartDate_PrevAndNext(
		Session session, CaseApplication caseApplication, Long CaseModelId,
		Date StartDate, OrderByComparator<CaseApplication> orderByComparator,
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

		sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

		sb.append(_FINDER_COLUMN_STARTDATE_CASEMODELID_2);

		boolean bindStartDate = false;

		if (StartDate == null) {
			sb.append(_FINDER_COLUMN_STARTDATE_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			sb.append(_FINDER_COLUMN_STARTDATE_STARTDATE_2);
		}

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
			sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(CaseModelId.longValue());

		if (bindStartDate) {
			queryPos.add(new Timestamp(StartDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						caseApplication)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CaseApplication> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case applications where CaseModelId = &#63; and StartDate = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 */
	@Override
	public void removeByStartDate(Long CaseModelId, Date StartDate) {
		for (CaseApplication caseApplication :
				findByStartDate(
					CaseModelId, StartDate, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(caseApplication);
		}
	}

	/**
	 * Returns the number of case applications where CaseModelId = &#63; and StartDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param StartDate the start date
	 * @return the number of matching case applications
	 */
	@Override
	public int countByStartDate(Long CaseModelId, Date StartDate) {
		FinderPath finderPath = _finderPathCountByStartDate;

		Object[] finderArgs = new Object[] {CaseModelId, _getTime(StartDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_STARTDATE_CASEMODELID_2);

			boolean bindStartDate = false;

			if (StartDate == null) {
				sb.append(_FINDER_COLUMN_STARTDATE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_STARTDATE_STARTDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId.longValue());

				if (bindStartDate) {
					queryPos.add(new Timestamp(StartDate.getTime()));
				}

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

	private static final String _FINDER_COLUMN_STARTDATE_CASEMODELID_2 =
		"caseApplication.CaseModelId = ? AND ";

	private static final String _FINDER_COLUMN_STARTDATE_STARTDATE_1 =
		"caseApplication.StartDate IS NULL";

	private static final String _FINDER_COLUMN_STARTDATE_STARTDATE_2 =
		"caseApplication.StartDate = ?";

	private FinderPath _finderPathWithPaginationFindByEndDate;
	private FinderPath _finderPathWithoutPaginationFindByEndDate;
	private FinderPath _finderPathCountByEndDate;

	/**
	 * Returns all the case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @return the matching case applications
	 */
	@Override
	public List<CaseApplication> findByEndDate(Long CaseModelId, Date EndDate) {
		return findByEndDate(
			CaseModelId, EndDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByEndDate(
		Long CaseModelId, Date EndDate, int start, int end) {

		return findByEndDate(CaseModelId, EndDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByEndDate(
		Long CaseModelId, Date EndDate, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return findByEndDate(
			CaseModelId, EndDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case applications
	 */
	@Override
	public List<CaseApplication> findByEndDate(
		Long CaseModelId, Date EndDate, int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEndDate;
				finderArgs = new Object[] {CaseModelId, _getTime(EndDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEndDate;
			finderArgs = new Object[] {
				CaseModelId, _getTime(EndDate), start, end, orderByComparator
			};
		}

		List<CaseApplication> list = null;

		if (useFinderCache) {
			list = (List<CaseApplication>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CaseApplication caseApplication : list) {
					if (!Objects.equals(
							CaseModelId, caseApplication.getCaseModelId()) ||
						!Objects.equals(
							EndDate, caseApplication.getEndDate())) {

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

			sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_ENDDATE_CASEMODELID_2);

			boolean bindEndDate = false;

			if (EndDate == null) {
				sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId.longValue());

				if (bindEndDate) {
					queryPos.add(new Timestamp(EndDate.getTime()));
				}

				list = (List<CaseApplication>)QueryUtil.list(
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
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByEndDate_First(
			Long CaseModelId, Date EndDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByEndDate_First(
			CaseModelId, EndDate, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append(", EndDate=");
		sb.append(EndDate);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the first case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByEndDate_First(
		Long CaseModelId, Date EndDate,
		OrderByComparator<CaseApplication> orderByComparator) {

		List<CaseApplication> list = findByEndDate(
			CaseModelId, EndDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application
	 * @throws NoSuchCaseApplicationException if a matching case application could not be found
	 */
	@Override
	public CaseApplication findByEndDate_Last(
			Long CaseModelId, Date EndDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByEndDate_Last(
			CaseModelId, EndDate, orderByComparator);

		if (caseApplication != null) {
			return caseApplication;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CaseModelId=");
		sb.append(CaseModelId);

		sb.append(", EndDate=");
		sb.append(EndDate);

		sb.append("}");

		throw new NoSuchCaseApplicationException(sb.toString());
	}

	/**
	 * Returns the last case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case application, or <code>null</code> if a matching case application could not be found
	 */
	@Override
	public CaseApplication fetchByEndDate_Last(
		Long CaseModelId, Date EndDate,
		OrderByComparator<CaseApplication> orderByComparator) {

		int count = countByEndDate(CaseModelId, EndDate);

		if (count == 0) {
			return null;
		}

		List<CaseApplication> list = findByEndDate(
			CaseModelId, EndDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the case applications before and after the current case application in the ordered set where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param id the primary key of the current case application
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication[] findByEndDate_PrevAndNext(
			long id, Long CaseModelId, Date EndDate,
			OrderByComparator<CaseApplication> orderByComparator)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CaseApplication[] array = new CaseApplicationImpl[3];

			array[0] = getByEndDate_PrevAndNext(
				session, caseApplication, CaseModelId, EndDate,
				orderByComparator, true);

			array[1] = caseApplication;

			array[2] = getByEndDate_PrevAndNext(
				session, caseApplication, CaseModelId, EndDate,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CaseApplication getByEndDate_PrevAndNext(
		Session session, CaseApplication caseApplication, Long CaseModelId,
		Date EndDate, OrderByComparator<CaseApplication> orderByComparator,
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

		sb.append(_SQL_SELECT_CASEAPPLICATION_WHERE);

		sb.append(_FINDER_COLUMN_ENDDATE_CASEMODELID_2);

		boolean bindEndDate = false;

		if (EndDate == null) {
			sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
		}

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
			sb.append(CaseApplicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(CaseModelId.longValue());

		if (bindEndDate) {
			queryPos.add(new Timestamp(EndDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						caseApplication)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CaseApplication> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case applications where CaseModelId = &#63; and EndDate = &#63; from the database.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 */
	@Override
	public void removeByEndDate(Long CaseModelId, Date EndDate) {
		for (CaseApplication caseApplication :
				findByEndDate(
					CaseModelId, EndDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(caseApplication);
		}
	}

	/**
	 * Returns the number of case applications where CaseModelId = &#63; and EndDate = &#63;.
	 *
	 * @param CaseModelId the case model ID
	 * @param EndDate the end date
	 * @return the number of matching case applications
	 */
	@Override
	public int countByEndDate(Long CaseModelId, Date EndDate) {
		FinderPath finderPath = _finderPathCountByEndDate;

		Object[] finderArgs = new Object[] {CaseModelId, _getTime(EndDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CASEAPPLICATION_WHERE);

			sb.append(_FINDER_COLUMN_ENDDATE_CASEMODELID_2);

			boolean bindEndDate = false;

			if (EndDate == null) {
				sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CaseModelId.longValue());

				if (bindEndDate) {
					queryPos.add(new Timestamp(EndDate.getTime()));
				}

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

	private static final String _FINDER_COLUMN_ENDDATE_CASEMODELID_2 =
		"caseApplication.CaseModelId = ? AND ";

	private static final String _FINDER_COLUMN_ENDDATE_ENDDATE_1 =
		"caseApplication.EndDate IS NULL";

	private static final String _FINDER_COLUMN_ENDDATE_ENDDATE_2 =
		"caseApplication.EndDate = ?";

	public CaseApplicationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CaseApplication.class);

		setModelImplClass(CaseApplicationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the case application in the entity cache if it is enabled.
	 *
	 * @param caseApplication the case application
	 */
	@Override
	public void cacheResult(CaseApplication caseApplication) {
		entityCache.putResult(
			CaseApplicationImpl.class, caseApplication.getPrimaryKey(),
			caseApplication);
	}

	/**
	 * Caches the case applications in the entity cache if it is enabled.
	 *
	 * @param caseApplications the case applications
	 */
	@Override
	public void cacheResult(List<CaseApplication> caseApplications) {
		for (CaseApplication caseApplication : caseApplications) {
			if (entityCache.getResult(
					CaseApplicationImpl.class,
					caseApplication.getPrimaryKey()) == null) {

				cacheResult(caseApplication);
			}
		}
	}

	/**
	 * Clears the cache for all case applications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CaseApplicationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the case application.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CaseApplication caseApplication) {
		entityCache.removeResult(CaseApplicationImpl.class, caseApplication);
	}

	@Override
	public void clearCache(List<CaseApplication> caseApplications) {
		for (CaseApplication caseApplication : caseApplications) {
			entityCache.removeResult(
				CaseApplicationImpl.class, caseApplication);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CaseApplicationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new case application with the primary key. Does not add the case application to the database.
	 *
	 * @param id the primary key for the new case application
	 * @return the new case application
	 */
	@Override
	public CaseApplication create(long id) {
		CaseApplication caseApplication = new CaseApplicationImpl();

		caseApplication.setNew(true);
		caseApplication.setPrimaryKey(id);

		return caseApplication;
	}

	/**
	 * Removes the case application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the case application
	 * @return the case application that was removed
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication remove(long id)
		throws NoSuchCaseApplicationException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the case application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the case application
	 * @return the case application that was removed
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication remove(Serializable primaryKey)
		throws NoSuchCaseApplicationException {

		Session session = null;

		try {
			session = openSession();

			CaseApplication caseApplication = (CaseApplication)session.get(
				CaseApplicationImpl.class, primaryKey);

			if (caseApplication == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCaseApplicationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(caseApplication);
		}
		catch (NoSuchCaseApplicationException noSuchEntityException) {
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
	protected CaseApplication removeImpl(CaseApplication caseApplication) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(caseApplication)) {
				caseApplication = (CaseApplication)session.get(
					CaseApplicationImpl.class,
					caseApplication.getPrimaryKeyObj());
			}

			if (caseApplication != null) {
				session.delete(caseApplication);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (caseApplication != null) {
			clearCache(caseApplication);
		}

		return caseApplication;
	}

	@Override
	public CaseApplication updateImpl(CaseApplication caseApplication) {
		boolean isNew = caseApplication.isNew();

		if (!(caseApplication instanceof CaseApplicationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(caseApplication.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					caseApplication);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in caseApplication proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CaseApplication implementation " +
					caseApplication.getClass());
		}

		CaseApplicationModelImpl caseApplicationModelImpl =
			(CaseApplicationModelImpl)caseApplication;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(caseApplication);
			}
			else {
				caseApplication = (CaseApplication)session.merge(
					caseApplication);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CaseApplicationImpl.class, caseApplicationModelImpl, false, true);

		if (isNew) {
			caseApplication.setNew(false);
		}

		caseApplication.resetOriginalValues();

		return caseApplication;
	}

	/**
	 * Returns the case application with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the case application
	 * @return the case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCaseApplicationException {

		CaseApplication caseApplication = fetchByPrimaryKey(primaryKey);

		if (caseApplication == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCaseApplicationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return caseApplication;
	}

	/**
	 * Returns the case application with the primary key or throws a <code>NoSuchCaseApplicationException</code> if it could not be found.
	 *
	 * @param id the primary key of the case application
	 * @return the case application
	 * @throws NoSuchCaseApplicationException if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication findByPrimaryKey(long id)
		throws NoSuchCaseApplicationException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the case application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the case application
	 * @return the case application, or <code>null</code> if a case application with the primary key could not be found
	 */
	@Override
	public CaseApplication fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the case applications.
	 *
	 * @return the case applications
	 */
	@Override
	public List<CaseApplication> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @return the range of case applications
	 */
	@Override
	public List<CaseApplication> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the case applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of case applications
	 */
	@Override
	public List<CaseApplication> findAll(
		int start, int end,
		OrderByComparator<CaseApplication> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case applications
	 * @param end the upper bound of the range of case applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of case applications
	 */
	@Override
	public List<CaseApplication> findAll(
		int start, int end,
		OrderByComparator<CaseApplication> orderByComparator,
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

		List<CaseApplication> list = null;

		if (useFinderCache) {
			list = (List<CaseApplication>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CASEAPPLICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CASEAPPLICATION;

				sql = sql.concat(CaseApplicationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CaseApplication>)QueryUtil.list(
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
	 * Removes all the case applications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CaseApplication caseApplication : findAll()) {
			remove(caseApplication);
		}
	}

	/**
	 * Returns the number of case applications.
	 *
	 * @return the number of case applications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CASEAPPLICATION);

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
		return _SQL_SELECT_CASEAPPLICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CaseApplicationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the case application persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new CaseApplicationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CaseApplication.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindBybyCaseModelId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyCaseModelId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"CaseModelId"}, true);

		_finderPathWithoutPaginationFindBybyCaseModelId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyCaseModelId",
			new String[] {Long.class.getName()}, new String[] {"CaseModelId"},
			true);

		_finderPathCountBybyCaseModelId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyCaseModelId",
			new String[] {Long.class.getName()}, new String[] {"CaseModelId"},
			false);

		_finderPathWithPaginationFindByActive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"Active", "CaseModelId"}, true);

		_finderPathWithoutPaginationFindByActive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] {Boolean.class.getName(), Long.class.getName()},
			new String[] {"Active", "CaseModelId"}, true);

		_finderPathCountByActive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] {Boolean.class.getName(), Long.class.getName()},
			new String[] {"Active", "CaseModelId"}, false);

		_finderPathWithPaginationFindByArchive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArchive",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"Archive", "CaseModelId"}, true);

		_finderPathWithoutPaginationFindByArchive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArchive",
			new String[] {Boolean.class.getName(), Long.class.getName()},
			new String[] {"Archive", "CaseModelId"}, true);

		_finderPathCountByArchive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArchive",
			new String[] {Boolean.class.getName(), Long.class.getName()},
			new String[] {"Archive", "CaseModelId"}, false);

		_finderPathWithPaginationFindByHidden = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHidden",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"Hidden", "CaseModelId"}, true);

		_finderPathWithoutPaginationFindByHidden = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHidden",
			new String[] {Boolean.class.getName(), Long.class.getName()},
			new String[] {"Hidden", "CaseModelId"}, true);

		_finderPathCountByHidden = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHidden",
			new String[] {Boolean.class.getName(), Long.class.getName()},
			new String[] {"Hidden", "CaseModelId"}, false);

		_finderPathWithPaginationFindByStatusCase = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusCase",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"CaseModelId", "Status"}, true);

		_finderPathWithoutPaginationFindByStatusCase = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusCase",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"CaseModelId", "Status"}, true);

		_finderPathCountByStatusCase = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusCase",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"CaseModelId", "Status"}, false);

		_finderPathWithPaginationFindByStartDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStartDate",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"CaseModelId", "StartDate"}, true);

		_finderPathWithoutPaginationFindByStartDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStartDate",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"CaseModelId", "StartDate"}, true);

		_finderPathCountByStartDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStartDate",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"CaseModelId", "StartDate"}, false);

		_finderPathWithPaginationFindByEndDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEndDate",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"CaseModelId", "EndDate"}, true);

		_finderPathWithoutPaginationFindByEndDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEndDate",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"CaseModelId", "EndDate"}, true);

		_finderPathCountByEndDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEndDate",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"CaseModelId", "EndDate"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CaseApplicationImpl.class.getName());

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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_CASEAPPLICATION =
		"SELECT caseApplication FROM CaseApplication caseApplication";

	private static final String _SQL_SELECT_CASEAPPLICATION_WHERE =
		"SELECT caseApplication FROM CaseApplication caseApplication WHERE ";

	private static final String _SQL_COUNT_CASEAPPLICATION =
		"SELECT COUNT(caseApplication) FROM CaseApplication caseApplication";

	private static final String _SQL_COUNT_CASEAPPLICATION_WHERE =
		"SELECT COUNT(caseApplication) FROM CaseApplication caseApplication WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "caseApplication.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CaseApplication exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CaseApplication exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CaseApplicationPersistenceImpl.class);

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

	private static class CaseApplicationModelArgumentsResolver
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

			CaseApplicationModelImpl caseApplicationModelImpl =
				(CaseApplicationModelImpl)baseModel;

			long columnBitmask = caseApplicationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					caseApplicationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						caseApplicationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					caseApplicationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CaseApplicationModelImpl caseApplicationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						caseApplicationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = caseApplicationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}
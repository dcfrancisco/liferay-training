/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.gradebook.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.training.gradebook.service.AssignmentServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>AssignmentServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentServiceSoap
 * @generated
 */
public class AssignmentServiceHttp {

	public static com.liferay.training.gradebook.model.Assignment addAssignment(
			HttpPrincipal httpPrincipal, long groupId, String title,
			String description, java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AssignmentServiceUtil.class, "addAssignment",
				_addAssignmentParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, title, description, dueDate,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.gradebook.model.Assignment)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.gradebook.model.Assignment
			deleteAssignment(HttpPrincipal httpPrincipal, long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AssignmentServiceUtil.class, "deleteAssignment",
				_deleteAssignmentParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, assignmentId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.gradebook.model.Assignment)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.gradebook.model.Assignment getAssignment(
			HttpPrincipal httpPrincipal, long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AssignmentServiceUtil.class, "getAssignment",
				_getAssignmentParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, assignmentId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.gradebook.model.Assignment)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.training.gradebook.model.Assignment>
			getAssignmentsByGroupId(HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				AssignmentServiceUtil.class, "getAssignmentsByGroupId",
				_getAssignmentsByGroupIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.training.gradebook.model.Assignment>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.training.gradebook.model.Assignment>
			getAssignmentsByKeywords(
				HttpPrincipal httpPrincipal, long groupId, String keywords,
				int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.training.gradebook.model.Assignment>
						orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				AssignmentServiceUtil.class, "getAssignmentsByKeywords",
				_getAssignmentsByKeywordsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, keywords, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.training.gradebook.model.Assignment>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getAssignmentsCountByKeywords(
		HttpPrincipal httpPrincipal, long groupId, String keywords) {

		try {
			MethodKey methodKey = new MethodKey(
				AssignmentServiceUtil.class, "getAssignmentsCountByKeywords",
				_getAssignmentsCountByKeywordsParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.gradebook.model.Assignment
			updateAssignment(
				HttpPrincipal httpPrincipal, long assignmentId, String title,
				String description, java.util.Date dueDate,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AssignmentServiceUtil.class, "updateAssignment",
				_updateAssignmentParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, assignmentId, title, description, dueDate,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.gradebook.model.Assignment)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		AssignmentServiceHttp.class);

	private static final Class<?>[] _addAssignmentParameterTypes0 =
		new Class[] {
			long.class, String.class, String.class, java.util.Date.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteAssignmentParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _getAssignmentParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getAssignmentsByGroupIdParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _getAssignmentsByKeywordsParameterTypes4 =
		new Class[] {
			long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[]
		_getAssignmentsCountByKeywordsParameterTypes5 = new Class[] {
			long.class, String.class
		};
	private static final Class<?>[] _updateAssignmentParameterTypes6 =
		new Class[] {
			long.class, String.class, String.class, java.util.Date.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};

}
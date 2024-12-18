/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.petclinic.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.training.petclinic.model.Vet;
import com.liferay.training.petclinic.service.VetService;
import com.liferay.training.petclinic.service.VetServiceUtil;
import com.liferay.training.petclinic.service.persistence.AppointmentPersistence;
import com.liferay.training.petclinic.service.persistence.OwnerPersistence;
import com.liferay.training.petclinic.service.persistence.PetPersistence;
import com.liferay.training.petclinic.service.persistence.SpecialtyPersistence;
import com.liferay.training.petclinic.service.persistence.VetPersistence;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the vet remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.training.petclinic.service.impl.VetServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.petclinic.service.impl.VetServiceImpl
 * @generated
 */
public abstract class VetServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, VetService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>VetService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>VetServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		VetServiceUtil.setService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {VetService.class, IdentifiableOSGiService.class};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		vetService = (VetService)aopProxy;

		VetServiceUtil.setService(vetService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return VetService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Vet.class;
	}

	protected String getModelClassName() {
		return Vet.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = vetPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected AppointmentPersistence appointmentPersistence;

	@Reference
	protected OwnerPersistence ownerPersistence;

	@Reference
	protected PetPersistence petPersistence;

	@Reference
	protected SpecialtyPersistence specialtyPersistence;

	@Reference
	protected com.liferay.training.petclinic.service.VetLocalService
		vetLocalService;

	protected VetService vetService;

	@Reference
	protected VetPersistence vetPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	private static final Log _log = LogFactoryUtil.getLog(
		VetServiceBaseImpl.class);

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.training.petclinic.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAppointmentException extends NoSuchModelException {

	public NoSuchAppointmentException() {
	}

	public NoSuchAppointmentException(String msg) {
		super(msg);
	}

	public NoSuchAppointmentException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAppointmentException(Throwable throwable) {
		super(throwable);
	}

}
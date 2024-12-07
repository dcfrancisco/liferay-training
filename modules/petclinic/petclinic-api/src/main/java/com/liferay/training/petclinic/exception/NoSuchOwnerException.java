/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.training.petclinic.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchOwnerException extends NoSuchModelException {

	public NoSuchOwnerException() {
	}

	public NoSuchOwnerException(String msg) {
		super(msg);
	}

	public NoSuchOwnerException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchOwnerException(Throwable throwable) {
		super(throwable);
	}

}
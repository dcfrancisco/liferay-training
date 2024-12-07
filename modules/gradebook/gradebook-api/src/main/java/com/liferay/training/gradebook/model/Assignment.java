/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.gradebook.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Assignment service. Represents a row in the &quot;Gradebook_Assignment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.training.gradebook.model.impl.AssignmentImpl"
)
@ProviderType
public interface Assignment extends AssignmentModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.training.gradebook.model.impl.AssignmentImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Assignment, Long> ASSIGNMENT_ID_ACCESSOR =
		new Accessor<Assignment, Long>() {

			@Override
			public Long get(Assignment assignment) {
				return assignment.getAssignmentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Assignment> getTypeClass() {
				return Assignment.class;
			}

		};

}
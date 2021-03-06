/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the CTUser service. Represents a row in the &quot;CT_CTUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CTUserModel
 * @see com.liferay.contenttargeting.model.impl.CTUserImpl
 * @see com.liferay.contenttargeting.model.impl.CTUserModelImpl
 * @generated
 */
public interface CTUser extends CTUserModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.contenttargeting.model.impl.CTUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public long[] getMatchesUserSegmentIds(long[] groupIds,
		com.liferay.contenttargeting.api.model.RulesRegistry rulesRegistry)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}
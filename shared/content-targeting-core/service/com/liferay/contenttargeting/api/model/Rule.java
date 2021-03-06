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

package com.liferay.contenttargeting.api.model;

import com.liferay.contenttargeting.model.CTUser;
import com.liferay.contenttargeting.model.RuleInstance;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eudaldo Alonso
 */
public interface Rule {

	public boolean evaluate(RuleInstance ruleInstance, CTUser ctUser);

	public String getFormHTML(
		RuleInstance ruleInstance, Map<String, Object> context);

	public String getIcon();

	public String getName(Locale locale);

	public String getRuleKey();

	public String getSummary(RuleInstance ruleInstance, Locale locale);

	public String processRule(PortletRequest request, PortletResponse response);

}
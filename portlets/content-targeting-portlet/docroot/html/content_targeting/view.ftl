<#--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
-->

<#include "../init.ftl" />

<#if contentTargetingPermission.contains(permissionChecker, scopeGroupId, actionKeys.ADD_USER_SEGMENT)>
	<@aui["nav-bar"]>
		<@aui["nav"]>
			<@portlet["renderURL"] var="addUserSegmentURL">
				<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_USER_SEGMENT}" />
				<@portlet["param"] name="redirect" value="${currentURL}" />
			</@>

			<@aui["nav-item"] href="${addUserSegmentURL}" iconCssClass="icon-plus" label="add-user-segment" />
		</@>
	</@>
</#if>

<@liferay_ui["search-container"]
	emptyResultsMessage="no-user-segments-were-found"
	iteratorURL=renderResponse.createRenderURL()
>
	<@liferay_ui["search-container-results"]
		results=userSegments
		total=userSegments ?size
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.contenttargeting.model.UserSegment"
		modelVar="userSegment"
	>

		<@liferay_ui["search-container-column-text"]
			name="name"
			value=userSegment.getName(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			name="description"
			value=userSegment.getDescription(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			align="right"
			name=""
		>
			<@liferay_ui["icon-menu"]>
				<#if userSegmentPermission.contains(permissionChecker, userSegment, actionKeys.UPDATE)>
					<@portlet["renderURL"] var="editUserSegmentURL">
						<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_USER_SEGMENT}" />
						<@portlet["param"] name="redirect" value="${currentURL}" />
						<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()?string}" />
					</@>


					<@liferay_ui["icon"]
						image="edit"
						method="get"
						url="${editUserSegmentURL}"
					/>
				</#if>

				<#if userSegmentPermission.contains(permissionChecker, userSegment, actionKeys.DELETE)>
					<@portlet["actionURL"] name="deleteUserSegment" var="deleteUserSegmentURL">
						<@portlet["param"] name="redirect" value="${currentURL}" />
						<@portlet["param"] name="userSegmentId" value="${userSegment.getUserSegmentId()?string}" />
					</@>

					<@liferay_ui["icon-delete"]
						url="${deleteUserSegmentURL}"
					/>
				</#if>

				<#if userSegmentPermission.contains(permissionChecker, userSegment, actionKeys.PERMISSIONS)>
					<@liferay_security["permissionsURL"]
						modelResource="${userSegmentClass.getName()}"
						modelResourceDescription="${userSegment.getName(locale)}"
						resourcePrimKey="${userSegment.getUserSegmentId()}"
						var="permissionsEntryURL"
						windowState="${liferayWindowStatePopUp}"
					/>

					<@liferay_ui["icon"]
						image="permissions"
						method="get"
						url="${permissionsEntryURL}"
						useDialog=true
					/>
				</#if>
			</@>
		</@>
	</@>

	<@liferay_ui["search-iterator"] />
</@>
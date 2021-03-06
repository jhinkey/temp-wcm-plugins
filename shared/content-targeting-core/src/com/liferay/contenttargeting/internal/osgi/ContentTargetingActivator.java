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

package com.liferay.contenttargeting.internal.osgi;

import com.liferay.contenttargeting.service.CTUserLocalService;
import com.liferay.contenttargeting.service.RuleInstanceLocalService;
import com.liferay.contenttargeting.service.RuleInstanceService;
import com.liferay.contenttargeting.service.UserSegmentLocalService;
import com.liferay.contenttargeting.service.UserSegmentService;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.messaging.SerialDestination;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import org.springframework.context.ApplicationContext;

/**
 * @author Carlos Sierra Andrés
 */
public class ContentTargetingActivator
	implements BundleActivator, MessageListener {

	@Override
	public synchronized void receive(Message message)
		throws MessageListenerException {

		ApplicationContext applicationContext =
			(ApplicationContext)message.getPayload();

		CTUserLocalService ctUserLocalService =
			(CTUserLocalService)applicationContext.getBean(
				CTUserLocalService.class.getName());

		_ctUserLocalServiceServiceRegistration =
			_bundleContext.registerService(
				CTUserLocalService.class, ctUserLocalService, null);

		RuleInstanceLocalService ruleInstanceLocalService =
			(RuleInstanceLocalService)applicationContext.getBean(
				RuleInstanceLocalService.class.getName());

		_ruleInstanceLocalServiceServiceRegistration =
			_bundleContext.registerService(
				RuleInstanceLocalService.class, ruleInstanceLocalService, null);

		RuleInstanceService ruleInstanceService =
			(RuleInstanceService)applicationContext.getBean(
				RuleInstanceService.class.getName());

		_ruleInstanceServiceServiceRegistration =
			_bundleContext.registerService(
				RuleInstanceService.class, ruleInstanceService, null);

		UserSegmentLocalService userSegmentLocalService =
			(UserSegmentLocalService)applicationContext.getBean(
				UserSegmentLocalService.class.getName());

		_userSegmentLocalServiceServiceRegistration =
			_bundleContext.registerService(
				UserSegmentLocalService.class, userSegmentLocalService, null);

		UserSegmentService userSegmentService =
			(UserSegmentService)applicationContext.getBean(
				UserSegmentService.class.getName());

		_userSegmentServiceServiceRegistration = _bundleContext.registerService(
			UserSegmentService.class, userSegmentService, null);
	}

	@Override
	public synchronized void start(BundleContext bundleContext)
		throws Exception {

		_bundleContext = bundleContext;

		SerialDestination destination = new SerialDestination(DESTINATION_NAME);

		MessageBusUtil.addDestination(destination);

		MessageBusUtil.registerMessageListener(DESTINATION_NAME, this);
	}

	@Override
	public synchronized void stop(BundleContext context) throws Exception {
		MessageBusUtil.removeDestination(DESTINATION_NAME);

		MessageBusUtil.unregisterMessageListener(DESTINATION_NAME, this);

		if (_ctUserLocalServiceServiceRegistration != null) {
			_ctUserLocalServiceServiceRegistration.unregister();

			_ctUserLocalServiceServiceRegistration = null;
		}

		if (_ruleInstanceLocalServiceServiceRegistration != null) {
			_ruleInstanceLocalServiceServiceRegistration.unregister();

			_ruleInstanceLocalServiceServiceRegistration = null;
		}

		if (_ruleInstanceServiceServiceRegistration != null) {
			_ruleInstanceServiceServiceRegistration.unregister();

			_ruleInstanceServiceServiceRegistration = null;
		}

		if (_userSegmentLocalServiceServiceRegistration != null) {
			_userSegmentLocalServiceServiceRegistration.unregister();

			_userSegmentLocalServiceServiceRegistration = null;
		}

		if (_userSegmentServiceServiceRegistration != null) {
			_userSegmentServiceServiceRegistration.unregister();

			_userSegmentServiceServiceRegistration = null;
		}
	}

	protected static final String DESTINATION_NAME =
		"content-targeting-core-spring";

	private BundleContext _bundleContext;
	private ServiceRegistration<CTUserLocalService>
		_ctUserLocalServiceServiceRegistration;
	private ServiceRegistration<RuleInstanceLocalService>
		_ruleInstanceLocalServiceServiceRegistration;
	private ServiceRegistration<RuleInstanceService>
		_ruleInstanceServiceServiceRegistration;
	private ServiceRegistration<UserSegmentLocalService>
		_userSegmentLocalServiceServiceRegistration;
	private ServiceRegistration<UserSegmentService>
		_userSegmentServiceServiceRegistration;

}
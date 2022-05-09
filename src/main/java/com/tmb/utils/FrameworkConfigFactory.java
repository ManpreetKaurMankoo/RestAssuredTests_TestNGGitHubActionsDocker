package com.tmb.utils;

import org.aeonbits.owner.ConfigFactory;

import com.tmb.utils.FrameworkConfig;

public final class FrameworkConfigFactory {

	private FrameworkConfigFactory() {}

	public static FrameworkConfig createConfigFactory() {
		return ConfigFactory.create(FrameworkConfig.class);
	}

}

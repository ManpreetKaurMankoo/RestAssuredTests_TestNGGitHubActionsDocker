package com.tmb.utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
	"system:properties",
	"system:env",
	"file:${user.dir}/src/test/resources/configdata/config.properties"
})
public interface FrameworkConfig extends Config {

	@DefaultValue("https://reqres.in")
	@Key("baseuri")
	String baseURI();

	// Try combining the second approach (using static block) with final approach(owner)to take care of exceptions

	@Key("contenttype")
	String contentType();
}

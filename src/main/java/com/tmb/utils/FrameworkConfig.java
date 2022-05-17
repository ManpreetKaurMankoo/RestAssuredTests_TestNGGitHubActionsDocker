package com.tmb.utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
	"file:${user.dir}/src/test/resources/configdata/config.properties"
})
public interface FrameworkConfig extends Config {

	@DefaultValue("https://reqres.in")
	@Key("baseuri")
	String baseURI();

	@Key("contenttype")
	String contentType();
}

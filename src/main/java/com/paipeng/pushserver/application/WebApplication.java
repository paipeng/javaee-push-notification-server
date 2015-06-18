package com.paipeng.pushserver.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class WebApplication extends Application {
	public WebApplication() {
		System.out.println("WebApplication");
	}
}

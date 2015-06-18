package com.paipeng.network;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

public class RestClient {
	@Inject
	protected Logger log;
	
	public RestResult test() {
		Client client;
		client = ClientBuilder.newClient();
		// enable POJO mapping using Jackson - see
		// https://jersey.java.net/documentation/latest/user-guide.html#json.jackson
		// client.register(JacksonFeature.class);

		String uri = "http://localhost:3004/test";

		Invocation.Builder bldr = client.target(uri)
				.request("application/json");
		
		//Response res = bldr.get();
		//String a = (String) res.readEntity(String.class);
		//log.info("response " + a);
		return bldr.get(RestResult.class);
		//RestResult ret = new RestResult();
		//return ret;
	}

	
}

package com.paipeng.pushserver.network;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.paipeng.pushserver.push.gcm.GCMResult;
import com.paipeng.pushserver.push.gcm.GCMessage;

public class RestClient {
	@Inject
	protected Logger log;
	
	public RestResult test(String echo) {
		Client client;
		client = ClientBuilder.newClient();
		// enable POJO mapping using Jackson - see
		// https://jersey.java.net/documentation/latest/user-guide.html#json.jackson
		// client.register(JacksonFeature.class);

		String uri = "http://localhost:3004/test/" + echo;

		Invocation.Builder bldr = client.target(uri)
				.request("application/json");
		
		//Response res = bldr.get();
		//String a = (String) res.readEntity(String.class);
		//log.info("response " + a);
		return bldr.get(RestResult.class);
		//RestResult ret = new RestResult();
		//return ret;
	}

	public GCMResult sendMessage(String url, GCMessage gCMessage) {
		Client client = ClientBuilder.newClient();
		
		Invocation.Builder bldr = client.target(url)
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "key=");
		
		
		Response response = bldr.post(Entity.entity(gCMessage, MediaType.APPLICATION_JSON));
		//System.out.println("response "  + response.readEntity(String.class));
		return response.readEntity(GCMResult.class);
	}
	
}

package com.paipeng.pushserver.network;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.paipeng.pushserver.model.PushMessage;
import com.paipeng.pushserver.push.gcm.GCMResult;

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

	public GCMResult sendMessage(String url, PushMessage pushMessage) {
		Client client = ClientBuilder.newClient();
		
		Invocation.Builder bldr = client.target(url)
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "key=" + pushMessage.getAppKey());
		
		
		Response response = bldr.post(Entity.entity(pushMessage.getGcmMessage(), MediaType.APPLICATION_JSON));
		if (response.getStatus() == 200) {
			//System.out.println("response "  + response.readEntity(String.class));
			GCMResult result = response.readEntity(GCMResult.class);
			result.setStatus(response.getStatus());
			return result;		
		} else {
			GCMResult result = new GCMResult();
			result.setStatus(response.getStatus());
			result.setMessage(response.readEntity(String.class));
			return result;
		}
	}
	
}

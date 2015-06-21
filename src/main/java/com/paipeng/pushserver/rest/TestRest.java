package com.paipeng.pushserver.rest;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.paipeng.pushserver.network.RestClient;
import com.paipeng.pushserver.network.RestResult;
import com.paipeng.pushserver.push.gcm.GCMResult;
import com.paipeng.pushserver.push.gcm.GCMServer;
import com.paipeng.pushserver.push.gcm.GCMessage;

@RequestScoped
@Path("")
public class TestRest {

	@Inject
	protected Logger log;

	@Inject
	private GCMServer gcmServer;
	
	@PostConstruct
	public void postConstruct() {
		log.info("postConstruct");
	}
	
	@Path("/echo")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@POST
	public Response echo(@QueryParam("echo") String echo) {
		log.info("echo " + echo);

		RestClient client = new RestClient();
		RestResult ret = client.test(echo);
		return Response.ok(ret).build();
	}
	
	
	@Path("/sendGCM")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Response sendGCM(GCMessage gcMessage) {
		log.info("redId " + gcMessage.getTo());
		GCMResult result = gcmServer.sendMessage(gcMessage);
		
		return Response.ok(result).build();
	}
	
}

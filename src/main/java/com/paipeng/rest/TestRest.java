package com.paipeng.rest;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.paipeng.network.RestClient;
import com.paipeng.network.RestResult;

@RequestScoped
@Path("")
public class TestRest {

	@Inject
	protected Logger log;

	@PostConstruct
	public void postConstruct() {
		log.info("postConstruct");
	}
	
	@Path("/echo")
	@Produces("application/json")
	@GET
	@POST
	public Response echo(@QueryParam("echo") String echo) {
		log.info("echo " + echo);

		RestClient client = new RestClient();
		RestResult ret = client.test(echo);
		return Response.ok(ret).build();
	}
}

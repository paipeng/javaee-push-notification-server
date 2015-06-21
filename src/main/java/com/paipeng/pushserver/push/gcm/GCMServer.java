package com.paipeng.pushserver.push.gcm;

import com.paipeng.pushserver.network.RestClient;

public class GCMServer {
	private static final String GOOGLE_GCM_URL = "https://gcm-http.googleapis.com/gcm/send";
	public GCMServer() {
		
	}
	
	public GCMResult sendMessage(GCMessage gcMessage) {
		RestClient restClient = new RestClient();
		GCMResult result = restClient.sendMessage(GOOGLE_GCM_URL, gcMessage);
		return result;
	}
}

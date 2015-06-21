package com.paipeng.pushserver.push.gcm;

import java.util.List;

public class GCMResult {
	private long multicast_id;
	private boolean success;
	private boolean failure;
	private long canonical_ids;
	
	private List<Result> results;
	
	public GCMResult() {
		
	}
	
	public long getMulticast_id() {
		return multicast_id;
	}

	public void setMulticast_id(long multicast_id) {
		this.multicast_id = multicast_id;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isFailure() {
		return failure;
	}

	public void setFailure(boolean failure) {
		this.failure = failure;
	}

	public long getCanonical_ids() {
		return canonical_ids;
	}

	public void setCanonical_ids(long canonical_ids) {
		this.canonical_ids = canonical_ids;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	

	@Override
	public String toString() {
		return this.multicast_id + " success: " + success + " failure: " + failure +  "canonical_ids: " + this.canonical_ids
				+ " results: " + ((this.results != null)?this.results.size(): 0);
	}


	public static class Result {
		private String message_id;
		
		public Result() {
			
		}
		

		public String getMessage_id() {
			return message_id;
		}

		public void setMessage_id(String message_id) {
			this.message_id = message_id;
		}
		
		@Override
		public String toString() {
			return "message_id: " + this.message_id;
		}
		
	}
}

package com.paipeng.pushserver.push.gcm;


public class GCMessage {
	private String to;
	private Data data;
	
	public GCMessage() {
		
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	

	public class Data {
		private String title;
		private String text;		
		
		public Data() {
			
			
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}		
	}
	
}

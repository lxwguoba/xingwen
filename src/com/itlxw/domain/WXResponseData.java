package com.itlxw.domain;

public class WXResponseData {
	// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
		private Long wx_id;
		private String signature;
		// 时间戳
		private String timestamp;
		// 随机数
		private String nonce;
		// 随机字符串
		private String echostr;
		
		public Long getWx_id() {
			return wx_id;
		}

		public void setWx_id(Long wx_id) {
			this.wx_id = wx_id;
		}

		
		
		
		
		
		public String getSignature() {
			return signature;
		}

		public String getTimestamp() {
			return timestamp;
		}

		public String getNonce() {
			return nonce;
		}

		public String getEchostr() {
			return echostr;
		}



		public void setSignature(String signature) {
			this.signature = signature;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

		public void setNonce(String nonce) {
			this.nonce = nonce;
		}

		public void setEchostr(String echostr) {
			this.echostr = echostr;
		}
}

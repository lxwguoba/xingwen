package com.itlxw.domain;

public class Data {

	public Data_ data;

	public Data_ getData() {
		return data;
	}

	public void setData(Data_ data) {
		this.data = data;
	}

	public class Data_ {
		public String errcode;
		public String errmsg;

		public String getErrcode() {
			return errcode;
		}

		public void setErrcode(String errcode) {
			this.errcode = errcode;
		}

		public String getErrmsg() {
			return errmsg;
		}

		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}

	}
}

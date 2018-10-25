package com.example.demo;

import org.springframework.data.annotation.Id;

public class mongo {

	@Id private String id;

	private String sess;
	private String message;

	public String getsess() {
		return sess;
	}
	public void setsess(String sess) {
		this.sess = sess;
	}
	public String getmessage() {
		return message;
	}
	public void setmessage(String message) {
		this.message = message;
	}

    public mongo(String sess, String message) {
        this.sess = sess;
        this.message = message;
    }

	@Override
    public String toString() {
        return String.format(
                "Customer[id=%s, sess='%s', message='%s']",
                id, sess, message);
    }


}

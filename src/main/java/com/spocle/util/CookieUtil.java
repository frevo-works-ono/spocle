package com.spocle.util;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Value;

public class CookieUtil {

	private static CookieUtil instance = new CookieUtil();

	@Value("${server.session.cookie.http-only}")
	private boolean httpOnly;

	@Value("${server.session.cookie.secure}")
	private boolean secure;

	private CookieUtil() {

	}

	public static CookieUtil use() {
		return instance;
	}

	public Cookie get(String key, String value) {
		Cookie cookie = new Cookie(key, value);
		cookie.setSecure(secure);
		cookie.setHttpOnly(httpOnly);
		cookie.setPath("/");
		return cookie;
	}
}

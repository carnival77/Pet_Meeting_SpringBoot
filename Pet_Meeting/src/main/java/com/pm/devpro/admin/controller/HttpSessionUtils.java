package com.ktds.devpro.admin.controller;

import javax.servlet.http.HttpSession;

import com.ktds.devpro.admin.vo.AdminVO;

public class HttpSessionUtils {
	public static String ADMIN_SESSION_KEY = "sessionedAdmin";
	public static HttpSession session = null;
//	private HttpSession session;
	public static AdminVO adminvo;

//	public static boolean isLoginAdmin(HttpSession session){
//	    Object sessionedAdmin=session.getAttribute(ADMIN_SESSION_KEY);
//	    if(sessionedAdmin==null){
//	        return false;
//	    }
//	    return true;
//	}

//	public HttpSession getSession() {
//		return session;
//	}
//
//	public void setSession(HttpSession session) {
//		this.session = session;
//	}

	public static boolean isLoginAdmin(HttpSession session, String session_key) {
		Object sessionedAdmin = session.getAttribute(ADMIN_SESSION_KEY);
		System.out.println("테스트 : " + sessionedAdmin);
//		if (sessionedAdmin != null && session_key.equals(ADMIN_SESSION_KEY)) {
			if (sessionedAdmin != null && adminvo == sessionedAdmin) {
			return true;
		}
		return false;

//		if (session_key == session.getAttribute(ADMIN_SESSION_KEY)) {
//			return true;
//		}
//		if (session_key == session.getAttribute(ADMIN_SESSION_KEY)) {
//			return true;
//		}
//		return false;

	}

}

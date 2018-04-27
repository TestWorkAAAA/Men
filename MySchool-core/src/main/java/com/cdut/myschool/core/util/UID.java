package com.cdut.myschool.core.util;

import java.util.UUID;

public class UID {
	public static synchronized String next(){
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
}

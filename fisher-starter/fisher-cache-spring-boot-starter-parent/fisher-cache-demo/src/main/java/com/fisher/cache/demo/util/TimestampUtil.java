package com.fisher.cache.demo.util;

import java.sql.Timestamp;

public class TimestampUtil {

	public static final Timestamp getCurrentTimestamp(){
		return new Timestamp(System.currentTimeMillis());
	}
}

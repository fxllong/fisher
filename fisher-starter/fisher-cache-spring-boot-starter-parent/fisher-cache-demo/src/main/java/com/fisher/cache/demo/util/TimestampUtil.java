package com.fisher.cache.demo.util;

import java.sql.Timestamp;

public class TimestampUtil {

	public static final Timestamp current(){
		return new Timestamp(System.currentTimeMillis());
	}
}

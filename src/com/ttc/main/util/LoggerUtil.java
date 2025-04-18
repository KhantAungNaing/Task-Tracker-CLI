package com.ttc.main.util;

public class LoggerUtil {

	private LoggerUtil() {
	}

	public static void info(String message) {
		System.out.println("[INFO] " + message);
	}

	public static void warn(String message) {
		System.out.println("[WARN] " + message);
	}

	public static void error(String message) {
		System.err.println("[ERROR] " + message);
	}
}

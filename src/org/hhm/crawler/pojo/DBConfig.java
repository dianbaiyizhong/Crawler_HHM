package org.hhm.crawler.pojo;

public class DBConfig {

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		DBConfig.name = name;
	}

	public static String getiP() {
		return iP;
	}

	public static void setiP(String iP) {
		DBConfig.iP = iP;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		DBConfig.port = port;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		DBConfig.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		DBConfig.password = password;
	}

	private static String name;
	private static String iP;
	private static String port;
	private static String username;
	private static String password;

}

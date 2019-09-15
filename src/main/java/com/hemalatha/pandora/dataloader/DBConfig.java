package com.hemalatha.pandora.dataloader;

public class DBConfig {

	private String dbConnectAddress;
	private int dbConnectPort;
	private String dbConnectName;
	private String dbConnectSchema;
	private String dbConnectUser;

	public DBConfig(String dbConnectAddress, int dbConnectPort, String dbConnectName, String dbConnectSchema, String dbConnectUser) {
		this.dbConnectAddress = dbConnectAddress;
		this.dbConnectPort = dbConnectPort;
		this.dbConnectName = dbConnectName;
		this.dbConnectSchema = dbConnectSchema;
		this.dbConnectUser = dbConnectUser;
	}

	public String getDbConnectAddress() {
		return dbConnectAddress;
	}

	public void setDbConnectAddress(String dbConnectAddress) {
		this.dbConnectAddress = dbConnectAddress;
	}

	public int getDbConnectPort() {
		return dbConnectPort;
	}

	public void setDbConnectPort(int dbConnectPort) {
		this.dbConnectPort = dbConnectPort;
	}

	public String getDbConnectName() {
		return dbConnectName;
	}

	public void setDbConnectName(String dbConnectName) {
		this.dbConnectName = dbConnectName;
	}

	public String getDbConnectSchema() {
		return dbConnectSchema;
	}

	public void setDbConnectSchema(String dbConnectSchema) {
		this.dbConnectSchema = dbConnectSchema;
	}

	public String getDbConnectUser() {
		return dbConnectUser;
	}

	public void setDbConnectUser(String dbConnectUser) {
		this.dbConnectUser = dbConnectUser;
	}
}

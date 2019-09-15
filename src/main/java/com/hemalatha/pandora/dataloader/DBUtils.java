package com.hemalatha.pandora.dataloader;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class DBUtils {
	public DBUtils() {
	}

	public EntityManagerFactory getDBEntityManager(DBConfig config) {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
		properties.put("javax.persistence.provider", "org.hibernate.jpa.HibernatePersistenceProvider");
		properties.put("javax.persistence.class", "com.pandora.charon.model.*");
		String url = String.format("jdbc:postgresql://%s:%s/%s", config.getDbConnectAddress(), config.getDbConnectPort(), config.getDbConnectName());
		properties.put("javax.persistence.jdbc.url", url);
		properties.put("hibernate.default_schema", config.getDbConnectSchema());
		properties.put("javax.persistence.jdbc.user", config.getDbConnectUser());
		properties.put("hibernate.implicit_naming_strategy", "com.hemalatha.pandora.dataloader.SegmentedNamingStrategy");
		properties.put("hibernate.show_sql", "true");
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("testDB", properties);
		return managerFactory;
	}
}
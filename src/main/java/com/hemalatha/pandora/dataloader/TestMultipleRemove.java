//package com.hemalatha.pandora.dataloader;
//
//
//
//import com.pandora.charon.model.ListenerProduct;
//import com.pandora.charon.model.SubscriptionStatus;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import java.time.ZonedDateTime;
//
//public class TestMultipleRemove {
//
//
//	public static void main(String[] args) {
//	DBConfig dbConfig =  new DBConfig("localhost",5432,
//			"helangovan_charondb","charondb_seg2","helangovan");
//
//	 DBUtils utils = new DBUtils();
//	 EntityManagerFactory managerFactory = utils.getDBEntityManager(dbConfig);
//	 EntityManager manager = managerFactory.createEntityManager();
//	 Long subId = 0l;
//	 manager.getTransaction().begin();
//		SubscriptionStatus subscriptionStatus = new SubscriptionStatus(0);
//		subscriptionStatus.setDateCreated(ZonedDateTime.now());
//		manager.persist(subscriptionStatus);
//		ListenerProduct product1 = new ListenerProduct();
//		product1.setState(ListenerProduct.State.ACTIVE);
//		product1.setDateCreated(ZonedDateTime.now());
//		product1.setSku("testsku1");
//		ListenerProduct product2 = new ListenerProduct();
//		product2.setDateCreated(ZonedDateTime.now());
//		product2.setState(ListenerProduct.State.PENDING);
//		product2.setSku("testsku2");
//		subscriptionStatus.addProduct(product1);
//		subscriptionStatus.addProduct(product2);
//		manager.persist(product1);
//		manager.persist(product2);
//		subId = manager.merge(subscriptionStatus).getListenerId();
//		manager.getTransaction().commit();
//
//		manager.getTransaction().begin();
//		SubscriptionStatus status2 = manager.find(SubscriptionStatus.class,subId);
//		//manager.remove(product1);
//		status2.removeProduct(product1);
//		manager.getTransaction().commit();
//
//
//	}
//
//}

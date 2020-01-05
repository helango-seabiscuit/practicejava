//package com.hemalatha.pandora.dataloader;
//
//
//import com.pandora.charon.model.InAppPurchaseInfo;
//import com.pandora.charon.model.ListenerProduct;
//import com.pandora.charon.model.ListenerProductGracePeriodActivity;
//import com.pandora.charon.model.SubscriptionStatus;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//
//public class DataLoader {
//
//
//   private final com.hemalatha.pandora.dataloader.DBUtils DBUtils = new DBUtils();
//   private EntityManagerFactory sourceEntityManager;
//   private EntityManagerFactory destEntityManager;
//   private EntityManager sourceEM;
//   private EntityManager destEM;
//   private SubscriptionStatus status;
//   private InAppPurchaseInfo inAppPurchaseInfo;
//   private  ListenerProduct listenerProduct;
//
//   static  DBConfig fromDBCharonConfig;
//   static DBConfig toDBCharonConfig;
//
//   public DataLoader() {
//      toDBCharonConfig = new DBConfig("localhost",5432,
//              "helangovan_charondb","charondb_seg1","helangovan");
//      fromDBCharonConfig =  new DBConfig("carly",5432,
//              "carly-charon-fr_charon","charondb_seg1","build");
//   }
//
//   public void init(){
//      sourceEntityManager = DBUtils.getDBEntityManager(fromDBCharonConfig);
//      destEntityManager = DBUtils.getDBEntityManager(toDBCharonConfig);
//      sourceEM = sourceEntityManager.createEntityManager();
//      destEM = destEntityManager.createEntityManager();
//
//   }
//
//   public void shutDown(){
//      sourceEM.close();
//      destEM.close();
//      sourceEntityManager.close();
//      destEntityManager.close();
//   }
//
//   public static void main(String[] args) {
//
//      List<Long> subIds = Arrays.asList(42604l);
//      DataLoader dataLoader = new DataLoader();
//      dataLoader.init();
//      long toCopyId = subIds.get(subIds.size()-1);
//      dataLoader.moveData(toCopyId);
//     // dataLoader.deleteDataFromDest(toCopyId);
//      dataLoader.shutDown();
//      System.out.println(toCopyId%3);
//
//   }
//
//   private void deleteDataFromDest(long subscribId) {
//      SubscriptionStatus status = destEM.find(SubscriptionStatus.class,subscribId);
//
//      List<InAppPurchaseInfo> inAppPurchaseInfo = destEM.createQuery("from InAppPurchaseInfo where subscriptionStatus = :status")
//              .setParameter("status",status).getResultList();
//      destEM.getTransaction().begin();
//      inAppPurchaseInfo.forEach(inAppInfo ->{  destEM.remove(inAppInfo);});
//      destEM.flush();
//      destEM.getTransaction().commit();
//      status = destEM.find(SubscriptionStatus.class,subscribId);
//      destEM.getTransaction().begin();
//      destEM.remove(status);
//      destEM.getTransaction().commit();
//   }
//
//   public void  moveData(long subscribId){
//      status =destEM.find(SubscriptionStatus.class,subscribId);
////      listenerProduct = status.getActiveProduct();
////      List<InAppPurchaseInfo> inAppPurchaseInfoList = sourceEM.createQuery("from InAppPurchaseInfo where subscriptionStatus = :status")
////              .setParameter("status",status).getResultList();
////      destEM.getTransaction().begin();
////      SubscriptionStatus newStatus = copyStatus(status);
////      destEM.persist(newStatus);
////      List<InAppPurchaseInfo> inAppPurchaseInfos = new ArrayList<>();
////      for(InAppPurchaseInfo inAppPurchaseInfo: inAppPurchaseInfoList){
////         InAppPurchaseInfo purchaseInfo = copyInappPurchase(inAppPurchaseInfo);
////         purchaseInfo.setSubscriptionStatus(newStatus);
////         inAppPurchaseInfos.add(purchaseInfo);
////         destEM.persist(purchaseInfo);
////      }
////
////      destEM.getTransaction().commit();
//      destEM.getTransaction().begin();
//      copyListenerGracePeriod(status);
//      destEM.getTransaction().commit();
//
//
//
//
//   }
//
//   private void copyListenerGracePeriod(SubscriptionStatus subscriptionStatus){
//      List<ListenerProductGracePeriodActivity> gracePeriodActivities =sourceEM.createQuery("from ListenerProductGracePeriodActivity where subscriptionStatus = :status").setParameter("status",subscriptionStatus).getResultList();
//
//      for (ListenerProductGracePeriodActivity activity:gracePeriodActivities){
//         ListenerProductGracePeriodActivity act1 = new ListenerProductGracePeriodActivity();
//         act1.setDateActivity(activity.getDateActivity());
//         act1.setGracePeriodActivity(activity.getGracePeriodActivity());
//         act1.setGracePeriodDurationChosen(activity.getGracePeriodDurationChosen());
//         //act1.setGracePeriodEnd(activity.getGracePeriodEnd());
//         act1.setGracePeriodStart(activity.getGracePeriodStart());
//         act1.setSubscriptionStatus(subscriptionStatus);
//         ListenerProduct lp = subscriptionStatus.getProductHistory().stream().findFirst().get();
//         act1.setListenerProduct(lp);
//         destEM.persist(act1);
//      }
//   }
//
//   private InAppPurchaseInfo copyInappPurchase(InAppPurchaseInfo inAppPurchaseInfo) {
//      InAppPurchaseInfo purchaseInfo = new InAppPurchaseInfo();
//
//      purchaseInfo.setActive(inAppPurchaseInfo.isActive());
//      purchaseInfo.setStore(inAppPurchaseInfo.getStore());
//      purchaseInfo.setLastRevalidation(inAppPurchaseInfo.getLastRevalidation());
//      purchaseInfo.setDateCreated(inAppPurchaseInfo.getDateCreated());
//      purchaseInfo.setReceiptData(inAppPurchaseInfo.getReceiptData());
//      purchaseInfo.setReceiptSignature(inAppPurchaseInfo.getReceiptSignature());
//      purchaseInfo.setTransactionId(inAppPurchaseInfo.getTransactionId());
//      purchaseInfo.setVendorSKU(inAppPurchaseInfo.getVendorSKU());
//      purchaseInfo.setStoreUserId(inAppPurchaseInfo.getStoreUserId());
//      purchaseInfo.setStoreTerritory(inAppPurchaseInfo.getStoreTerritory());
//      purchaseInfo.setTracking(inAppPurchaseInfo.getTracking());
//      purchaseInfo.setReceiptIdentifier(inAppPurchaseInfo.getReceiptIdentifier());
//      purchaseInfo.setLatestExpirationDate(inAppPurchaseInfo.getLatestExpirationDate());
//      purchaseInfo.setTransferredToLid(inAppPurchaseInfo.getTransferredToLid());
//      return purchaseInfo;
//   }
//
//   public SubscriptionStatus copyStatus(SubscriptionStatus remote){
//       SubscriptionStatus status = new SubscriptionStatus(remote.getListenerId());
//       status.setExpirationDate(remote.getExpirationDate());
//       status.setProductHistory(remote.getProductHistory());
//      // status.setListenerValue(remote.lis);
//      status.setBillingStore(remote.getBillingStore());
//      status.setAutoRenew(remote.isAutoRenew());
//      status.setAnnual48PricingEligible(remote.isAnnual48PricingEligible());
//      status.setUsedPlusTrial(remote.hasUsedPlusTrial());
//      status.setUsedPremiumTrial(remote.hasUsedPremiumTrial());
//      status.setProcessingRenewal(remote.isProcessingRenewal());
//      status.setConsecutiveRenewalErrors(remote.getConsecutiveRenewalErrors());
//      //status.setListenerNotes(remote.getListenerNotes());
//      status.setDateUpdated(remote.getDateUpdated());
//      status.setDateCreated(remote.getDateCreated());
//      status.setReprocessDate(remote.getReprocessDate());
//      status.setGracePeriodExpirationDate(remote.getGracePeriodExpirationDate());
//      status.setDateAutoRenewUpdated(remote.getDateAutoRenewUpdated());
//
//      List<ListenerProduct> oldListenerProduct = new ArrayList<>(remote.getProductHistory());
//      List<ListenerProduct> newListenerProduct = new ArrayList<>();
//      for(ListenerProduct lp:oldListenerProduct){
//         ListenerProduct nlp = copyLP(lp);
//         nlp.setSubscriptionStatus(status);
//         newListenerProduct.add(nlp);
//      }
//       status.setProductHistory(new HashSet<>(newListenerProduct));
//       return status;
//
//   }
//
//   private ListenerProduct copyLP(ListenerProduct lp) {
//      ListenerProduct listenerProduct = new ListenerProduct();
//      listenerProduct.setProductId(lp.getProductId());
//      listenerProduct.setProductOfferingId(lp.getProductOfferingId());
//      listenerProduct.setState(lp.getState());
//      listenerProduct.setSku(lp.getSku());
//      listenerProduct.setSkuIdentifier(lp.getSkuIdentifier());
//      listenerProduct.setTimeRemaining(lp.getTimeRemaining());
//      listenerProduct.setNumTimesRenewed(lp.getNumTimesRenewed());
//      listenerProduct.setProductInvalidated(lp.isProductInvalidated());
//      listenerProduct.setDateActivated(lp.getDateActivated());
//      listenerProduct.setDateCreated(lp.getDateCreated());
//      return listenerProduct;
//
//   }
//
//
//   public  void getDataFrom(EntityManager entityManager){
//       //SubscriptionStatus status = entityManager.find(SubscriptionStatus.class,2744l);
//       SubscriptionStatus status = entityManager.find(SubscriptionStatus.class,2008440l);
//       System.out.println(status);
//    }
//
//
//   public  EntityManagerFactory getDBEntityManager(DBConfig config){
//      return DBUtils.getDBEntityManager(config);
//   }
//
//}

package dbGarmentHibernate.session;

import dbGarmentHibernate.servicelocator.*;
import java.util.Iterator;

/**
 * Tests the <code>OrderInfoService</code>.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.4 $, $Date: 2006/01/20 13:10:17 $
 */
public class OrderInfoServiceTest extends  junit.framework.TestCase {

   /* Test facade */
   private IOrderInfoService facade;

   /**
    * Test constructor
    */
   public OrderInfoServiceTest(String testName) {
      super(testName);
   }

   /**
    * Main target to run the JUnit test.
    */
   public static void main(String[] args) {
      junit.textui.TestRunner.run(suite());
   }

   /**
    * Runs the test suite.
    */
   public static junit.framework.Test suite() {
      junit.framework.TestSuite suite = new junit.framework.TestSuite(OrderInfoServiceTest.class);
      return suite;
   }

   /**
    * Test if the service can be accessed.
    */
   public void testFacade() {
      System.out.println("test facade");
      try {
         facade = getFacade();
         assertNotNull("Didn't get the facade", facade);
      }
      catch (Exception e) {
         e.printStackTrace();
         fail("Exception thrown during test: " + e.getMessage());
      }
   }

   /**
    * Helper method to get the testfacade.
    */
   private IOrderInfoService getFacade()  {
      try {
         if (facade == null) {
            facade = (IOrderInfoService) ServiceLocator.getService(ServiceLocator.ORDERINFOSERVICE_SERVICE);
         }
         return facade;
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }



   /*******************************************************************************************************************
    *              T E S T S    F O R   B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *              I N T E G R A T I O N   T E S T S  F O R   P E R S I S T E N C E   M E T H O D S
    *******************************************************************************************************************/

   public void testAddOrderInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.OrderInfo model = new dbGarmentHibernate.entity.OrderInfo();
      // Fill the model.
      dbGarmentHibernate.entity.OrderInfo result =
      getFacade().addOrderInfo(model);
      assertEquals(getFacade().getOrderInfo(model.getPrimaryKey()).getPrimaryKey(), model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testSaveOrderInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.OrderInfo model = null;
      java.util.Collection list = getFacade().getOrderInfoList(1,1);
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.OrderInfo) iterator.next();
      }
      // Now change the model and save it.
      getFacade().saveOrderInfo(model);
      dbGarmentHibernate.entity.OrderInfo result =
         getFacade().getOrderInfo(model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testDeleteOrderInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.OrderInfo model = null;
      java.util.Collection list = getFacade().getOrderInfoList();
      int size1 = list.size();
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.OrderInfo) iterator.next();
      }
      getFacade().deleteOrderInfo(model.getPrimaryKey());
      int size2 = getFacade().getOrderInfoListSize();
      // Now try to read the object again.
      assertEquals(size1 - 1, size2);
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testListOrderInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      // These tests assume there is at least one entry in the database.
      // We expect only one result.
      java.util.Collection list = getFacade().getOrderInfoList(1,1);
      assertTrue(list.size()  == 1);

      // Index 0 is not supported. We expect 1 result.
      list = getFacade().getOrderInfoList(0,1);
      assertTrue(list.size() == 1);

      // Negative indexes are reset to 1. We expect 1 result.
      list = getFacade().getOrderInfoList(-300,1);
      assertTrue(list.size() == 1);

      // Negative ranges result in empty lists.
      list = getFacade().getOrderInfoList(3,1);
      assertTrue(list.size() == 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

   public void testFindByOrderInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      java.util.Collection result;
      java.lang.Integer idUser;
      idUser = null;
      // Set the field for testing!
      result = getFacade().findOrderInfoByIdUser(idUser);
      assertTrue(result.size() > 0);
      java.lang.Integer idOrderType;
      idOrderType = null;
      // Set the field for testing!
      result = getFacade().findOrderInfoByIdOrderType(idOrderType);
      assertTrue(result.size() > 0);
      java.lang.Integer productAmount;
      productAmount = null;
      // Set the field for testing!
      result = getFacade().findOrderInfoByProductAmount(productAmount);
      assertTrue(result.size() > 0);
      java.sql.Date orderEstimatedDate;
      orderEstimatedDate = null;
      // Set the field for testing!
      result = getFacade().findOrderInfoByOrderEstimatedDate(orderEstimatedDate);
      assertTrue(result.size() > 0);
      java.lang.Integer idProduct;
      idProduct = null;
      // Set the field for testing!
      result = getFacade().findOrderInfoByIdProduct(idProduct);
      assertTrue(result.size() > 0);
      java.lang.String orderDetail;
      orderDetail = null;
      // Set the field for testing!
      result = getFacade().findOrderInfoByOrderDetail(orderDetail);
      assertTrue(result.size() > 0);
      java.lang.Integer idOrderStatus;
      idOrderStatus = null;
      // Set the field for testing!
      result = getFacade().findOrderInfoByIdOrderStatus(idOrderStatus);
      assertTrue(result.size() > 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

}

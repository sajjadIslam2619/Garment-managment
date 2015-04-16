package dbGarmentHibernate.session;

import dbGarmentHibernate.servicelocator.*;
import java.util.Iterator;

/**
 * Tests the <code>OrderStatusTypeService</code>.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.4 $, $Date: 2006/01/20 13:10:17 $
 */
public class OrderStatusTypeServiceTest extends  junit.framework.TestCase {

   /* Test facade */
   private IOrderStatusTypeService facade;

   /**
    * Test constructor
    */
   public OrderStatusTypeServiceTest(String testName) {
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
      junit.framework.TestSuite suite = new junit.framework.TestSuite(OrderStatusTypeServiceTest.class);
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
   private IOrderStatusTypeService getFacade()  {
      try {
         if (facade == null) {
            facade = (IOrderStatusTypeService) ServiceLocator.getService(ServiceLocator.ORDERSTATUSTYPESERVICE_SERVICE);
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

   public void testAddOrderStatusType() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.OrderStatusType model = new dbGarmentHibernate.entity.OrderStatusType();
      // Fill the model.
      dbGarmentHibernate.entity.OrderStatusType result =
      getFacade().addOrderStatusType(model);
      assertEquals(getFacade().getOrderStatusType(model.getPrimaryKey()).getPrimaryKey(), model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testSaveOrderStatusType() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.OrderStatusType model = null;
      java.util.Collection list = getFacade().getOrderStatusTypeList(1,1);
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.OrderStatusType) iterator.next();
      }
      // Now change the model and save it.
      getFacade().saveOrderStatusType(model);
      dbGarmentHibernate.entity.OrderStatusType result =
         getFacade().getOrderStatusType(model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testDeleteOrderStatusType() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.OrderStatusType model = null;
      java.util.Collection list = getFacade().getOrderStatusTypeList();
      int size1 = list.size();
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.OrderStatusType) iterator.next();
      }
      getFacade().deleteOrderStatusType(model.getPrimaryKey());
      int size2 = getFacade().getOrderStatusTypeListSize();
      // Now try to read the object again.
      assertEquals(size1 - 1, size2);
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testListOrderStatusType() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      // These tests assume there is at least one entry in the database.
      // We expect only one result.
      java.util.Collection list = getFacade().getOrderStatusTypeList(1,1);
      assertTrue(list.size()  == 1);

      // Index 0 is not supported. We expect 1 result.
      list = getFacade().getOrderStatusTypeList(0,1);
      assertTrue(list.size() == 1);

      // Negative indexes are reset to 1. We expect 1 result.
      list = getFacade().getOrderStatusTypeList(-300,1);
      assertTrue(list.size() == 1);

      // Negative ranges result in empty lists.
      list = getFacade().getOrderStatusTypeList(3,1);
      assertTrue(list.size() == 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

   public void testFindByOrderStatusType() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      java.util.Collection result;
      java.lang.String orderStatusName;
      orderStatusName = null;
      // Set the field for testing!
      result = getFacade().findOrderStatusTypeByOrderStatusName(orderStatusName);
      assertTrue(result.size() > 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

}

package dbGarmentHibernate.session;

import dbGarmentHibernate.servicelocator.*;
import java.util.Iterator;

/**
 * Tests the <code>OrderTypeService</code>.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.4 $, $Date: 2006/01/20 13:10:17 $
 */
public class OrderTypeServiceTest extends  junit.framework.TestCase {

   /* Test facade */
   private IOrderTypeService facade;

   /**
    * Test constructor
    */
   public OrderTypeServiceTest(String testName) {
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
      junit.framework.TestSuite suite = new junit.framework.TestSuite(OrderTypeServiceTest.class);
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
   private IOrderTypeService getFacade()  {
      try {
         if (facade == null) {
            facade = (IOrderTypeService) ServiceLocator.getService(ServiceLocator.ORDERTYPESERVICE_SERVICE);
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

   public void testAddOrderType() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.OrderType model = new dbGarmentHibernate.entity.OrderType();
      // Fill the model.
      dbGarmentHibernate.entity.OrderType result =
      getFacade().addOrderType(model);
      assertEquals(getFacade().getOrderType(model.getPrimaryKey()).getPrimaryKey(), model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testSaveOrderType() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.OrderType model = null;
      java.util.Collection list = getFacade().getOrderTypeList(1,1);
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.OrderType) iterator.next();
      }
      // Now change the model and save it.
      getFacade().saveOrderType(model);
      dbGarmentHibernate.entity.OrderType result =
         getFacade().getOrderType(model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testDeleteOrderType() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.OrderType model = null;
      java.util.Collection list = getFacade().getOrderTypeList();
      int size1 = list.size();
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.OrderType) iterator.next();
      }
      getFacade().deleteOrderType(model.getPrimaryKey());
      int size2 = getFacade().getOrderTypeListSize();
      // Now try to read the object again.
      assertEquals(size1 - 1, size2);
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testListOrderType() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      // These tests assume there is at least one entry in the database.
      // We expect only one result.
      java.util.Collection list = getFacade().getOrderTypeList(1,1);
      assertTrue(list.size()  == 1);

      // Index 0 is not supported. We expect 1 result.
      list = getFacade().getOrderTypeList(0,1);
      assertTrue(list.size() == 1);

      // Negative indexes are reset to 1. We expect 1 result.
      list = getFacade().getOrderTypeList(-300,1);
      assertTrue(list.size() == 1);

      // Negative ranges result in empty lists.
      list = getFacade().getOrderTypeList(3,1);
      assertTrue(list.size() == 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

   public void testFindByOrderType() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      java.util.Collection result;
      java.lang.String orderName;
      orderName = null;
      // Set the field for testing!
      result = getFacade().findOrderTypeByOrderName(orderName);
      assertTrue(result.size() > 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

}

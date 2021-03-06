package dbGarmentHibernate.session;

import dbGarmentHibernate.servicelocator.*;
import java.util.Iterator;

/**
 * Tests the <code>RawMatarialService</code>.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.4 $, $Date: 2006/01/20 13:10:17 $
 */
public class RawMatarialServiceTest extends  junit.framework.TestCase {

   /* Test facade */
   private IRawMatarialService facade;

   /**
    * Test constructor
    */
   public RawMatarialServiceTest(String testName) {
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
      junit.framework.TestSuite suite = new junit.framework.TestSuite(RawMatarialServiceTest.class);
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
   private IRawMatarialService getFacade()  {
      try {
         if (facade == null) {
            facade = (IRawMatarialService) ServiceLocator.getService(ServiceLocator.RAWMATARIALSERVICE_SERVICE);
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

   public void testAddRawMatarial() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.RawMatarial model = new dbGarmentHibernate.entity.RawMatarial();
      // Fill the model.
      dbGarmentHibernate.entity.RawMatarial result =
      getFacade().addRawMatarial(model);
      assertEquals(getFacade().getRawMatarial(model.getPrimaryKey()).getPrimaryKey(), model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testSaveRawMatarial() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.RawMatarial model = null;
      java.util.Collection list = getFacade().getRawMatarialList(1,1);
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.RawMatarial) iterator.next();
      }
      // Now change the model and save it.
      getFacade().saveRawMatarial(model);
      dbGarmentHibernate.entity.RawMatarial result =
         getFacade().getRawMatarial(model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testDeleteRawMatarial() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.RawMatarial model = null;
      java.util.Collection list = getFacade().getRawMatarialList();
      int size1 = list.size();
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.RawMatarial) iterator.next();
      }
      getFacade().deleteRawMatarial(model.getPrimaryKey());
      int size2 = getFacade().getRawMatarialListSize();
      // Now try to read the object again.
      assertEquals(size1 - 1, size2);
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testListRawMatarial() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      // These tests assume there is at least one entry in the database.
      // We expect only one result.
      java.util.Collection list = getFacade().getRawMatarialList(1,1);
      assertTrue(list.size()  == 1);

      // Index 0 is not supported. We expect 1 result.
      list = getFacade().getRawMatarialList(0,1);
      assertTrue(list.size() == 1);

      // Negative indexes are reset to 1. We expect 1 result.
      list = getFacade().getRawMatarialList(-300,1);
      assertTrue(list.size() == 1);

      // Negative ranges result in empty lists.
      list = getFacade().getRawMatarialList(3,1);
      assertTrue(list.size() == 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

   public void testFindByRawMatarial() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      java.util.Collection result;
      java.lang.Integer idRawMaterialType;
      idRawMaterialType = null;
      // Set the field for testing!
      result = getFacade().findRawMatarialByIdRawMaterialType(idRawMaterialType);
      assertTrue(result.size() > 0);
      java.lang.Integer rawMaterialAmount;
      rawMaterialAmount = null;
      // Set the field for testing!
      result = getFacade().findRawMatarialByRawMaterialAmount(rawMaterialAmount);
      assertTrue(result.size() > 0);
      java.lang.Double perUnitPrice;
      perUnitPrice = null;
      // Set the field for testing!
      result = getFacade().findRawMatarialByPerUnitPrice(perUnitPrice);
      assertTrue(result.size() > 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

}

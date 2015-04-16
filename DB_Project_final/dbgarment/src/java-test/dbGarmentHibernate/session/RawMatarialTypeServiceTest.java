package dbGarmentHibernate.session;

import dbGarmentHibernate.servicelocator.*;
import java.util.Iterator;

/**
 * Tests the <code>RawMatarialTypeService</code>.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.4 $, $Date: 2006/01/20 13:10:17 $
 */
public class RawMatarialTypeServiceTest extends  junit.framework.TestCase {

   /* Test facade */
   private IRawMatarialTypeService facade;

   /**
    * Test constructor
    */
   public RawMatarialTypeServiceTest(String testName) {
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
      junit.framework.TestSuite suite = new junit.framework.TestSuite(RawMatarialTypeServiceTest.class);
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
   private IRawMatarialTypeService getFacade()  {
      try {
         if (facade == null) {
            facade = (IRawMatarialTypeService) ServiceLocator.getService(ServiceLocator.RAWMATARIALTYPESERVICE_SERVICE);
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

   public void testAddRawMatarialType() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.RawMatarialType model = new dbGarmentHibernate.entity.RawMatarialType();
      // Fill the model.
      dbGarmentHibernate.entity.RawMatarialType result =
      getFacade().addRawMatarialType(model);
      assertEquals(getFacade().getRawMatarialType(model.getPrimaryKey()).getPrimaryKey(), model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testSaveRawMatarialType() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.RawMatarialType model = null;
      java.util.Collection list = getFacade().getRawMatarialTypeList(1,1);
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.RawMatarialType) iterator.next();
      }
      // Now change the model and save it.
      getFacade().saveRawMatarialType(model);
      dbGarmentHibernate.entity.RawMatarialType result =
         getFacade().getRawMatarialType(model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testDeleteRawMatarialType() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.RawMatarialType model = null;
      java.util.Collection list = getFacade().getRawMatarialTypeList();
      int size1 = list.size();
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.RawMatarialType) iterator.next();
      }
      getFacade().deleteRawMatarialType(model.getPrimaryKey());
      int size2 = getFacade().getRawMatarialTypeListSize();
      // Now try to read the object again.
      assertEquals(size1 - 1, size2);
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testListRawMatarialType() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      // These tests assume there is at least one entry in the database.
      // We expect only one result.
      java.util.Collection list = getFacade().getRawMatarialTypeList(1,1);
      assertTrue(list.size()  == 1);

      // Index 0 is not supported. We expect 1 result.
      list = getFacade().getRawMatarialTypeList(0,1);
      assertTrue(list.size() == 1);

      // Negative indexes are reset to 1. We expect 1 result.
      list = getFacade().getRawMatarialTypeList(-300,1);
      assertTrue(list.size() == 1);

      // Negative ranges result in empty lists.
      list = getFacade().getRawMatarialTypeList(3,1);
      assertTrue(list.size() == 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

   public void testFindByRawMatarialType() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      java.util.Collection result;
      java.lang.String rawMaterialTypeName;
      rawMaterialTypeName = null;
      // Set the field for testing!
      result = getFacade().findRawMatarialTypeByRawMaterialTypeName(rawMaterialTypeName);
      assertTrue(result.size() > 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

}

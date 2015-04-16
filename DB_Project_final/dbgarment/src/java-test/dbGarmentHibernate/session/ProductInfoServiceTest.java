package dbGarmentHibernate.session;

import dbGarmentHibernate.servicelocator.*;
import java.util.Iterator;

/**
 * Tests the <code>ProductInfoService</code>.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.4 $, $Date: 2006/01/20 13:10:17 $
 */
public class ProductInfoServiceTest extends  junit.framework.TestCase {

   /* Test facade */
   private IProductInfoService facade;

   /**
    * Test constructor
    */
   public ProductInfoServiceTest(String testName) {
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
      junit.framework.TestSuite suite = new junit.framework.TestSuite(ProductInfoServiceTest.class);
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
   private IProductInfoService getFacade()  {
      try {
         if (facade == null) {
            facade = (IProductInfoService) ServiceLocator.getService(ServiceLocator.PRODUCTINFOSERVICE_SERVICE);
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

   public void testAddProductInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.ProductInfo model = new dbGarmentHibernate.entity.ProductInfo();
      // Fill the model.
      dbGarmentHibernate.entity.ProductInfo result =
      getFacade().addProductInfo(model);
      assertEquals(getFacade().getProductInfo(model.getPrimaryKey()).getPrimaryKey(), model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testSaveProductInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.ProductInfo model = null;
      java.util.Collection list = getFacade().getProductInfoList(1,1);
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.ProductInfo) iterator.next();
      }
      // Now change the model and save it.
      getFacade().saveProductInfo(model);
      dbGarmentHibernate.entity.ProductInfo result =
         getFacade().getProductInfo(model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testDeleteProductInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.ProductInfo model = null;
      java.util.Collection list = getFacade().getProductInfoList();
      int size1 = list.size();
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.ProductInfo) iterator.next();
      }
      getFacade().deleteProductInfo(model.getPrimaryKey());
      int size2 = getFacade().getProductInfoListSize();
      // Now try to read the object again.
      assertEquals(size1 - 1, size2);
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testListProductInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      // These tests assume there is at least one entry in the database.
      // We expect only one result.
      java.util.Collection list = getFacade().getProductInfoList(1,1);
      assertTrue(list.size()  == 1);

      // Index 0 is not supported. We expect 1 result.
      list = getFacade().getProductInfoList(0,1);
      assertTrue(list.size() == 1);

      // Negative indexes are reset to 1. We expect 1 result.
      list = getFacade().getProductInfoList(-300,1);
      assertTrue(list.size() == 1);

      // Negative ranges result in empty lists.
      list = getFacade().getProductInfoList(3,1);
      assertTrue(list.size() == 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

   public void testFindByProductInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      java.util.Collection result;
      java.lang.String productName;
      productName = null;
      // Set the field for testing!
      result = getFacade().findProductInfoByProductName(productName);
      assertTrue(result.size() > 0);
      java.lang.Integer idProductType;
      idProductType = null;
      // Set the field for testing!
      result = getFacade().findProductInfoByIdProductType(idProductType);
      assertTrue(result.size() > 0);
      java.lang.Double productPrice;
      productPrice = null;
      // Set the field for testing!
      result = getFacade().findProductInfoByProductPrice(productPrice);
      assertTrue(result.size() > 0);
      java.lang.String productImage;
      productImage = null;
      // Set the field for testing!
      result = getFacade().findProductInfoByProductImage(productImage);
      assertTrue(result.size() > 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

}

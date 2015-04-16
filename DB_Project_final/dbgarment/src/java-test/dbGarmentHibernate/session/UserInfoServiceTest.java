package dbGarmentHibernate.session;

import dbGarmentHibernate.servicelocator.*;
import java.util.Iterator;

/**
 * Tests the <code>UserInfoService</code>.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.4 $, $Date: 2006/01/20 13:10:17 $
 */
public class UserInfoServiceTest extends  junit.framework.TestCase {

   /* Test facade */
   private IUserInfoService facade;

   /**
    * Test constructor
    */
   public UserInfoServiceTest(String testName) {
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
      junit.framework.TestSuite suite = new junit.framework.TestSuite(UserInfoServiceTest.class);
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
   private IUserInfoService getFacade()  {
      try {
         if (facade == null) {
            facade = (IUserInfoService) ServiceLocator.getService(ServiceLocator.USERINFOSERVICE_SERVICE);
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

   public void testAddUserInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.UserInfo model = new dbGarmentHibernate.entity.UserInfo();
      // Fill the model.
      dbGarmentHibernate.entity.UserInfo result =
      getFacade().addUserInfo(model);
      assertEquals(getFacade().getUserInfo(model.getPrimaryKey()).getPrimaryKey(), model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testSaveUserInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.UserInfo model = null;
      java.util.Collection list = getFacade().getUserInfoList(1,1);
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.UserInfo) iterator.next();
      }
      // Now change the model and save it.
      getFacade().saveUserInfo(model);
      dbGarmentHibernate.entity.UserInfo result =
         getFacade().getUserInfo(model.getPrimaryKey());
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testDeleteUserInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
   try {
      dbGarmentHibernate.entity.UserInfo model = null;
      java.util.Collection list = getFacade().getUserInfoList();
      int size1 = list.size();
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
         model = (dbGarmentHibernate.entity.UserInfo) iterator.next();
      }
      getFacade().deleteUserInfo(model.getPrimaryKey());
      int size2 = getFacade().getUserInfoListSize();
      // Now try to read the object again.
      assertEquals(size1 - 1, size2);
       } catch (Exception e) {
            fail("No exception expected");
       }
   }

   public void testListUserInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      // These tests assume there is at least one entry in the database.
      // We expect only one result.
      java.util.Collection list = getFacade().getUserInfoList(1,1);
      assertTrue(list.size()  == 1);

      // Index 0 is not supported. We expect 1 result.
      list = getFacade().getUserInfoList(0,1);
      assertTrue(list.size() == 1);

      // Negative indexes are reset to 1. We expect 1 result.
      list = getFacade().getUserInfoList(-300,1);
      assertTrue(list.size() == 1);

      // Negative ranges result in empty lists.
      list = getFacade().getUserInfoList(3,1);
      assertTrue(list.size() == 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

   public void testFindByUserInfo() throws dbGarmentHibernate.exception.GenericBusinessException {
      try {
      java.util.Collection result;
      java.lang.String userName;
      userName = null;
      // Set the field for testing!
      result = getFacade().findUserInfoByUserName(userName);
      assertTrue(result.size() > 0);
      java.lang.String fullName;
      fullName = null;
      // Set the field for testing!
      result = getFacade().findUserInfoByFullName(fullName);
      assertTrue(result.size() > 0);
      java.lang.String userEmail;
      userEmail = null;
      // Set the field for testing!
      result = getFacade().findUserInfoByUserEmail(userEmail);
      assertTrue(result.size() > 0);
      java.lang.Integer idUserType;
      idUserType = null;
      // Set the field for testing!
      result = getFacade().findUserInfoByIdUserType(idUserType);
      assertTrue(result.size() > 0);
      java.lang.String password;
      password = null;
      // Set the field for testing!
      result = getFacade().findUserInfoByPassword(password);
      assertTrue(result.size() > 0);
      java.lang.String companyName;
      companyName = null;
      // Set the field for testing!
      result = getFacade().findUserInfoByCompanyName(companyName);
      assertTrue(result.size() > 0);
      } catch (Exception e) {
            fail("No exception expected");
      }
   }

}

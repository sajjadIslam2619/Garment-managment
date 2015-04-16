package dbGarmentHibernate.forms;

import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IUserInfoService;
import com.finalist.Constants;
import dbGarmentHibernate.session.*;

/**
 * Form bean for the userinfo form page.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.3 $, $Date: 2006/01/20 13:10:17 $
 * @struts.form name="userInfoForm"
 */
public final class UserInfoForm extends ServiceBaseForm {
   private String mode;
   private String idUser;
   private String userName;
   private String fullName;
   private String userEmail;
   private String idUserType;
   private String password;
   private String companyName;

   /**
    * Returns the value of the <code>mode</code> property.
    *
    * @return the value of the <code>mode</code> property.
    */
   public String getMode() {
      return mode;
   }

   /**
    * Sets the value of the <code>mode</code> property.
    *
    * @param mode the mode
    */
   public void setMode(String mode) {
      this.mode = mode;
   }

   /**
    * Returns the value of the <code>idUser</code> property.
    *
    * @return the value of the <code>idUser</code> property.
    */
   public String getIdUser() {
      return idUser;
   }

   /**
    * Sets the value of the <code>idUser</code> property.
    *
    * @param idUser a value for <code>idUser</code>.
    */
   public void setIdUser(String idUser) {
      this.idUser = idUser;
   }

   /**
    * Returns the value of the <code>userName</code> property.
    *
    * @return the value of the <code>userName</code> property.
    */
   public String getUserName() {
      return userName;
   }

   /**
    * Sets the value of the <code>userName</code> property.
    *
    * @param userName a value for <code>userName</code>.
    */
   public void setUserName(String userName) {
      this.userName = userName;
   }

   /**
    * Returns the value of the <code>fullName</code> property.
    *
    * @return the value of the <code>fullName</code> property.
    */
   public String getFullName() {
      return fullName;
   }

   /**
    * Sets the value of the <code>fullName</code> property.
    *
    * @param fullName a value for <code>fullName</code>.
    */
   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   /**
    * Returns the value of the <code>userEmail</code> property.
    *
    * @return the value of the <code>userEmail</code> property.
    */
   public String getUserEmail() {
      return userEmail;
   }

   /**
    * Sets the value of the <code>userEmail</code> property.
    *
    * @param userEmail a value for <code>userEmail</code>.
    */
   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }

   /**
    * Returns the value of the <code>idUserType</code> property.
    *
    * @return the value of the <code>idUserType</code> property.
    */
   public String getIdUserType() {
      return idUserType;
   }

   /**
    * Sets the value of the <code>idUserType</code> property.
    *
    * @param idUserType a value for <code>idUserType</code>.
    */
   public void setIdUserType(String idUserType) {
      this.idUserType = idUserType;
   }

   /**
    * Returns the value of the <code>password</code> property.
    *
    * @return the value of the <code>password</code> property.
    */
   public String getPassword() {
      return password;
   }

   /**
    * Sets the value of the <code>password</code> property.
    *
    * @param password a value for <code>password</code>.
    */
   public void setPassword(String password) {
      this.password = password;
   }

   /**
    * Returns the value of the <code>companyName</code> property.
    *
    * @return the value of the <code>companyName</code> property.
    */
   public String getCompanyName() {
      return companyName;
   }

   /**
    * Sets the value of the <code>companyName</code> property.
    *
    * @param companyName a value for <code>companyName</code>.
    */
   public void setCompanyName(String companyName) {
      this.companyName = companyName;
   }

   /**
    * Obtains the total number of userInfo objects.
    *
    * @throws Exception exception
    * @return an integer value.
    */
   public int getListSize() throws Exception {
      return getUserInfoServiceService().getUserInfoListSize();
   }

   /**
    * Obtains a collection of all userInfo objects.
    *
    * @throws Exception exception
    * @return a collection of UserInfo objects.
    */
   public Collection getList() throws Exception {
      Collection result = getUserInfoServiceService().getUserInfoList();
      if (result.size() > 0) {
        return result;
      } else {
        return new ArrayList();
      }

   }
   /**
    * Performs server-side validation on the properties that have been set from this HTTP request,
    * and returns an <code>ActionErrors</code> object that encapsulates any
    * validation errors that have been found.  If no errors are found, returns
    * <code>null</code> or an <code>ActionErrors</code> object with no
    * recorded error messages.
    * <p>
    * <b>NOTE:</b> Please override this method and not the ValidatorForm 'validate'
    * method - any errors thrown in an overwritten 'validate' method will not be handled
    * by the GenericExceptionHandling framework.
    *
    * @param mapping The mapping used to select this instance
    * @param request The servlet request we are processing
    * @return a list with errors or <code>null</code> iIf no errors are found
    * @throws Exception - all exceptions are handled by the GenericExceptions framework
    * (no stack trace dumps shown to the user!)
    */
   public ActionErrors doValidate(ActionMapping mapping, HttpServletRequest request) throws Exception {
      boolean noValidate = (request.getParameter(Constants.SUBMIT_NO_VALIDATION) != null);
      return noValidate ? null : super.doValidate(mapping, request);
   }

   /**
    * Returns the string representation of the form.
    *
    * @return the string representation of the form
    */
   public String toString() {
      StringBuffer sb = new StringBuffer();
      sb.append("\nidUser : ").append(idUser);
      sb.append("\nuserName : ").append(userName);
      sb.append("\nfullName : ").append(fullName);
      sb.append("\nuserEmail : ").append(userEmail);
      sb.append("\nidUserType : ").append(idUserType);
      sb.append("\npassword : ").append(password);
      sb.append("\ncompanyName : ").append(companyName);
      return sb.toString();
   }
}

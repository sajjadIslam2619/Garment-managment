package dbGarmentHibernate.forms;

import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IOrderTypeService;
import com.finalist.Constants;
import dbGarmentHibernate.session.*;

/**
 * Form bean for the ordertype form page.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.3 $, $Date: 2006/01/20 13:10:17 $
 * @struts.form name="orderTypeForm"
 */
public final class OrderTypeForm extends ServiceBaseForm {
   private String mode;
   private String idOrderType;
   private String orderName;

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
    * Returns the value of the <code>idOrderType</code> property.
    *
    * @return the value of the <code>idOrderType</code> property.
    */
   public String getIdOrderType() {
      return idOrderType;
   }

   /**
    * Sets the value of the <code>idOrderType</code> property.
    *
    * @param idOrderType a value for <code>idOrderType</code>.
    */
   public void setIdOrderType(String idOrderType) {
      this.idOrderType = idOrderType;
   }

   /**
    * Returns the value of the <code>orderName</code> property.
    *
    * @return the value of the <code>orderName</code> property.
    */
   public String getOrderName() {
      return orderName;
   }

   /**
    * Sets the value of the <code>orderName</code> property.
    *
    * @param orderName a value for <code>orderName</code>.
    */
   public void setOrderName(String orderName) {
      this.orderName = orderName;
   }

   /**
    * Obtains the total number of orderType objects.
    *
    * @throws Exception exception
    * @return an integer value.
    */
   public int getListSize() throws Exception {
      return getOrderTypeServiceService().getOrderTypeListSize();
   }

   /**
    * Obtains a collection of all orderType objects.
    *
    * @throws Exception exception
    * @return a collection of OrderType objects.
    */
   public Collection getList() throws Exception {
      Collection result = getOrderTypeServiceService().getOrderTypeList();
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
      sb.append("\nidOrderType : ").append(idOrderType);
      sb.append("\norderName : ").append(orderName);
      return sb.toString();
   }
}

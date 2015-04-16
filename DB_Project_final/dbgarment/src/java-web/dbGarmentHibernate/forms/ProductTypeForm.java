package dbGarmentHibernate.forms;

import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IProductTypeService;
import com.finalist.Constants;
import dbGarmentHibernate.session.*;

/**
 * Form bean for the producttype form page.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.3 $, $Date: 2006/01/20 13:10:17 $
 * @struts.form name="productTypeForm"
 */
public final class ProductTypeForm extends ServiceBaseForm {
   private String mode;
   private String idProductType;
   private String productTypeName;

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
    * Returns the value of the <code>idProductType</code> property.
    *
    * @return the value of the <code>idProductType</code> property.
    */
   public String getIdProductType() {
      return idProductType;
   }

   /**
    * Sets the value of the <code>idProductType</code> property.
    *
    * @param idProductType a value for <code>idProductType</code>.
    */
   public void setIdProductType(String idProductType) {
      this.idProductType = idProductType;
   }

   /**
    * Returns the value of the <code>productTypeName</code> property.
    *
    * @return the value of the <code>productTypeName</code> property.
    */
   public String getProductTypeName() {
      return productTypeName;
   }

   /**
    * Sets the value of the <code>productTypeName</code> property.
    *
    * @param productTypeName a value for <code>productTypeName</code>.
    */
   public void setProductTypeName(String productTypeName) {
      this.productTypeName = productTypeName;
   }

   /**
    * Obtains the total number of productType objects.
    *
    * @throws Exception exception
    * @return an integer value.
    */
   public int getListSize() throws Exception {
      return getProductTypeServiceService().getProductTypeListSize();
   }

   /**
    * Obtains a collection of all productType objects.
    *
    * @throws Exception exception
    * @return a collection of ProductType objects.
    */
   public Collection getList() throws Exception {
      Collection result = getProductTypeServiceService().getProductTypeList();
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
      sb.append("\nidProductType : ").append(idProductType);
      sb.append("\nproductTypeName : ").append(productTypeName);
      return sb.toString();
   }
}

package dbGarmentHibernate.forms;

import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IProductInfoService;
import com.finalist.Constants;
import dbGarmentHibernate.session.*;

/**
 * Form bean for the productinfo form page.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.3 $, $Date: 2006/01/20 13:10:17 $
 * @struts.form name="productInfoForm"
 */
public final class ProductInfoForm extends ServiceBaseForm {
   private String mode;
   private String idProduct;
   private String productName;
   private String idProductType;
   private String productPrice;
   private String productImage;

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
    * Returns the value of the <code>idProduct</code> property.
    *
    * @return the value of the <code>idProduct</code> property.
    */
   public String getIdProduct() {
      return idProduct;
   }

   /**
    * Sets the value of the <code>idProduct</code> property.
    *
    * @param idProduct a value for <code>idProduct</code>.
    */
   public void setIdProduct(String idProduct) {
      this.idProduct = idProduct;
   }

   /**
    * Returns the value of the <code>productName</code> property.
    *
    * @return the value of the <code>productName</code> property.
    */
   public String getProductName() {
      return productName;
   }

   /**
    * Sets the value of the <code>productName</code> property.
    *
    * @param productName a value for <code>productName</code>.
    */
   public void setProductName(String productName) {
      this.productName = productName;
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
    * Returns the value of the <code>productPrice</code> property.
    *
    * @return the value of the <code>productPrice</code> property.
    */
   public String getProductPrice() {
      return productPrice;
   }

   /**
    * Sets the value of the <code>productPrice</code> property.
    *
    * @param productPrice a value for <code>productPrice</code>.
    */
   public void setProductPrice(String productPrice) {
      this.productPrice = productPrice;
   }

   /**
    * Returns the value of the <code>productImage</code> property.
    *
    * @return the value of the <code>productImage</code> property.
    */
   public String getProductImage() {
      return productImage;
   }

   /**
    * Sets the value of the <code>productImage</code> property.
    *
    * @param productImage a value for <code>productImage</code>.
    */
   public void setProductImage(String productImage) {
      this.productImage = productImage;
   }

   /**
    * Obtains the total number of productInfo objects.
    *
    * @throws Exception exception
    * @return an integer value.
    */
   public int getListSize() throws Exception {
      return getProductInfoServiceService().getProductInfoListSize();
   }

   /**
    * Obtains a collection of all productInfo objects.
    *
    * @throws Exception exception
    * @return a collection of ProductInfo objects.
    */
   public Collection getList() throws Exception {
      Collection result = getProductInfoServiceService().getProductInfoList();
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
      sb.append("\nidProduct : ").append(idProduct);
      sb.append("\nproductName : ").append(productName);
      sb.append("\nidProductType : ").append(idProductType);
      sb.append("\nproductPrice : ").append(productPrice);
      sb.append("\nproductImage : ").append(productImage);
      return sb.toString();
   }
}

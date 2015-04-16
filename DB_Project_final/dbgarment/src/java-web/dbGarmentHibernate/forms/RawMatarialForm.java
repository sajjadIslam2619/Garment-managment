package dbGarmentHibernate.forms;

import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IRawMatarialService;
import com.finalist.Constants;
import dbGarmentHibernate.session.*;

/**
 * Form bean for the rawmatarial form page.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.3 $, $Date: 2006/01/20 13:10:17 $
 * @struts.form name="rawMatarialForm"
 */
public final class RawMatarialForm extends ServiceBaseForm {
   private String mode;
   private String idRawMatarial;
   private String idRawMaterialType;
   private String rawMaterialAmount;
   private String perUnitPrice;

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
    * Returns the value of the <code>idRawMatarial</code> property.
    *
    * @return the value of the <code>idRawMatarial</code> property.
    */
   public String getIdRawMatarial() {
      return idRawMatarial;
   }

   /**
    * Sets the value of the <code>idRawMatarial</code> property.
    *
    * @param idRawMatarial a value for <code>idRawMatarial</code>.
    */
   public void setIdRawMatarial(String idRawMatarial) {
      this.idRawMatarial = idRawMatarial;
   }

   /**
    * Returns the value of the <code>idRawMaterialType</code> property.
    *
    * @return the value of the <code>idRawMaterialType</code> property.
    */
   public String getIdRawMaterialType() {
      return idRawMaterialType;
   }

   /**
    * Sets the value of the <code>idRawMaterialType</code> property.
    *
    * @param idRawMaterialType a value for <code>idRawMaterialType</code>.
    */
   public void setIdRawMaterialType(String idRawMaterialType) {
      this.idRawMaterialType = idRawMaterialType;
   }

   /**
    * Returns the value of the <code>rawMaterialAmount</code> property.
    *
    * @return the value of the <code>rawMaterialAmount</code> property.
    */
   public String getRawMaterialAmount() {
      return rawMaterialAmount;
   }

   /**
    * Sets the value of the <code>rawMaterialAmount</code> property.
    *
    * @param rawMaterialAmount a value for <code>rawMaterialAmount</code>.
    */
   public void setRawMaterialAmount(String rawMaterialAmount) {
      this.rawMaterialAmount = rawMaterialAmount;
   }

   /**
    * Returns the value of the <code>perUnitPrice</code> property.
    *
    * @return the value of the <code>perUnitPrice</code> property.
    */
   public String getPerUnitPrice() {
      return perUnitPrice;
   }

   /**
    * Sets the value of the <code>perUnitPrice</code> property.
    *
    * @param perUnitPrice a value for <code>perUnitPrice</code>.
    */
   public void setPerUnitPrice(String perUnitPrice) {
      this.perUnitPrice = perUnitPrice;
   }

   /**
    * Obtains the total number of rawMatarial objects.
    *
    * @throws Exception exception
    * @return an integer value.
    */
   public int getListSize() throws Exception {
      return getRawMatarialServiceService().getRawMatarialListSize();
   }

   /**
    * Obtains a collection of all rawMatarial objects.
    *
    * @throws Exception exception
    * @return a collection of RawMatarial objects.
    */
   public Collection getList() throws Exception {
      Collection result = getRawMatarialServiceService().getRawMatarialList();
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
      sb.append("\nidRawMatarial : ").append(idRawMatarial);
      sb.append("\nidRawMaterialType : ").append(idRawMaterialType);
      sb.append("\nrawMaterialAmount : ").append(rawMaterialAmount);
      sb.append("\nperUnitPrice : ").append(perUnitPrice);
      return sb.toString();
   }
}

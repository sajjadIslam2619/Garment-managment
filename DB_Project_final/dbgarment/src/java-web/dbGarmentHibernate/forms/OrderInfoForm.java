package dbGarmentHibernate.forms;

import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IOrderInfoService;
import com.finalist.Constants;
import dbGarmentHibernate.session.*;

/**
 * Form bean for the orderinfo form page.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.3 $, $Date: 2006/01/20 13:10:17 $
 * @struts.form name="orderInfoForm"
 */
public final class OrderInfoForm extends ServiceBaseForm {
   private String mode;
   private String idOrderInfo;
   private String idUser;
   private String idOrderType;
   private String productAmount;
   private String orderEstimatedDate;
   private String idProduct;
   private String orderDetail;
   private String idOrderStatus;

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
    * Returns the value of the <code>idOrderInfo</code> property.
    *
    * @return the value of the <code>idOrderInfo</code> property.
    */
   public String getIdOrderInfo() {
      return idOrderInfo;
   }

   /**
    * Sets the value of the <code>idOrderInfo</code> property.
    *
    * @param idOrderInfo a value for <code>idOrderInfo</code>.
    */
   public void setIdOrderInfo(String idOrderInfo) {
      this.idOrderInfo = idOrderInfo;
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
    * Returns the value of the <code>productAmount</code> property.
    *
    * @return the value of the <code>productAmount</code> property.
    */
   public String getProductAmount() {
      return productAmount;
   }

   /**
    * Sets the value of the <code>productAmount</code> property.
    *
    * @param productAmount a value for <code>productAmount</code>.
    */
   public void setProductAmount(String productAmount) {
      this.productAmount = productAmount;
   }

   /**
    * Returns the value of the <code>orderEstimatedDate</code> property.
    *
    * @return the value of the <code>orderEstimatedDate</code> property.
    */
   public String getOrderEstimatedDate() {
      return orderEstimatedDate;
   }

   /**
    * Sets the value of the <code>orderEstimatedDate</code> property.
    *
    * @param orderEstimatedDate a value for <code>orderEstimatedDate</code>.
    */
   public void setOrderEstimatedDate(String orderEstimatedDate) {
      this.orderEstimatedDate = orderEstimatedDate;
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
    * Returns the value of the <code>orderDetail</code> property.
    *
    * @return the value of the <code>orderDetail</code> property.
    */
   public String getOrderDetail() {
      return orderDetail;
   }

   /**
    * Sets the value of the <code>orderDetail</code> property.
    *
    * @param orderDetail a value for <code>orderDetail</code>.
    */
   public void setOrderDetail(String orderDetail) {
      this.orderDetail = orderDetail;
   }

   /**
    * Returns the value of the <code>idOrderStatus</code> property.
    *
    * @return the value of the <code>idOrderStatus</code> property.
    */
   public String getIdOrderStatus() {
      return idOrderStatus;
   }

   /**
    * Sets the value of the <code>idOrderStatus</code> property.
    *
    * @param idOrderStatus a value for <code>idOrderStatus</code>.
    */
   public void setIdOrderStatus(String idOrderStatus) {
      this.idOrderStatus = idOrderStatus;
   }

   /**
    * Obtains the total number of orderInfo objects.
    *
    * @throws Exception exception
    * @return an integer value.
    */
   public int getListSize() throws Exception {
      return getOrderInfoServiceService().getOrderInfoListSize();
   }

   /**
    * Obtains a collection of all orderInfo objects.
    *
    * @throws Exception exception
    * @return a collection of OrderInfo objects.
    */
   public Collection getList() throws Exception {
      Collection result = getOrderInfoServiceService().getOrderInfoList();
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
      sb.append("\nidOrderInfo : ").append(idOrderInfo);
      sb.append("\nidUser : ").append(idUser);
      sb.append("\nidOrderType : ").append(idOrderType);
      sb.append("\nproductAmount : ").append(productAmount);
      sb.append("\norderEstimatedDate : ").append(orderEstimatedDate);
      sb.append("\nidProduct : ").append(idProduct);
      sb.append("\norderDetail : ").append(orderDetail);
      sb.append("\nidOrderStatus : ").append(idOrderStatus);
      return sb.toString();
   }
}

package dbGarmentHibernate.actions;

import java.text.SimpleDateFormat;
import javax.servlet.*;
import javax.servlet.http.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IOrderStatusTypeService;
import org.apache.struts.action.*;
import dbGarmentHibernate.forms.*;
import com.finalist.util.log.*;
import com.finalist.util.*;
import com.finalist.util.genelv.struts.GenericAction;
import dbGarmentHibernate.session.*;
import dbGarmentHibernate.entity.*;
import com.finalist.Constants;
import dbGarmentHibernate.forms.OrderStatusTypeForm;

/**
 * Implementation of <strong>Action</strong>
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.3 $, $Date: 2006/01/20 13:10:17 $
 * @struts.action path="/saveOrderStatusType"
 *                type="dbGarmentHibernate.actions.SaveOrderStatusTypeAction"
 *                name="orderStatusTypeForm"
 *                scope="request"
 *                input="/orderstatustype.jsp"
 * @struts.action-forward name="success" path="/initOrderStatusTypeSearch.do"
 *
 */
public class SaveOrderStatusTypeAction extends ServiceAction {
   private transient Logger log = LogService.getLogger(this.getClass());

   /**
    * Performs an action.
    *
    * @param mapping The ActionMapping used to select this instance
    * @param form The optional ActionForm bean for this request (if any)
    * @param request The optional ActionForm bean for this request (if any)
    * @param response The HTTP response we are creating
    * @return describes where and how control should be forwarded, or <code>null</code> if the response has already
    *         been completed
    * @throws Exception in case of an error
    */
   public ActionForward doPerform(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {

      log.info("start doPerform");
      HttpSession session = request.getSession();
      OrderStatusTypeForm subform = (OrderStatusTypeForm) form;
      String idOrderStatusType = subform.getIdOrderStatusType();
      if (idOrderStatusType != null && (idOrderStatusType.equalsIgnoreCase("null") || idOrderStatusType.length() < 1)) {
         idOrderStatusType = null;
         subform.setIdOrderStatusType(null);
      }
      dbGarmentHibernate.session.IOrderStatusTypeService facade = getOrderStatusTypeServiceService();

      // Was this transaction cancelled?
      if (isCancelled(request)) {
         if (mapping.getAttribute() != null) {
            session.removeAttribute(mapping.getAttribute());
         }
         return (mapping.findForward("success"));
      }

      try {
         // Retrieve the information       
         OrderStatusType data = new OrderStatusType();


         PropertyUtilsExt.copyProperties(data, subform);
         // Save to database..
         if ("new".equals(subform.getMode())) {
            if (request.getParameter("submit") != null) {
               facade.addOrderStatusType(data);
            }
         }
         else {
            if (request.getParameter("submit") != null) {
               facade.saveOrderStatusType(data);
            }
            else if (request.getParameter(Constants.SUBMIT_NO_VALIDATION) != null) {
               facade.deleteOrderStatusType(data.getIdOrderStatusType());
            }
         }
      }
      catch (Throwable t) {
         log.error("SaveOrderStatusTypeAction :", t);
         throw new Exception("SaveOrderStatusTypeAction :", t);
      }

      // Remove the obsolete form bean
      if (mapping.getAttribute() != null) {
         if ("request".equals(mapping.getScope())) {
            request.removeAttribute(mapping.getAttribute());
         }
         else {
            session.removeAttribute(mapping.getAttribute());
         }
      }

      return mapping.findForward("success");
   }
}

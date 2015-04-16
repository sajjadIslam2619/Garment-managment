package dbGarmentHibernate.actions;

import javax.servlet.*;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IProductInfoService;
import org.apache.struts.action.*;

import com.finalist.util.log.*;
import com.finalist.util.*;
import com.finalist.util.genelv.struts.GenericAction;
import dbGarmentHibernate.session.*;
import dbGarmentHibernate.entity.*;
import com.finalist.Constants;
import dbGarmentHibernate.forms.*;


/**
 * Struts 'Init' Action; prepares any information needed prior to displaying the 'productInfoForm'.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.4 $, $Date: 2006/04/27 06:56:25 $
 * @struts.action path="/initProductInfo"
 *                type="dbGarmentHibernate.actions.InitProductInfoAction"                 
 *                name="productInfoForm"
 *                scope="request"
 *                validate="false"
 * @struts.action-forward name="success" path="/productinfo.jsp"
 *
 */
public class InitProductInfoAction extends ServiceAction {
   private Logger log = LogService.getLogger(this.getClass());

   /**
    * Performs an action.
    *
    * @param mapping The ActionMapping used to select this instance
    * @param actionForm The optional ActionForm bean for this request (if any)
    * @param request The optional ActionForm bean for this request (if any)
    * @param response The HTTP response we are creating
    * @return describes where and how control should be forwarded, or <code>null</code> if the response has already
    *         been completed
    * @throws Exception in case of an error
    */
   public ActionForward doPerform(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
      log.info("start doPerform");
      ProductInfoForm form = (ProductInfoForm) actionForm;
      HttpSession session  = request.getSession();
      String idProduct = request.getParameter("idProduct");

      if (idProduct != null && idProduct.equalsIgnoreCase("null")) {
         idProduct = null;
      }

      if (form == null) {
         form = new ProductInfoForm();

         if ("request".equals(mapping.getScope())) {
            request.setAttribute(mapping.getAttribute(), form);
         }
         else {
            session.setAttribute(mapping.getAttribute(), form);
         }
      }

      if (idProduct != null &&  true) { // hack to allow automatic generation of sources with JAG
         try {
            form.setMode("change");
            ProductInfo productinfo = getProductInfoServiceService().getProductInfo(new java.lang.Integer(idProduct));
            PropertyUtilsExt.copyProperties(form, productinfo);

         }
         catch (Throwable t) {
            servlet.log("InitProductInfoAction :", t);
            throw new ServletException("InitProductInfoAction :", t);
         }
      }
      else {
         form.setMode("new");
         PropertyUtilsExt.copyProperties(form, new ProductInfo());
      }

      return mapping.findForward("success");
   }
}

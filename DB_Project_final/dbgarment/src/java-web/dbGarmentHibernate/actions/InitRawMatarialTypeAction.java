package dbGarmentHibernate.actions;

import javax.servlet.*;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IRawMatarialTypeService;
import org.apache.struts.action.*;

import com.finalist.util.log.*;
import com.finalist.util.*;
import com.finalist.util.genelv.struts.GenericAction;
import dbGarmentHibernate.session.*;
import dbGarmentHibernate.entity.*;
import com.finalist.Constants;
import dbGarmentHibernate.forms.*;


/**
 * Struts 'Init' Action; prepares any information needed prior to displaying the 'rawMatarialTypeForm'.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.4 $, $Date: 2006/04/27 06:56:25 $
 * @struts.action path="/initRawMatarialType"
 *                type="dbGarmentHibernate.actions.InitRawMatarialTypeAction"                 
 *                name="rawMatarialTypeForm"
 *                scope="request"
 *                validate="false"
 * @struts.action-forward name="success" path="/rawmatarialtype.jsp"
 *
 */
public class InitRawMatarialTypeAction extends ServiceAction {
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
      RawMatarialTypeForm form = (RawMatarialTypeForm) actionForm;
      HttpSession session  = request.getSession();
      String idRawMaterialType = request.getParameter("idRawMaterialType");

      if (idRawMaterialType != null && idRawMaterialType.equalsIgnoreCase("null")) {
         idRawMaterialType = null;
      }

      if (form == null) {
         form = new RawMatarialTypeForm();

         if ("request".equals(mapping.getScope())) {
            request.setAttribute(mapping.getAttribute(), form);
         }
         else {
            session.setAttribute(mapping.getAttribute(), form);
         }
      }

      if (idRawMaterialType != null &&  true) { // hack to allow automatic generation of sources with JAG
         try {
            form.setMode("change");
            RawMatarialType rawmatarialtype = getRawMatarialTypeServiceService().getRawMatarialType(new java.lang.Integer(idRawMaterialType));
            PropertyUtilsExt.copyProperties(form, rawmatarialtype);

         }
         catch (Throwable t) {
            servlet.log("InitRawMatarialTypeAction :", t);
            throw new ServletException("InitRawMatarialTypeAction :", t);
         }
      }
      else {
         form.setMode("new");
         PropertyUtilsExt.copyProperties(form, new RawMatarialType());
      }

      return mapping.findForward("success");
   }
}

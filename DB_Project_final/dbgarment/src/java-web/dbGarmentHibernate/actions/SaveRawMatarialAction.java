package dbGarmentHibernate.actions;

import java.text.SimpleDateFormat;
import javax.servlet.*;
import javax.servlet.http.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IRawMatarialService;
import org.apache.struts.action.*;
import dbGarmentHibernate.forms.*;
import com.finalist.util.log.*;
import com.finalist.util.*;
import com.finalist.util.genelv.struts.GenericAction;
import dbGarmentHibernate.session.*;
import dbGarmentHibernate.entity.*;
import com.finalist.Constants;
import dbGarmentHibernate.forms.RawMatarialForm;

/**
 * Implementation of <strong>Action</strong>
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.3 $, $Date: 2006/01/20 13:10:17 $
 * @struts.action path="/saveRawMatarial"
 *                type="dbGarmentHibernate.actions.SaveRawMatarialAction"
 *                name="rawMatarialForm"
 *                scope="request"
 *                input="/rawmatarial.jsp"
 * @struts.action-forward name="success" path="/initRawMatarialSearch.do"
 *
 */
public class SaveRawMatarialAction extends ServiceAction {
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
      RawMatarialForm subform = (RawMatarialForm) form;
      String idRawMatarial = subform.getIdRawMatarial();
      if (idRawMatarial != null && (idRawMatarial.equalsIgnoreCase("null") || idRawMatarial.length() < 1)) {
         idRawMatarial = null;
         subform.setIdRawMatarial(null);
      }
      dbGarmentHibernate.session.IRawMatarialService facade = getRawMatarialServiceService();

      // Was this transaction cancelled?
      if (isCancelled(request)) {
         if (mapping.getAttribute() != null) {
            session.removeAttribute(mapping.getAttribute());
         }
         return (mapping.findForward("success"));
      }

      try {
         // Retrieve the information       
         RawMatarial data = new RawMatarial();


         PropertyUtilsExt.copyProperties(data, subform);
         // Save to database..
         if ("new".equals(subform.getMode())) {
            if (request.getParameter("submit") != null) {
               facade.addRawMatarial(data);
            }
         }
         else {
            if (request.getParameter("submit") != null) {
               facade.saveRawMatarial(data);
            }
            else if (request.getParameter(Constants.SUBMIT_NO_VALIDATION) != null) {
               facade.deleteRawMatarial(data.getIdRawMatarial());
            }
         }
      }
      catch (Throwable t) {
         log.error("SaveRawMatarialAction :", t);
         throw new Exception("SaveRawMatarialAction :", t);
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

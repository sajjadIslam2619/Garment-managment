package dbGarmentHibernate.actions;

import java.text.SimpleDateFormat;
import javax.servlet.*;
import javax.servlet.http.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IUserInfoService;
import org.apache.struts.action.*;
import dbGarmentHibernate.forms.*;
import com.finalist.util.log.*;
import com.finalist.util.*;
import com.finalist.util.genelv.struts.GenericAction;
import dbGarmentHibernate.session.*;
import dbGarmentHibernate.entity.*;
import com.finalist.Constants;
import dbGarmentHibernate.forms.UserInfoForm;

/**
 * Implementation of <strong>Action</strong>
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.3 $, $Date: 2006/01/20 13:10:17 $
 * @struts.action path="/saveUserInfo"
 *                type="dbGarmentHibernate.actions.SaveUserInfoAction"
 *                name="userInfoForm"
 *                scope="request"
 *                input="/userinfo.jsp"
 * @struts.action-forward name="success" path="/initUserInfoSearch.do"
 *
 */
public class SaveUserInfoAction extends ServiceAction {
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
      UserInfoForm subform = (UserInfoForm) form;
      String idUser = subform.getIdUser();
      if (idUser != null && (idUser.equalsIgnoreCase("null") || idUser.length() < 1)) {
         idUser = null;
         subform.setIdUser(null);
      }
      dbGarmentHibernate.session.IUserInfoService facade = getUserInfoServiceService();

      // Was this transaction cancelled?
      if (isCancelled(request)) {
         if (mapping.getAttribute() != null) {
            session.removeAttribute(mapping.getAttribute());
         }
         return (mapping.findForward("success"));
      }

      try {
         // Retrieve the information       
         UserInfo data = new UserInfo();


         PropertyUtilsExt.copyProperties(data, subform);
         // Save to database..
         if ("new".equals(subform.getMode())) {
            if (request.getParameter("submit") != null) {
               facade.addUserInfo(data);
            }
         }
         else {
            if (request.getParameter("submit") != null) {
               facade.saveUserInfo(data);
            }
            else if (request.getParameter(Constants.SUBMIT_NO_VALIDATION) != null) {
               facade.deleteUserInfo(data.getIdUser());
            }
         }
      }
      catch (Throwable t) {
         log.error("SaveUserInfoAction :", t);
         throw new Exception("SaveUserInfoAction :", t);
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

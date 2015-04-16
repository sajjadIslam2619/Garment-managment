package dbGarmentHibernate.actions;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

import javax.servlet.http.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IUserInfoService;
import org.apache.struts.action.*;
import org.apache.commons.beanutils.BeanUtils;

import com.finalist.util.log.*;
import dbGarmentHibernate.session.*;
import dbGarmentHibernate.forms.UserInfoSearchForm;
import dbGarmentHibernate.entity.*;

/**
 * The initialise Action for the userInfo search screen.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.15 $, $Date: 2006/02/02 18:28:43 $
 * @struts.action path="/initUserInfoSearch"
 *                type="dbGarmentHibernate.actions.InitUserInfoSearchAction"
 *                name="userInfoSearchForm"
 *                scope="request"
 *                validate="false"
 * @struts.action-forward name="success" path="/userinfoList.jsp"
 *
 */
public class InitUserInfoSearchAction extends ServiceAction {

   private static Logger log = LogService.getLogger(InitUserInfoSearchAction.class);
   private final static int MAX_LIST_SIZE = 1000;

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

      if (request.getParameter("Delete") != null) {
         java.util.Enumeration en = request.getParameterNames();
         while (en.hasMoreElements()) {
            String param = (String) en.nextElement();
            String checkbox = "checkbox";
            if (param.indexOf(checkbox) != -1) {
               param = param.substring(checkbox.length());
               java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(param, "_");
               String[] ids = new String[tokenizer.countTokens()];
               int i = 0;
               while (tokenizer.hasMoreTokens() ) {
                  ids[i] = tokenizer.nextToken();
                  i++;
               }
               java.lang.Integer idUserInfo;
               idUserInfo = new java.lang.Integer(ids[0]);
               getUserInfoServiceService().deleteUserInfo(idUserInfo);
            }
         }
      }

      String queryString = ((UserInfoSearchForm) actionForm).getQuery();
      String queryField = ((UserInfoSearchForm) actionForm).getQueryField();
      Collection userInfoList = null;
      if (queryString == null || "".equals(queryString) || queryField == null || "".equals(queryField)) {
        userInfoList =
            getUserInfoServiceService().getUserInfoList();
            // To limit the list, you may use:
            // getUserInfoServiceService().getUserInfoList(1, MAX_LIST_SIZE);
      } else {
            // Here the specify findBy method should be called.
            if (queryField.equals("idUser")) {
                try {
                java.lang.Integer query = new java.lang.Integer(queryString);
                 UserInfo result = getUserInfoServiceService().getUserInfo(query);
                 java.util.ArrayList list = new java.util.ArrayList();
                 if (result != null) {
                    list.add(result);
                 }
                 userInfoList = list;
                 } catch (Exception e) {
                   log.error("Error while parsing the query string", e);
                   userInfoList = new java.util.ArrayList();
                 }

            }

            if (queryField.equals("userName")) {
               try {
                java.lang.String query = queryString;
                userInfoList = getUserInfoServiceService().findUserInfoByUserName(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  userInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("fullName")) {
               try {
                java.lang.String query = queryString;
                userInfoList = getUserInfoServiceService().findUserInfoByFullName(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  userInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("userEmail")) {
               try {
                java.lang.String query = queryString;
                userInfoList = getUserInfoServiceService().findUserInfoByUserEmail(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  userInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("idUserType")) {
               try {
                java.lang.Integer query = new java.lang.Integer(queryString);
                userInfoList = getUserInfoServiceService().findUserInfoByIdUserType(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  userInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("password")) {
               try {
                java.lang.String query = queryString;
                userInfoList = getUserInfoServiceService().findUserInfoByPassword(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  userInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("companyName")) {
               try {
                java.lang.String query = queryString;
                userInfoList = getUserInfoServiceService().findUserInfoByCompanyName(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  userInfoList = new java.util.ArrayList();
                }
            }

      }
      ((UserInfoSearchForm) actionForm).setUserInfoList(userInfoList);
      return mapping.findForward("success");
   }
}

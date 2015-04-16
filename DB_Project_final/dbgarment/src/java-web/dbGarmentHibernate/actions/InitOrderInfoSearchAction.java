package dbGarmentHibernate.actions;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

import javax.servlet.http.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IOrderInfoService;
import org.apache.struts.action.*;
import org.apache.commons.beanutils.BeanUtils;

import com.finalist.util.log.*;
import dbGarmentHibernate.session.*;
import dbGarmentHibernate.forms.OrderInfoSearchForm;
import dbGarmentHibernate.entity.*;

/**
 * The initialise Action for the orderInfo search screen.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.15 $, $Date: 2006/02/02 18:28:43 $
 * @struts.action path="/initOrderInfoSearch"
 *                type="dbGarmentHibernate.actions.InitOrderInfoSearchAction"
 *                name="orderInfoSearchForm"
 *                scope="request"
 *                validate="false"
 * @struts.action-forward name="success" path="/orderinfoList.jsp"
 *
 */
public class InitOrderInfoSearchAction extends ServiceAction {

   private static Logger log = LogService.getLogger(InitOrderInfoSearchAction.class);
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
               java.lang.Integer idOrderInfo;
               idOrderInfo = new java.lang.Integer(ids[0]);
               getOrderInfoServiceService().deleteOrderInfo(idOrderInfo);
            }
         }
      }

      String queryString = ((OrderInfoSearchForm) actionForm).getQuery();
      String queryField = ((OrderInfoSearchForm) actionForm).getQueryField();
      Collection orderInfoList = null;
      if (queryString == null || "".equals(queryString) || queryField == null || "".equals(queryField)) {
        orderInfoList =
            getOrderInfoServiceService().getOrderInfoList();
            // To limit the list, you may use:
            // getOrderInfoServiceService().getOrderInfoList(1, MAX_LIST_SIZE);
      } else {
            // Here the specify findBy method should be called.
            if (queryField.equals("idOrderInfo")) {
                try {
                java.lang.Integer query = new java.lang.Integer(queryString);
                 OrderInfo result = getOrderInfoServiceService().getOrderInfo(query);
                 java.util.ArrayList list = new java.util.ArrayList();
                 if (result != null) {
                    list.add(result);
                 }
                 orderInfoList = list;
                 } catch (Exception e) {
                   log.error("Error while parsing the query string", e);
                   orderInfoList = new java.util.ArrayList();
                 }

            }

            if (queryField.equals("idUser")) {
               try {
                java.lang.Integer query = new java.lang.Integer(queryString);
                orderInfoList = getOrderInfoServiceService().findOrderInfoByIdUser(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  orderInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("idOrderType")) {
               try {
                java.lang.Integer query = new java.lang.Integer(queryString);
                orderInfoList = getOrderInfoServiceService().findOrderInfoByIdOrderType(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  orderInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("productAmount")) {
               try {
                java.lang.Integer query = new java.lang.Integer(queryString);
                orderInfoList = getOrderInfoServiceService().findOrderInfoByProductAmount(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  orderInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("orderEstimatedDate")) {
               try {
                java.sql.Date query = new java.sql.Date(DATE_FORMATTER.parse(queryString).getTime());
                orderInfoList = getOrderInfoServiceService().findOrderInfoByOrderEstimatedDate(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  orderInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("idProduct")) {
               try {
                java.lang.Integer query = new java.lang.Integer(queryString);
                orderInfoList = getOrderInfoServiceService().findOrderInfoByIdProduct(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  orderInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("orderDetail")) {
               try {
                java.lang.String query = queryString;
                orderInfoList = getOrderInfoServiceService().findOrderInfoByOrderDetail(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  orderInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("idOrderStatus")) {
               try {
                java.lang.Integer query = new java.lang.Integer(queryString);
                orderInfoList = getOrderInfoServiceService().findOrderInfoByIdOrderStatus(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  orderInfoList = new java.util.ArrayList();
                }
            }

      }
      ((OrderInfoSearchForm) actionForm).setOrderInfoList(orderInfoList);
      return mapping.findForward("success");
   }
}

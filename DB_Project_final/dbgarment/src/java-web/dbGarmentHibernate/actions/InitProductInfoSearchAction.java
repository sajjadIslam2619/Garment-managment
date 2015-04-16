package dbGarmentHibernate.actions;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

import javax.servlet.http.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IProductInfoService;
import org.apache.struts.action.*;
import org.apache.commons.beanutils.BeanUtils;

import com.finalist.util.log.*;
import dbGarmentHibernate.session.*;
import dbGarmentHibernate.forms.ProductInfoSearchForm;
import dbGarmentHibernate.entity.*;

/**
 * The initialise Action for the productInfo search screen.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.15 $, $Date: 2006/02/02 18:28:43 $
 * @struts.action path="/initProductInfoSearch"
 *                type="dbGarmentHibernate.actions.InitProductInfoSearchAction"
 *                name="productInfoSearchForm"
 *                scope="request"
 *                validate="false"
 * @struts.action-forward name="success" path="/productinfoList.jsp"
 *
 */
public class InitProductInfoSearchAction extends ServiceAction {

   private static Logger log = LogService.getLogger(InitProductInfoSearchAction.class);
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
               java.lang.Integer idProductInfo;
               idProductInfo = new java.lang.Integer(ids[0]);
               getProductInfoServiceService().deleteProductInfo(idProductInfo);
            }
         }
      }

      String queryString = ((ProductInfoSearchForm) actionForm).getQuery();
      String queryField = ((ProductInfoSearchForm) actionForm).getQueryField();
      Collection productInfoList = null;
      if (queryString == null || "".equals(queryString) || queryField == null || "".equals(queryField)) {
        productInfoList =
            getProductInfoServiceService().getProductInfoList();
            // To limit the list, you may use:
            // getProductInfoServiceService().getProductInfoList(1, MAX_LIST_SIZE);
      } else {
            // Here the specify findBy method should be called.
            if (queryField.equals("idProduct")) {
                try {
                java.lang.Integer query = new java.lang.Integer(queryString);
                 ProductInfo result = getProductInfoServiceService().getProductInfo(query);
                 java.util.ArrayList list = new java.util.ArrayList();
                 if (result != null) {
                    list.add(result);
                 }
                 productInfoList = list;
                 } catch (Exception e) {
                   log.error("Error while parsing the query string", e);
                   productInfoList = new java.util.ArrayList();
                 }

            }

            if (queryField.equals("productName")) {
               try {
                java.lang.String query = queryString;
                productInfoList = getProductInfoServiceService().findProductInfoByProductName(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  productInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("idProductType")) {
               try {
                java.lang.Integer query = new java.lang.Integer(queryString);
                productInfoList = getProductInfoServiceService().findProductInfoByIdProductType(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  productInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("productPrice")) {
               try {
                java.lang.Double query = new java.lang.Double(queryString);
                productInfoList = getProductInfoServiceService().findProductInfoByProductPrice(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  productInfoList = new java.util.ArrayList();
                }
            }

            if (queryField.equals("productImage")) {
               try {
                java.lang.String query = queryString;
                productInfoList = getProductInfoServiceService().findProductInfoByProductImage(query);
                } catch (Exception e) {
                  log.error("Error while parsing the query string", e);
                  productInfoList = new java.util.ArrayList();
                }
            }

      }
      ((ProductInfoSearchForm) actionForm).setProductInfoList(productInfoList);
      return mapping.findForward("success");
   }
}

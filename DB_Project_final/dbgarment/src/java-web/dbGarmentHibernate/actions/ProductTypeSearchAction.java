package dbGarmentHibernate.actions;

import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.finalist.util.log.*;
import dbGarmentHibernate.forms.ProductTypeSearchForm;

/**
 * The submit action for the productType search screen.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.3 $, $Date: 2006/01/20 13:10:17 $
 * @struts.action path="/ProductTypeSearch"
 *                type="dbGarmentHibernate.actions.ProductTypeSearchAction"
 *                name="productTypeSearchForm"
 *                scope="request"
 *                input="/producttypeList.jsp"
 * @struts.action-forward name="success" path="/initProductType.do"
 *
 */
public class ProductTypeSearchAction extends ServiceAction {

   private static Logger log = LogService.getLogger(ProductTypeSearchAction.class);

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

      return mapping.findForward("success");
   }
}

package dbGarmentHibernate.forms;

import java.util.Collection;
import javax.servlet.http.*;
import dbGarmentHibernate.servicelocator.*;
import dbGarmentHibernate.session.IOrderInfoService;
import dbGarmentHibernate.session.IOrderStatusService;
import dbGarmentHibernate.session.IOrderStatusTypeService;
import dbGarmentHibernate.session.IOrderTypeService;
import dbGarmentHibernate.session.IProductInfoService;
import dbGarmentHibernate.session.IProductTypeService;
import dbGarmentHibernate.session.IRawMatarialService;
import dbGarmentHibernate.session.IRawMatarialTypeService;
import dbGarmentHibernate.session.IUserInfoService;
import dbGarmentHibernate.session.IUserTypeService;
import org.apache.struts.action.*;
import com.finalist.Constants;
import com.finalist.util.LabeledIdentifier;


/**
 * Form bean for the rawMatarialType search page.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.8 $, $Date: 2006/02/01 07:25:19 $
 * @struts.form name="rawMatarialTypeSearchForm"
 */
public final class RawMatarialTypeSearchForm extends ServiceBaseForm {
   private String queryField;
   private String query;
   private Collection rawMatarialTypeList;


    /**
     * Return a list of fields that can be searched on.
     * @return list of LabeledIdentifier objects.
     */
    public Collection<LabeledIdentifier> getQueryFields() {
        java.util.ArrayList<LabeledIdentifier> list = new java.util.ArrayList<LabeledIdentifier>();
        LabeledIdentifier bean;
        // Currently only searching on string fields is supported:
        bean = new LabeledIdentifier();
        bean.setName("IdRawMaterialType");
        bean.setId("idRawMaterialType");
        list.add(bean);
        bean = new LabeledIdentifier();
        bean.setName("RawMaterialTypeName");
        bean.setId("rawMaterialTypeName");
        list.add(bean);
        return list;
    }

    public String getQueryField() {
        return queryField;
    }

    public void setQueryField(String queryField) {
        this.queryField = queryField;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

   /**
    * Gets the list of rawMatarialType beans, set in the {@link dbGarmentHibernate.actions.InitRawMatarialTypeSearchAction}.
    * @return Collection
    */
   public Collection getRawMatarialTypeList() {
      return rawMatarialTypeList;
   }

   /**
    * Sets the list of rawMatarialType beans.
    * @param rawMatarialTypeList the list.
    */
   public void setRawMatarialTypeList(Collection rawMatarialTypeList) {
      this.rawMatarialTypeList = rawMatarialTypeList;
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

}

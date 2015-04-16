package dbGarmentHibernate.forms;

import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.*;
import com.finalist.util.LabeledIdentifier;
import dbGarmentHibernate.servicelocator.*;
import com.finalist.util.genelv.struts.GenericForm;
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
/**
 * Base form that has access to the service methods.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.5 $, $Date: 2006/02/01 07:45:47 $
 */
public abstract class ServiceBaseForm extends GenericForm {

   /**
    * Specifiy the default page list size.
    */
   public final static int DEFAULT_PAGE_LIST_SIZE = 10;

   private String pageListSize = "" + DEFAULT_PAGE_LIST_SIZE;

   /**
    * Get the current list size.
    * @return size
    */
   public String getPageListSize() {
      return pageListSize;
   }

   /**
    * Set the current list size.
    * @param pageListSize
    */
   public void setPageListSize(String pageListSize) {
      this.pageListSize = pageListSize;
   }

   /**
    * Dropdown list for the list size on a page.
    * @return list with sizes.
    */
   public Collection<LabeledIdentifier> getPageListSizes() {
      java.util.ArrayList<LabeledIdentifier> list = new java.util.ArrayList<LabeledIdentifier>();
      LabeledIdentifier ls;
      ls = new LabeledIdentifier();
      ls.setId("5");
      ls.setName("5");
      list.add(ls);
      ls = new LabeledIdentifier();
      ls.setId("10");
      ls.setName("10");
      list.add(ls);
      ls = new LabeledIdentifier();
      ls.setId("20");
      ls.setName("20");
      list.add(ls);
      ls = new LabeledIdentifier();
      ls.setId("50");
      ls.setName("50");
      list.add(ls);
      ls = new LabeledIdentifier();
      ls.setId("100");
      ls.setName("100");
      list.add(ls);

      return list;
   }


    /**
    * Get the service interface.
    * @return IOrderInfoService interface
    */
    public static IOrderInfoService getOrderInfoServiceService() {
    try {
        return (IOrderInfoService) ServiceLocator.getService(ServiceLocator.ORDERINFOSERVICE_SERVICE);
        } catch (Exception e) {
            return null;
        }
    }

    /**
    * Get the service interface.
    * @return IOrderStatusService interface
    */
    public static IOrderStatusService getOrderStatusServiceService() {
    try {
        return (IOrderStatusService) ServiceLocator.getService(ServiceLocator.ORDERSTATUSSERVICE_SERVICE);
        } catch (Exception e) {
            return null;
        }
    }

    /**
    * Get the service interface.
    * @return IOrderStatusTypeService interface
    */
    public static IOrderStatusTypeService getOrderStatusTypeServiceService() {
    try {
        return (IOrderStatusTypeService) ServiceLocator.getService(ServiceLocator.ORDERSTATUSTYPESERVICE_SERVICE);
        } catch (Exception e) {
            return null;
        }
    }

    /**
    * Get the service interface.
    * @return IOrderTypeService interface
    */
    public static IOrderTypeService getOrderTypeServiceService() {
    try {
        return (IOrderTypeService) ServiceLocator.getService(ServiceLocator.ORDERTYPESERVICE_SERVICE);
        } catch (Exception e) {
            return null;
        }
    }

    /**
    * Get the service interface.
    * @return IProductInfoService interface
    */
    public static IProductInfoService getProductInfoServiceService() {
    try {
        return (IProductInfoService) ServiceLocator.getService(ServiceLocator.PRODUCTINFOSERVICE_SERVICE);
        } catch (Exception e) {
            return null;
        }
    }

    /**
    * Get the service interface.
    * @return IProductTypeService interface
    */
    public static IProductTypeService getProductTypeServiceService() {
    try {
        return (IProductTypeService) ServiceLocator.getService(ServiceLocator.PRODUCTTYPESERVICE_SERVICE);
        } catch (Exception e) {
            return null;
        }
    }

    /**
    * Get the service interface.
    * @return IRawMatarialService interface
    */
    public static IRawMatarialService getRawMatarialServiceService() {
    try {
        return (IRawMatarialService) ServiceLocator.getService(ServiceLocator.RAWMATARIALSERVICE_SERVICE);
        } catch (Exception e) {
            return null;
        }
    }

    /**
    * Get the service interface.
    * @return IRawMatarialTypeService interface
    */
    public static IRawMatarialTypeService getRawMatarialTypeServiceService() {
    try {
        return (IRawMatarialTypeService) ServiceLocator.getService(ServiceLocator.RAWMATARIALTYPESERVICE_SERVICE);
        } catch (Exception e) {
            return null;
        }
    }

    /**
    * Get the service interface.
    * @return IUserInfoService interface
    */
    public static IUserInfoService getUserInfoServiceService() {
    try {
        return (IUserInfoService) ServiceLocator.getService(ServiceLocator.USERINFOSERVICE_SERVICE);
        } catch (Exception e) {
            return null;
        }
    }

    /**
    * Get the service interface.
    * @return IUserTypeService interface
    */
    public static IUserTypeService getUserTypeServiceService() {
    try {
        return (IUserTypeService) ServiceLocator.getService(ServiceLocator.USERTYPESERVICE_SERVICE);
        } catch (Exception e) {
            return null;
        }
    }
}

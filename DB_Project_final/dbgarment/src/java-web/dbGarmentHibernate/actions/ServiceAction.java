package dbGarmentHibernate.actions;

import com.finalist.util.genelv.struts.GenericAction;
import java.text.SimpleDateFormat;
import com.finalist.Constants;
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
 * Base action that has access to the service methods.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.2 $, $Date: 2006/01/20 13:10:17 $
 */
public abstract class ServiceAction extends GenericAction {

   
   protected static final SimpleDateFormat TIMESTAMP_FORMATTER =
         new SimpleDateFormat(Constants.TIMESTAMP_DISPLAY_FORMAT);

   protected static final SimpleDateFormat DATE_FORMATTER =
         new SimpleDateFormat(Constants.DATE_DISPLAY_FORMAT);

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

package dbGarmentHibernate.session;

import java.util.*;
import dbGarmentHibernate.*;
import dbGarmentHibernate.servicelocator.LocatableService;
import com.finalist.util.log.*;
import dbGarmentHibernate.exception.GenericBusinessException;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.finalist.util.log.*;
import dbGarmentHibernate.entity.*;

/**
 * The <code>OrderInfoService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class OrderInfoService implements IOrderInfoService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(OrderInfoService.class);


   /**
    * Default implementation for the Locatable Service interface.
    */
    public void init() {
    }

   /**
    * Default implementation for the Locatable Service interface.
    */
    public void destroy() {
    }

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/



   /**
    * Adds a new orderInfo to the database.
    *
    * @param model a data object
    * @return OrderInfo a data object with the primary key
    */
   public dbGarmentHibernate.entity.OrderInfo addOrderInfo(dbGarmentHibernate.entity.OrderInfo model) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getOrderInfo(model.getPrimaryKey());
      } finally {
         log.debug("finished addOrderInfo(dbGarmentHibernate.entity.OrderInfo model)");
      }
   }

   /**
    * Stores the <code>OrderInfo</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveOrderInfo(dbGarmentHibernate.entity.OrderInfo model) throws GenericBusinessException {
      // We have to create an object:
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveOrderInfo(dbGarmentHibernate.entity.OrderInfo model)");
      }
   }

   /**
    * Removes a orderInfo.
    *
    * @param id the unique reference for the orderInfo
    */
   public void deleteOrderInfo(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // First get the data.
         OrderInfo bean = (OrderInfo) hibernateTemplate.get(OrderInfo.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteOrderInfo(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return OrderInfo the data object
    */
   public dbGarmentHibernate.entity.OrderInfo getOrderInfo(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
      OrderInfo bean = (OrderInfo) hibernateTemplate.get(OrderInfo.class, id);
      return bean;
      } finally {
         log.debug("finished getOrderInfo(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all orderInfo instances.
    *
    * @return a list of OrderInfo objects.
    */
   public List getOrderInfoList() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {

      String queryString = "from " + OrderInfo.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idOrderInfo";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getOrderInfoList");
      }
   }

   /**
    * Returns a subset of all orderInfo instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of orderInfo instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getOrderInfoListSize()</code> = last record),
    * any values greater than or equal to the total number of orderInfo instances will cause
    * the full set to be returned.
    * @return a list of OrderInfo objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getOrderInfoList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderInfo.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderInfo";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getOrderInfoList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of orderInfo objects in the database.
    *
    * @return an integer value.
    */
   public int getOrderInfoListSize() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + OrderInfo.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getOrderInfoListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idOrderInfo field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idOrderInfo the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    public java.util.List findOrderInfoByIdOrderInfo(java.lang.Integer idOrderInfo) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderInfo.class.getName() + " e where e.idOrderInfo like :idOrderInfo ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderInfo";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idOrderInfo", idOrderInfo);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderInfoByIdOrderInfo(java.lang.Integer idOrderInfo)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idUser field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idUser the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    public java.util.List findOrderInfoByIdUser(java.lang.Integer idUser) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderInfo.class.getName() + " e where e.idUser like :idUser ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderInfo";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idUser", idUser);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderInfoByIdUser(java.lang.Integer idUser)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idOrderType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idOrderType the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    public java.util.List findOrderInfoByIdOrderType(java.lang.Integer idOrderType) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderInfo.class.getName() + " e where e.idOrderType like :idOrderType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderInfo";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idOrderType", idOrderType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderInfoByIdOrderType(java.lang.Integer idOrderType)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified productAmount field.
     * To use a wildcard search, use a % in the query.
     *
     * @param productAmount the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    public java.util.List findOrderInfoByProductAmount(java.lang.Integer productAmount) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderInfo.class.getName() + " e where e.productAmount like :productAmount ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderInfo";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "productAmount", productAmount);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderInfoByProductAmount(java.lang.Integer productAmount)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified orderEstimatedDate field.
     * To use a wildcard search, use a % in the query.
     *
     * @param orderEstimatedDate the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    public java.util.List findOrderInfoByOrderEstimatedDate(java.sql.Date orderEstimatedDate) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderInfo.class.getName() + " e where e.orderEstimatedDate like :orderEstimatedDate ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderInfo";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "orderEstimatedDate", orderEstimatedDate);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderInfoByOrderEstimatedDate(java.sql.Date orderEstimatedDate)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idProduct field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idProduct the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    public java.util.List findOrderInfoByIdProduct(java.lang.Integer idProduct) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderInfo.class.getName() + " e where e.idProduct like :idProduct ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderInfo";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idProduct", idProduct);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderInfoByIdProduct(java.lang.Integer idProduct)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified orderDetail field.
     * To use a wildcard search, use a % in the query.
     *
     * @param orderDetail the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    public java.util.List findOrderInfoByOrderDetail(java.lang.String orderDetail) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderInfo.class.getName() + " e where e.orderDetail like :orderDetail ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderInfo";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "orderDetail", orderDetail);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderInfoByOrderDetail(java.lang.String orderDetail)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idOrderStatus field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idOrderStatus the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    public java.util.List findOrderInfoByIdOrderStatus(java.lang.Integer idOrderStatus) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderInfo.class.getName() + " e where e.idOrderStatus like :idOrderStatus ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderInfo";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idOrderStatus", idOrderStatus);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderInfoByIdOrderStatus(java.lang.Integer idOrderStatus)");
      }
    }


}

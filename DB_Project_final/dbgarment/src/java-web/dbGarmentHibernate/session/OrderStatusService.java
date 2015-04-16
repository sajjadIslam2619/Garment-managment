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
 * The <code>OrderStatusService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class OrderStatusService implements IOrderStatusService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(OrderStatusService.class);


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
    * Adds a new orderStatus to the database.
    *
    * @param model a data object
    * @return OrderStatus a data object with the primary key
    */
   public dbGarmentHibernate.entity.OrderStatus addOrderStatus(dbGarmentHibernate.entity.OrderStatus model) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getOrderStatus(model.getPrimaryKey());
      } finally {
         log.debug("finished addOrderStatus(dbGarmentHibernate.entity.OrderStatus model)");
      }
   }

   /**
    * Stores the <code>OrderStatus</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveOrderStatus(dbGarmentHibernate.entity.OrderStatus model) throws GenericBusinessException {
      // We have to create an object:
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveOrderStatus(dbGarmentHibernate.entity.OrderStatus model)");
      }
   }

   /**
    * Removes a orderStatus.
    *
    * @param id the unique reference for the orderStatus
    */
   public void deleteOrderStatus(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // First get the data.
         OrderStatus bean = (OrderStatus) hibernateTemplate.get(OrderStatus.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteOrderStatus(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return OrderStatus the data object
    */
   public dbGarmentHibernate.entity.OrderStatus getOrderStatus(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
      OrderStatus bean = (OrderStatus) hibernateTemplate.get(OrderStatus.class, id);
      return bean;
      } finally {
         log.debug("finished getOrderStatus(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all orderStatus instances.
    *
    * @return a list of OrderStatus objects.
    */
   public List getOrderStatusList() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {

      String queryString = "from " + OrderStatus.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idOrderStatus";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getOrderStatusList");
      }
   }

   /**
    * Returns a subset of all orderStatus instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of orderStatus instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getOrderStatusListSize()</code> = last record),
    * any values greater than or equal to the total number of orderStatus instances will cause
    * the full set to be returned.
    * @return a list of OrderStatus objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getOrderStatusList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderStatus.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderStatus";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getOrderStatusList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of orderStatus objects in the database.
    *
    * @return an integer value.
    */
   public int getOrderStatusListSize() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + OrderStatus.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getOrderStatusListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idOrderStatus field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idOrderStatus the field
     * @return List of OrderStatus data objects, empty list in case no results were found.
     */
    public java.util.List findOrderStatusByIdOrderStatus(java.lang.Integer idOrderStatus) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderStatus.class.getName() + " e where e.idOrderStatus like :idOrderStatus ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderStatus";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idOrderStatus", idOrderStatus);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderStatusByIdOrderStatus(java.lang.Integer idOrderStatus)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idOrderStatusType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idOrderStatusType the field
     * @return List of OrderStatus data objects, empty list in case no results were found.
     */
    public java.util.List findOrderStatusByIdOrderStatusType(java.lang.Integer idOrderStatusType) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderStatus.class.getName() + " e where e.idOrderStatusType like :idOrderStatusType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderStatus";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idOrderStatusType", idOrderStatusType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderStatusByIdOrderStatusType(java.lang.Integer idOrderStatusType)");
      }
    }


}

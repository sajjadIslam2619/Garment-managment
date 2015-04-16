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
 * The <code>OrderStatusTypeService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class OrderStatusTypeService implements IOrderStatusTypeService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(OrderStatusTypeService.class);


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
    * Adds a new orderStatusType to the database.
    *
    * @param model a data object
    * @return OrderStatusType a data object with the primary key
    */
   public dbGarmentHibernate.entity.OrderStatusType addOrderStatusType(dbGarmentHibernate.entity.OrderStatusType model) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getOrderStatusType(model.getPrimaryKey());
      } finally {
         log.debug("finished addOrderStatusType(dbGarmentHibernate.entity.OrderStatusType model)");
      }
   }

   /**
    * Stores the <code>OrderStatusType</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveOrderStatusType(dbGarmentHibernate.entity.OrderStatusType model) throws GenericBusinessException {
      // We have to create an object:
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveOrderStatusType(dbGarmentHibernate.entity.OrderStatusType model)");
      }
   }

   /**
    * Removes a orderStatusType.
    *
    * @param id the unique reference for the orderStatusType
    */
   public void deleteOrderStatusType(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // First get the data.
         OrderStatusType bean = (OrderStatusType) hibernateTemplate.get(OrderStatusType.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteOrderStatusType(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return OrderStatusType the data object
    */
   public dbGarmentHibernate.entity.OrderStatusType getOrderStatusType(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
      OrderStatusType bean = (OrderStatusType) hibernateTemplate.get(OrderStatusType.class, id);
      return bean;
      } finally {
         log.debug("finished getOrderStatusType(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all orderStatusType instances.
    *
    * @return a list of OrderStatusType objects.
    */
   public List getOrderStatusTypeList() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {

      String queryString = "from " + OrderStatusType.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idOrderStatusType";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getOrderStatusTypeList");
      }
   }

   /**
    * Returns a subset of all orderStatusType instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of orderStatusType instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getOrderStatusTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of orderStatusType instances will cause
    * the full set to be returned.
    * @return a list of OrderStatusType objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getOrderStatusTypeList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderStatusType.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderStatusType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getOrderStatusTypeList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of orderStatusType objects in the database.
    *
    * @return an integer value.
    */
   public int getOrderStatusTypeListSize() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + OrderStatusType.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getOrderStatusTypeListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idOrderStatusType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idOrderStatusType the field
     * @return List of OrderStatusType data objects, empty list in case no results were found.
     */
    public java.util.List findOrderStatusTypeByIdOrderStatusType(java.lang.Integer idOrderStatusType) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderStatusType.class.getName() + " e where e.idOrderStatusType like :idOrderStatusType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderStatusType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idOrderStatusType", idOrderStatusType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderStatusTypeByIdOrderStatusType(java.lang.Integer idOrderStatusType)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified orderStatusName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param orderStatusName the field
     * @return List of OrderStatusType data objects, empty list in case no results were found.
     */
    public java.util.List findOrderStatusTypeByOrderStatusName(java.lang.String orderStatusName) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderStatusType.class.getName() + " e where e.orderStatusName like :orderStatusName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderStatusType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "orderStatusName", orderStatusName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderStatusTypeByOrderStatusName(java.lang.String orderStatusName)");
      }
    }


}

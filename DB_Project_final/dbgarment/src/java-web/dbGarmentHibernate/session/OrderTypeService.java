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
 * The <code>OrderTypeService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class OrderTypeService implements IOrderTypeService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(OrderTypeService.class);


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
    * Adds a new orderType to the database.
    *
    * @param model a data object
    * @return OrderType a data object with the primary key
    */
   public dbGarmentHibernate.entity.OrderType addOrderType(dbGarmentHibernate.entity.OrderType model) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getOrderType(model.getPrimaryKey());
      } finally {
         log.debug("finished addOrderType(dbGarmentHibernate.entity.OrderType model)");
      }
   }

   /**
    * Stores the <code>OrderType</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveOrderType(dbGarmentHibernate.entity.OrderType model) throws GenericBusinessException {
      // We have to create an object:
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveOrderType(dbGarmentHibernate.entity.OrderType model)");
      }
   }

   /**
    * Removes a orderType.
    *
    * @param id the unique reference for the orderType
    */
   public void deleteOrderType(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // First get the data.
         OrderType bean = (OrderType) hibernateTemplate.get(OrderType.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteOrderType(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return OrderType the data object
    */
   public dbGarmentHibernate.entity.OrderType getOrderType(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
      OrderType bean = (OrderType) hibernateTemplate.get(OrderType.class, id);
      return bean;
      } finally {
         log.debug("finished getOrderType(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all orderType instances.
    *
    * @return a list of OrderType objects.
    */
   public List getOrderTypeList() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {

      String queryString = "from " + OrderType.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idOrderType";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getOrderTypeList");
      }
   }

   /**
    * Returns a subset of all orderType instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of orderType instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getOrderTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of orderType instances will cause
    * the full set to be returned.
    * @return a list of OrderType objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getOrderTypeList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderType.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getOrderTypeList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of orderType objects in the database.
    *
    * @return an integer value.
    */
   public int getOrderTypeListSize() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + OrderType.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getOrderTypeListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idOrderType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idOrderType the field
     * @return List of OrderType data objects, empty list in case no results were found.
     */
    public java.util.List findOrderTypeByIdOrderType(java.lang.Integer idOrderType) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderType.class.getName() + " e where e.idOrderType like :idOrderType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idOrderType", idOrderType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderTypeByIdOrderType(java.lang.Integer idOrderType)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified orderName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param orderName the field
     * @return List of OrderType data objects, empty list in case no results were found.
     */
    public java.util.List findOrderTypeByOrderName(java.lang.String orderName) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + OrderType.class.getName() + " e where e.orderName like :orderName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idOrderType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "orderName", orderName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findOrderTypeByOrderName(java.lang.String orderName)");
      }
    }


}

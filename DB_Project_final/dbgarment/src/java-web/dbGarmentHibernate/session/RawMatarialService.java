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
 * The <code>RawMatarialService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class RawMatarialService implements IRawMatarialService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(RawMatarialService.class);


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
    * Adds a new rawMatarial to the database.
    *
    * @param model a data object
    * @return RawMatarial a data object with the primary key
    */
   public dbGarmentHibernate.entity.RawMatarial addRawMatarial(dbGarmentHibernate.entity.RawMatarial model) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getRawMatarial(model.getPrimaryKey());
      } finally {
         log.debug("finished addRawMatarial(dbGarmentHibernate.entity.RawMatarial model)");
      }
   }

   /**
    * Stores the <code>RawMatarial</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveRawMatarial(dbGarmentHibernate.entity.RawMatarial model) throws GenericBusinessException {
      // We have to create an object:
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveRawMatarial(dbGarmentHibernate.entity.RawMatarial model)");
      }
   }

   /**
    * Removes a rawMatarial.
    *
    * @param id the unique reference for the rawMatarial
    */
   public void deleteRawMatarial(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // First get the data.
         RawMatarial bean = (RawMatarial) hibernateTemplate.get(RawMatarial.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteRawMatarial(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return RawMatarial the data object
    */
   public dbGarmentHibernate.entity.RawMatarial getRawMatarial(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
      RawMatarial bean = (RawMatarial) hibernateTemplate.get(RawMatarial.class, id);
      return bean;
      } finally {
         log.debug("finished getRawMatarial(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all rawMatarial instances.
    *
    * @return a list of RawMatarial objects.
    */
   public List getRawMatarialList() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {

      String queryString = "from " + RawMatarial.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idRawMatarial";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getRawMatarialList");
      }
   }

   /**
    * Returns a subset of all rawMatarial instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of rawMatarial instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getRawMatarialListSize()</code> = last record),
    * any values greater than or equal to the total number of rawMatarial instances will cause
    * the full set to be returned.
    * @return a list of RawMatarial objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getRawMatarialList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + RawMatarial.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRawMatarial";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getRawMatarialList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of rawMatarial objects in the database.
    *
    * @return an integer value.
    */
   public int getRawMatarialListSize() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + RawMatarial.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getRawMatarialListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idRawMatarial field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idRawMatarial the field
     * @return List of RawMatarial data objects, empty list in case no results were found.
     */
    public java.util.List findRawMatarialByIdRawMatarial(java.lang.Integer idRawMatarial) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + RawMatarial.class.getName() + " e where e.idRawMatarial like :idRawMatarial ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRawMatarial";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idRawMatarial", idRawMatarial);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRawMatarialByIdRawMatarial(java.lang.Integer idRawMatarial)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idRawMaterialType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idRawMaterialType the field
     * @return List of RawMatarial data objects, empty list in case no results were found.
     */
    public java.util.List findRawMatarialByIdRawMaterialType(java.lang.Integer idRawMaterialType) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + RawMatarial.class.getName() + " e where e.idRawMaterialType like :idRawMaterialType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRawMatarial";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idRawMaterialType", idRawMaterialType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRawMatarialByIdRawMaterialType(java.lang.Integer idRawMaterialType)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified rawMaterialAmount field.
     * To use a wildcard search, use a % in the query.
     *
     * @param rawMaterialAmount the field
     * @return List of RawMatarial data objects, empty list in case no results were found.
     */
    public java.util.List findRawMatarialByRawMaterialAmount(java.lang.Integer rawMaterialAmount) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + RawMatarial.class.getName() + " e where e.rawMaterialAmount like :rawMaterialAmount ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRawMatarial";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "rawMaterialAmount", rawMaterialAmount);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRawMatarialByRawMaterialAmount(java.lang.Integer rawMaterialAmount)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified perUnitPrice field.
     * To use a wildcard search, use a % in the query.
     *
     * @param perUnitPrice the field
     * @return List of RawMatarial data objects, empty list in case no results were found.
     */
    public java.util.List findRawMatarialByPerUnitPrice(java.lang.Double perUnitPrice) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + RawMatarial.class.getName() + " e where e.perUnitPrice like :perUnitPrice ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRawMatarial";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "perUnitPrice", perUnitPrice);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRawMatarialByPerUnitPrice(java.lang.Double perUnitPrice)");
      }
    }


}

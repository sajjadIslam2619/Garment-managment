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
 * The <code>RawMatarialTypeService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class RawMatarialTypeService implements IRawMatarialTypeService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(RawMatarialTypeService.class);


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
    * Adds a new rawMatarialType to the database.
    *
    * @param model a data object
    * @return RawMatarialType a data object with the primary key
    */
   public dbGarmentHibernate.entity.RawMatarialType addRawMatarialType(dbGarmentHibernate.entity.RawMatarialType model) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getRawMatarialType(model.getPrimaryKey());
      } finally {
         log.debug("finished addRawMatarialType(dbGarmentHibernate.entity.RawMatarialType model)");
      }
   }

   /**
    * Stores the <code>RawMatarialType</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveRawMatarialType(dbGarmentHibernate.entity.RawMatarialType model) throws GenericBusinessException {
      // We have to create an object:
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveRawMatarialType(dbGarmentHibernate.entity.RawMatarialType model)");
      }
   }

   /**
    * Removes a rawMatarialType.
    *
    * @param id the unique reference for the rawMatarialType
    */
   public void deleteRawMatarialType(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // First get the data.
         RawMatarialType bean = (RawMatarialType) hibernateTemplate.get(RawMatarialType.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteRawMatarialType(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return RawMatarialType the data object
    */
   public dbGarmentHibernate.entity.RawMatarialType getRawMatarialType(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
      RawMatarialType bean = (RawMatarialType) hibernateTemplate.get(RawMatarialType.class, id);
      return bean;
      } finally {
         log.debug("finished getRawMatarialType(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all rawMatarialType instances.
    *
    * @return a list of RawMatarialType objects.
    */
   public List getRawMatarialTypeList() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {

      String queryString = "from " + RawMatarialType.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idRawMaterialType";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getRawMatarialTypeList");
      }
   }

   /**
    * Returns a subset of all rawMatarialType instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of rawMatarialType instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getRawMatarialTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of rawMatarialType instances will cause
    * the full set to be returned.
    * @return a list of RawMatarialType objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getRawMatarialTypeList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + RawMatarialType.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRawMaterialType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getRawMatarialTypeList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of rawMatarialType objects in the database.
    *
    * @return an integer value.
    */
   public int getRawMatarialTypeListSize() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + RawMatarialType.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getRawMatarialTypeListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idRawMaterialType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idRawMaterialType the field
     * @return List of RawMatarialType data objects, empty list in case no results were found.
     */
    public java.util.List findRawMatarialTypeByIdRawMaterialType(java.lang.Integer idRawMaterialType) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + RawMatarialType.class.getName() + " e where e.idRawMaterialType like :idRawMaterialType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRawMaterialType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idRawMaterialType", idRawMaterialType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRawMatarialTypeByIdRawMaterialType(java.lang.Integer idRawMaterialType)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified rawMaterialTypeName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param rawMaterialTypeName the field
     * @return List of RawMatarialType data objects, empty list in case no results were found.
     */
    public java.util.List findRawMatarialTypeByRawMaterialTypeName(java.lang.String rawMaterialTypeName) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + RawMatarialType.class.getName() + " e where e.rawMaterialTypeName like :rawMaterialTypeName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRawMaterialType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "rawMaterialTypeName", rawMaterialTypeName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRawMatarialTypeByRawMaterialTypeName(java.lang.String rawMaterialTypeName)");
      }
    }


}

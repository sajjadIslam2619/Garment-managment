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
 * The <code>UserTypeService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class UserTypeService implements IUserTypeService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(UserTypeService.class);


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
    * Adds a new userType to the database.
    *
    * @param model a data object
    * @return UserType a data object with the primary key
    */
   public dbGarmentHibernate.entity.UserType addUserType(dbGarmentHibernate.entity.UserType model) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getUserType(model.getPrimaryKey());
      } finally {
         log.debug("finished addUserType(dbGarmentHibernate.entity.UserType model)");
      }
   }

   /**
    * Stores the <code>UserType</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveUserType(dbGarmentHibernate.entity.UserType model) throws GenericBusinessException {
      // We have to create an object:
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveUserType(dbGarmentHibernate.entity.UserType model)");
      }
   }

   /**
    * Removes a userType.
    *
    * @param id the unique reference for the userType
    */
   public void deleteUserType(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // First get the data.
         UserType bean = (UserType) hibernateTemplate.get(UserType.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteUserType(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return UserType the data object
    */
   public dbGarmentHibernate.entity.UserType getUserType(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
      UserType bean = (UserType) hibernateTemplate.get(UserType.class, id);
      return bean;
      } finally {
         log.debug("finished getUserType(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all userType instances.
    *
    * @return a list of UserType objects.
    */
   public List getUserTypeList() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {

      String queryString = "from " + UserType.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idUserType";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getUserTypeList");
      }
   }

   /**
    * Returns a subset of all userType instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of userType instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getUserTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of userType instances will cause
    * the full set to be returned.
    * @return a list of UserType objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getUserTypeList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + UserType.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUserType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getUserTypeList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of userType objects in the database.
    *
    * @return an integer value.
    */
   public int getUserTypeListSize() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + UserType.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getUserTypeListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idUserType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idUserType the field
     * @return List of UserType data objects, empty list in case no results were found.
     */
    public java.util.List findUserTypeByIdUserType(java.lang.Integer idUserType) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + UserType.class.getName() + " e where e.idUserType like :idUserType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUserType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idUserType", idUserType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserTypeByIdUserType(java.lang.Integer idUserType)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userTypeName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userTypeName the field
     * @return List of UserType data objects, empty list in case no results were found.
     */
    public java.util.List findUserTypeByUserTypeName(java.lang.String userTypeName) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + UserType.class.getName() + " e where e.userTypeName like :userTypeName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUserType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userTypeName", userTypeName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserTypeByUserTypeName(java.lang.String userTypeName)");
      }
    }


}

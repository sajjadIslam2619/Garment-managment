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
 * The <code>UserInfoService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class UserInfoService implements IUserInfoService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(UserInfoService.class);


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
    * Adds a new userInfo to the database.
    *
    * @param model a data object
    * @return UserInfo a data object with the primary key
    */
   public dbGarmentHibernate.entity.UserInfo addUserInfo(dbGarmentHibernate.entity.UserInfo model) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getUserInfo(model.getPrimaryKey());
      } finally {
         log.debug("finished addUserInfo(dbGarmentHibernate.entity.UserInfo model)");
      }
   }

   /**
    * Stores the <code>UserInfo</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveUserInfo(dbGarmentHibernate.entity.UserInfo model) throws GenericBusinessException {
      // We have to create an object:
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveUserInfo(dbGarmentHibernate.entity.UserInfo model)");
      }
   }

   /**
    * Removes a userInfo.
    *
    * @param id the unique reference for the userInfo
    */
   public void deleteUserInfo(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // First get the data.
         UserInfo bean = (UserInfo) hibernateTemplate.get(UserInfo.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteUserInfo(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return UserInfo the data object
    */
   public dbGarmentHibernate.entity.UserInfo getUserInfo(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
      UserInfo bean = (UserInfo) hibernateTemplate.get(UserInfo.class, id);
      return bean;
      } finally {
         log.debug("finished getUserInfo(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all userInfo instances.
    *
    * @return a list of UserInfo objects.
    */
   public List getUserInfoList() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {

      String queryString = "from " + UserInfo.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idUser";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getUserInfoList");
      }
   }

   /**
    * Returns a subset of all userInfo instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of userInfo instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getUserInfoListSize()</code> = last record),
    * any values greater than or equal to the total number of userInfo instances will cause
    * the full set to be returned.
    * @return a list of UserInfo objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getUserInfoList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + UserInfo.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getUserInfoList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of userInfo objects in the database.
    *
    * @return an integer value.
    */
   public int getUserInfoListSize() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + UserInfo.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getUserInfoListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idUser field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idUser the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    public java.util.List findUserInfoByIdUser(java.lang.Integer idUser) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + UserInfo.class.getName() + " e where e.idUser like :idUser ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idUser", idUser);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserInfoByIdUser(java.lang.Integer idUser)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userName the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    public java.util.List findUserInfoByUserName(java.lang.String userName) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + UserInfo.class.getName() + " e where e.userName like :userName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userName", userName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserInfoByUserName(java.lang.String userName)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified fullName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param fullName the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    public java.util.List findUserInfoByFullName(java.lang.String fullName) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + UserInfo.class.getName() + " e where e.fullName like :fullName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "fullName", fullName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserInfoByFullName(java.lang.String fullName)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userEmail field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userEmail the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    public java.util.List findUserInfoByUserEmail(java.lang.String userEmail) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + UserInfo.class.getName() + " e where e.userEmail like :userEmail ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userEmail", userEmail);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserInfoByUserEmail(java.lang.String userEmail)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idUserType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idUserType the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    public java.util.List findUserInfoByIdUserType(java.lang.Integer idUserType) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + UserInfo.class.getName() + " e where e.idUserType like :idUserType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idUserType", idUserType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserInfoByIdUserType(java.lang.Integer idUserType)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified password field.
     * To use a wildcard search, use a % in the query.
     *
     * @param password the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    public java.util.List findUserInfoByPassword(java.lang.String password) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + UserInfo.class.getName() + " e where e.password like :password ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "password", password);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserInfoByPassword(java.lang.String password)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified companyName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param companyName the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    public java.util.List findUserInfoByCompanyName(java.lang.String companyName) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + UserInfo.class.getName() + " e where e.companyName like :companyName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "companyName", companyName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserInfoByCompanyName(java.lang.String companyName)");
      }
    }


}

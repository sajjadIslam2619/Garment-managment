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
 * The <code>ProductTypeService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class ProductTypeService implements IProductTypeService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(ProductTypeService.class);


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
    * Adds a new productType to the database.
    *
    * @param model a data object
    * @return ProductType a data object with the primary key
    */
   public dbGarmentHibernate.entity.ProductType addProductType(dbGarmentHibernate.entity.ProductType model) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getProductType(model.getPrimaryKey());
      } finally {
         log.debug("finished addProductType(dbGarmentHibernate.entity.ProductType model)");
      }
   }

   /**
    * Stores the <code>ProductType</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveProductType(dbGarmentHibernate.entity.ProductType model) throws GenericBusinessException {
      // We have to create an object:
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveProductType(dbGarmentHibernate.entity.ProductType model)");
      }
   }

   /**
    * Removes a productType.
    *
    * @param id the unique reference for the productType
    */
   public void deleteProductType(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // First get the data.
         ProductType bean = (ProductType) hibernateTemplate.get(ProductType.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteProductType(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return ProductType the data object
    */
   public dbGarmentHibernate.entity.ProductType getProductType(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
      ProductType bean = (ProductType) hibernateTemplate.get(ProductType.class, id);
      return bean;
      } finally {
         log.debug("finished getProductType(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all productType instances.
    *
    * @return a list of ProductType objects.
    */
   public List getProductTypeList() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {

      String queryString = "from " + ProductType.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idProductType";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getProductTypeList");
      }
   }

   /**
    * Returns a subset of all productType instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of productType instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getProductTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of productType instances will cause
    * the full set to be returned.
    * @return a list of ProductType objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getProductTypeList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + ProductType.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idProductType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getProductTypeList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of productType objects in the database.
    *
    * @return an integer value.
    */
   public int getProductTypeListSize() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + ProductType.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getProductTypeListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idProductType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idProductType the field
     * @return List of ProductType data objects, empty list in case no results were found.
     */
    public java.util.List findProductTypeByIdProductType(java.lang.Integer idProductType) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + ProductType.class.getName() + " e where e.idProductType like :idProductType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idProductType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idProductType", idProductType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findProductTypeByIdProductType(java.lang.Integer idProductType)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified productTypeName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param productTypeName the field
     * @return List of ProductType data objects, empty list in case no results were found.
     */
    public java.util.List findProductTypeByProductTypeName(java.lang.String productTypeName) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + ProductType.class.getName() + " e where e.productTypeName like :productTypeName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idProductType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "productTypeName", productTypeName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findProductTypeByProductTypeName(java.lang.String productTypeName)");
      }
    }


}

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
 * The <code>ProductInfoService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class ProductInfoService implements IProductInfoService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(ProductInfoService.class);


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
    * Adds a new productInfo to the database.
    *
    * @param model a data object
    * @return ProductInfo a data object with the primary key
    */
   public dbGarmentHibernate.entity.ProductInfo addProductInfo(dbGarmentHibernate.entity.ProductInfo model) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getProductInfo(model.getPrimaryKey());
      } finally {
         log.debug("finished addProductInfo(dbGarmentHibernate.entity.ProductInfo model)");
      }
   }

   /**
    * Stores the <code>ProductInfo</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveProductInfo(dbGarmentHibernate.entity.ProductInfo model) throws GenericBusinessException {
      // We have to create an object:
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveProductInfo(dbGarmentHibernate.entity.ProductInfo model)");
      }
   }

   /**
    * Removes a productInfo.
    *
    * @param id the unique reference for the productInfo
    */
   public void deleteProductInfo(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         // First get the data.
         ProductInfo bean = (ProductInfo) hibernateTemplate.get(ProductInfo.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteProductInfo(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return ProductInfo the data object
    */
   public dbGarmentHibernate.entity.ProductInfo getProductInfo(java.lang.Integer id) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
      ProductInfo bean = (ProductInfo) hibernateTemplate.get(ProductInfo.class, id);
      return bean;
      } finally {
         log.debug("finished getProductInfo(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all productInfo instances.
    *
    * @return a list of ProductInfo objects.
    */
   public List getProductInfoList() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {

      String queryString = "from " + ProductInfo.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idProduct";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getProductInfoList");
      }
   }

   /**
    * Returns a subset of all productInfo instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of productInfo instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getProductInfoListSize()</code> = last record),
    * any values greater than or equal to the total number of productInfo instances will cause
    * the full set to be returned.
    * @return a list of ProductInfo objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getProductInfoList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + ProductInfo.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idProduct";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getProductInfoList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of productInfo objects in the database.
    *
    * @return an integer value.
    */
   public int getProductInfoListSize() throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + ProductInfo.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getProductInfoListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idProduct field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idProduct the field
     * @return List of ProductInfo data objects, empty list in case no results were found.
     */
    public java.util.List findProductInfoByIdProduct(java.lang.Integer idProduct) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + ProductInfo.class.getName() + " e where e.idProduct like :idProduct ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idProduct";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idProduct", idProduct);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findProductInfoByIdProduct(java.lang.Integer idProduct)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified productName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param productName the field
     * @return List of ProductInfo data objects, empty list in case no results were found.
     */
    public java.util.List findProductInfoByProductName(java.lang.String productName) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + ProductInfo.class.getName() + " e where e.productName like :productName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idProduct";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "productName", productName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findProductInfoByProductName(java.lang.String productName)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idProductType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idProductType the field
     * @return List of ProductInfo data objects, empty list in case no results were found.
     */
    public java.util.List findProductInfoByIdProductType(java.lang.Integer idProductType) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + ProductInfo.class.getName() + " e where e.idProductType like :idProductType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idProduct";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idProductType", idProductType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findProductInfoByIdProductType(java.lang.Integer idProductType)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified productPrice field.
     * To use a wildcard search, use a % in the query.
     *
     * @param productPrice the field
     * @return List of ProductInfo data objects, empty list in case no results were found.
     */
    public java.util.List findProductInfoByProductPrice(java.lang.Double productPrice) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + ProductInfo.class.getName() + " e where e.productPrice like :productPrice ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idProduct";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "productPrice", productPrice);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findProductInfoByProductPrice(java.lang.Double productPrice)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified productImage field.
     * To use a wildcard search, use a % in the query.
     *
     * @param productImage the field
     * @return List of ProductInfo data objects, empty list in case no results were found.
     */
    public java.util.List findProductInfoByProductImage(java.lang.String productImage) throws GenericBusinessException {
      dbGarmentHibernate.HibernateQueryHelper hibernateTemplate = new dbGarmentHibernate.HibernateQueryHelper();
      try {
         String queryString = "from " + ProductInfo.class.getName() + " e where e.productImage like :productImage ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idProduct";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "productImage", productImage);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findProductInfoByProductImage(java.lang.String productImage)");
      }
    }


}

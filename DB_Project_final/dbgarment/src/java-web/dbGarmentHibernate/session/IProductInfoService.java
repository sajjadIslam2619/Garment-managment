package dbGarmentHibernate.session;

/**
 * The <code>ProductInfoServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IProductInfoService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new productInfo to the storage.
    *
    * @param model a data object
    * @return ProductInfo a data object with the primary key
    */
   dbGarmentHibernate.entity.ProductInfo addProductInfo(dbGarmentHibernate.entity.ProductInfo model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Stores the <code>ProductInfo</code>.
    *
    * @param model the data model to store
    */
   void saveProductInfo(dbGarmentHibernate.entity.ProductInfo model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Removes a productInfo.
    *
    * @param id the unique reference for the productInfo
    */
   void deleteProductInfo(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return ProductInfo the data object
    */
   dbGarmentHibernate.entity.ProductInfo getProductInfo(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a list of all productInfo instances.
    *
    * @return a list of ProductInfo objects.
    */
   java.util.List<dbGarmentHibernate.entity.ProductInfo> getProductInfoList() throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a subset of all productInfo instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of productInfo instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getProductInfoListSize()</code> = last record),
    * any values greater than or equal to the total number of productInfo instances will cause
    * the full set to be returned.
    * @return a collection of ProductInfo objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<dbGarmentHibernate.entity.ProductInfo> getProductInfoList(int startIndex, int endIndex) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Obtains the total number of productInfo objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getProductInfoListSize() throws dbGarmentHibernate.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idProduct field.
     *
     * @param idProduct the field
     * @return List of ProductInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.ProductInfo> findProductInfoByIdProduct(java.lang.Integer idProduct) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified productName field.
     *
     * @param productName the field
     * @return List of ProductInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.ProductInfo> findProductInfoByProductName(java.lang.String productName) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idProductType field.
     *
     * @param idProductType the field
     * @return List of ProductInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.ProductInfo> findProductInfoByIdProductType(java.lang.Integer idProductType) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified productPrice field.
     *
     * @param productPrice the field
     * @return List of ProductInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.ProductInfo> findProductInfoByProductPrice(java.lang.Double productPrice) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified productImage field.
     *
     * @param productImage the field
     * @return List of ProductInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.ProductInfo> findProductInfoByProductImage(java.lang.String productImage) throws dbGarmentHibernate.exception.GenericBusinessException;


}

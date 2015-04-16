package dbGarmentHibernate.session;

/**
 * The <code>ProductTypeServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IProductTypeService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new productType to the storage.
    *
    * @param model a data object
    * @return ProductType a data object with the primary key
    */
   dbGarmentHibernate.entity.ProductType addProductType(dbGarmentHibernate.entity.ProductType model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Stores the <code>ProductType</code>.
    *
    * @param model the data model to store
    */
   void saveProductType(dbGarmentHibernate.entity.ProductType model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Removes a productType.
    *
    * @param id the unique reference for the productType
    */
   void deleteProductType(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return ProductType the data object
    */
   dbGarmentHibernate.entity.ProductType getProductType(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a list of all productType instances.
    *
    * @return a list of ProductType objects.
    */
   java.util.List<dbGarmentHibernate.entity.ProductType> getProductTypeList() throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a subset of all productType instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of productType instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getProductTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of productType instances will cause
    * the full set to be returned.
    * @return a collection of ProductType objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<dbGarmentHibernate.entity.ProductType> getProductTypeList(int startIndex, int endIndex) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Obtains the total number of productType objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getProductTypeListSize() throws dbGarmentHibernate.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idProductType field.
     *
     * @param idProductType the field
     * @return List of ProductType data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.ProductType> findProductTypeByIdProductType(java.lang.Integer idProductType) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified productTypeName field.
     *
     * @param productTypeName the field
     * @return List of ProductType data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.ProductType> findProductTypeByProductTypeName(java.lang.String productTypeName) throws dbGarmentHibernate.exception.GenericBusinessException;


}

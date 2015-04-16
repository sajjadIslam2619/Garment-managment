package dbGarmentHibernate.session;

/**
 * The <code>RawMatarialTypeServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IRawMatarialTypeService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new rawMatarialType to the storage.
    *
    * @param model a data object
    * @return RawMatarialType a data object with the primary key
    */
   dbGarmentHibernate.entity.RawMatarialType addRawMatarialType(dbGarmentHibernate.entity.RawMatarialType model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Stores the <code>RawMatarialType</code>.
    *
    * @param model the data model to store
    */
   void saveRawMatarialType(dbGarmentHibernate.entity.RawMatarialType model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Removes a rawMatarialType.
    *
    * @param id the unique reference for the rawMatarialType
    */
   void deleteRawMatarialType(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return RawMatarialType the data object
    */
   dbGarmentHibernate.entity.RawMatarialType getRawMatarialType(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a list of all rawMatarialType instances.
    *
    * @return a list of RawMatarialType objects.
    */
   java.util.List<dbGarmentHibernate.entity.RawMatarialType> getRawMatarialTypeList() throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a subset of all rawMatarialType instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of rawMatarialType instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getRawMatarialTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of rawMatarialType instances will cause
    * the full set to be returned.
    * @return a collection of RawMatarialType objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<dbGarmentHibernate.entity.RawMatarialType> getRawMatarialTypeList(int startIndex, int endIndex) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Obtains the total number of rawMatarialType objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getRawMatarialTypeListSize() throws dbGarmentHibernate.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idRawMaterialType field.
     *
     * @param idRawMaterialType the field
     * @return List of RawMatarialType data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.RawMatarialType> findRawMatarialTypeByIdRawMaterialType(java.lang.Integer idRawMaterialType) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified rawMaterialTypeName field.
     *
     * @param rawMaterialTypeName the field
     * @return List of RawMatarialType data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.RawMatarialType> findRawMatarialTypeByRawMaterialTypeName(java.lang.String rawMaterialTypeName) throws dbGarmentHibernate.exception.GenericBusinessException;


}

package dbGarmentHibernate.session;

/**
 * The <code>RawMatarialServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IRawMatarialService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new rawMatarial to the storage.
    *
    * @param model a data object
    * @return RawMatarial a data object with the primary key
    */
   dbGarmentHibernate.entity.RawMatarial addRawMatarial(dbGarmentHibernate.entity.RawMatarial model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Stores the <code>RawMatarial</code>.
    *
    * @param model the data model to store
    */
   void saveRawMatarial(dbGarmentHibernate.entity.RawMatarial model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Removes a rawMatarial.
    *
    * @param id the unique reference for the rawMatarial
    */
   void deleteRawMatarial(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return RawMatarial the data object
    */
   dbGarmentHibernate.entity.RawMatarial getRawMatarial(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a list of all rawMatarial instances.
    *
    * @return a list of RawMatarial objects.
    */
   java.util.List<dbGarmentHibernate.entity.RawMatarial> getRawMatarialList() throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a subset of all rawMatarial instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of rawMatarial instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getRawMatarialListSize()</code> = last record),
    * any values greater than or equal to the total number of rawMatarial instances will cause
    * the full set to be returned.
    * @return a collection of RawMatarial objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<dbGarmentHibernate.entity.RawMatarial> getRawMatarialList(int startIndex, int endIndex) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Obtains the total number of rawMatarial objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getRawMatarialListSize() throws dbGarmentHibernate.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idRawMatarial field.
     *
     * @param idRawMatarial the field
     * @return List of RawMatarial data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.RawMatarial> findRawMatarialByIdRawMatarial(java.lang.Integer idRawMatarial) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idRawMaterialType field.
     *
     * @param idRawMaterialType the field
     * @return List of RawMatarial data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.RawMatarial> findRawMatarialByIdRawMaterialType(java.lang.Integer idRawMaterialType) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified rawMaterialAmount field.
     *
     * @param rawMaterialAmount the field
     * @return List of RawMatarial data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.RawMatarial> findRawMatarialByRawMaterialAmount(java.lang.Integer rawMaterialAmount) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified perUnitPrice field.
     *
     * @param perUnitPrice the field
     * @return List of RawMatarial data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.RawMatarial> findRawMatarialByPerUnitPrice(java.lang.Double perUnitPrice) throws dbGarmentHibernate.exception.GenericBusinessException;


}

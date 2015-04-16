package dbGarmentHibernate.session;

/**
 * The <code>OrderTypeServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IOrderTypeService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new orderType to the storage.
    *
    * @param model a data object
    * @return OrderType a data object with the primary key
    */
   dbGarmentHibernate.entity.OrderType addOrderType(dbGarmentHibernate.entity.OrderType model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Stores the <code>OrderType</code>.
    *
    * @param model the data model to store
    */
   void saveOrderType(dbGarmentHibernate.entity.OrderType model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Removes a orderType.
    *
    * @param id the unique reference for the orderType
    */
   void deleteOrderType(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return OrderType the data object
    */
   dbGarmentHibernate.entity.OrderType getOrderType(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a list of all orderType instances.
    *
    * @return a list of OrderType objects.
    */
   java.util.List<dbGarmentHibernate.entity.OrderType> getOrderTypeList() throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a subset of all orderType instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of orderType instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getOrderTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of orderType instances will cause
    * the full set to be returned.
    * @return a collection of OrderType objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<dbGarmentHibernate.entity.OrderType> getOrderTypeList(int startIndex, int endIndex) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Obtains the total number of orderType objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getOrderTypeListSize() throws dbGarmentHibernate.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idOrderType field.
     *
     * @param idOrderType the field
     * @return List of OrderType data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderType> findOrderTypeByIdOrderType(java.lang.Integer idOrderType) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified orderName field.
     *
     * @param orderName the field
     * @return List of OrderType data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderType> findOrderTypeByOrderName(java.lang.String orderName) throws dbGarmentHibernate.exception.GenericBusinessException;


}

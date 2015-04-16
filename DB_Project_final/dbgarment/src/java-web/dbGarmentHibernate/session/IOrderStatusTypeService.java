package dbGarmentHibernate.session;

/**
 * The <code>OrderStatusTypeServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IOrderStatusTypeService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new orderStatusType to the storage.
    *
    * @param model a data object
    * @return OrderStatusType a data object with the primary key
    */
   dbGarmentHibernate.entity.OrderStatusType addOrderStatusType(dbGarmentHibernate.entity.OrderStatusType model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Stores the <code>OrderStatusType</code>.
    *
    * @param model the data model to store
    */
   void saveOrderStatusType(dbGarmentHibernate.entity.OrderStatusType model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Removes a orderStatusType.
    *
    * @param id the unique reference for the orderStatusType
    */
   void deleteOrderStatusType(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return OrderStatusType the data object
    */
   dbGarmentHibernate.entity.OrderStatusType getOrderStatusType(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a list of all orderStatusType instances.
    *
    * @return a list of OrderStatusType objects.
    */
   java.util.List<dbGarmentHibernate.entity.OrderStatusType> getOrderStatusTypeList() throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a subset of all orderStatusType instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of orderStatusType instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getOrderStatusTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of orderStatusType instances will cause
    * the full set to be returned.
    * @return a collection of OrderStatusType objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<dbGarmentHibernate.entity.OrderStatusType> getOrderStatusTypeList(int startIndex, int endIndex) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Obtains the total number of orderStatusType objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getOrderStatusTypeListSize() throws dbGarmentHibernate.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idOrderStatusType field.
     *
     * @param idOrderStatusType the field
     * @return List of OrderStatusType data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderStatusType> findOrderStatusTypeByIdOrderStatusType(java.lang.Integer idOrderStatusType) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified orderStatusName field.
     *
     * @param orderStatusName the field
     * @return List of OrderStatusType data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderStatusType> findOrderStatusTypeByOrderStatusName(java.lang.String orderStatusName) throws dbGarmentHibernate.exception.GenericBusinessException;


}

package dbGarmentHibernate.session;

/**
 * The <code>OrderStatusServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IOrderStatusService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new orderStatus to the storage.
    *
    * @param model a data object
    * @return OrderStatus a data object with the primary key
    */
   dbGarmentHibernate.entity.OrderStatus addOrderStatus(dbGarmentHibernate.entity.OrderStatus model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Stores the <code>OrderStatus</code>.
    *
    * @param model the data model to store
    */
   void saveOrderStatus(dbGarmentHibernate.entity.OrderStatus model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Removes a orderStatus.
    *
    * @param id the unique reference for the orderStatus
    */
   void deleteOrderStatus(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return OrderStatus the data object
    */
   dbGarmentHibernate.entity.OrderStatus getOrderStatus(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a list of all orderStatus instances.
    *
    * @return a list of OrderStatus objects.
    */
   java.util.List<dbGarmentHibernate.entity.OrderStatus> getOrderStatusList() throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a subset of all orderStatus instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of orderStatus instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getOrderStatusListSize()</code> = last record),
    * any values greater than or equal to the total number of orderStatus instances will cause
    * the full set to be returned.
    * @return a collection of OrderStatus objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<dbGarmentHibernate.entity.OrderStatus> getOrderStatusList(int startIndex, int endIndex) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Obtains the total number of orderStatus objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getOrderStatusListSize() throws dbGarmentHibernate.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idOrderStatus field.
     *
     * @param idOrderStatus the field
     * @return List of OrderStatus data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderStatus> findOrderStatusByIdOrderStatus(java.lang.Integer idOrderStatus) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idOrderStatusType field.
     *
     * @param idOrderStatusType the field
     * @return List of OrderStatus data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderStatus> findOrderStatusByIdOrderStatusType(java.lang.Integer idOrderStatusType) throws dbGarmentHibernate.exception.GenericBusinessException;


}

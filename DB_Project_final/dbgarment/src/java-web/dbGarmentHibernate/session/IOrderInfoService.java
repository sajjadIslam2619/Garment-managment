package dbGarmentHibernate.session;

/**
 * The <code>OrderInfoServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IOrderInfoService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new orderInfo to the storage.
    *
    * @param model a data object
    * @return OrderInfo a data object with the primary key
    */
   dbGarmentHibernate.entity.OrderInfo addOrderInfo(dbGarmentHibernate.entity.OrderInfo model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Stores the <code>OrderInfo</code>.
    *
    * @param model the data model to store
    */
   void saveOrderInfo(dbGarmentHibernate.entity.OrderInfo model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Removes a orderInfo.
    *
    * @param id the unique reference for the orderInfo
    */
   void deleteOrderInfo(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return OrderInfo the data object
    */
   dbGarmentHibernate.entity.OrderInfo getOrderInfo(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a list of all orderInfo instances.
    *
    * @return a list of OrderInfo objects.
    */
   java.util.List<dbGarmentHibernate.entity.OrderInfo> getOrderInfoList() throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a subset of all orderInfo instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of orderInfo instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getOrderInfoListSize()</code> = last record),
    * any values greater than or equal to the total number of orderInfo instances will cause
    * the full set to be returned.
    * @return a collection of OrderInfo objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<dbGarmentHibernate.entity.OrderInfo> getOrderInfoList(int startIndex, int endIndex) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Obtains the total number of orderInfo objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getOrderInfoListSize() throws dbGarmentHibernate.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idOrderInfo field.
     *
     * @param idOrderInfo the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderInfo> findOrderInfoByIdOrderInfo(java.lang.Integer idOrderInfo) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idUser field.
     *
     * @param idUser the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderInfo> findOrderInfoByIdUser(java.lang.Integer idUser) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idOrderType field.
     *
     * @param idOrderType the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderInfo> findOrderInfoByIdOrderType(java.lang.Integer idOrderType) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified productAmount field.
     *
     * @param productAmount the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderInfo> findOrderInfoByProductAmount(java.lang.Integer productAmount) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified orderEstimatedDate field.
     *
     * @param orderEstimatedDate the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderInfo> findOrderInfoByOrderEstimatedDate(java.sql.Date orderEstimatedDate) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idProduct field.
     *
     * @param idProduct the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderInfo> findOrderInfoByIdProduct(java.lang.Integer idProduct) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified orderDetail field.
     *
     * @param orderDetail the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderInfo> findOrderInfoByOrderDetail(java.lang.String orderDetail) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idOrderStatus field.
     *
     * @param idOrderStatus the field
     * @return List of OrderInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.OrderInfo> findOrderInfoByIdOrderStatus(java.lang.Integer idOrderStatus) throws dbGarmentHibernate.exception.GenericBusinessException;


}

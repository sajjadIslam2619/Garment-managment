package dbGarmentHibernate.session;

/**
 * The <code>UserTypeServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IUserTypeService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new userType to the storage.
    *
    * @param model a data object
    * @return UserType a data object with the primary key
    */
   dbGarmentHibernate.entity.UserType addUserType(dbGarmentHibernate.entity.UserType model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Stores the <code>UserType</code>.
    *
    * @param model the data model to store
    */
   void saveUserType(dbGarmentHibernate.entity.UserType model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Removes a userType.
    *
    * @param id the unique reference for the userType
    */
   void deleteUserType(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return UserType the data object
    */
   dbGarmentHibernate.entity.UserType getUserType(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a list of all userType instances.
    *
    * @return a list of UserType objects.
    */
   java.util.List<dbGarmentHibernate.entity.UserType> getUserTypeList() throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a subset of all userType instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of userType instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getUserTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of userType instances will cause
    * the full set to be returned.
    * @return a collection of UserType objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<dbGarmentHibernate.entity.UserType> getUserTypeList(int startIndex, int endIndex) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Obtains the total number of userType objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getUserTypeListSize() throws dbGarmentHibernate.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idUserType field.
     *
     * @param idUserType the field
     * @return List of UserType data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.UserType> findUserTypeByIdUserType(java.lang.Integer idUserType) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userTypeName field.
     *
     * @param userTypeName the field
     * @return List of UserType data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.UserType> findUserTypeByUserTypeName(java.lang.String userTypeName) throws dbGarmentHibernate.exception.GenericBusinessException;


}

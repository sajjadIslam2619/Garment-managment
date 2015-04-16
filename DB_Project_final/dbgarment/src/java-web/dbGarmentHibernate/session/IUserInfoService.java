package dbGarmentHibernate.session;

/**
 * The <code>UserInfoServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IUserInfoService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new userInfo to the storage.
    *
    * @param model a data object
    * @return UserInfo a data object with the primary key
    */
   dbGarmentHibernate.entity.UserInfo addUserInfo(dbGarmentHibernate.entity.UserInfo model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Stores the <code>UserInfo</code>.
    *
    * @param model the data model to store
    */
   void saveUserInfo(dbGarmentHibernate.entity.UserInfo model) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Removes a userInfo.
    *
    * @param id the unique reference for the userInfo
    */
   void deleteUserInfo(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return UserInfo the data object
    */
   dbGarmentHibernate.entity.UserInfo getUserInfo(java.lang.Integer id) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a list of all userInfo instances.
    *
    * @return a list of UserInfo objects.
    */
   java.util.List<dbGarmentHibernate.entity.UserInfo> getUserInfoList() throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Returns a subset of all userInfo instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of userInfo instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getUserInfoListSize()</code> = last record),
    * any values greater than or equal to the total number of userInfo instances will cause
    * the full set to be returned.
    * @return a collection of UserInfo objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<dbGarmentHibernate.entity.UserInfo> getUserInfoList(int startIndex, int endIndex) throws dbGarmentHibernate.exception.GenericBusinessException;

   /**
    * Obtains the total number of userInfo objects in the storage.
    * <b>NOTE:</b>If this session fa�ade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getUserInfoListSize() throws dbGarmentHibernate.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idUser field.
     *
     * @param idUser the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.UserInfo> findUserInfoByIdUser(java.lang.Integer idUser) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userName field.
     *
     * @param userName the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.UserInfo> findUserInfoByUserName(java.lang.String userName) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified fullName field.
     *
     * @param fullName the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.UserInfo> findUserInfoByFullName(java.lang.String fullName) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userEmail field.
     *
     * @param userEmail the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.UserInfo> findUserInfoByUserEmail(java.lang.String userEmail) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idUserType field.
     *
     * @param idUserType the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.UserInfo> findUserInfoByIdUserType(java.lang.Integer idUserType) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified password field.
     *
     * @param password the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.UserInfo> findUserInfoByPassword(java.lang.String password) throws dbGarmentHibernate.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified companyName field.
     *
     * @param companyName the field
     * @return List of UserInfo data objects, empty list in case no results were found.
     */
    java.util.List<dbGarmentHibernate.entity.UserInfo> findUserInfoByCompanyName(java.lang.String companyName) throws dbGarmentHibernate.exception.GenericBusinessException;


}

package dbGarmentHibernate.entity;

import java.io.Serializable;
import com.finalist.util.log.*;

import javax.persistence.*;
import dbGarmentHibernate.*;

/**
 * The UserInfo entity bean.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.23 $, $Date: 2006/05/19 20:42:48 $
 *
 *
 */
@Entity
@Table(name = "user_info")
public class UserInfo extends DbgarmentModelBase implements Serializable {

   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(UserInfo.class);



   private java.lang.Integer idUser;
   private java.lang.String userName;
   private java.lang.String fullName;
   private java.lang.String userEmail;
   private java.lang.Integer idUserType;
   private java.lang.String password;
   private java.lang.String companyName;

   /**
    * Default constructor.
    */
   public UserInfo() {
   }

   /**
    * Value object constructor.
    */
   public UserInfo(dbGarmentHibernate.entity.UserInfo value) {
      if (value != null) {
         setIdUser(value.getIdUser());
      }
      if (value != null) {
         setUserName(value.getUserName());
      }
      if (value != null) {
         setFullName(value.getFullName());
      }
      if (value != null) {
         setUserEmail(value.getUserEmail());
      }
      if (value != null) {
         setIdUserType(value.getIdUserType());
      }
      if (value != null) {
         setPassword(value.getPassword());
      }
      if (value != null) {
         setCompanyName(value.getCompanyName());
      }
   }

    /**
     * Return the primary key.
     *
     * @return java.lang.Integer with the primary key.
     */
   @javax.persistence.Transient
   public java.lang.Integer getPrimaryKey() {
        return getIdUser();
    }

    /**
     * Set the primary key.
     *
     * @param primaryKey the primary key
     */
   @javax.persistence.Transient
   public void setPrimaryKey(java.lang.Integer primaryKey) {
       setIdUser(primaryKey);
    }

   /**
    * Returns the value of the <code>idUser</code> property.
    *
    */
   @Column(name = "id_user" , nullable = false )
//  For a more generic generator, chose AUTO.
   @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
   public java.lang.Integer getIdUser() {
      return idUser;
   }

   /**
    * Sets the value of the <code>idUser</code> property.
    *
    * @param idUser the value for the <code>idUser</code> property
    */
   public void setIdUser(java.lang.Integer idUser) {
      this.idUser = idUser;
   }

   /**
    * Returns the value of the <code>userName</code> property.
    *
    */
   @Column(name = "user_name" , nullable = false , length=55 )
   public java.lang.String getUserName() {
      return userName;
   }

   /**
    * Sets the value of the <code>userName</code> property.
    *
    * @param userName the value for the <code>userName</code> property
    */
   public void setUserName(java.lang.String userName) {
      this.userName = userName;
   }

   /**
    * Returns the value of the <code>fullName</code> property.
    *
    */
   @Column(name = "full_name" , nullable = false , length=55 )
   public java.lang.String getFullName() {
      return fullName;
   }

   /**
    * Sets the value of the <code>fullName</code> property.
    *
    * @param fullName the value for the <code>fullName</code> property
    */
   public void setFullName(java.lang.String fullName) {
      this.fullName = fullName;
   }

   /**
    * Returns the value of the <code>userEmail</code> property.
    *
    */
   @Column(name = "user_email" , nullable = false , length=55 )
   public java.lang.String getUserEmail() {
      return userEmail;
   }

   /**
    * Sets the value of the <code>userEmail</code> property.
    *
    * @param userEmail the value for the <code>userEmail</code> property
    */
   public void setUserEmail(java.lang.String userEmail) {
      this.userEmail = userEmail;
   }

   /**
    * Returns the value of the <code>idUserType</code> property.
    *
    */
   @Column(name = "id_user_type" , nullable = false )
   public java.lang.Integer getIdUserType() {
      return idUserType;
   }

   /**
    * Sets the value of the <code>idUserType</code> property.
    *
    * @param idUserType the value for the <code>idUserType</code> property
    */
   public void setIdUserType(java.lang.Integer idUserType) {
      this.idUserType = idUserType;
   }

   /**
    * Returns the value of the <code>password</code> property.
    *
    */
   @Column(name = "password" , nullable = false , length=55 )
   public java.lang.String getPassword() {
      return password;
   }

   /**
    * Sets the value of the <code>password</code> property.
    *
    * @param password the value for the <code>password</code> property
    */
   public void setPassword(java.lang.String password) {
      this.password = password;
   }

   /**
    * Returns the value of the <code>companyName</code> property.
    *
    */
   @Column(name = "company_name"  , length=55 )
   public java.lang.String getCompanyName() {
      return companyName;
   }

   /**
    * Sets the value of the <code>companyName</code> property.
    *
    * @param companyName the value for the <code>companyName</code> property
    */
   public void setCompanyName(java.lang.String companyName) {
      this.companyName = companyName;
   }




    /**
     * Used by the display tag library for rendering a checkbox in the list.
     * @return String with a HTML checkbox.
     */
    @Transient
    public String getCheckbox() {
        String checkBox = "<input type=\"checkbox\" name=\"checkbox";
        checkBox += "_"+ getIdUser();
        checkBox += "\"/>";
        return checkBox;
    }


}

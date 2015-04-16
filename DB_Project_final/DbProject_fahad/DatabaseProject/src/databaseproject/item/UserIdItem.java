
package databaseproject.item;


public class UserIdItem {
    int id_user;
    String user_name,full_name,user_email,password,company_name,id_user_type,user_type_name;

    public UserIdItem() {
    }

    public UserIdItem(int id_user, String user_name, String full_name, String user_email, String password, String company_name, String id_user_type, String user_type_name) {
        this.id_user = id_user;
        this.user_name = user_name;
        this.full_name = full_name;
        this.user_email = user_email;
        this.password = password;
        this.company_name = company_name;
        this.id_user_type = id_user_type;
        this.user_type_name = user_type_name;
    }

    public String getId_user_type() {
        return id_user_type;
    }

    public void setId_user_type(String id_user_type) {
        this.id_user_type = id_user_type;
    }

    public String getUser_type_name() {
        return user_type_name;
    }

    public void setUser_type_name(String user_type_name) {
        this.user_type_name = user_type_name;
    }
    
    

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    
    
}

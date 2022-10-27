package Domain;

public class Admin extends User {

    //implements --> AdminCategoria,AdminUser,AdminProducts,ICommentsAdmin;
    public Admin (){}
    public Admin(String rut, String name, String password, String mail) {
        super(rut,name,password,mail);
    }
    
    
}

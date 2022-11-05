package Domain;

public class Admin extends User implements ICategoryAdmin,ICommentsAdmin,IUsersAdmin{

    //implements --> AdminCategoria,AdminUser,AdminProducts,ICommentsAdmin;
    public Admin (){}
    public Admin(String rut, String name, String password, String mail) {
        super(rut,name,password,mail);
    }
    @Override
    public void deleteComment() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void addCategory() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void deleteCategory() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void addUser() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void deleteUser() {
        // TODO Auto-generated method stub
        
    }
    

}

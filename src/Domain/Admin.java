package Domain;

public class Admin extends User {

    //implements --> AdminCategoria,AdminUser,AdminProducts,ICommentsAdmin;
    public Admin (){}
    public Admin(String rut, String name, String password, String mail) {
        this.rut = rut;
        this.name = name;
        this.password = password;
        this.mail = mail;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
}

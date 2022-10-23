package User;

public interface IUserBuilder {
    void setRut(String rut);
    void setName(String name);
    void setPassword(String password);
    void setIsAdmin(boolean admin);
    void setNumber(int number);
}

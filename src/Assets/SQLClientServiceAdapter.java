package Assets;

import Domain.User;
import Domain.UserBuilder;
import Domain.UserDirector;

public class SQLClientServiceAdapter {

    public static User loginData (String values){
        // Login & delete
        UserBuilder ub = new UserBuilder();
        UserDirector director = UserDirector.getUserDirector();
        director.loginUser(ub, values);
        return ub.getResult();
    }

    public static User userData(String values){
        //Register & update
        UserBuilder ub = new UserBuilder();
        UserDirector director = UserDirector.getUserDirector();
        director.createUser(ub, values);
        return ub.getResult();
    }




}

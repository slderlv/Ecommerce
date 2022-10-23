package Assets;

import User.User;
import User.UserBuilder;

public class SQLClientServiceAdapter {

    public static User loginData (String values){
        // Login & delete
        UserBuilder ub = new UserBuilder();
        String parts[] = FieldFormater.fillArrayValues(values);
        ub.setRut(parts[0]);
        ub.setPassword(parts[1]);
        User user = ub.getResult();
        ub = null; 
        return user;
    }

    public static User essentialData(String values){
        //Register & update
        UserBuilder ub = new UserBuilder();
        String parts[] = FieldFormater.fillArrayValues(values);
        ub.setRut(parts[0]);
        ub.setPassword(parts[1]);
        ub.setMail(parts[2]);
        ub.setNumber(Integer.parseInt(parts[3]));
        User user = ub.getResult();
        ub = null; 
        return user;
    }




}

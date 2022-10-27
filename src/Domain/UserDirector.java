package Domain;

import Assets.FieldFormater;

public class UserDirector {
    //Director director = new Director();
    //CarBuilder builder = new CarBuilder();
    //director.constructSportsCar(builder);
    //Car car = builder.getResult();

    //HOW TO USE
    // replace AdminBuilder,UserBuilder,ClientBuilder from builder to create every possible user
    private static UserDirector userDirector = null;
    private UserDirector(){}
	static public UserDirector getUserDirector() {
 
        if (userDirector == null) {
            userDirector = new UserDirector();
        }
        return userDirector;
    }

    public void createUser(IUserBuilder builder,String values){
        String parts[] = FieldFormater.fillArrayValues(values);
        builder.setName(parts[0]);
        builder.setMail(parts[1]);
        builder.setPassword(parts[2]);
        builder.setRut(parts[3]);
    }

    public void loginUser(IUserBuilder builder, String values){
        String parts[] = FieldFormater.fillArrayValues(values);
        builder.setRut(parts[0]);
        builder.setPassword(parts[1]);
    }
}

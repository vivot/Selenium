package models.components;

import java.lang.reflect.Constructor;

public class ComponentExploring {
    // public Boundary Genetic
    public <T extends LoginPage> void login(Class<T> loginPageClass, String usernameStr) {
        // Wildcard Generic type
        Class<?>[] parameters = new Class[]{};
        try {
            //Java Reflection
            Constructor<T> constructor = loginPageClass.getConstructor( parameters );
            T loginPageObj = constructor.newInstance();
            loginPageObj.inputUserName( usernameStr );

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

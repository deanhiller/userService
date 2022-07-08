package biz.xsoftware.api.usersvc;

import java.util.Map;

import biz.xsoftware.impl.usersvc.UserServiceFactoryImpl;

public abstract class UserServiceFactory
{
    public static UserServiceFactory createFactory(Map<String, Object> map) {
        UserServiceFactory factory = new UserServiceFactoryImpl();
        factory.configure(map);
        return factory;
    }
    
    protected abstract void configure(Map<String, Object> map);


    public abstract UserService createService();    
        
}

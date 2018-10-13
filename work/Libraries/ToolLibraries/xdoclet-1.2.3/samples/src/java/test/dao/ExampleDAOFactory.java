package test.dao;

/**
 * Example of a DAO factory class.  To see it in action, edit the CustomerBMPBean
 * to use impl-factory="test.dao.ExampleDAOFactory" in its class-level ejb.dao
 * tag instead of impl-jndi="dao".
 */
public class ExampleDAOFactory {
    
    /* Prevent instance creation, since it's not needed */
    private ExampleDAOFactory() {
    }
    
    public static Object getDaoInstance(Class clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("No type supplied");
        }
        
        // This example only handles the CustomerDAO.  Additional cases could be
        // added for other types, or a more sophisticated factory might use dynamic
        // proxies.
        if ("test.dao.CustomerDAO".equals(clazz.getName())) {
            return new CustomerExampleDAO();
        } else {
            throw new IllegalArgumentException("Don't know how to create DAO of type " + clazz.getName());
        }
    }
    
}

package dao;


import java.io.InputStream;
import java.util.Properties;

public class Factory {
    private Factory(){};
    private static Factory factroy= new Factory();
    public static Factory getFactory(){
        return factroy;
    }
    public <T> T getInstance(Class<T> clazz) {
        try {
            Properties p = new Properties();
            InputStream ins = Factory.class.getResourceAsStream("/db.properties") ;
            p.load( ins ) ;
            String className=clazz.getSimpleName();
            String realClass=p.getProperty(className) ;
           /* System.out.println(className);
            System.out.println(realClass);*/
            return (T) Class.forName(realClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

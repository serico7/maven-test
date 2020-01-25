package org.myorg;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.naming.Name;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    static final Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args )
    {
        App app = new App();
        Properties prop = null;
        String name = "";
        try {
            prop = app.loadPropertiesFile("resources.properties");
            name = prop.getProperty("hello.name");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BasicConfigurator.configure();
        logger.debug("Hello " + name + "!");
        System.out.println( "Hello " + name + "!" );
    }

    public Properties loadPropertiesFile(String filePath) throws IOException {

        Properties prop = new Properties();

        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath);
            prop.load(resourceAsStream);

        return prop;

    }
}

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final String PROPERTIES_PATH = "src/test/resources/config.properties";

    public static void setProperties() {
        try {
            InputStream input = new FileInputStream(PROPERTIES_PATH);
            Properties properties = new Properties();
            properties.load(input);

            String driver = properties.getProperty("driver");
            String pathToDriver = properties.getProperty("path");

            System.setProperty(driver, pathToDriver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

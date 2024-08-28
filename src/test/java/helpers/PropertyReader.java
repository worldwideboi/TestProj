package helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public Properties getPropertiesFile(String filePath) {
        Properties properties = new Properties();

        try (InputStream stream = this.getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (stream == null) {
                throw new FileNotFoundException("The file " + filePath + " could not be found.");
            }

            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}

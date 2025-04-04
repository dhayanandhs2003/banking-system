package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

    public static Properties getConnectionProperties(String propertyFileName) throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\dhaya\\eclipse-workspace\\VirtualArtGallery_CaseStudy\\database.properties");
        props.load(fis);
        fis.close();
        return props;
    }
}


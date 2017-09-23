package com.rocksoft.LogStr;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Created by Esenin on 19.09.2017.
 */
public class Utils {

    public static final Logger LOGGER = Logger.getLogger(Utils.class);

    public static String getConfig(String key) {
        String result = null;
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("src/main/resources/com/rocksoft/LogStr/config.properties");
            properties.load(inputStream);
            result = properties.getProperty(key);
        } catch (IOException e) {
            LOGGER.error(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }
        return result;
    }
}

package com.epam.scripps.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Iurii_Galias on 6/16/2015.
 */
public class ConfigReader
{
    private static Properties configFile;
    private static String configFileName = "./src/main/resources/config.properties";
    public static String getStringFromFile(String key)
    {
        Properties properties = new Properties();
        InputStream inputStream = null;
        String resullt = "";
        try
        {
            properties.load(new FileInputStream(configFileName));
            resullt = properties.getProperty(key);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(inputStream != null)
            {
                try
                {
                    inputStream.close();
                }
                catch (IOException err)
                {
                    err.printStackTrace();
                }
            }
        }return resullt;
    }
}

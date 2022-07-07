package com.example.automation.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
    public static Properties properties;

    public static void configProperties(){
        properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

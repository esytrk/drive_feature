package com.agileprocrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
//make it private so we are limiting access to the object
    //static is to make sure its created and loaded before everything else

    //1. Create the object of Properties
    private static Properties properties= new Properties();



    static {
        try{
            //2- We need to open the file in java memory: FileInputStream
            FileInputStream file= new FileInputStream("configuration.properties");

            //3- load the "properties" object with "file
            properties.load(file);

            //close the file in the memory
            file.close();

        } catch (IOException e) {
            e.printStackTrace();;
            System.out.println("file not found with given path!!");
            throw new RuntimeException(e);
        }}
    //create a utility method to use the object to read
    //4. use "properties" object to read from the file

    public static String getProperty(String keyword){
        return properties.getProperty(keyword); //??
    }



}

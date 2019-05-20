package com.cheer.dao;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFileTest {
    @Test
    public void readConfFile(){
        //绝对路径 不推荐
        //InputStream in = new FileInputStream("C:\\Developer_Tools\\dao-demo\\src\\main\\resources\\jdbc.properties");

        //以classpath为相对路径
        InputStream in = ReadPropertiesFileTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();

        try {
            properties.load(in);
            System.out.println("url=" + properties.getProperty("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (properties != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

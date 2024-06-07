package org.test.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class readPropertyFile {

    public static void main (String[] args) throws IOException {

        FileReader fr = new FileReader("C:\\Users\\Boev\\IdeaProjects\\Java-Selenium-TestNG-Framework\\src\\main\\resources\\configfiles\\config.properties");

        Properties p = new Properties();

        p.load(fr);

        System.out.println(p.getProperty("browser"));



    }
}

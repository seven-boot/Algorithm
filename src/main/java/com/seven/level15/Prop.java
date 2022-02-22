package com.seven.level15;

import java.io.IOException;
import java.util.Properties;

/**
 * @author QH
 */
public class Prop {



    static {
        Properties pro = new Properties();

        try {
            pro.load(Prop.class.getClassLoader().getResourceAsStream("231.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        pro.getProperty("");
    }
}

package com.seven.level10;

/**
 * @author QH
 * @date 2020/5/5
 * @description
 */
public class TJest {

    class Example {
        String str1;
        Example example;

        public Example() {
            str1 = "example";
        }

        public Example(String str) {
            str1 = str;
        }
    }


    class Demo extends Example{

    }

    public void test() {
        Example example = new Example("ex1");
//        Demo demo = new Demo("ex1");
    }
}

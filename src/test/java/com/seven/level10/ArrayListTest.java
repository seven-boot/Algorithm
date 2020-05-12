package com.seven.level10;

import org.junit.Test;

/**
 * @author QH
 * @date 2019/11/21
 * @description ArrayList 测试
 */
public class ArrayListTest {

   @Test
   public void test() {

           Example example = new Example("ex2");
           Demo demo = new Demo("ex1");
           System.out.println(demo.str1 + "-" + example.str1);

   }

    class Example {
        String str1;

        public Example() {
            str1 = "example";
        }

        public Example(String str) {
            str1 = str;
        }
    }


    class Demo extends Example {
        public Demo(String str) {
            super(str);
        }
    }
}

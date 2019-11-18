package com.seven.level10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QH
 * @date 2019/10/25
 * @description 创建List的时候指定容量大小与不指定的区别
 */
public class ListWithInitialCapacity {

    static int length = 1_000_000;
    public static List<String> listNoLength = new ArrayList<>();
    public static List<String> listWithLength = new ArrayList<>(length);

    public static void add(int sign) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            if (sign == 0) {
                listNoLength.add("test");
            } else {
                listWithLength.add("test");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("sign:"+sign+"----"+(end-start));
    }

    public static void main(String[] args) throws InterruptedException {
        add(0);
        add(1);
    }
}

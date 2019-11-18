package com.seven.level10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author QH
 * @date 2019/11/14
 * @description HashMap 分析
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("first", "Monedy");
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        formatList(stringList);
        formatList(integerList);
    }

    public static void formatList(List<?> list) {

    }
}

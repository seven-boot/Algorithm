package com.seven.level3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author QH
 * @date 2019/10/22
 * @description 针对给定的句子，返回字母表中每个字母出现的次数
 */
public class OccurTime {

    public static String StatList(String str) {
        StringBuffer sb = new StringBuffer();
        Map<String, Integer> has = new HashMap<>();
        String[] slist = str.split("\\b");  // 划分单词
        for (int i = 0; i < slist.length; i++) {
            if (has.containsKey(slist[i])) {    // 如果有此单词
                has.put(slist[i], has.get(slist[i]) + 1);
            } else {    // 没有此单词
                has.put(slist[i], 1);
            }
        }

        Iterator iterator = has.keySet().iterator();
        while (iterator.hasNext()) {
            String word = (String) iterator.next();
            sb.append("单词：").append(word).append("次数").append(has.get(word)).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "You are the mananger of an office supplies company. A colleague has received a letter compaining about an order for office furniture. She has left the letter for you to answer and has written some notes on it.";
        System.out.println(StatList(str));
    }
}

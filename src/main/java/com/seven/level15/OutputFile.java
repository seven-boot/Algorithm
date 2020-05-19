package com.seven.level15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author QH
 * @date 2020/5/19
 * @description 控制台输入内容输出到文件
 */
public class OutputFile {

    public static void main(String[] args) {

        InputStream in = System.in;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
                BufferedWriter bw = new BufferedWriter(new FileWriter("console.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if ("exit".equals(line)) {
                    break;
                }
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.seven.level15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author QH
 * @date 2020/5/19
 * @description 读取文件内容输出到控制台
 */
public class ReadFile {

    public static void main(String[] args) {

        OutputStream out = System.out;

        try (BufferedReader br = new BufferedReader(new FileReader("console.txt"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

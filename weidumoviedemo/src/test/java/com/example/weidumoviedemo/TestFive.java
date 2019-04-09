package com.example.weidumoviedemo;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2019-04-09.
 * GitHub：
 * email：
 * description：
 */
public class TestFive {
    @Test
    public void main(){
        List<String> list = new ArrayList<>();
        list.add("张三"+"\n");
        list.add("李四"+"\n");
        list.add("王五"+"\n");
        list.add("小何"+"\n");
        list.add("小海"+"\n");
        list.add("小燕"+"\n");
        list.add("历史"+"\n");
        list.add("你好"+"\n");
        list.add("钢板"+"\n");
        list.add("读流"+"\n");
        try {
            File file = new File("E:\\student.txt");
            if (!file.exists()){
                file.createNewFile();
                FileWriter outputStream = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStream);
                for (String s : list) {
                    bufferedWriter.write(s);
                    System.out.println(s);
                }
            }else{
                FileWriter outputStream = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStream);
                for (String s : list) {
                    bufferedWriter.write(s);
                    System.out.println(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void aa(){

    }
}

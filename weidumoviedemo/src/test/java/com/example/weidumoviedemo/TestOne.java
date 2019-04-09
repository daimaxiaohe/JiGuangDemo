package com.example.weidumoviedemo;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @date 2019-04-09.
 * GitHub：
 * email：
 * description：
 */
public class TestOne {
    /**
     * 现有一个文本文档。文档中存储着10个学生的成绩。
     * 请用IO进行读取，然后将成绩按从大到小排列，并将排序后的结果输出一下。
     */
    @Test
    public void student(){
        File file = new File("C:\\Users\\某某某\\Desktop\\aa.txt");
        StringBuffer stringBuffer = new StringBuffer();
        if (file.exists()){
            int len;
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                char[] bytes = new char[1024];
                while ((len=bufferedReader.read(bytes))>0){
                    stringBuffer.append(new String(bytes,0,len));
                }
                System.out.println(stringBuffer.toString());
                //转化
                List<String> list = Arrays.asList(stringBuffer.toString().split(","));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

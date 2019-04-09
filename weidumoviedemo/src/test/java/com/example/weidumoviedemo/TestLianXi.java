package com.example.weidumoviedemo;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author
 * @date 2019-04-09.
 * GitHub：
 * email：
 * description：
 */
public class TestLianXi {

    private File file;

    /**
     * ①创建学生名单列表student.txt，在文件中插入最少10个学生姓名，每行一个学生姓名来排列。
     * ②初始化5个奖品信息。分别为 手机、电脑、水杯、散热器、仙人掌。
     * ③从学生名单中随机抽取5个学生参与抽奖，奖品不可以重复获得。
     * ④将中奖人和他抽中的奖品信息输出出来（例如：张三抽中了手机）
     * ⑤将未中奖的学生名单写入到新的文件no.txt中
     */
    @Test
    public void main(){
        //第一步在txt文档中写入十个学生的姓名
        addstudent();
        //初始化五个奖品的信息
        List<String> list = new ArrayList<>();
        list.add("手机");
        list.add("电脑");
        list.add("水杯");
        list.add("散热器");
        list.add("仙人掌");
        //开始读取字符串 添加到集合中
        HashMap<String, String> map = new HashMap<>();
        try {
            //定义一个string 类型
            StringBuffer stringBuffer = new StringBuffer();
            //开始读取文件
            FileReader fileReader = new FileReader(file);
            //字符缓冲流
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String a;
            //随机数
            Random random = new Random();
            //开始循环  获取文件中的名字
            while ((a=bufferedReader.readLine())!=null){
                stringBuffer.append(a+",");
            }
            //关闭流
            bufferedReader.close();
            fileReader.close();
            //将文件名保存为一个集合
            List<String> list1 = Arrays.asList(stringBuffer.toString().split(","));
            //定义一个集合 来配合判断数据
            List<Integer> intlist= new ArrayList<>();
            intlist.add(0);
            intlist.add(1);
            intlist.add(2);
            intlist.add(3);
            intlist.add(4);
            int sui=5;
            //循环条件
            while (sui>0){
                int i = random.nextInt(list.size());
                for (int j=0;j<intlist.size();j++){
                    //判断是否是相同数
                    if (intlist.get(j)==i){
                        map.put(list1.get(i),list.get(i));
                        intlist.remove(j);
                        sui--;
                        break;
                    }
                }
            }
            //开始遍历写入中奖名单
            //输出流  写入到文件
            FileWriter fileWriter = new FileWriter(new File("E:\\no.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //遍历数组  将文件写入txt文本中
            for (Map.Entry<String, String> s : map.entrySet()) {
                //写入
                bufferedWriter.write(s.getKey()+"抽中了"+s.getValue());
                //换行
                bufferedWriter.newLine();
            }
            //刷新  不刷新文件中会没有数据
            bufferedWriter.flush();
            //关流
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 插入学生名单列表
     */
    public void addstudent(){
        file = new File("E:\\student.txt");
        //写入名字
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("张三");
            bufferedWriter.newLine();
            bufferedWriter.write("李四");
            bufferedWriter.newLine();
            bufferedWriter.write("王五");
            bufferedWriter.newLine();
            bufferedWriter.write("张二");
            bufferedWriter.newLine();
            bufferedWriter.write("仗义");
            bufferedWriter.newLine();
            bufferedWriter.write("网六");
            bufferedWriter.newLine();
            bufferedWriter.write("小七");
            bufferedWriter.newLine();
            bufferedWriter.write("丈八");
            bufferedWriter.newLine();
            bufferedWriter.write("老旧");
            bufferedWriter.newLine();
            bufferedWriter.write("意识");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

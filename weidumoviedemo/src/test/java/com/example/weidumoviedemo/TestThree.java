package com.example.weidumoviedemo;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2019-04-09.
 * GitHub：
 * email：
 * description：
 */
public class TestThree {

    private List<Person> list1;
    private List<Person> list2;

    @Test
    public void main() throws Exception {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list1.add(new Person(1,"马化腾",27,36000));
        list1.add(new Person(2,"刘强东",23,23000));
        list2.add(new Person(3,"李彦宏",25,18000));
        list2.add(new Person(4,"周鸿祎",21,12000));
        addMethod(list2);
        //boolean b = delMethod();
        //if (b){
           /* File file = new File("d:\\\\1701Z\\\\myclass.txt");
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            for (Person person : list1) {
                outputStreamWriter.write(person.toString());
            }*/
       // }
    }

    /**
     * 将list2添加到list1中
     * @param list
     */
    public void addMethod(List<Person> list){
        list1.addAll(list);
        for (Person person : list1) {
            System.out.print("list1:"+person.toString()+"\n");
        }
        for (Person person : list2) {
            System.out.print("list2:"+person.toString()+"\n");
        }
    }

    public boolean delMethod(){
        for (Person person : list1) {
            if (person.id%2!=0){
                list1.remove(person);
            }
        }
        return true;
    }

}

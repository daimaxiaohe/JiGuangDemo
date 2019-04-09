package com.example.weidumoviedemo;

import org.junit.Test;

/**
 * @author
 * @date 2019-04-09.
 * GitHub：
 * email：
 * description：
 */
public class TestFour {
    /**
     *分别使用while、do while 和for 循环打印10遍”一寸光阴一寸金”
     */
    @Test
    public void main(){
        int a=0;
        int b=0;
        //for循环
        for (int i = 0; i < 10; i++) {
            System.out.println("for:"+"一寸光阴一寸金"+i);
        }

        while (a!=10){
            System.out.println("while"+"一寸光阴一寸金"+a);
            a++;
        }
        do {
            System.out.println("do while:"+"一寸光阴一寸金"+b);
            b++;
        }while (b!=10);
    }
}

package com.example.weidumoviedemo;

import org.junit.Test;

/**
 * @author
 * @date 2019-04-09.
 * GitHub：
 * email：
 * description：
 */
public class TestTwo {
    /**
     * 2.定义一个乐器（Instrument）接口，其中有抽象方法play（）;
     * 在InstrumentTest测试类中，定义方法playInstrument(Instrument ins);
     * 在该类的main方法中调用上述方法，
     * 采用多态和匿名内部类两种形式进行调用（10分）
     */
    @Test
    public void main(){
        InstrumentTest(new Instrument() {
            @Override
            public void play() {
                System.out.print("aa");
            }
        });
    }

    public void InstrumentTest(Instrument instrument){
        
    }

}

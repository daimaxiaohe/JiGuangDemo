package com.example.weidumoviedemo;

/**
 * @author
 * @date 2019-04-09.
 * GitHub：
 * email：
 * description：
 */
public class Person {
    public int id;
    public String name;
    public int age;
    public int salary;

    public Person() {

    }

    public Person(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

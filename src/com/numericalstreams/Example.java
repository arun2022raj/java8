package com.numericalstreams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class A<T extends Number> {

    public int add(T a, T b, T c) {
        return a.intValue() + b.intValue() + c.intValue();
    }

}




public class Example {
    public static void main(String[] args) {
        Inter g=()-> System.out.println();
        Function<String,String> f= String::new;
        System.out.println(f.apply("jakkam"));

        Integer i=8;
        Integer j=5;
        Integer k=i+j;

        Consumer<Integer> s=a-> System.out.println(a);//System.out::println;
        s.accept(7);


    }
}
interface Inter{
    void maintain();
}
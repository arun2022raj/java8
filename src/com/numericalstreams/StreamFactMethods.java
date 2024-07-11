package com.numericalstreams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamFactMethods {
    public static void main(String[] args) {
        Stream st= Stream.of("Jakkam","Arun","Rajesh");
        st.forEach(System.out::println);

        Stream.iterate((long)1,x->x*2)
                .limit(64)
                .forEach(System.out::println);
        Supplier<Integer> sui= new Random()::nextInt;
        Stream.generate(sui)
                .filter(i->i>0)
                .limit(5)
                .forEach(System.out::println);



    }
}

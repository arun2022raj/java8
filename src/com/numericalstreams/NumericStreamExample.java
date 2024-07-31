package com.numericalstreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class NumericStreamExample {
    public static void main(String[] args) {
        long t=IntStream.rangeClosed(1,6)
                .count();
        System.out.println(t);
        long lt=IntStream.range(1,6)
                .sum();
        System.out.println(lt);
        System.out.println("Now range below");
        IntStream.range(1,6)
                .forEach(System.out::println);
        System.out.println("Now range closed below");
        IntStream.rangeClosed(1,6)
                .asDoubleStream()
                .forEach(System.out::println);

        int sumint=IntStream.rangeClosed(1,50)
                .sum();
        System.out.println(sumint);

        OptionalInt optionalmaxInt=IntStream.rangeClosed(1,50)
                .max();
        System.out.println(optionalmaxInt.getAsInt());

        OptionalInt optionalminInt=IntStream.rangeClosed(1,50)
                .max();
        System.out.println(optionalminInt.getAsInt());

        OptionalDouble optionalDouble=IntStream.rangeClosed(1,3)
                .average();
        System.out.println(optionalDouble.getAsDouble());

        DoubleStream.of(2.4);



    }
}

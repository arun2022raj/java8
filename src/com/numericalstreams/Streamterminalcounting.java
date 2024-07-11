package com.numericalstreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streamterminalcounting {
    public static void main(String[] args) {
        List<String> stringList= Arrays.asList("Jakkam","Arun","Rajesh","Arun");
        long count=stringList.stream()
                .filter(i->i.startsWith("A"))
                .collect(Collectors.counting());
        System.out.println(count);

        List<String> upperList=stringList.stream()
                .collect(Collectors.mapping(String::toUpperCase,Collectors.toList()));
        System.out.println(upperList);

        List<String> st=new ArrayList<>();
        Optional<String> opts=st.stream()
                .collect(Collectors.minBy((s1,s2)->s1.compareTo(s2)));
        System.out.println(opts.isPresent()?opts.get():"empty");

        List<String> ts=new ArrayList<>();
        Optional<String> opns=stringList.stream()
                .collect(Collectors.maxBy((s1,s2)->s2.compareTo(s1)));
        System.out.println(opns.isPresent()?opns.get():"empty");

        List<Integer> integerArrayList=Arrays.asList(1,2,3,4,5,6,7,8,9);

        int sumInt= integerArrayList.stream()
                .collect(Collectors.summingInt(i->i));
        System.out.println(sumInt);

        double avgInt= integerArrayList.stream()
                .collect(Collectors.averagingInt(i->i));
        System.out.println(avgInt);






    }
}

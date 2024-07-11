package com.numericalstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamterminalJoining {
    public static void main(String[] args) {
        List<String> stringList= Arrays.asList("Jakkam","Arun","Rajesh");
        String name=stringList.stream().collect(Collectors.joining());
        System.out.println(name);

        List<String> stringList2= Arrays.asList("Jakkam","Arun","Rajesh");
        String name1=stringList.stream().collect(Collectors.joining(" "));
        System.out.println(name1);

        List<String> stringList3= Arrays.asList("Jakkam","Arun","Rajesh");
        String name3=stringList.stream().collect(Collectors.joining(" ","(",")"));
        System.out.println(name3);

    }
}

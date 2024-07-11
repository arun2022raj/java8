package com.numericalstreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> a=/*null;*/ new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        Optional<List> b=Optional.ofNullable(a);

        //Optional.empty() create a Optional with empty
        System.out.println(b.isPresent()?b.get():b);
        // of is used when we know deinitly there is nullPointerException will come than we us of to wrap in optional
        Optional<String> name=Optional.ofNullable(null);
//        System.out.println(name.isPresent()?name.get():name);
        String uname=name.map(String::toUpperCase).orElse("empty");
        System.out.println(uname);
        String uname1=name.map(String::toUpperCase).orElseGet(()->"empty");
//        System.out.println(uname1);
//        String uname2=name.map(String::toUpperCase).orElseThrow(()->new RuntimeException("it is empty"));

        System.out.println("using ispreset and ifpresent");
        Optional<String> country=Optional.ofNullable("India");
        //But Optional isEmpty doesnot take any input simply gives boolean values
        System.out.println(country.isEmpty());
        //Optional isPresent doesnot take any input simply gives boolean values
        System.out.println(country.isPresent());
        System.out.println(country.isPresent()?country.get():"it is empty");
        //Optional ifPresnt takes a consumer as input
        //But Optional isPresent doesnot take any input simply gives boolean values
        country.ifPresent((i)->System.out.println(i+" is My Country \nBharath Mathaki Jai"));

        country.filter(i->i.startsWith("I")).ifPresent(i->System.out.println(i));
        country.map(String::toUpperCase).ifPresent(i->System.out.println(i));

        Optional<Optional<String>> op2=Optional.ofNullable(country);

        System.out.println("Flatmap");
        op2.flatMap(i -> i)
                .map(String::toUpperCase)
                .ifPresent(i -> System.out.println(i));




















    }
}

package com.numericalstreams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingAndUnbocimgStreams {
    public static void main(String[] args) {
//        List<Integer> list = IntStream.range(0,10)
//                .boxed()
//                .collect(Collectors.toList());
//        System.out.println(list);
//        int sum=list.stream()
//                .mapToInt(Integer::intValue)
//                .sum();
//        System.out.println(sum);
//        List<Integer> list1= IntStream.range(1,20)
//                .mapToObj(i->Integer.valueOf(i))
//                .collect(Collectors.toList());
//        System.out.println(list1);
//        double sumdouble= IntStream.range(1,20)
//                .mapToDouble(i->i)
//                .sum();
//        System.out.println(sumdouble);
//        long sumlong= IntStream.range(1,20)
//                .mapToLong(i->i)
//                .sum();
//        System.out.println(sumlong);

        String pol="వికటకవి";
        Predicate<String> isPolindrome= i->i.equals(new StringBuffer(i).reverse().toString());
        System.out.println(isPolindrome.test(pol));
        System.out.println(new StringBuffer(pol).reverse().toString());

    }
}

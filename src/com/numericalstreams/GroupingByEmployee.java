package com.numericalstreams;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Map;

public class GroupingByEmployee {
    public static void main(String[] args) {
        List<Employee> e = new ArrayList<Employee>();
        e.add(new Employee(101, "Arun", Arrays.asList("carrom", "reading"), 1000000, "M", "Bangalore"));
        e.add(new Employee(102, "Vinay", Arrays.asList("chess", "dancing"), 55000, "M", "Hyderabad"));
        e.add(new Employee(103, "Lakshimi Narayana", Arrays.asList("cricket", "singing"), 60000, "M", "Tirupati"));
        e.add(new Employee(104, "Arun Rajaram", Arrays.asList("cricket", "reading"), 65000, "M", "Chennai"));
        e.add(new Employee(105, "Romita", Arrays.asList("ludo", "eating"), 70000, "F", "Bangalore"));
        e.add(new Employee(106, "Hanumanth", Arrays.asList("rummy", "playing"), 75000, "M", "Hyderabad"));
        e.add(new Employee(107, "Sachin", Arrays.asList("candycrush", "watching"), 80000, "M", "Tirupati"));
        e.add(new Employee(108, "Sirisha", Arrays.asList("football", "eating"), 85000, "F", "Chennai"));
        e.add(new Employee(109, "Lavanya", Arrays.asList("templerun", "reading"), 90000, "F", "Bangalore"));
        e.add(new Employee(110, "Geetha", Arrays.asList("table tennis", "dancing"), 95000, "F", "Hyderabad"));
        e.add(new Employee(111, "Supraja", Arrays.asList("volleyball", "singing"), 100000, "F", "Tirupati"));
        e.add(new Employee(112, "Amrutha", Arrays.asList("basketball", "reading"), 55000, "F", "Chennai"));
        e.add(new Employee(113, "Sri Veni", Arrays.asList("throwball", "singing"), 60000, "F", "Bangalore"));
//        System.out.println(e);

        System.out.println("------Excel Questions ----------------------------");
        System.out.println("1. Given a list of employee objects count the male and female employees in the given list.");
        Map<String,Long> genderCount=  e.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        int[] genc=new int[2];
        e.stream().forEach(e1->{
            if(e1.getGender().equals("M"))
                genc[0]++;
            else
                genc[1]++;
        });
        System.out.println(Arrays.toString(genc));
        System.out.println(genderCount);

        System.out.println("2. Find employees belonging to one city.");

        List<Employee> tptPeople= e.stream().filter(e1->e1.getCity()
                .trim().equalsIgnoreCase("Tirupati"))
                .collect(Collectors.toList());
        System.out.println(tptPeople);

        System.out.println("3. Count the number of employees according to designation.");
        Map<String,Long> cityCount= e.stream().collect(Collectors.groupingBy(Employee::getCity,Collectors.counting()));
        System.out.println(cityCount);

        System.out.println("\n4. Increase salary of employees by 10%.\n");
        e.stream().peek(e1-> System.out.print(e1.getSalary()+" - ")).forEach(e1->{
            System.out.println(e1.getSalary()+(e1.getSalary()/100));
        });

        System.out.println("\n5. Sort employees based on name.\n");
        e.sort((e1,e2)->e1.getEname().compareTo(e2.getEname()));
        System.out.println(e);

        System.out.println("\n6. Print each number and its occurrence in a given list of integers.\n");
        List<Integer> integers=Arrays.asList(1,2,4,3,1,2,4,1,1,2,3,4,2,1,1,2,4);
        Map<Integer,Long>intcount=integers.stream().collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()));
        System.out.println(intcount);

        System.out.println("\n7. Print the even numbers in a list using java8 streams.\n");
        integers.stream().filter(i->i%2==0).forEach(System.out::print);

        System.out.println("\n8. Filter the employees whose salary is greater than 40000.\n");
        e.stream().filter(e1->e1.getSalary()>75000).forEach(System.out::println);

        System.out.println("\n9. Find the minimum and maximum number in a list.\n");
        Optional<Integer> min=integers.stream().reduce((i1,i2)->i1<i2?i2:i1);
        System.out.println(min);
        IntSummaryStatistics statistics=integers.stream().mapToInt(i1->Integer.valueOf(i1)).summaryStatistics();
        System.out.println("max : "+statistics.getMax()+ "   Min : "+statistics.getMin());

        System.out.println("\n Print true if the list contains duplicate characters.\n");

        List<Character> charlist=Arrays.asList('c','d','d','t','e','t');
        List<Character> newchar= charlist.stream().distinct().collect(Collectors.toList());
        System.out.println(charlist.size()==newchar.size()?true:false);

        System.out.println("\n Convert employee name to upper case using stream.\n");

        e.stream().map(Employee::getEname).map(String::toUpperCase).forEach(i-> System.out.print(i+" - "));

        System.out.println("\n Print the strings and its occurrence from a list of strings.\n");
        List<String> stringList= Arrays.asList("arun","jakkam","rajesh","jakkam");

        Map<String,Long> stringoccuracne= stringList.stream().collect(Collectors.groupingBy(String::toString,Collectors.counting()));
        System.out.println(stringoccuracne);
        System.out.println("\n Find count of each character in a string using java8.\n");

        String name="jakkam arun rajesh";
        Stream<String> arstring = Arrays.stream(name.split(""));
        Map<String,Long> charCoutn=arstring.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        System.out.println(charCoutn);

        System.out.println("\n  Sort the list in reverse order.\n");
        integers.sort((i1,i2)->i1>i2?-1:i1<i2?1:1);
        System.out.println(integers);
        System.out.println("\n Print multiples of 5 in list.\n");

        IntStream.rangeClosed(1,50).filter(i->i%5==0).forEach(i-> System.out.print(i+" - "));

        System.out.println("\n Amstrong Number.");

        int num=123;
        Function<Integer,Integer> f=(i)->i*i*i;
        Stream<String> amg = Arrays.stream(String.valueOf(num).split(""));
        int rev=amg.map(i->Integer.valueOf(i)).map(f).reduce((i1,i2)->i1+i2).get();
        if (rev==num)
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println("\n anagram");

        BiFunction<String,String,Boolean> anag=(an1,an2)->{
            char[] ch=an1.toCharArray();
            char[] ch1=an2.toCharArray();
            Arrays.sort(ch);
            Arrays.sort(ch1);
            return Arrays.equals(ch,ch1);
        };
        System.out.println(anag.apply("listen","silent"));
        System.out.println("\n min3 max3");

        List<Integer> integers1=Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> min3=integers1.stream()
                .sorted((i1,i2)->i1>i2?1:i1<i2?-1:1)
                .limit(3)
                        .collect(Collectors.toList());
        System.out.println("min3"+min3);
        List<Integer> max3=integers1.stream()
                .sorted((i1,i2)->i1<i2?1:i1>i2?-1:1)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("max3"+max3);

        System.out.println("Sum of first 10 natuarl number");
        System.out.println(IntStream.rangeClosed(1,10).sum());

        System.out.println("sum of all digits of a number");

        num=123456789;
        int sum= Arrays.stream(String.valueOf(num).split("")).map(Integer::valueOf).reduce((i1,i2)->i1+i2).get();
        System.out.println(sum);
        System.out.println("sorting string increasing order of thier length");

        List<String> strings=Arrays.asList("arun","jakkam","Rajesh","arun");
        strings.sort((e1,e2)->{
            int s1=e1.length();
            int s2=e2.length();
            return s1<s2?-1:s1>s2?1:1;
        });
        System.out.println(strings);

        System.out.println("Laragest String in the Array");
        strings.stream().sorted((e1,e2)->e1.compareTo(e2)).limit(1).forEach(System.out::println);

        IntSummaryStatistics llist=integers1.stream().mapToInt(Integer::valueOf).summaryStatistics();
        System.out.println("sum: "+llist.getSum());
        System.out.println("Average: "+llist.getAverage());

        String s="I Love Java Programming";
        String s1=Arrays.stream(s.split(" "))
                .map(i->{return new StringBuffer(i).reverse();})
                        .collect(Collectors.joining(" "));
        System.out.println(s1);

        System.out.println("reversing array");
        int[] intArray={1,2,3,4,5,6,7,8,9};
        int[] revArray=Arrays.stream(intArray).boxed().sorted((i1,i2)->i2-i1).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(revArray));

        BiFunction<String,String,Boolean> polind= (e1,e2)->{
            return new StringBuilder(e1).reverse().toString().equals(e2);
        };
        System.out.println(polind.apply("cat","tac"));

        System.out.println("functional interface for multiply 2 number");
        BiFunction<Integer,Integer,Integer> mul2=(i1,i2)->i1*i2;
        System.out.println(mul2.apply(4,3));

        System.out.println("to print random number");

        IntStream.generate(()->new Random().nextInt()).limit(10).forEach(System.out::println);

        System.out.println("count whose length is greater than 3");

        System.out.println(strings.stream().filter(e1->e1.length()>3).count());

        System.out.println("multiply three to all the elements in the lis");

        integers1.stream().map(i->i*3).forEach(System.out::println);

        System.out.println("finding duplicate string and count");

        Map<String,Long> dupcount=strings.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<Map.Entry<String, Long>> collect = dupcount.entrySet().stream().filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toList());
        System.out.println(collect);


        String input = "swiss";

        Character firstNonRepeatedChar = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("First non-repeated character: " + firstNonRepeatedChar);

        String input2 = "swiss";

        Set<Character> seen = new HashSet<>();
        Character firstRepeatedChar = input2.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !seen.add(c))
                .findFirst()
                .orElse(null);

        System.out.println("First repeated character: " + firstRepeatedChar);































        System.out.println("\n------Excel Questions ----------------------------");
//
//        Map<String, List<Employee>> groupbygender=e.stream()
//                .collect(Collectors.groupingBy(Employee::getGender));
//        System.out.println(groupbygender);
//        Map<String, List<Employee>> groupbycoustcat=e.stream()
//                .collect(Collectors.groupingBy(i->i.getSalary()>75000?"more than 75000":"Less than 75000"));
//        System.out.println(groupbycoustcat);
//
//        Map<String, Map<String,List<Employee>>> twolevelgrouping=e.stream()
//                .collect(Collectors.groupingBy(i->i.getSalary()>75000?"more than 75000":"Less than 75000",Collectors.groupingBy(Employee::getGender)));
//        System.out.println(twolevelgrouping);
//
//        Map<String, Integer> twolevelgrouping1=e.stream()
//                .collect(Collectors.groupingBy(Employee::getGender,Collectors.summingInt(Employee::getSalary)));
//        System.out.println(twolevelgrouping1);
//        Map<String, Set<Employee>> three_Argument_type=e.stream()
//                .collect(Collectors.groupingBy(Employee::getGender, LinkedHashMap::new,Collectors.toSet()));
//        System.out.println(three_Argument_type);
//
//        Map<String, Optional<Employee>> HighSalary=e.stream()
//                .collect(Collectors.groupingBy(Employee::getGender,Collectors.maxBy((e1,e2)->e1.getSalary()>e2.getSalary()?1:e1.getSalary()<e2.getSalary()?-1:1)));
//        System.out.println("HighSalary : "+HighSalary);
//
//        Map<String, Employee> HighSalaryemployeename=e.stream()
//                .collect(Collectors.groupingBy(Employee::getGender,Collectors.collectingAndThen(Collectors.maxBy((e1,e2)->e1.getSalary()>e2.getSalary()?1:e1.getSalary()<e2.getSalary()?-1:1),Optional::get)));
//        System.out.println("HighSalaryemployeename : "+HighSalaryemployeename);
//
//        Map<Boolean, List<Employee>> partioningby=e.stream()
//                .collect(Collectors.partitioningBy(e1->e1.getSalary()>75000));
//        System.out.println("partioningby : "+partioningby);
//
//        Map<Boolean, Optional<Employee>> partioningbytwo=e.stream()
//                .collect(Collectors.partitioningBy(e1->e1.getSalary()>75000,Collectors.maxBy((e1,e2)->e1.getSalary()>e2.getSalary()?1:e1.getSalary()<e2.getSalary()?-1:1)));
//        System.out.println("partioningbytwo : "+partioningbytwo);











    }
}

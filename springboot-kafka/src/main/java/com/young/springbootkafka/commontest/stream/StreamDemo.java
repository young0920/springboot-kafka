package com.young.springbootkafka.commontest.stream;

import com.young.springbootkafka.pojo.User;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流基本操作
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/22 17:28
 */
public class StreamDemo {
    private static final List<User> userList = new ArrayList<>();

    static {
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.valueOf(i + 2));
            user.setUsername("young" + i);
            user.setPassword("young" + i);
            user.setRealname("young" + i);
            userList.add(user);
        }
    }

    public static void main(String[] args) {
        Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .map(s -> s.length())
                .forEach(s -> System.out.println(s));

        toListAndSet();
        listToMap();
        join();
        counting();
        summarizing();
        reducing();
        groupingby();
        partitioningBy();
    }

    private static void toListAndSet() {
        Stream.of(1, 2, 3, 4, 5, 6, 8, 9, 0, 1)
                .collect(Collectors.toCollection(ArrayList::new));

        //Set
        Stream.of(1, 2, 3, 4, 5, 6, 8, 9, 0, 1)
                .collect(Collectors.toCollection(HashSet::new));

        //List
        Stream.of(1, 2, 3, 4, 5, 6, 8, 9, 0)
                .collect(Collectors.toList());
        //Set
        Stream.of(1, 2, 3, 4, 5, 6, 8, 9, 0)
                .collect(Collectors.toSet());
    }

    private static void listToMap() {
        //Function.identity() 获取这个对象本身，那么结果就是Map<String,Student> 即 id->student
        //串行收集
        userList.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));

        //并发收集
        userList.stream()
                .parallel()
                .collect(Collectors.toConcurrentMap(User::getId, Function.identity()));


        //Map<String,String> 即 id->name
        //串行收集
        userList.stream()
                .collect(Collectors.toMap(User::getId, User::getUsername));
        //并发收集
        userList.stream()
                .parallel()
                .collect(Collectors.toConcurrentMap(User::getId, User::getUsername));

        //Map<String,Student>
        //假设有两个id相同Student，如果他们id相同，在转成Map的时候，取name大一个，小的将会被丢弃。
        userList.stream()
                .collect(Collectors
                        .toMap(User::getId,
                                Function.identity(),
                                BinaryOperator
                                        .maxBy(Comparator.comparing(User::getUsername))));


        //可能上面比较复杂，这编写一个命令式
        //Map<String,Student>
        userList.stream()
                .collect(Collectors
                        .toMap(User::getId,
                                Function.identity(),
                                (s1, s2) -> {
                                    //这里使用compareTo 方法 s1>s2 会返回1,s1==s2 返回0 ，否则返回-1
                                    if (s1.getUsername().compareTo(s2.getUsername()) < 0) {
                                        return s2;
                                    } else {
                                        return s1;
                                    }
                                }));

        //自定义LinkedHashMap
        //Map<String,Student>
        userList.stream()
                .collect(Collectors
                        .toMap(User::getId,
                                Function.identity(),
                                BinaryOperator
                                        .maxBy(Comparator.comparing(User::getUsername)),
                                LinkedHashMap::new));
    }

    private static void join() {
        //使用分隔符：201900012019000220190003
        userList.stream()
                .map(user -> user.getId())
                .collect(Collectors.joining());

        //使用^_^ 作为分隔符
        //20190001^_^20190002^_^20190003
        userList.stream()
                .map(user -> user.getId())
                .collect(Collectors.joining("^_^"));

        //使用^_^ 作为分隔符
        //[]作为前后缀
        //[20190001^_^20190002^_^20190003]
        userList.stream()
                .map(User::getId)
                .collect(Collectors.joining("^_^", "[", "]"));
    }

    private static void counting() {
        // Long 8
        Stream.of(1, 0, -10, 9, 8, 100, 200, -80)
                .collect(Collectors.counting());

        //如果仅仅只是为了统计，那就没必要使用Collectors了，那样更消耗资源
        // long 8
        Stream.of(1, 0, -10, 9, 8, 100, 200, -80)
                .count();

        // maxBy 200
        Stream.of(1, 0, -10, 9, 8, 100, 200, -80)
                .collect(Collectors.maxBy(Integer::compareTo)).ifPresent(System.out::println);

        // max 200
        Stream.of(1, 0, -10, 9, 8, 100, 200, -80)
                .max(Integer::compareTo).ifPresent(System.out::println);

        // minBy -80
        Stream.of(1, 0, -10, 9, 8, 100, 200, -80)
                .collect(Collectors.minBy(Integer::compareTo)).ifPresent(System.out::println);

        // min -80
        Stream.of(1, 0, -10, 9, 8, 100, 200, -80)
                .min(Integer::compareTo).ifPresent(System.out::println);
    }

    private static void summarizing() {
        //IntSummaryStatistics{count=10, sum=55, min=1, average=5.500000, max=10}
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.summarizingInt(Integer::valueOf));

        //DoubleSummaryStatistics{count=10, sum=55.000000, min=1.000000, average=5.500000, max=10.000000}
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.summarizingDouble(Double::valueOf));

        //LongSummaryStatistics{count=10, sum=55, min=1, average=5.500000, max=10}
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.summarizingLong(Long::valueOf));


        // 55
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).mapToInt(Integer::valueOf).sum();

        // 55.0
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).mapToDouble(Double::valueOf).sum();

        // 55
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).mapToLong(Long::valueOf).sum();

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.averagingInt(Integer::valueOf));

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.averagingDouble(Double::valueOf));

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.averagingLong(Long::valueOf));
    }

    private static void reducing() {
        //对所有名字长度求和规约操作
        //Optional[6]
        userList.stream()
                .map(user -> user.getUsername().length())
                .collect(Collectors.reducing((a, b) -> Integer.sum(a, b)));
        userList.stream()
                .map(user -> user.getUsername().length())
                .reduce((a, b) -> Integer.sum(a, b));

        //6
        //或者这样，指定初始值，这样可以防止没有元素的情况下正常执行
        userList.stream()
                .map(user -> user.getUsername().length())
                .collect(Collectors.reducing(0, (i1, i2) -> i1 + i2));
        userList.stream()
                .map(user -> user.getUsername().length())
                .reduce(0, (i1, i2) -> i1 + i2);


        //6
        //更或者先不转换，规约的时候再转换
        userList.stream()
                .collect(Collectors.reducing(0, s -> s.getUsername().length(), Integer::sum));
        userList.stream().map(s -> s.getUsername().length())
                .reduce(0, Integer::sum);
    }

    public static void groupingby(){
        //将一组数整型数分为正数、负数、零
        //Map<String,List<Integer>>
        Stream.of(-6, -7, -8, -9, 1, 2, 3, 4, 5, 6)
                .collect(Collectors.groupingBy(integer -> {
                    if (integer < 0) {
                        return "小于";
                    } else if (integer == 0) {
                        return "等于";
                    } else {
                        return "大于";
                    }
                }));

        //Map<String,Set<Integer>>
        //自定义下游收集器
        Stream.of(-6, -7, -8, -9, 1, 2, 3, 4, 5, 6)
                .collect(Collectors.groupingBy(integer -> {
                    if (integer < 0) {
                        return "小于";
                    } else if (integer == 0) {
                        return "等于";
                    } else {
                        return "大于";
                    }
                },Collectors.toSet()));

        //Map<String,Set<Integer>>
        //自定义map容器 和 下游收集器
        Stream.of(-6, -7, -8, -9, 1, 2, 3, 4, 5, 6)
                .collect(Collectors.groupingBy(integer -> {
                    if (integer < 0) {
                        return "小于";
                    } else if (integer == 0) {
                        return "等于";
                    } else {
                        return "大于";
                    }
                },LinkedHashMap::new,Collectors.toSet()));
    }

    public static void partitioningBy(){
        //partitioningBy最多只能将数据分为两部分，因为partitioningBy分区的依据Predicate，
        // 而Predicate只会有true 和false 两种结果，所有partitioningBy最多只能将数据分为两组
        //Map<Boolean,List<Integer>>
        Stream.of(0,1,0,1)
                .collect(Collectors.partitioningBy(integer -> integer==0));

        //Map<Boolean,Set<Integer>>
        //自定义下游收集器
        Stream.of(0,1,0,1)
                .collect(Collectors.partitioningBy(integer -> integer==0,Collectors.toSet()));

        //List<String>
        userList.stream()
                .collect(Collectors.mapping(User::getUsername,Collectors.toList()));
        userList.stream()
                .map(User::getUsername)
                .collect(Collectors.toList());

        //listIterator
        userList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.listIterator()));

    }
}

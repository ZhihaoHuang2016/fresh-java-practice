package demo;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;

/**
 * @author chenling
 */
public class StreamDemo {

    public static final Collector<String, List<String>, List<String>> myToList = Collector.of(
            // supplier： 创建 A（ArrayList）
            ArrayList::new,
            // accumulator：把每个元素放入 A 中
            (list, el) -> list.add(el),
            // combiner：如果并行拆分成多个流，直接 addAll 合并
            // 如果不想支持并行可以写个空，或抛UnsupportedOperationException异常
            (listA, listB) -> {
                listA.addAll(listB);
                return listA;
            },
            // finisher：不做任何事情，直接返回 A
            Function.identity(),
            // characteristics...：表名 A R 类型相同， 且支持并行流
            Collector.Characteristics.IDENTITY_FINISH,
            Collector.Characteristics.CONCURRENT
    );

    static {
        map = new HashMap<>();
        list = new ArrayList<>();
        init();
    }

    private static final Map<String, String> map;
    private static final List<String> list;

    private static void init() {
        map.put("name", "wang");
        map.put("age", "12");

        list.add("name");
        list.add("age");
        list.add("time");
        list.add("title");
        list.add("year");
    }

    public static void case1() {
        list.stream().forEach(System.out::println);
    }

    public static void case2() {
        list.stream().filter(s -> s.length() > 2).forEach(System.out::println);
    }

    public static void case3() {
        System.out.println(list.stream().anyMatch(s -> s.startsWith("a")));
        System.out.println(list.stream().allMatch(s -> s.startsWith("a")));
    }

    public static void case4() {
        list.stream().findAny().ifPresent(System.out::print);
    }

    public static void case5() {
        list.stream().map(s -> s.charAt(0)).forEach(System.out::println);
    }

    public static void case6() {
        list.stream().flatMap(s -> map.values().stream().map(s1 -> s + s1)).forEach(System.out::println);
    }

    public static void case7() {
        list.stream().map(s -> String.valueOf(s.charAt(0))).reduce((s1, s2) -> s1 + s2).ifPresent(System.out::print);
    }

    public static void main(String[] args) throws IOException {
//        Utils.invokeAllCases(StreamDemo.class);
//
//        // 生成一个空流
//        Stream<Object> empty = Stream.empty();
//        // 值生成流
//        Stream<String> stringStream = Stream.of("1", "2", "3");
//
//        // 数组生成流
//        String[] strings = {"1", "2", "3"};
//        Stream<String> stream = Arrays.stream(strings);
//
//        List<String> strings1 = Arrays.asList("1", "2", "3");
//        List<String> strings1 = Arrays.asList("1", "2", "3");
//        List<String> strings1 = Arrays.asList("1", "2", "3");
//        Stream<String> stream1 = strings1.stream();
//
//        Stream<String> lines = Files.lines(Paths.get("/c/mnt/"));
//
//        // 无限流，流从0开始，下面的每个元素依次加2
//        Stream<Integer> iterate = Stream.iterate(0, num -> num + 2);
//        // 无限流，流中每个元素都是 0~1 随机数
//        Stream<Double> generate = Stream.generate(Math::random);
//
//        // 生成0到10的int流
//        IntStream intStream = IntStream.rangeClosed(0, 10);
//        // 生成0到9的int流
//1/zWW~ `;       IntStream intStream1 = IntStream.range(0, 10);
//1/zWW~ `;       IntStream intStream1 = IntStream.range(0, 10);

////        long count = Stream.of("1", "2", "3").count();
//
////        IntStream.rangeClosed(0,20).forEach(num -> System.out.println(Stream.of("1", "22", "333").findAny()));
////        System.out.println(
////                IntStream.of(1, 2, 3).reduce(0, (pre, post) -> pre * post + 1)
////        );
////        IntStream.of(1, 22, 333).reduce(0, (pre, post) -> pre * post - 1);
//
//        Arrays.asList("1", "2", "3", "4", "5").parallelStream()
//                .unordered()
//                .limit(2).forEach(System.out::print);
//
////
////        Stream.concat(
////                Stream.of("1", 22, "333"),
////                Stream.of("1", 22, 333)
////        ).forEach(System.out::print);
////
////        Stream.of("1", "2", "3").iterator();
////
////        Spliterator<String> spliterator = Stream.of("1", "2", "3").spliterator();
//        Stream.of("1", "2", "3").parallel();
////        Arrays.asList("1", "2", "3", "4", "5").parallelStream().unordered().limit(2);

        //        Stream.of("1", "2", "3").collect(Collectors.summingInt(Integer::valueOf));
//
//        Stream.of("1", "2", "3").collect(Collectors.joining());
//
//        Stream.of("1", "2", "3").mapToInt(Integer::valueOf).sum();
//        Stream.of("1", "2", "3").mapToInt(Integer::valueOf).average();
//        Stream.of("1", "2", "3").mapToInt(Integer::valueOf).c();
//
        System.out.println(
//                Stream.of("1", "22", "33", "4", "555")
//                        .collect(Collectors.toCollection(ArrayList::new))
        );

//        Stream.of("1", "22", "33", "4", "555")
//                .collect(Collectors.reducing(0, Integer::valueOf, Integer::sum));
//
//        Integer collect = Stream.of("1", "22", "33", "4", "555")
//                .collect(Collectors.collectingAndThen(Collectors.toList(), List::size));

//        List<String> collect = Stream.of("1", "22", "33", "4", "555").collect(myToList);
//        System.out.println(collect);
        Function<String, String> function = s1 -> s1 = StringUtils.isEmpty(s1) ? null : s1;
        Optional<String> s = Optional.ofNullable("").map(function);
        System.out.println();
    }


}


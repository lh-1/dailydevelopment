package com.mjy.daily.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JAVA8Test {

    @Test
    public void test() throws Exception {

        List<String> languages = Arrays.asList("java", "scala", "python");
        //before java8
        for (String each : languages) {
            System.out.println(each);
        }
        //after java8
        languages.forEach(x -> System.out.println(x));
        languages.forEach(System.out::println);
    }

    @Test
    public void test2() throws Exception {
        List<Double> cost = Arrays.asList(10.0, 21.0, 30.0, 39.9, 50.0);
        System.err.println("=== 1 ===" + JSONObject.toJSONString(cost));
        cost.stream().map(x -> x + x * 0.05).forEach(x -> System.out.println(x));
//        cost.stream().map(x -> x * 1.1).forEach(x -> x = x * 1.1);
        System.err.println("=== 3 ===" + JSONObject.toJSONString(cost));

        double allCost = cost.stream().map(x -> x + x * 0.05).reduce((sum, x) -> sum + x).get();
        System.err.println("=== 4 ===" + allCost);
        System.err.println("=== 5 ===" + JSONObject.toJSONString(cost));

        List<Double> filteredCost = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredCost.forEach(x -> System.out.println(x));
        System.err.println("=== 6 ===" + JSONObject.toJSONString(cost));
    }

    @Test
    public void mapTest() {
        List<User> list = new ArrayList<>();
        initUser(list);
        System.err.println("== 1 ==" + JSONObject.toJSONString(list));

        Map<String, User> map = new HashMap<>();
        list.stream().forEach(user -> map.put(user.getName(), user));
        System.err.println("== 2 ==" + JSONObject.toJSONString(map));

    }

    public static void filterTest(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(x + " "));
    }

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "scala", "Shell", "R");
        System.out.println("Language starts with J: ");
        filterTest(languages, x -> x.startsWith("J"));
        System.out.println("\nLanguage ends with a: ");
        filterTest(languages, x -> x.endsWith("a"));
        System.out.println("\nAll languages: ");
        filterTest(languages, x -> true);
        System.out.println("\nNo languages: ");
        filterTest(languages, x -> false);
        System.out.println("\nLanguage length bigger three: ");
        filterTest(languages, x -> x.length() > 4);
    }

    public static void filterUserTest(List<User> languages, Predicate<User> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(JSONObject.toJSONString(x)));
    }

    public static List<User> filterUserListTest(List<User> languages, Predicate<User> condition) {
        return languages.stream().filter(x -> condition.test(x)).collect(Collectors.toList());
    }

    @Test
    public void test3() {
        List<User> list = new ArrayList<>();
        initUser(list);
        filterUserTest(list, x -> (x.getAge() >= 19
                && StringUtils.isNotEmpty(x.getName())
                && x.getName().contains("i")));

        List<User> resultList = new ArrayList<>();
        resultList = filterUserListTest(list, x -> (x.getAge() >= 19
                && StringUtils.isNotEmpty(x.getName())
                && x.getName().contains("i")));

        System.err.println("== 1 ==" + JSONObject.toJSONString(list));
        System.err.println("== 2 ==" + JSONObject.toJSONString(resultList));

    }

    public void initUser(List<User> list) {
        User u1 = new User();
        u1.setId(1L);
        u1.setName("zhao");
        u1.setAge(20);
        u1.setGender(0);

        User u2 = new User();
        u2.setId(2L);
        u2.setName("qian");
        u2.setAge(19);
        u2.setGender(0);

        User u3 = new User();
        u3.setId(3L);
        u3.setName("sun");
        u3.setAge(18);
        u3.setGender(0);
        User u4 = new User();

        u4.setId(4L);
        u4.setName("li");
        u4.setAge(22);
        u4.setGender(1);

        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
    }

    @Test
    public void testBigInt() {
        int i = 0x7fffffff;//
        System.err.println(Integer.MAX_VALUE);
        System.err.println(Integer.MIN_VALUE);
        int aa = 2147483647;
        int ab = -2147483648;
    }

}

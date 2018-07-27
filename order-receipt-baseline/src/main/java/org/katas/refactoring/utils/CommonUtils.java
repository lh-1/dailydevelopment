package org.katas.refactoring.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CommonUtils {

    public static List<Integer> list = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            list.add(new Double(Math.random() * 10).intValue());
        }
    }

    public static double funSum(double d1, double d2) {
        return d1 + d2;
    }

    public static double reduceSum(Double[] doubles){
        return Arrays.asList(doubles).stream().reduce((x, y) -> x + y).get();
    }

    public static void main(String[] args) {
        Stream<Integer> stream = list.stream();
        System.err.println(list.toString());
        int sum = stream.reduce(0, (x, y) -> x + y);

        stream = list.stream();
        int sum2 = stream.reduce((x, y) -> x + y).get();
        System.err.println(sum);
        System.err.println(sum2);
    }

}

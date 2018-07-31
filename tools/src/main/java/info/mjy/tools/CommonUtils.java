package info.mjy.tools;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CommonUtils {

    public static List<Integer> list = new ArrayList<>();

    static {
        for (int i = 0; i < 50; i++) {
            list.add(new Double(Math.random() * 100).intValue());
        }
        /*int[] aa = IntStream.range(10, 3_000).filter(x -> x % 9 == 0).toArray();
        System.err.println(JSONObject.toJSONString(aa));
        int[] i = Arrays.stream(aa).map(x -> x + 1).toArray();
        System.err.println(JSONObject.toJSONString(i));*/

        // 排序
        list = list.stream().sorted().collect(Collectors.toList());
        System.err.println(JSONObject.toJSONString(list));

        // 分布
        for (int i = 0; i < 10; i++) {
            System.err.println(JSONObject.toJSONString(list.stream().skip(i * 5).limit(5).collect(Collectors.toList())));
        }
        System.err.println(JSONObject.toJSONString(list));
    }

    public static double funSum(double d1, double d2) {
        return d1 + d2;
    }

    public static double reduceSum(Double[] doubles) {
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

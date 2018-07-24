package info.mjy.tools;
/**
 * this is a feature at 2018.724
 */

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortUtils {

    public Integer[] integers = {6, 2, 3, 1, 9, 5, 7, 4, 8};


    public Integer[] sort1(Integer[] integers) {

//        integers
        quickSort(0, integers.length - 1);


        return null;
    }

    /**
     * 6 2 3 1 9 5 7 4 8
     *
     * @param firstIndex
     * @param latestIndex
     */
    public void quickSort(int firstIndex, int latestIndex) {

        if (firstIndex > latestIndex) {
            return;
        }
        int temp = integers[firstIndex];
        int i = firstIndex;
        int j = latestIndex;

        while (i != j) {
            while (integers[j] >= temp && j > i) {
                j--;
            }
            while (integers[i] <= temp && i < j) {
                i++;
            }
            int t = integers[i];
            integers[i] = integers[j];
            integers[j] = t;
        }
        integers[firstIndex] = integers[i];
        integers[i] = temp;

        quickSort(firstIndex, i - 1);
        quickSort(i + 1, latestIndex);

    }

    public static void main(String[] args) {
        SortUtils sortUtils = new SortUtils();

        Integer[] ints = new Integer[5000];
        for (int i = 0; i < 5000; i++) {
            ints[i] = Double.valueOf(Math.random() * 5000).intValue();
        }
//        sortUtils.integers = ints;
//        sortUtils.quickSort(0, ints.length - 1);
//        System.err.println(JSONObject.toJSONString(ints));

        int len = 500;
        int tlen = len >>> 1;

        List list = Lists.newArrayList(ints);
        Collections.sort(list);
        Arrays.sort(ints);
        System.err.println(JSONObject.toJSONString(ints));
    }

}

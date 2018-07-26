package com.mjy.daily.demo.factory;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface FoodFactory {

    Food create(String foodName);

    static FoodFactory factory(Consumer<Builder> consumer) {
        Map<String, Supplier<Food>> map = Maps.newHashMap();
        consumer.accept(map::put);
        return foodName -> map.get(foodName).get();
    }

    static int test(int a, int b) {
        return a * b;
    }

}

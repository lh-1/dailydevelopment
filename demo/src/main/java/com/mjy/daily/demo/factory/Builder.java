package com.mjy.daily.demo.factory;

import java.util.function.Supplier;

public interface Builder {

    void doo(String foodName, Supplier<Food> supplier);

}

package com.mjy.daily.demo.factory;

public class APP {

    public static void main(String[] args) {
        FoodFactory foodFactory = FoodFactory.factory(builder -> {
            builder.doo("康师傅", Water::new);
            builder.doo("红烧", Noodles::new);
        });

        System.err.println(foodFactory.create("康师傅"));
        System.err.println(foodFactory.create("红烧"));
    }

}

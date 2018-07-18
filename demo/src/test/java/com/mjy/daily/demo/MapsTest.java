package com.mjy.daily.demo;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapsTest {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Person p1 = new Person("001", "zhang_san");
        Person p2 = new Person("002", "li_si");
        Person p3 = new Person("003", "wang_wu");

        List<Person> personList = Lists.newArrayList(p1, p2, p3);

        // 将主键当作Map的Key
        Map<String, Person> personMap0 = Maps.uniqueIndex(personList.iterator(), new Function<Person, String>() {
            @Override
            public String apply(Person input) {
                return input.getId();
            }
        });
        Map<String, Person> personMap1 = Maps.uniqueIndex(personList.iterator(), Person::getId);
        Map<String, Person> personMap2 = Maps.uniqueIndex(personList.iterator(), person -> person.getId());
        System.out.println("将主键当作Map的Key:" + personMap1);


        // 可以说是Maps.uniqueIndex相反的作用
        Set<Person> personSet = Sets.newHashSet(p1, p2, p3);
        @SuppressWarnings("unused")
        Map<Person, String> personAsMap = Maps.asMap(personSet, new Function() {
            @Override
            public Object apply(Object input) {
                return ((Person) input).getId();
            }
        });
        System.out.println(personAsMap);


        // 转换Map中的value值
        Map<String, Integer> transformValuesMap = Maps.transformValues(personMap1, new Function<Person, Integer>() {
            @Override
            public Integer apply(Person input) {
                return Integer.valueOf(1);
            }
        });
        System.out.println("转换Map中的value值" + transformValuesMap);

    }
}


class Person {
    private String Id;
    private String name;

    public Person(String Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
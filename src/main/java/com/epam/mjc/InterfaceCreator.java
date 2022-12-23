package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class InterfaceCreator {


    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strs -> strs.stream()
                           .allMatch(s -> s.length() > 0 &&
                                   Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evens = new ArrayList<>();
            for (Integer i : list)
                if (i % 2 ==0)
                    evens.add(i);
            list.addAll(evens);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        Predicate<String> startsWithUpperCase = s -> s.length() > 0 && Character.isUpperCase(s.charAt(0));
        Predicate<String> endsWith = s -> s.endsWith(".");
        Predicate<String> containMoreThan3Words = s -> s.length() > 3;


        return () -> values.stream()
                            .filter(startsWithUpperCase
                                .and(endsWith)
                                .and(containMoreThan3Words)).collect(Collectors.toList());
        }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return result -> result.stream()
                .collect(Collectors.toMap(m -> m, String::length));

    }

    public BiFunction<List<Integer>, List<   Integer>, List<Integer>> concatList() {
        return (x1, x2) -> Stream.concat(x1.stream(), x2.stream()).collect(Collectors.toList());
    }
}

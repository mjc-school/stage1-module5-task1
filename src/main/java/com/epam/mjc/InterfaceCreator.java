package com.epam.mjc;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> x.stream().allMatch(word -> Character.isUpperCase(word.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> x.addAll(x.stream().filter(value -> value % 2 == 0).toList());
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(word -> Character.isUpperCase(word.charAt(0)) && word.endsWith(".") && word.length() < 3)
                .toList();
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> x.stream().collect(Collectors.toMap(Function.identity(), String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
}

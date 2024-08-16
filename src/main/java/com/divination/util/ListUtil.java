package com.divination.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListUtil {
    public ListUtil() {
    }

    public static boolean isEmpty(List list) {
        return !isNotEmpty(list);
    }

    public static boolean isNotEmpty(List list) {
        return list != null && list.size() > 0;
    }

    public static <R> List<R> splitStr(String str, String splitPattern, Function<String, R> mapper) {
        String[] strings = str.split(splitPattern);
        Stream<String> stream = Arrays.stream(strings);
        return (List)stream.map(mapper).collect(Collectors.toList());
    }

    public static <A, R> List<R> transformationByListToList(List<A> list, Function<A, R> mapper) {
        return (List)list.stream().map(mapper).collect(Collectors.toList());
    }

    public static <A, R> List<R> transformationByListToListDistinct(List<A> list, Function<A, R> mapper) {
        return (List)list.stream().map(mapper).distinct().collect(Collectors.toList());
    }

    public static <R, A> Map<R, A> transformationByListToMapObject(List<A> list, Function<A, R> mapper) {
        return (Map)list.stream().collect(Collectors.toMap(mapper, (a) -> {
            return a;
        }));
    }

    public static <R, A> Map<R, List<A>> transformationByListToMapList(List<A> list, Function<A, R> mapper) {
        return (Map)list.stream().collect(Collectors.groupingBy(mapper));
    }

    /**
     * 拆分List
     * @param sourceList
     * @param size
     * @return
     * @param <T>
     */
    public static <T> List<List<T>> splitList(List<T> sourceList, int size) {
        List<List<T>> partitions = new ArrayList<>();
        if (sourceList == null || sourceList.isEmpty() || size <= 0) {
            return partitions; // 如果源列表为空或size无效，则返回空列表
        }

        for (int i = 0; i < sourceList.size(); i += size) {
            partitions.add(new ArrayList<>(
                    sourceList.subList(i, Math.min(i + size, sourceList.size()))
            ));
        }
        return partitions;
    }
}
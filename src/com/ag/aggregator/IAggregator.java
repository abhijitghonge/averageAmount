package com.ag.aggregator;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface IAggregator<K,V, T> {

    Map<K,V> compute(List<T> data);

}

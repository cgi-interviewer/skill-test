package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public final class CounterEntry<K extends Comparable<K>> implements Comparable<CounterEntry<K>> {

    private final K key;
    private final int count;

    public <V> CounterEntry(Map.Entry<K, List<V>> entry) {
        this.key = entry.getKey();
        this.count = entry.getValue().size();
    }

    public K getKey() {
        return key;
    }

    public int getCount() {
        return count;
    }

    public static void print(CounterEntry<?> counterEntry) {
        System.out.println(counterEntry.getKey() + ": " + counterEntry.getCount());
    }

    @Override
    public int compareTo(CounterEntry<K> other) {
        if (other.getCount() == this.getCount()) {
            return other.getKey().compareTo(this.getKey());
        } else {
            return other.getCount() < this.getCount() ? 1 : -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof CounterEntry) {
            return ((CounterEntry<?>) o).getKey().equals(getKey())
                && ((CounterEntry<?>) o).getCount() == getCount();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return key.hashCode() + count;
    }
}

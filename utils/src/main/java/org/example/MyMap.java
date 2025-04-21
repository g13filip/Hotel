package org.example;

import java.util.ArrayList;
import java.util.List;

public  class MyMap<K,V> implements Map<K,V>{
    private final List<K> keys;
    private final List<V> values;


    public MyMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }
    @Override
    public boolean put(K key, V value)
    {
        if(key == null || value == null)
            return false;

        int Index = keys.indexOf(key);
        if( Index == -1) {
            keys.add(key);
            values.add(value);
        }
        else
            values.set(Index, value);

        return true;
    }

    @Override
    public boolean remove(K key){
        int Index = keys.indexOf(key);

        if(Index == -1)
            return false;

        keys.remove(Index);
        values.remove(Index);

        return true;
    }

    @Override
    public V get(K key) {
        int Index = keys.indexOf(key);

        if(Index == -1)
            return null;

        return values.get(Index);
    }

    @Override
    public List<K> keys() {
        return keys;
    }

    @Override
    public boolean contains(K key) {
        return keys.contains(key);
    }
}

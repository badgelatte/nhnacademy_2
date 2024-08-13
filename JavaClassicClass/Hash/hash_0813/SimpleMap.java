package hash_0813;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

public class SimpleMap<K, V> extends AbstractMap<K, V> {
    Set<Entry<K, V>> entries = new HashSet<>();

    class SimpleEntry<I, E> implements Entry<I, E> {
        I key;
        E value;
        int hashCode;
        public SimpleEntry(I key, E value) {
            this.key = key;
            this.value = value;

            this.hashCode = key.hashCode();
        }

        @Override
        public I getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return value;
        }

        @Override
        public E setValue(E arg0) {
            E oldValue = value;
            value = arg0;
            return oldValue;
        }
        
        @Override
        public int hashCode(){
            return hashCode;
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof SimpleEntry) && (key.equals((SimpleEntry)o));
            // return (o instanceof SimpleEntry) && (key.hashCode() == o.hashCode());
        }
    }

    @Override
    public Set entrySet() {
        return entries;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        for(Entry<K, V> entry: entries) {
            if(entry.getKey().equals(key)) {
                oldValue = entry.getValue();
                entry.setValue(value);
                // break;
                return oldValue;
            }
        }
        entries.add(new SimpleEntry<>(key, value));
        // return oldValue;
        return null;
    }


    public static void main1(String[] args) {
        SimpleMap<String, String> map = new SimpleMap<>();
        String one = "one";

        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put(one, "4");

        Set<Entry<String, String>> entrySet = map.entrySet();
        for (Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " : " + entry.hashCode());
        }

        System.out.println("get(one) : " + map.get("one"));
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Tag", "day");
        map.put("Hut", "hat");
        map.put("Uhr", "clock");
        map.put("Rad", "wheel");
        map.put("Ohr", "ear");
        map.put("Tor", "gate");
        System.out.println("map=" + map);
        System.out.println("map.size()=" + map.size());
        System.out.println("map.keySet()=" + map.keySet());
        System.out.println("map.values()=" + map.values());
        System.out.println("map.get(\"Uhr\")=" + map.get("Uhr"));
        System.out.println("map.remove(\"Rad\")=" + map.remove("Rad"));
        System.out.println("map.get(\"Rad\")=" + map.get("Rad"));
        System.out.println("map=" + map);
        System.out.println("map.size()=" + map.size());

    }
}

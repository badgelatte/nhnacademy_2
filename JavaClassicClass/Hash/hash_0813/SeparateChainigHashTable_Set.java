package hash_0813;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SeparateChainigHashTable_Set {
    class Entry {
        String key;
        String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + "," + value + ")";
        }
    }

    class Bucket {
        static final int DEFAULT_CAPACITY = 10;
        Entry[] entries;
        int count;

        public Bucket() {
            this(DEFAULT_CAPACITY);
        }

        public Bucket(int capacity) {
            entries = new Entry[capacity];
            count = 0;
        }

        public Entry put(String key, String value) {
            for (int i = 0; i < count; i++) {
                if (entries[i].getKey().equals(key)) {
                    entries[i].setValue(value);
                    return null;
                }
            }

            if (entries.length == count) {
                entries = Arrays.copyOf(entries, entries.length + DEFAULT_CAPACITY);
            }

            Entry newEntry = new Entry(key, value);
            entries[count++] = newEntry;

            return newEntry;
        }

        public String get(String key) {
            for (int i = 0; i < count; i++) {
                if (entries[i].getKey().equals(key)) {
                    return entries[i].getValue();
                }
            }

            return null;
        }

        public Set<Entry> getEntries() {
            Set<Entry> entrySet = new HashSet<>();

            for (int i = 0; i < count; i++) {
                entrySet.add(entries[i]);
            }

            return entrySet;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append("{");
            if (count > 0) {
                sb.append(entries[0].getKey())
                        .append("=")
                        .append(entries[0].getValue());
            }
            for (int i = 1; i < count; i++) {
                sb.append(", ")
                        .append(entries[i].getKey())
                        .append("=")
                        .append(entries[i].getValue());
            }
            sb.append("}");
            return sb.toString();
        }
    }

    static final int DEFAULT_CAPACITY = 11;
    Set<Entry> entrySet;
    Bucket[] buckets;

    public SeparateChainigHashTable_Set() {
        this(DEFAULT_CAPACITY);
    }

    public SeparateChainigHashTable_Set(int capacity) {
        entrySet = new HashSet<>();
        buckets = new Bucket[capacity];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
    }

    public void put(String key, String value) {
        Entry newEntry = getBucket(key).put(key, value);
        if (newEntry != null) {
            entrySet.add(newEntry);
        }
    }

    public String get(String key) {
        return getBucket(key).get(key);
    }

    public Set<Entry> getEntries() {
        return entrySet;
    }

    Bucket getBucket(String key) {
        return buckets[getIndex(key)];
    }

    public int getIndex(String key) {
        return key.hashCode() % buckets.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(buckets[0].toString());
        for (int i = 1; i < buckets.length; i++) {
            sb.append(", ").append(buckets[i].toString());
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        SeparateChainigHashTable_Set table = new SeparateChainigHashTable_Set();

        table.put("one", "1");
        table.put("two", "2");
        table.put("three", "3");
        table.put("Tag", "day");
        table.put("Hut", "hat");
        table.put("Uhr", "clock");
        table.put("Rad", "wheel");
        table.put("Ohr", "ear");
        table.put("Tor", "gate");

        System.out.println(table);

        System.out.println(table.getEntries());
    }


}

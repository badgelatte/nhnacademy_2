package hash_0813;

import java.util.Arrays;

public class SeparateChainigHashTable_Bucket {
    class Entry{
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
            return "("+key +", " + value +")";
        }
        
    }
    class Bucket{
        static final int DEFAULT_CAPACITY = 10;
        Entry[] entries;
        int count;

        public Bucket(){
            this(DEFAULT_CAPACITY);
        }

        public Bucket(int capacity){
            entries = new Entry[capacity];
            count = 0;
        }

        public void put(String key, String value) {
            for (int i = 0; i < count; i++) {
                if(entries[i].getKey().equals(key)) {
                    entries[i].setValue(value);
                    return;
                }
            }
            if(entries.length == count) {
                entries = Arrays.copyOf(entries, entries.length + DEFAULT_CAPACITY);
            }

            entries[count++] = new Entry(key, value);

        }

        public String get(String key) {
            for (int i = 0; i < buckets.length; i++) {
                if(entries[i].getKey().equals(key)) {
                    return entries[i].getValue();
                }
            }
            return null;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            if(count > 0 ) {
                sb.append(entries[0].getKey()).append("=").append(entries[0].getValue());
            }
            for (int i = 1; i < count; i++) {
                sb.append(entries[i].getKey()).append("=").append(entries[i].getValue());
            }
            sb.append("}");
            return sb.toString();
        }

    }

    static final int DEFAULT_CAPACITY = 11; // 대체로 소수로 한다 그래야 안 겹치니까
    Bucket[] buckets;

    public SeparateChainigHashTable_Bucket() {
        this(DEFAULT_CAPACITY);
    }

    public SeparateChainigHashTable_Bucket(int capacity) {
        buckets = new Bucket[capacity];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
    }

    public void put(String key, String value) {
        getBucket(key).put(key, value);
    }

    public String get(String key) {
        return getBucket(key).get(key);
    }

    public Bucket getBucket(String key) {
        return buckets[getIndex(key)];
    }

    public int getIndex(String key) {
        return key.hashCode() % buckets.length;
    }

    @Override
    public String toString(){
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
        SeparateChainigHashTable_Bucket table = new SeparateChainigHashTable_Bucket();

        table.put("one", "one");
        table.put("two", "two");
        table.put("three", "three");

        System.out.println(table.toString());
    }
}


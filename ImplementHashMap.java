
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ImplementHashMap<K, V> {

    private final int size;
    private List<LinkedList<Entry<K, V>>> bucketList;

    public ImplementHashMap(int MAX_SIZE) {
        this.bucketList = new ArrayList<>();
        this.size = MAX_SIZE;

        for (int i = 0; i < size; i++) {
            LinkedList<Entry<K, V>> ll = new LinkedList<>();
            bucketList.add(ll);
        }
    }

    public static void main(String[] args) {
        ImplementHashMap<String, Integer> map = new ImplementHashMap<>(10);
        map.put("A", 1);
        System.out.println("A: " + map.get("A"));
        map.put("B", 2);
        map.put("A", 2);
        System.out.println("New A: " + map.get("A"));

        System.out.println(map.remove("A"));
        System.out.println(map.containsKey("A"));

        System.out.println(map.containsKey("B"));
        System.out.println("B : " + map.get("B"));

        System.out.println(map.remove("10"));
        System.out.println(map.remove(null));

    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int hash = hash(key);
        LinkedList<ImplementHashMap.Entry<K, V>> linkedList = bucketList.get(hash);
        ImplementHashMap.Entry<K, V> newEntry = new Entry<>(key, value);
        if (linkedList.size() == 0) {
            linkedList = bucketList.get(hash);
            linkedList.add(newEntry);
        } else {
            for (ImplementHashMap.Entry<K, V> entry : linkedList) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
            }
        }

    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        int hash = hash(key);
        LinkedList<ImplementHashMap.Entry<K, V>> linkedList = bucketList.get(hash);
        if (linkedList.size() == 0) {
            return null;
        } else {
            for (ImplementHashMap.Entry<K, V> entry : linkedList) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }


        }
        return null;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }
        int hash = hash(key);
        LinkedList<ImplementHashMap.Entry<K, V>> linkedList = bucketList.get(hash);
        if (linkedList.size() == 0) {
            return false;
        } else {
            for (ImplementHashMap.Entry<K, V> entry : linkedList) {
                if (entry.getKey().equals(key)) {
                    return true;

                }
            }

        }
        return false;
    }

    public V remove(K key) {
        if (key == null) {
            return null;
        }
        int hash = hash(key);
        LinkedList<ImplementHashMap.Entry<K, V>> linkedList = bucketList.get(hash);
        ImplementHashMap.Entry<K, V> removeEntry = null;
        if (linkedList.size() == 0) {
            return null;
        } else {
            for (ImplementHashMap.Entry<K, V> entry : linkedList) {
                if (entry.getKey().equals(key)) {
                    removeEntry = entry;
                }
            }
            if (removeEntry != null) {
                linkedList.remove(removeEntry);
                return removeEntry.getValue();
            }
        }
        return null;
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }


        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
/*
OUTPUT
2
false
true
B : 2
null
null

 */

package HashMapLLD;

public class MyHashMap<K, V> {
    private static final int INITIAL_SIZE = 1 << 4;
    private static final int MAX_CAP = 1 << 30;
    
    Entry[] hashTable;

    MyHashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }

    MyHashMap(int size) {
        int tableSize = calculateSize(size);
        hashTable = new Entry[tableSize];
    }

    final int calculateSize(int size) {
        int n = size - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAX_CAP) ? MAX_CAP : n + 1;
    }


    class Entry<K, V>{
        public K key;
        public V value;
        public Entry next;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // getters and setters
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

    public void put(K key, V value){
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if(node == null){
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        } else {
            Entry previousNode = node;
            while(node != null){
                if(node.key == key){
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            previousNode.next = newNode;
        }
    }
    public V get(K key){
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while(node != null){
            if(node.key.equals(key)){
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>(10);
        map.put(1, "hello");
        map.put(2, "welcome");
        map.put(3, "to");
        map.put(4, "my");
        map.put(5, "github");
        map.put(6, "you");
        map.put(7, "can ");
        map.put(8, "find");
        map.put(9, "LLD");
        map.put(10, "code");
        map.put(11, "here");

        String value = map.get(8);
        System.out.println(value);

    }
}

package searching;

import java.util.TreeMap;

public class HashTable<Key, Value> {

    private int tableSize;
    private int keyValuePairsNumber;
    private TreeMap<Key, Value> chains[];

    public HashTable(int tableSize) {
        this.tableSize = tableSize;

        chains = (TreeMap<Key, Value>[]) new TreeMap[tableSize];
        for (int i = 0; i < tableSize; i++)
            chains[i] = new TreeMap<>();
    }

    protected int hash(Key key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (tableSize - 1);
    }

    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            return;
        }
        if (keyValuePairsNumber >= 10 * tableSize) resize(2 * tableSize);

        int i = hash(key);
        if (!chains[i].containsKey(key)) keyValuePairsNumber++;
        chains[i].put(key, value);
    }

    public Value get(Key key) {
        int i = hash(key);
        return chains[i].get(key);
    }

    public void delete(Key key) {
        int i = hash(key);
        if (chains[i].containsKey(key)) keyValuePairsNumber--;
        chains[i].remove(key);

        if (keyValuePairsNumber <= 2 * tableSize) resize(tableSize / 2);
    }

    private void resize(int newSize) {
        HashTable<Key, Value> temp = new HashTable<>(newSize);
        for (int i = 0; i < tableSize; i++) {
            for (Key key : chains[i].navigableKeySet()) {
                temp.put(key, chains[i].get(key));
            }
        }
        this.tableSize = temp.tableSize;
        this.keyValuePairsNumber = temp.keyValuePairsNumber;
        this.chains = temp.chains;
    }

}

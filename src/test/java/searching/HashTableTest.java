package searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void shouldHashKey() {
        HashTable<String, Integer> hashTable = new HashTable<>(7);
        int christianCode = hashTable.hash("Christian");
        assertEquals(0, christianCode);

        int davidCode = hashTable.hash("David");
        assertEquals(2, davidCode);

        int aliceCode = hashTable.hash("Alice");
        assertEquals(4, aliceCode);

        int tomCode = hashTable.hash("Tom");
        assertEquals(6, tomCode);

        int robCode = hashTable.hash("Rob");
        assertEquals(0, robCode);

    }

    @Test
    void insertedValueShouldBePresent() {
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.put("Alice", 123654);

        assertEquals(123654, hashTable.get("Alice"));
    }

    @Test
    void removedValueShouldBeAbsent() {
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.put("Alice", 123654);
        hashTable.put("David", 456123);

        hashTable.delete("Alice");
        assertNull(hashTable.get("Alice"));
    }

}
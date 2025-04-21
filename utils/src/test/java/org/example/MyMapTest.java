package org.example;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("MyMapTests")
@DisplayName("MyMap Test Suite")
class MyMapTest {
    private MyMap<String,String> map = new MyMap<>();

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    public void setUp() {
        map = new MyMap<>();
    }

    @Test
    void put_1() { assertTrue(map.put("key1","value1"));
        assertEquals("value1", map.get("key1"));
    }
    @Test
    void put_2() {
        assertFalse(map.put(null,"value2"));
        assertFalse(map.put("key2",null));
    }
    @Test
    void put_3() {
        map.put("key1", "value1");
        assertTrue(map.put("key1", "newValue1"));
        assertEquals("newValue1", map.get("key1"));
    }

    @Test
    void testGetNonExistingKey() {
        assertNull(map.get("nonExistingKey"));
    }

    @Test
    void testRemoveExistingKey() {
        map.put("key1", "value1");
        assertTrue(map.remove("key1"));
        assertNull(map.get("key1"));
    }

    @Test
    void remove() {
        assertFalse(map.remove("nonExistingKey"));
    }

    @Test
    void get() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        List<String> keys = map.keys();
        assertTrue(keys.contains("key1"));
        assertTrue(keys.contains("key2"));
    }

    @Test
    void contains() {
            map.put("key1", "value1");
            assertTrue(map.contains("key1"));
            assertFalse(map.contains("nonExistingKey"));
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }
}

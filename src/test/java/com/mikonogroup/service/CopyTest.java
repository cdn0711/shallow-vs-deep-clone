package com.mikonogroup.service;

import com.mikonogroup.model.Address;
import com.mikonogroup.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CopyTest {

    @Test
    void testDeepCopy() {
        Person original = create();
        Person copy = CopyService.deepCopy(original);
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getAge(), copy.getAge());

        // Test before manipulation
        assertEquals(original.getAddress().getStreet(), copy.getAddress().getStreet());

        original.getAddress().setStreet("Risky Avenue");

        // Test after manipulation
        assertNotEquals(original.getAddress().getStreet(), copy.getAddress().getStreet());
        assertEquals("Risky Avenue", original.getAddress().getStreet());
        assertEquals("Long Highway", copy.getAddress().getStreet());
    }

    @Test
    void testShallowCopy() {
        Person original = create();
        Person copy = CopyService.shallowCopy(original);
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getAge(), copy.getAge());

        // Test before manipulation
        assertEquals(original.getAddress().getStreet(), copy.getAddress().getStreet());

        original.getAddress().setStreet("Risky Avenue");

        // Test after manipulation
        assertEquals(original.getAddress().getStreet(), copy.getAddress().getStreet());
    }

    private static Person create() {
        return Person.builder()
                .name("Test Steve")
                .age("64")
                .address(Address.builder()
                        .street("Long Highway")
                        .streetNo("994")
                        .city("Anywhere town")
                        .country("USA")
                        .build())
                .build();
    }
}

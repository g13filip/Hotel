package org.example;

import org.example.hotel.Room;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    void testIsBusy() {
        Room room = new Room(101, 200, 2, "Deluxe Room", "2024-10-15", "John, Jane");
        assertTrue(room.isBusy());

        room.checkout();
        assertFalse(room.isBusy());
    }

    @Test
    void testDescribe() {
        Room room = new Room(101, 150, 2, "Standard Room", "2024-10-12", "Alice, Bob");
        assertDoesNotThrow(room::describe);
    }

    @Test
    void testCheckIn() {
        Room room = new Room(102, 100, 3, "Family Room", "", "");
        assertFalse(room.isBusy());

        LocalDate checkInDate = LocalDate.of(2024, 10, 15);
        LocalDate checkOutDate = LocalDate.of(2024, 10, 20);
        room.checkIn(checkInDate, checkOutDate, List.of("Alice", "Bob"));

        assertTrue(room.isBusy());
        assertEquals(checkInDate, room.getCheckInDate());
        assertEquals(checkOutDate, room.getCheckOutDate());
        assertEquals(2, room.getGuests().size());
    }

    @Test
    void testCheckout() {
        Room room = new Room(103, 80, 1, "Single Room", "2024-10-10", "Charlie");
        float expectedCost = 80.0f * ChronoUnit.DAYS.between(LocalDate.of(2024,10,10),LocalDate.now());
        assertEquals(expectedCost, room.checkout());

        assertNull(room.getCheckInDate());
        assertNull(room.getCheckOutDate());
        assertFalse(room.isBusy());
    }

    @Test
    void testGuestInfo() {
        Room room = new Room(104, 120, 2, "Double Room", "2024-10-15", "Eve, Adam");
        String guestInfo = room.guestInfo();
        assertTrue(guestInfo.contains("Eve"));
        assertTrue(guestInfo.contains("Adam"));
        assertTrue(guestInfo.contains("Check-in date: 2024-10-15"));
    }

    @Test
    void testToPrintFreeRoom() {
        Room room = new Room(105, 90, 2, "Economy Room", "", "");
        List<String> printData = room.toPrint();

        assertEquals("105", printData.get(0));
        assertEquals("90", printData.get(1));
        assertEquals("2", printData.get(2));
        assertEquals("Economy Room", printData.get(3));
        assertEquals("", printData.get(4));
        assertEquals("", printData.get(5));
    }
    @Test
    void testToPrintBusyRoom() {
        Room room = new Room(106, 150, 3, "Deluxe Room", "2024-10-12", "Alice, Bob, Charlie");
        List<String> printData = room.toPrint();

        assertEquals("106", printData.get(0));
        assertEquals("150", printData.get(1));
        assertEquals("3", printData.get(2));
        assertEquals("Deluxe Room", printData.get(3));
        assertTrue(printData.get(5).contains("Alice"));
        assertEquals("2024-10-12", printData.get(4));
    }

}
package org.example;

import org.example.hotel.HotelManagement;

public class Main {
    public static void main(String[] args) {
        HotelManagement hotelManagement = new HotelManagement();
        hotelManagement.commandLoop();
    }
}
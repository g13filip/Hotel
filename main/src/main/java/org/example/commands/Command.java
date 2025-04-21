package org.example.commands;

import org.example.hotel.HotelManagement;

public interface Command {

    void execute(HotelManagement hotel);

    String getName();
}

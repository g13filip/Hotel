package org.example.commands;

import org.example.hotel.HotelManagement;
import org.example.MyMap;
import org.example.hotel.Room;

public class ListCommand implements Command {

    public void execute(HotelManagement hotel) {
        MyMap<Integer, Room> rooms = hotel.getRooms();
        for (Integer key : rooms.keys()) {
            if(rooms.get(key).isBusy())
                System.out.println(rooms.get(key).guestInfo());
            else
                System.out.println(key + " Free room");
        }
    }

    public String getName(){
        return "list";
    }
}

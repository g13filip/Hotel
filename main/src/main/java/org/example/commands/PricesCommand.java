package org.example.commands;

import org.example.hotel.HotelManagement;

public class PricesCommand implements Command{

    public void execute(HotelManagement hotel) {
        for(Integer key :hotel.getRooms().keys()){
            System.out.println(hotel.getRooms().get(key));
        }
    }

    public String getName(){
        return "prices";
    }
}

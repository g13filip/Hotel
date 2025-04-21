package org.example.commands;

import org.example.hotel.HotelManagement;

import java.util.Scanner;

public class ViewCommand implements Command {

    public void execute(HotelManagement hotel) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter room number");
        int roomNumber = sc.nextInt();

        if (hotel.getRooms().get(roomNumber) == null) {
            System.out.println("There is no such room");
        } else {
            hotel.getRooms().get(roomNumber).describe();
        }
    }

    public String getName(){
        return "view";
    }
}

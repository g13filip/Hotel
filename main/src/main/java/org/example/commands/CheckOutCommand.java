package org.example.commands;

import org.example.hotel.HotelManagement;
import org.example.MyMap;
import org.example.hotel.Room;

import java.util.Scanner;

public class CheckOutCommand implements Command{

    public void execute(HotelManagement hotel) {
        Scanner sc = new Scanner(System.in);
        MyMap<Integer, Room> rooms = hotel.getRooms();

        while(true){
            System.out.println("Enter room number");
            int roomNumber = sc.nextInt();
            if (rooms.get(roomNumber) == null) {
                System.out.println("There is no such room");
            } else {
                if(!rooms.get(roomNumber).isBusy())
                    System.out.println("That room is free");
                else{
                    float cost = rooms.get(roomNumber).checkout();
                    System.out.println("You have to pay " + cost);

                    break;}
                    }
}}
    public String getName(){
        return "checkout";
    }
}

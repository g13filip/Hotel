package org.example.commands;

import org.example.hotel.HotelManagement;
import org.example.MyMap;
import org.example.hotel.Room;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckinCommand implements Command {

    public void execute(HotelManagement hotel) {
        Scanner sc = new Scanner(System.in);
        MyMap<Integer, Room> rooms = hotel.getRooms();
        int roomNumber;

        while(true){
        System.out.println("Enter room number");
        roomNumber = sc.nextInt();
        sc.nextLine();
        if (rooms.get(roomNumber) == null) {
            System.out.println("There is no such room");
        }
        else {
            if(rooms.get(roomNumber).isBusy())
                System.out.println("Room is busy");
            else
                break;}}

        System.out.println("Checking in...");
        ArrayList<String> guests = new ArrayList<>();

        for(int i = 0; i < rooms.get(roomNumber).getCapacity(); i++){
            System.out.println("Enter guest name");
            guests.add(sc.nextLine());
        }

        System.out.println("Enter check-in date (yyyy-MM-dd)");

        LocalDate checkIn;
        String dateInput = sc.nextLine().trim();
        if (dateInput.isEmpty()) {
            checkIn = LocalDate.now();
        }
        else {
            try{
                checkIn = LocalDate.parse(dateInput);
            }
            catch(DateTimeParseException e){
                System.out.println("Invalid date, using default data");
                checkIn = LocalDate.now();
            }
        }
        System.out.println("How many nights do you plan to stay?");
        LocalDate checkOut = checkIn.plusDays(sc.nextInt());
        hotel.getRooms().get(roomNumber).checkIn(checkIn, checkOut, guests);
    }

    public String getName(){
        return "checkin";
    }
}





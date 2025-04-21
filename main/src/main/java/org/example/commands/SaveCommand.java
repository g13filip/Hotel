package org.example.commands;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.example.hotel.HotelManagement;
import org.example.MyMap;
import org.example.hotel.Room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveCommand implements Command{

    public void execute(HotelManagement hotel){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file: ");


        String fileName = sc.nextLine();

        MyMap<Integer, Room> rooms = hotel.getRooms();

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader("room_number","price","capacity","description","guests","checkin")
                .setQuote('"')
                .build();


        try(FileWriter fileWriter = new FileWriter(fileName);
            CSVPrinter printer = new CSVPrinter(fileWriter, csvFormat)){
            for(Integer key: rooms.keys())
            {
                printer.printRecord(rooms.get(key).toPrint());
            }

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public String getName(){
        return "save";
    }
}

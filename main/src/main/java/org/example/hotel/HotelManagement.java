package org.example.hotel;

import org.example.MyMap;
import org.example.commands.*;
import org.reflections.Reflections;

import java.util.Scanner;
import java.util.Set;

public class HotelManagement {
    private final MyMap<Integer, Room> rooms;
    private MyMap<String, Command> commands;

    public HotelManagement() {
        Read czytnik = new Read();

        rooms = czytnik.read("Hotel.txt");

        initializeCommands();

    }


    public MyMap<Integer, Room> getRooms() {
        return rooms;
    }

    private void initializeCommands() {
//        commands = new MyMap<>();
//        commands.put("view", new ViewCommand());
//        commands.put("list", new ListCommand());
//        commands.put("checkin", new CheckinCommand());
//        commands.put("prices", new PricesCommand());
//        commands.put("checkout", new CheckOutCommand());
//        commands.put("save", new SaveCommand());

        commands = new MyMap<>();
        Reflections reflections = new Reflections("org.example.commands");
        Set<Class<? extends Command>> commandClasses = reflections.getSubTypesOf(Command.class);

        for (Class<? extends Command> commandClass : commandClasses) {
            try {
                Command commandInstance = commandClass.getDeclaredConstructor().newInstance();

                String commandName = commandInstance.getName();

                commands.put(commandName, commandInstance);
            } catch (Exception e) {
                System.err.println("Błąd podczas rejestracji komendy: " + commandClass.getName());
            }
        }
    }

    public void commandLoop() {
        Scanner sc = new Scanner(System.in);
        boolean end = false;

        while (!end) {
            System.out.print("Enter command: ");
            String input = sc.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exit");
                end = true;}
            if(commands.contains(input)){
                commands.get(input).execute(this);
            }
            else {
                System.out.println("Invalid command");
            }}}

}


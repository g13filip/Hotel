package org.example.hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {
    private final int number;
    private final int price;
    private final int capacity;
    private final String description;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    ArrayList<String> guests;

    public Room(int number, int price, int capacity, String description, String date, String guests) {
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.description = description;
        if (!date.isEmpty())
            this.checkInDate = LocalDate.parse(date);
        if (!guests.isEmpty())
            this.guests = new ArrayList<>(Arrays.asList(guests.split(",\\s*")));
        else
            this.guests = new ArrayList<>();}

    public String toString(){
        return "Room number: " + number + ", price = " + price + ", capacity = " + capacity;}

    public boolean isBusy(){
        return !guests.isEmpty();}

    public void describe() {
        System.out.println("Room number: " + number + ", price = " + price + ", capacity = " + capacity
        + ",\ndescription = " + description );

        if(checkInDate != null){
            System.out.println("check-in date = " + checkInDate + "\nGuests: ");
            for(String guest : guests){
                System.out.println(guest);
            }}
        else {
            System.out.println("Free room");
        }}

    public int getCapacity() {
        return capacity;}
    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public List<String> getGuests() {
        return guests;
    }

    public void checkIn(LocalDate checkInDate, LocalDate checkOutDate, List<String> guests) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guests = new ArrayList<>(guests);
    }

    public float checkout(){
        float cost = price * ChronoUnit.DAYS.between(checkInDate,LocalDate.now());
        checkInDate = null;
        checkOutDate = null;
        guests.clear();

        return cost;
    }

    public String guestInfo(){
        String checkout;
        if(checkOutDate == null)
            checkout = "No planned check-out date";
        else
            checkout = "Check-out date: " + checkOutDate;
        return this.number + " Guests: " + guests.toString() + " Check-in date: " + checkInDate.toString() + " " + checkout;
    }

    public List<String> toPrint(){
        ArrayList<String> tab = new ArrayList<>();

        tab.add(String.valueOf(number));
        tab.add(String.valueOf(price));
        tab.add(String.valueOf(capacity));
        tab.add(description);

        if(!guests.isEmpty())
        {
            tab.add(checkInDate.toString());
            tab.add(guests.toString());
        }
        else{
            tab.add("");
            tab.add("");
        }

        return tab;

    }
}

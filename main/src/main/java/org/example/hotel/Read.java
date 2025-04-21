package org.example.hotel;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.example.MyMap;

import java.io.FileReader;
import java.io.IOException;


public class Read {

    public MyMap<Integer, Room> read(String file) {
        MyMap<Integer, Room> dane = new MyMap<>();

        try (CSVParser parser = CSVFormat.DEFAULT.builder()
                .setQuote('"')
                .setEscape('"')
                .setHeader()
                .build()
                .parse(new FileReader(file))) {

            for (CSVRecord recor : parser) {
                int number = Integer.parseInt(recor.get(0));
                Room tmp = new Room(number,
                                    Integer.parseInt(recor.get(2)),
                                    Integer.parseInt(recor.get(1)),
                                    recor.get(3),
                                    recor.get(4),
                                    recor.get(5));
                dane.put(number, tmp);
            }
        } catch (IOException e) {
            System.out.println("Coś nie tak z plikem");
        }
        return dane;
    }
}

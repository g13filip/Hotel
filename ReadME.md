# Hotel Management System

Projekt konsolowej aplikacji do uproszczonego zarządzania hotelem. Dane o pokojach są wczytywane z pliku CSV, a obsługa użytkownika odbywa się za pomocą systemu komend. Każda komenda jest implementacją interfejsu `Command`.

## Spis treści

- [Funkcjonalności](#funkcjonalności)
- [Struktura projektu](#struktura-projektu)
- [Format pliku CSV](#format-pliku-csv)
- [Jak uruchomić](#jak-uruchomić)
- [Dostępne komendy](#dostępne-komendy)
- [Rozszerzalność](#rozszerzalność)
- [Wymagane biblioteki](#wymagane-biblioteki)
- [Autor](#autor)

## Funkcjonalności

- Wczytywanie informacji o pokojach z pliku CSV (`Hotel.txt`)
- Przeglądanie i wypisywanie listy pokoi
- Zameldowanie i wymeldowanie gości
- Wyświetlanie informacji o cenach
- Zapisywanie stanu pokoi do pliku
- Obsługa komend w trybie interaktywnym

## Struktura projektu

```
org.example
├── hotel
│   ├── HotelManagement.java         # Główna logika programu
│   ├── Room.java                    # Klasa reprezentująca pokój
│   ├── Read.java                    # Wczytywanie danych z pliku CSV
├── commands                         # Komendy wykonujące konkretne operacje
│   ├── Command.java                 # Interfejs komendy
│   ├── ViewCommand.java
│   ├── ListCommand.java
│   ├── CheckinCommand.java
│   ├── CheckoutCommand.java
│   ├── PricesCommand.java
│   ├── SaveCommand.java
├── MyMap.java                       # Prosta implementacja mapy
```

## Format pliku CSV

Plik `Hotel.txt` powinien mieć strukturę zgodną z poniższym przykładem:

```csv
number,capacity,price,description,checkInDate,guests
101,2,300,"Pokój z widokiem","2025-04-20","Jan Kowalski, Anna Nowak"
102,1,200,"Pokój jednoosobowy",,
```

**Opis kolumn:**

- `number` – numer pokoju
- `capacity` – liczba miejsc
- `price` – cena za noc
- `description` – opis pokoju
- `checkInDate` – data zameldowania (opcjonalna)
- `guests` – lista gości (opcjonalna, oddzielona przecinkami)

## Jak uruchomić

1. Upewnij się, że masz zainstalowaną JDK 17+ i Maven.
2. Umieść plik `Hotel.txt` w katalogu głównym projektu.
3. Zbuduj projekt za pomocą Mavena:

   ```
   mvn compile
   ```

4. Uruchom program:

   ```
   mvn exec:java -Dexec.mainClass="org.example.hotel.HotelManagement"
   ```

## Dostępne komendy

W trybie interaktywnym użytkownik może wpisywać komendy:

- `view` – pokaż szczegóły wybranego pokoju
- `list` – wyświetl listę wszystkich pokoi
- `checkin` – zamelduj gości
- `checkout` – wymelduj gości i pokaż koszt
- `prices` – wypisz ceny pokoi
- `save` – zapisz aktualny stan pokoi do pliku
- `exit` – zakończ program

## Rozszerzalność

System komend został zaprojektowany z użyciem refleksji. Aby dodać nową komendę:

1. Stwórz klasę w pakiecie `org.example.commands`, która implementuje `Command`.
2. Zaimplementuj metody `execute(HotelManagement)` oraz `getName()`.
3. Program automatycznie zarejestruje nową komendę przy starcie – nie trzeba jej ręcznie dodawać do mapy.

## Wymagane biblioteki

Projekt korzysta z następujących bibliotek:

- [Apache Commons CSV](https://commons.apache.org/proper/commons-csv/) – do przetwarzania plików CSV
- [Reflections](https://github.com/ronmamo/reflections) – do automatycznego wyszukiwania klas komend

W pliku `pom.xml` należy dodać:

```xml
<dependencies>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-csv</artifactId>
        <version>1.10.0</version>
    </dependency>
    <dependency>
        <groupId>org.reflections</groupId>
        <artifactId>reflections</artifactId>
        <version>0.10.2</version>
    </dependency>
</dependencies>
```

## Autor

Projekt stworzony jako ćwiczenie z programowania obiektowego w Javie.
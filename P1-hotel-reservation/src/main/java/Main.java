import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(1, 1000);
        Room room2 = new Room(2, 1500);
        Room room3 = new Room(3, 800);
        Room room4 = new Room(4, 1250);

        Room[] rooms = new Room[5];
        rooms[0] = room1;
        rooms[1] = room2;
        rooms[2] = room3;
        rooms[3] = room4;

        Hotel hotel = new Hotel("Hotel São Carlos", rooms);

        Guest guest1 = new Guest("123", "Tiago", "tiago@hotmail.com");
        Guest guest2 = new Guest("321", "Pedro", "pedro@hotmail.com");
        Guest guest3 = new Guest("431", "Ana", "ana@hotmail.com");
        Guest guest4 = new Guest("512", "Maria", "maria@hotmail.com");

        LocalDate day1 = LocalDate.of(2022, 5, 10);
        LocalDate day2 = LocalDate.of(2022, 5, 15);
        LocalDate day3 = LocalDate.of(2022, 3, 15);
        LocalDate day4 = LocalDate.of(2022, 4, 15);
        LocalDate day5 = LocalDate.of(2022, 5, 15);
        LocalDate day6 = LocalDate.of(2022, 6, 20);

        System.out.printf(STR."First day1 to day2: \{String.valueOf(STR."\{hotel.makeReservation(guest2, 1, day1, day2).getId()}\n")}");
        System.out.printf(STR."Second day1 to day2: \{String.valueOf(STR."\{hotel.makeReservation(guest2, 1, day1, day2)}\n")}");
        Reservation day3To4 = hotel.makeReservation(guest2, 3, day3, day4);

        System.out.printf(STR."\nday3 to day4: \{day3To4.asString()}");
        System.out.println("Canceled reservation: " + hotel.cancelReservation(day3To4.getId()).getId());
        System.out.printf(STR."Trying day3 to day4 after cancel: \{hotel.makeReservation(guest2, 3, day3, day4).getId()}\n");

        System.out.println("Trying reserve into checkout of day1 to day2 : " + hotel.makeReservation(guest2, 1, day5, day6).getId());

        System.out.println("Rooms Available now: ");
        int countRoomsAv = 0;
        for (Room room: hotel.getRoomsAvailableAt(LocalDate.now())) {
            if (room == null) break;
            System.out.println(room.asString());
            countRoomsAv++;
        }
    }
}

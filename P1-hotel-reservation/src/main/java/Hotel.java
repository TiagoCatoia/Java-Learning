import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Hotel {
    private final String name;
    private final Room[] rooms;
    private final Reservation[] reservations;
    private int countReservations;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
        reservations = new Reservation[100];
    }

    private boolean isAvailableAt(Room room, LocalDate checkIn, LocalDate checkOut) {
        for (Reservation reservation: reservations) {
            if (reservation == null) break;
            if (reservation.getRoom().getNumber() == room.getNumber()) {
                int days = (int) ChronoUnit.DAYS.between(checkIn, checkOut);
                for (int i = 0; i < days - 1; i++) {
                    if (reservation.isReservedAt(checkIn.plusDays(i), room)) return false;
                }
            }
        }
        return true;
    }

    public Reservation makeReservation(Guest guest, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        Room room = findRoom(roomNumber);
        if (room != null && checkIn != null && checkOut != null && guest != null) {
            if (isAvailableAt(room, checkIn, checkOut)) {
                Reservation newReservation = new Reservation(guest, room, checkIn, checkOut);
                reservations[countReservations++] = newReservation;
                return newReservation;
            }
        }
        return null;
    }

    public Reservation cancelReservation(String reservationId) {
        int reservationIndex = findIndexReservation(reservationId);
        if (reservationIndex != -1) {
            Reservation aux = reservations[reservationIndex];
            for (int i = reservationIndex; i < countReservations ; i++) {
                reservations[i] = reservations[i + 1];
            }
            countReservations--;
            return aux;
        }
        return null;
    }

    private int findIndexReservation(String reservationId) {
        for (int i = 0; i < countReservations; i++) {
            if (reservations[i].getId().equals(reservationId)) {
                return i;
            }
        }
        return -1;
    }

    private Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room == null) break;
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public Room[] getRoomsAvailableAt(LocalDate date) {
        if (countReservations == 0) return rooms;
        Room[] availableRooms = new Room[100];
        int countAvailableRooms = 0;
        for (Reservation reservation: reservations) {
            if (reservation == null) break;
            if (IsPrevAdd(reservation.getRoom(), availableRooms)) continue;
            if (!reservation.isReservedAt(date, reservation.getRoom())) {
                availableRooms[countAvailableRooms++] = reservation.getRoom();
            }
        }
        return availableRooms;
    }

    private boolean IsPrevAdd(Room room, Room[] rooms) {
        for (Room availableRoom: rooms) {
            if (availableRoom == null) break;
            if (availableRoom.equals(room)) return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}

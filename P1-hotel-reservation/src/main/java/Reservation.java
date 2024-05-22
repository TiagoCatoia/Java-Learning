import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import static java.lang.StringTemplate.STR;

public class Reservation {
    private final String id;
    private final LocalDate checkin;
    private final LocalDate checkout;
    private final Room room;
    private final Guest guest;
    private final int numOfDays;

    public Reservation(Guest guest, Room room, LocalDate checkin, LocalDate checkout) {
        id = ReservationIdGenerator.id();
        this.room = room;
        this.guest = guest;
        this.checkin = checkin;
        this.checkout = checkout;
        numOfDays = (int) ChronoUnit.DAYS.between(checkin, checkout);
    }

    public double getPrice() {
        return (double) room.getPrice() * numOfDays;
    }

    public boolean isReservedAt (LocalDate date, Room room) {
        return this.room.equals(room) && !date.isBefore(checkin) && date.isBefore(checkout);
    }

    public String asString() {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yy");
        return STR.
                """
                \nReservation:\{id}   Room number:\{room.getNumber()}
                Guest name:\{guest.getName()}   SSN:\{guest.getSsn()}   E-mail:\{guest.getEmail()}
                Check-in:\{STR."\{checkin.format(formater)}"}    Check-out:\{STR."\{checkout.format(formater)}"}
                Number of days:\{numOfDays}     Room Price:U$\{String.format(Locale.US,"%.2f", room.getPrice())}
                TOTAL:U$\{String.format(Locale.US,"%.2f", getPrice())}
                \n""";
    }

    public Room getRoom() {
        return room;
    }

    public String getId() {
        return id;
    }
}

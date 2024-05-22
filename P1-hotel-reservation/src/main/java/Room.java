import java.util.Locale;

public class Room {
    private int number;
    private double price;

    public Room(int number, double price) {
        this.number = number;
        this.price = price;
    }

    public String asString() {
        return String.valueOf("Number: " + number + " " + "Price: U$" + String.format(Locale.US,"%.2f",price) + "\n");
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }
}

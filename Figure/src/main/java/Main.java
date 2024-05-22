import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[150];

        for (int i = 0; i < 50; i++) {
            figures[i] = new Circle(4, 6, 4);
        }
        for (int i = 50; i < 100; i++) {
            figures[i] = new Rectangle(2, 4);
        }
        for (int i = 100; i < 150; i++) {
            figures[i] = new Triangle(4, 4, 4, 4, 4);
        }

        double sumArea = 0;
        for (Figure figure: figures) {
            sumArea += figure.area();
        }
        System.out.printf(Locale.US, "Total area: %.2f%n", sumArea);
    }
}

public abstract class Figure {
    private double x;
    private double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double area();
}

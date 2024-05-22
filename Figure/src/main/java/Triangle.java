public final class Triangle extends Figure {
    private double a;
    private double b;
    private double c;
    private double heigth;

    public Triangle(double x, double y, double a, double b, double c) {
        super(x,y);
        this.a = a;
        this.b = b;
        this.c = c;
        heigth = y;
    }

    @Override
    public double area() {
        return b * heigth / 2;
    }
}

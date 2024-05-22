public interface Formatter <T extends Reportable> {
    String format(T[] elements);
}

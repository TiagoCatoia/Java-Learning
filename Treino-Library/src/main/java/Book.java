public class Book {
    private final String title;
    private final String author;
    private int exemplarsAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        exemplarsAvailable = 1;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getExemplarsAvailable() {
        return exemplarsAvailable;
    }

    public void incrementExemplars() {
        exemplarsAvailable++;
    }

    public void decrementExemplars() {
        exemplarsAvailable--;
    }
}

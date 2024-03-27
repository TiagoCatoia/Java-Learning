import java.util.StringJoiner;
import java.util.UUID;

public class Student {
    private final String name;
    private String studentEnrollment;
    private Book[] books;
    private int countBooks;

    public Student(String name) {
        this.name = name;
        studentEnrollment = UUID.randomUUID().toString();
        books = new Book[2];
    }

    public String booksAsString() {
        StringJoiner joiner = new StringJoiner(",","[","]");
        joiner.add(books[0].toString());
        joiner.add(books[1].toString());
        return joiner.toString();
    }

    public void acquiresBook(Book book) {
        if (countBooks == 2) {
            System.out.println("Max number of books adquired...");
        } else {
            books[countBooks++] = book;
        }
    }

    public void returnsBook(Book book) {
        if (countBooks == 0) {
            System.out.println("This student dont have any book adquired...");
        } else {
            if (countBooks == 1 && books[0].equals(book)) countBooks--;
            if (countBooks == 2) {
                Book aux = books[countBooks - 1];
                if (books[0].equals(book)) {
                    books[countBooks - 1] = books[0];
                    books[0] = aux;
                    countBooks--;
                } else if (books[1].equals(book)) {
                    countBooks--;
                }
            }
        }
    }

    public boolean haveBook(Book book) {
        if (countBooks == 0) return false;
        if (countBooks == 1 && books[0].equals(book)) return true;
        if (countBooks == 2 && books[0].equals(book) || books[1].equals(book)) return true;
        return false;
    }

    public String getName() {
        return name;
    }

    public String getEnrollment() {
        return studentEnrollment;
    }

    public int getCountBooks() {
        return countBooks;
    }
}

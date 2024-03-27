public class Library {
    Book[] books;
    Student[] studentsHaveBook;
    int countStudentsHaveBook;
    int countBooks;
    int BOOKS_CAPACITY = 10000;
    int STUDENT_CAPACITY = 5000;

    public Library() {
        books = new Book[BOOKS_CAPACITY];
        studentsHaveBook = new Student[STUDENT_CAPACITY];
    }

    public void registerBook(Book newBook) {
        if (findBook(newBook) == -1) {
            books[countBooks++] = newBook;
        }
    }

    public int findBook(Book newBook) {
        for (int i = 0; i < countBooks; i++) {
            if (books[i] == null) continue;
            if (books[i].getTitle().equals(newBook.getTitle()) && books[i].getAuthor().equals(newBook.getAuthor())) {
                books[i].incrementExemplars();
                return i;
            }
        }
        return -1;
    }

    public void borrowBook(Student student, Book book) {
        int bookIndex = findBook(book);
        if (student.getEnrollment() != null && bookIndex >= 0) {
            if (books[bookIndex].getExemplarsAvailable() > 0) {
                books[bookIndex].decrementExemplars();
                student.acquiresBook(books[bookIndex]);
                studentsHaveBook[countStudentsHaveBook++] = student;
            } else System.out.println("We dont have more exemplars...");
        } else {
            System.out.println("Invalid arguments on barrow book...");
        }
    }

    public void restoreBook(Student student, Book book) {
        int bookIndex = findBook(book);
        if (studentsHaveAnyBook(student, bookIndex) && bookIndex >= 0) {
            if (student.haveBook(books[bookIndex])) {
                books[bookIndex].incrementExemplars();
                student.returnsBook(books[bookIndex]);
            } else System.out.println("This student dont barrow this book...");
        } else {
            System.out.println("Invalid arguments on restore book...");
        }
    }

    private boolean studentsHaveAnyBook(Student student, int bookIndex) {
        for (int i = 0; i < countStudentsHaveBook; i++) {
            if (studentsHaveBook[i] == null) continue;
            if (studentsHaveBook[i].getEnrollment().equals(student.getEnrollment())) {
                if (student.getCountBooks() == 1 && student.haveBook(books[bookIndex])) {
                    dontHaveMoreBooks(i);
                }
                return true;
            }
        }
        return false;
    }

    private void dontHaveMoreBooks(int indexStudent) {
        Student aux = studentsHaveBook[countStudentsHaveBook - 1];
        studentsHaveBook[countStudentsHaveBook - 1] = studentsHaveBook[indexStudent];
        countStudentsHaveBook--;
        studentsHaveBook[indexStudent] = aux;
    }
}


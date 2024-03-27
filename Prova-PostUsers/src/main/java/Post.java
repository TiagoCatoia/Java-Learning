import java.time.LocalDate;

public class Post {
    private final String quote;
    private final LocalDate date;
    private final UserAccount user;
    private int claps;
    private int boos;

    public Post(UserAccount account, String quote) {
        user = account;
        this.quote = quote;
        date = LocalDate.now();
    }

    public String show() {
        return String.valueOf("[" + date + "] " + user.getUserName() + " says: " + quote + " | Claps: " + claps + " | Boos: " + boos);
    }

    public void clap() {
        claps++;
    }

    public void boo() {
        boos++;
    }

    public String getQuote() {
        return quote;
    }
}

public class Guest {
    private final String ssn;
    private final String name;
    private String email;

    public Guest(String ssn, String name, String email){
        this.ssn = ssn;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public String getEmail() {
        return email;
    }

    public void  setEmail(String email) {
        this.email = email;
    }
}

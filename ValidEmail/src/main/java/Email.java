public class Email {
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public boolean ValidatorEmail() {
        int countUser = 0;
        for (int i = 0; i < this.email.length() && countUser < 64; i++) {
            char eachChar = this.email.charAt(i);
            if (eachChar == '@') {
                if (countUser == 0) return false;
                break;
            }
            if (eachChar == ' ') return false;
            countUser++;
        }
        if (this.email.charAt(countUser) != '@' || this.email.charAt(countUser+1) == '.' || this.email.charAt(countUser+1) == '-') {
            return false;
        }
        int countSecondLevelDomain = this.email.length() - (countUser + 2);
        int countExtension = 0;
        for (int i = this.email.length() - 1; i > countUser + 2 && countExtension < 64; i--) {
            char eachChar = this.email.charAt(i);
            if (eachChar == '.') {
                if (countExtension == 0) return false;
                break;
            }
            if (eachChar == ' ') return false;
            countExtension++;
        }
        if (countExtension == 0) return false;
        int countSecondLevel = 0;
        for (int i = countUser + 2; i < this.email.length() && countSecondLevel < 190; i++) {
            char eachChar = this.email.charAt(i);
            if (eachChar == '@' || eachChar == ' ' || eachChar == '.') return false;
            countSecondLevel++;
        }
        if (countSecondLevel == 0) return false;
        return true;
    }
}

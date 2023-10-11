package ait.user.model;

public class User {
    private String email;
    private String password;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        User user = (User) object;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    /*
       1) @ exists and only one (done)
       2) dot after @ (done)
       3) after last dot 2 and more symbols (done)
       4) alphabetic, digits, '_', '-', '.', '@' (done)
        */
    public void setEmail(String email) {
        if (isEmailValid(email)) {
            this.email = email;
        } else {
            System.out.println(email + " invalid");
        }

    }

    private boolean isEmailValid(String email) {
        int indexAt = email.indexOf('@');
        // if (indexAt==-1||email.indexOf('@',indexAt+1)>=0){
        if (indexAt == -1 || indexAt != email.lastIndexOf('@')) {
            return false;
        }
        if (email.indexOf('.', indexAt) == -1) {
            return false;
        }
        if (email.lastIndexOf('.') >= email.length() - 2) {
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!(Character.isAlphabetic(c) || Character.isDigit(c) || c == '_' || c == '.' || c == '@' || c == '-')) {
                return false;
            }
        }
        return true;
    }

    public String getPassword() {
        return password;
    }

    /*
       1) length >= 8
       2) min one digit
       3) min one symbol in upperCase
       4) min one symbol in lowerCase
       5) min one special symbol (! % @ $ &)
        */
    private boolean isPasswordValid(String password) {
        boolean result = false;
        boolean lenght = false;
        if (password.length() >= 8) {
            lenght = true;
        }

        boolean digit = false;
        for (int i = 0; i < password.length(); i++) {
            char d = password.charAt(i);
            if (Character.isDigit(d)) {
                digit = true;
            }
        }
        boolean upperCase = false;
        for (int i = 0; i < password.length(); i++) {
            char u = password.charAt(i);
            if (Character.isUpperCase(u)) {
                upperCase = true;
            }
        }
        boolean lowerCase = false;
        for (int i = 0; i < password.length(); i++) {
            char l = password.charAt(i);
            if (Character.isLowerCase(l)) {
                lowerCase = true;
            }
        }
        boolean special = false;
        for (int i = 0; i < password.length(); i++) {
            char s = password.charAt(i);
            if ((s == '!' || s == '%' || s == '@' || s == '$' || s == '&')) {
                special = true;
            }
        }
        if ((lenght && digit && upperCase && lowerCase && special) == true) {
            result = true;
        }
        return result;


    }

    public void setPassword(String password) {
        if (isPasswordValid(password)) {
            this.password = password;
        } else System.out.println("Password: " + password + " is not valid. Be careful, try again.");
    }

    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }
}

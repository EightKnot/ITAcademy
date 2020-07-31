package HomeWork7;

public class Person {
    String nick = "";
    String password = "";

    public Person(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }
}

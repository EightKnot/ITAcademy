package HomeWork7;

public class Animal {
    int age = 0;
    String nick = "";

    public Animal(int age, String nick) {
        this.age = age;
        this.nick = nick;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public String getNick() {
        return nick;
    }
}

package Human;

public class Human {
    String name;
    int age;
    Sex sex;

    public Human(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getInfo() {
        return this.name + "\t" + this.sex.toString() + "\t" + this.age;
    }

    public String getName() {
        return name;
    }
}

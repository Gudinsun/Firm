package Human;

public class Worker extends Human {
    Position position;
    int salary;
    int experience;

    public Worker(Human human, Position position, int salary, int experience) {
        super(human.name, human.age, human.sex);
        this.position = position;
        this.salary = salary;
        this.experience = experience;
    }
    @Override
    public String getInfo() {
        return super.getInfo() + "\t" + this.position + "\t" + this.salary;
    }

    public int getSalary() {
        if (position == Position.DIRECTOR) {
            return salary * 2;
        }
        return salary;
    }
}
package db;

import java.io.Serializable;

public class Person implements Serializable {

    public int id;
    public String name;
    public String surname;
    public int age;
    public String address;
    public int salary;

    public Person() {}

    public Person(int id, String name, String surname, int age, String address, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  id +", "+
                "\t" + name + ",   " +
                "\t" + surname + ",   " +
                "\t" + age + ",   " +
                "\t" + salary + ",    " +
                "\t" + address;
    }
}

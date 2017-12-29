/**
 * Created by shir.cohen on 12/29/2017.
 */
public class Person implements Comparable<Person> {
    private Integer id, age;
    private String name;

    Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return this.age.compareTo(person.age);
    }

    @Override
    public String toString() {
        return name;
    }
}

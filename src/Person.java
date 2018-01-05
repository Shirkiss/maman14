/**
 * Person.java
 * The Person class wraps a set of values in an object.
 * An object of type Person contain id number, age and name.
 * *
 * @author Shir Cohen
 */
public class Person implements Comparable<Person> {
    private Integer id, age;
    private String name;

    Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * Compares two Person objects numerically by there age.
     *
     * @param   person the Person to be compared.
     * @return  The value 0 if this Person has the same age.
     *          A value less than 0 if this Person age is numerically less
     *          than the other age; and a value greater
     *          than 0 if this Person age is numerically
     *          greater than the other Person age.
     */
    @Override
    public int compareTo(Person person) {
        return this.age.compareTo(person.age);
    }

    /**
     * return a string representation of this Person
     *
     * @return
     */
    @Override
    public String toString() {
        return name;
    }
}

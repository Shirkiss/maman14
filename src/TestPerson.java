/**
 * TestPerson.java
 * Create a group of different persons and print out the smallest person name in the group
 *
 * @author Shir Cohen
 */
public class TestPerson {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Shir", 10);
        Person person2 = new Person(2, "William", 9);
        Person person3 = new Person(3, "Ella", 20);
        Person person4 = new Person(4, "Moshe", 30);
        Person person5 = new Person(5, "Leigh", 12);
        Person[] personArray = {person1, person2, person3, person4, person5};
        Group<Person> personGroup = new Group<>(personArray);
        System.out.println("The group: " + personGroup);
        System.out.println("Smallest item in the group: " + smallest(personGroup));
    }

    /**
     * return the smallest item in a given group
     *
     * @param group  - the group we want to scan
     * @return the smallest item in the group
     */
    private static <T extends Comparable<T>> T smallest(Group<T> group) {
        int i;
        T min = group.get(0);
        for (i = 1; i < group.size(); i++) {
            if (min.compareTo(group.get(i)) == 1)
                min = group.get(i);
        }
        return min;
    }
}

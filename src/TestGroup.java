import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * TestGroup.java
 * Create different groups and do checks and actions on them
 *
 * @author Shir Cohen
 */
public class TestGroup {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // create 3 arrays with random numbers (0..100)
        Integer[] array1 = randomArray(10, 100);
        Integer[] array2 = randomArray(10, 100);
        Integer[] array3 = randomArray(10, 100);
        System.out.println("Array1: " + Arrays.toString(array1));
        System.out.println("Array2: " + Arrays.toString(array2));
        System.out.println("Array3: " + Arrays.toString(array3));

        // create 3 groups from the given arrays
        Group<Integer> group1 = new Group<>(array1);
        Group<Integer> group2 = new Group<>(array2);
        Group<Integer> group3 = new Group<>(array3);

        group1.union(group2);  // union group1 with group2
        System.out.println("Group1 after union with Group2: " + group1);

        group1.intersect(group3); // intersect the result with group3
        System.out.println("Group1 after intersect with Group3: " + group1);

        System.out.println("Enter a number: ");
        int firstNumber = reader.nextInt(); // Scans the next token of the input as an int.

        Group<Integer> group4 = new Group<>();  // create empty group
        group4.insert(firstNumber); // insert the number given by the user to group4

        System.out.println("Enter another number: ");
        int secondNumber = reader.nextInt(); // Scans the next token of the input as an int.
        group4.insert(secondNumber); // insert the number given by the user to group4

        System.out.println("isSubset of Group1: " + group1.isSubset(group4));
        System.out.println("isSubset of Group2: " + group2.isSubset(group4));
        System.out.println("isSubset of Group3: " + group3.isSubset(group4));

        System.out.println("Enter a number: ");
        int number = reader.nextInt(); // Scans the next token of the input as an int.
        System.out.println("isMember of group1: " + group1.isMember(number));
        group2.insert(number);
        System.out.println("Group2 after adding " + number + " to it: " + group2);
        group3.delete(number);
        System.out.println("Group3 after deleting " + number + " from it: " + group3);
    }

    /**
     * Create random array on Integers with a given size and bound
     *
     * @param size  - the size of the array
     * @param bound - the bound of the random numbers in the array
     * @return array of random Integers
     */
    private static Integer[] randomArray(int size, int bound) {
        Integer[] anArray = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < anArray.length; i++) {
            anArray[i] = rand.nextInt(bound);
        }
        return anArray;
    }
}

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * Created by shir.cohen on 12/27/2017.
 */
public class TestGroup {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        Integer[] array1 = randomArray(10, 20);
        Integer[] array2 = randomArray(10, 20);
        Integer[] array3 = randomArray(10, 20);
        System.out.println("Array1: " + Arrays.toString(array1));
        System.out.println("Array2: " + Arrays.toString(array2));
        System.out.println("Array3: " + Arrays.toString(array3));
        Group<Integer> group1 = new Group<>(array1);
        Group<Integer> group2 = new Group<>(array2);
        Group<Integer> group3 = new Group<>(array3);
        Group<Integer> group4 = new Group<>();
        group1.union(group2);
        System.out.println("Group1 after union with Group2: " + group1);
        group1.intersect(group3);
        System.out.println("Group1 after intersect with Group3: " + group1);
        System.out.println("Enter a number: ");
        int firstNumber = reader.nextInt(); // Scans the next token of the input as an int.
        group4.insert(firstNumber);
        System.out.println("Enter another number: ");
        int secondNumber = reader.nextInt(); // Scans the next token of the input as an int.
        group4.insert(secondNumber);
        System.out.println("isSubset of Group1: " + group1.isSubset(group4));
        System.out.println("isSubset of Group2: " + group2.isSubset(group4));
        System.out.println("isSubset of Group3: " + group3.isSubset(group4));
        System.out.println("Enter a number: ");
        int number = reader.nextInt(); // Scans the next token of the input as an int.
        System.out.println("isMember of group1: " + group1.isMember(number));
        group2.insert(number);
        System.out.println("Group2 after adding " + number + " to it: " + group2);
        group3.delete(number);
        System.out.println("Group3 after deleting " + number + " from it: " + group2);
    }

    private static Integer[] randomArray(int size, int bound) {
        Integer[] anArray = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < anArray.length; i++) {
            anArray[i] = rand.nextInt(bound);
        }
        return anArray;
    }
}

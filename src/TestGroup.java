/**
 * Created by shir.cohen on 12/27/2017.
 */
public class TestGroup {
    public static void main(String[] args)
    {
        Group<Integer> list1 = new Group<>();
        Integer[] integers = {1,2,3};
        Integer[] sub_integers = {2,3,5,6};
        Group<Integer> list2 = new Group<>(integers);
        Group<Integer> list3 = new Group<>(sub_integers);
        System.out.println(list2.isMember(5));
        System.out.println(list2.isSubset(list3));
        list2.union(list3);
        list2.insert(3);
        list2.insert(4);
        list2.delete(4);
        list2.delete(5);
        System.out.println(list2);

    }
}

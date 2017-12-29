import java.util.*;

/**
 * Created by shir.cohen on 12/27/2017.
 */
public class Group<T> {
    private ArrayList<T> group;

    Group() {
        group = new ArrayList<>();
    }

    Group(T[] array) {
        group = new ArrayList<>(Arrays.asList(array));
        removeDuplicates();
    }

    boolean isMember(T element) {
        return group.contains(element);
    }

    boolean isSubset(Group<T> subsetGroup) {
        return group.containsAll(subsetGroup.group);
    }

    void union(Group<T> secondGroup) {
        this.group.addAll(secondGroup.group);
        removeDuplicates();
    }

    @Override
    public String toString() {
        return group.toString();
    }

    void intersect(Group<T> secondGroup) {
        Group<T> finalGroup = new Group<>();

        for (T t : this.group) {
            if (secondGroup.group.contains(t)) {
                finalGroup.group.add(t);
            }
        }
        this.group = finalGroup.group;
    }

    void insert(T element) {
        if (!this.isMember(element))
            this.group.add(element);
    }

    void delete(T element) {
        if (this.isMember(element))
            this.group.remove(element);
    }

    public Iterator<T> iterator() {
        return this.group.iterator();
    }

    private void removeDuplicates() {
        Set<T> hs = new HashSet<>();
        hs.addAll(this.group);
        this.group.clear();
        this.group.addAll(hs);
    }

    T get(int index) {
        return this.group.get(index);
    }

    int size() {
        return this.group.size();
    }
}

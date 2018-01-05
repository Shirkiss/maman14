import java.util.*;

/**
 * Group.java
 * Resizable-list of elements.
 * On each group there aren't any duplications.
 * *
 * @author Shir Cohen
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

    /**
     * Check if an element is a member of this group
     *
     * @return true if this group contains the specified element
     */
    boolean isMember(T element) {
        return group.contains(element);
    }

    /**
     * This implementation iterates over the specified group,
     * checking each element returned by the iterator in turn to see
     * if it's contained in this group. If all elements are so
     * contained true is returned, otherwise false.
     *
     * @return true if this group contains all the elements from the other group
     */
    boolean isSubset(Group<T> subsetGroup) {
        return group.containsAll(subsetGroup.group);
    }

    /**
     * union a group with this group
     */
    void union(Group<T> secondGroup) {
        this.group.addAll(secondGroup.group);
        removeDuplicates();
    }

    /**
     * return a string representation of this group
     *
     * @return
     */
    @Override
    public String toString() {
        return group.toString();
    }

    /**
     * intersect a group with this group
     */
    void intersect(Group<T> secondGroup) {
        Group<T> finalGroup = new Group<>();

        for (T t : this.group) {
            if (secondGroup.group.contains(t)) {
                finalGroup.group.add(t);
            }
        }
        this.group = finalGroup.group;
    }

    /**
     * insert an element to this group
     */
    void insert(T element) {
        if (!this.isMember(element))
            this.group.add(element);
    }

    /**
     * delete an element from this group
     */
    void delete(T element) {
        if (this.isMember(element))
            this.group.remove(element);
    }

    /**
     * create an iterator over this group
     *
     * @return the iterator
     */
    public Iterator<T> iterator() {
        return this.group.iterator();
    }

    /**
     * Remove duplicates from this group
     */
    private void removeDuplicates() {
        Set<T> hs = new HashSet<>();
        hs.addAll(this.group);
        this.group.clear();
        this.group.addAll(hs);
    }

    /**
     * Returns the element at the specified position in this group.
     *
     * @return the element at the specified position in this group
     */
    T get(int index) {
        return this.group.get(index);
    }

    /**
     * Returns the number of elements in this group.
     *
     * @return the number of elements in this group
     */
    int size() {
        return this.group.size();
    }
}

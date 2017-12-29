import java.util.*;

/**
 * Created by shir.cohen on 12/27/2017.
 */
public class Group<T> {
    private ArrayList<T> group;

    public Group() {
        group = new ArrayList<>();
    }

    public Group(T[] array){
         group = new ArrayList<>(Arrays.asList(array));
    }

    public boolean isMember(T element){
        return group.contains(element);
    }

    public boolean isSubset(Group<T> subsetGroup){
        return group.containsAll(subsetGroup.group);
    }

    public void union(Group<T> secondGroup) {
        this.group.addAll(secondGroup.group);
        Set<T> hs = new HashSet<>();
        hs.addAll(this.group);
        this.group.clear();
        this.group.addAll(hs);
    }

    public String toString(){
        return group.toString();
    }

    public void intersect(Group<T> secondGroup) {
        Group<T> finalGroup = new Group<>();

        for (T t : this.group) {
            if(secondGroup.group.contains(t)) {
                finalGroup.group.add(t);
            }
        }
        this.group = finalGroup.group;
    }

    public void insert(T element){
        if (!this.isMember(element))
            this.group.add(element);
    }
    public void delete(T element){
        if (this.isMember(element))
            this.group.remove(element);
    }

    public Iterator<T> iterator(){
        return this.group.iterator();
    }



}

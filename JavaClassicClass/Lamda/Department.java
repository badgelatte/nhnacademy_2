import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Student {
    public String name;

    public String getName() {
        return name;
    }
}

class StudentNoComparator {
}

public class Department<E extends Student> implements Iterable<E> {
    public int departmentNo;
    public String departmentName;
    private List<E> list;

    public Department(int departmentNo, String departmentName) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
        list = new ArrayList<>();
    }

    public Iterator<E> iterator() {
        return this.list.iterator();
    }

    public void sort() {
    }

    public List<Student> filter(String searchString) {
        return this.list.stream().filter(s->s.getName().contains(searchString)).collect(Collectors.toList());
        // 사용할 때 department.filter("Robert");
    }
    
    public List<Student> filter(Predicate<Student> preducate) {
        return this.list.stream().filter(preducate).collect(Collectors.toList());
        // 사용할 때 department.filter(s->s.getName().contains("Rogbert"));
    }

    public void sort(Comparator<Student> comparator) {
        Collections.sort(this.list, comparator);
    }
}
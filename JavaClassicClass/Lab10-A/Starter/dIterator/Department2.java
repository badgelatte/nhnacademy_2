package dIterator;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Department2 implements Iterable<Student> {
    private int departmentNo;
    private String departmentName;
    private List<Student> list;

    public Department2(int departmentNo, String departmentName) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
        list = new ArrayList<>();
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void addStudent(Student s) {
        list.add(s);
    }

    @Override
    public Iterator<Student> iterator() {
        return list.iterator();
    }
}

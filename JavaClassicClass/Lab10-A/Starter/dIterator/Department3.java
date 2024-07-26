package dIterator;
import java.util.Iterator;
import java.util.LinkedList;

public class Department3 implements Iterable {
    private int departmentNo;
    private String departmentName;
    private java.util.LinkedList list;

    public Department3(int departmentNo, String departmentName) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
        list = new LinkedList<>();
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

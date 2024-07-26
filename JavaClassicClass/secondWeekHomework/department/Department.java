package department;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Department implements Iterable<Student> {
    private int departmentNo;
    private String departmentName;
    private List<Student> list;

    public Department(int departmentNo, String departmentName) {
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

    public String getList() {
        StringBuilder s = new StringBuilder();
        for (Student student : list) {
            s.append(student.toString() + "/n");
        }
        return s.toString();
    }

    public void addStudent(Student s) {
        list.add(s);
    }

    @Override
    public Iterator<Student> iterator() {
        return list.iterator();
    }

    @Override
    public String toString(){
        return departmentNo + ", " + departmentName;
    }
}

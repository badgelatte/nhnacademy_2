package students;

public class Department {
    private int departmentNo;
    private String departmentName;
    private ArrayList list;
    
    public Department(int departmentNo, String departmentName) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
        list = new ArrayList();
    }

    public void add(Student s) {
        this.list.add(s);
    }

    public Student getStudent(int index) {
        return (Student)this.list.get(index);
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

}

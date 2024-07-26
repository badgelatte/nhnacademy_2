import java.util.List;

import department.Department;
import department.DepartmentManagement;
import department.Student;

public class Test {
    public static void main(String[] args) {
        DepartmentManagement dm = new DepartmentManagement();
        Department d = dm.createDepartment(21);
        System.out.println(d);
        System.out.println(d.getList());
        for (Student student : d) {
            System.out.println(student.toString());
        }
    }
}

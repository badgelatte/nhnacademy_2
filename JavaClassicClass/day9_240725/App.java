import students.Department;
import students.Student;

public class App {
    public static void main(String[] args) {
        Student s1 = new Student(1,"Celine", "celine@iese.com");
        System.out.println(s1);

        Department department = new Department(1, "Computer Science");
        department.add(s1);
        department.add(new Student(2, "James", "james@microsoft.com"));

        System.out.println(department.getStudent(0));
        System.out.println(department.getStudent(1));
    }
}

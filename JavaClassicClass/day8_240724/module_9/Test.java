package module_9;
public class Test {
    public static void main(String[] args) {
        Student s = new Student(1, "Celine");

        Department d = new Department(1);
        Student s2 = d.createStudent(2,"james");
    }
}

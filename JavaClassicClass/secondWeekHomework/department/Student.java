package department;

public class Student {
    private int studentNo;
    private String name;

    public Student(int studentNo, String name) {
        this.studentNo = studentNo;
        this.name = name;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return studentNo + ", " + name;
    }
}

package students;

public class Student {
    private int studentNo;
    private String name;
    private String email;

    public Student(int studentNo, String name, String email) {
        this.studentNo = studentNo;
        this.name = name;
        this.email = email;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return studentNo + ", " + name + ", " + email;
    }


}
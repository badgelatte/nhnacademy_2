package module_9;
public class Department{
    Student[] students;

    public Department(int size){
        this.students = new Student[size];
    }

    public void add(Student s) {
        this.students[0] = s;
    }

    public Student createStudent(int studentNo, String name) {
        return new Student(studentNo, name);
    }


}
import java.util.Comparator;

class NoComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.no - s2.no;
    }
}
class Student{
    int no;
    public Student(int no){
        this.no = no;
    }
}

public class Lamdba {
    Comparator<Student> noComp = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            return s1.no - s2.no;
        }
    };
    Comparator<Student> comp1 = (s1, s2) -> s1.no = s2.no;

    Comparator<Student> comp2 = new NoComparator();
}

package module_10;

public class Student {
    int studentNo;
    String name;
    
    public Student(int studentNo, String name) {
        this.studentNo = studentNo;
        this.name = name;
    }
}

class Graduate extends Student {
    String major;

    public Graduate(int studentNo, String name, String major) {
        super(studentNo, name);     
        // -> 이게 없으면 super class의 기본 생성자를 참조함 근데 지금은 없음 그래서 지우면 오류남
        this.major = major;
    }

    @Override
    public String toString(){
        return this.studentNo + ", " + this.name + ", "+ this.major;
    }
}

class School{
    public static void main(String[] args) {
        Graduate g = new Graduate(1, "Celine", "Computer Science");
        System.out.println(g);
    }
}
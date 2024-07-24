public class Test {
    public static void main(String[] args) {
        Student s = new Student.Builder()
        .studentNo(1)
        .name("Celine")
        .departmentName("Computer Engineering")
        .cellphone("010-2222-4444")
        .email("nobody@datamotion.co.kr")
        .build();
    }
}

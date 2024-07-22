public class JapanChef extends Chef{
    public JapanChef(String name, String toolName) {
        super(name, toolName);
    }

    public void cook() {
        System.out.println(this.toolName + "으로 " + "생선을 썹니다");
    }
}
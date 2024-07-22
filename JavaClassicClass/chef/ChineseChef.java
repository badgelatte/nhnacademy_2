public class ChineseChef extends Chef {
    public ChineseChef(String name, String toolName) {
        super(name, toolName);
    }

    public void cook() {
        System.out.println(this.toolName + "으로 " + "생선을 튀깁니다");
    }
}
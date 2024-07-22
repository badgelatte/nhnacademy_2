public class ItalianChef extends Chef{
    public ItalianChef(String name, String toolName) {
        super(name, toolName);
    }

    public void cook() {
        System.out.println(this.toolName + "으로 " + "삶은 면을 건집니다");
    }
}
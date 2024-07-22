public class KoreanChef extends Chef{
    public KoreanChef(String name, String toolName) {
        super(name, toolName);
    }

    public void cook() {
        System.out.println(this.toolName + "으로 " + "찌개를 끓입니다");
    }
}
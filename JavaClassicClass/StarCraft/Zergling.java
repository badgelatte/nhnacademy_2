public class Zergling extends Unit{
    public int hp;
    public int attackPower;
    public String name;

    public Zergling(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    public void attack (Unit unit) {
        System.out.println(this.getName() + "이 " + unit.getName() + "을 갈고리를 긁습니다.");
        unit.reduceHp(this.attackPower);
    }
}

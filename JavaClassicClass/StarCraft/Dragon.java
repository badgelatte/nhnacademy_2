public class Dragon extends Unit{
    public Dragon(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    public void attack (Unit unit) {
        System.out.println(this.getName() + "이 " + unit.getName() + "을 레이저롤 쏩니다.");
        unit.reduceHp(this.attackPower);
    }
}

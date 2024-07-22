public class Zealot extends Unit{

    public Zealot(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    public void attack (Unit unit) {
        System.out.println(this.getName() + "이 " + unit.getName() + "을 갈고리를 긁습니다.");
        unit.reduceHp(this.attackPower);
    }

}

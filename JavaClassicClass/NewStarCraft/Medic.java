public class Medic extends Unit {
    public Medic(String name, int hp, int attackPower) {
        super(name, hp, attackPower, 0);
    }

    @Override
    public void attack(Unit unit) {
        System.out.println(this.getName() + "이 " + unit.getName() + "을 공격합니다");
        unit.reduceHp(this.attackPower);
    }

}

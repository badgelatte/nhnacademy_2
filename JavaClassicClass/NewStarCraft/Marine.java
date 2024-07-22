public class Marine extends Unit implements Attackable{

    public Marine(String name, int hp, int attackPower, int location) {
        super(name, hp, attackPower, location);
    }

    public void attack(Unit unit) {
        if(unit instanceof Flyable) {
            System.out.println("공격불가");
        }
        else {
            System.out.println(this.getName() + "이 " + unit.getName() + "을 공격합니다");
            unit.reduceHp(this.attackPower);
        }
    }
}

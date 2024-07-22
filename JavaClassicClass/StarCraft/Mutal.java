public class Mutal extends Unit{
    public int hp;
    public int attackPower;
    public int movingSpeed;
    public String name;

    public Mutal(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    public void attack (Unit unit) {
        System.out.println(this.getName() + "이 " + unit.getName() + "에게 돌을 던집니다.");
        unit.reduceHp(this.attackPower);
    }
}
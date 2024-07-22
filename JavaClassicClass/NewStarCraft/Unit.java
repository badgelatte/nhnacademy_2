public abstract class Unit {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected int location;

    public Unit(String name, int hp, int attackPower, int location) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void move(int location) {
        System.out.println("길따라 움직입니다");
        this.location = location;
    }

    public void reduceHp(int attackPower) {
        this.hp -= attackPower;
    }

    public abstract void attack(Unit unit);
}
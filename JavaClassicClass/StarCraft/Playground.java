public class Playground {
    public static void main(String[] args) {
        Marine marine1 = new Marine("Marine1", 10, 2);
        Marine marine2 = new Marine("Marine2", 10, 2);
        
        Zealot zealot1 = new Zealot("Zealot1", 15, 3);
        Zealot zealot2 = new Zealot("Zealot2", 15, 3);

        Zergling zergling = new Zergling("zergling", 6, 1);
        
        marine1.attack(marine2);
        zealot1.attack(zealot2);
        marine1.attack(zealot1);
        zergling.attack(zealot1);

        System.out.println(marine1);
        System.out.println(marine2);

        System.out.println(zealot1);
        System.out.println(zealot2);

        System.out.println(zergling);
    }
}

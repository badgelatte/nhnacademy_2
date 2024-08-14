
public class HanoiTop { // x = department y = stopover z = arrival
    public static void hanoiTowers(int n, String x, String y, String z) {
        if(n ==1) {
            System.out.printf("Move top disk from peg %s to peg %s%n", x, z);
        } else {
            hanoiTowers(n-1, x, z, y);
            hanoiTowers(1, x, y, z);
            hanoiTowers(n-1, y, x, z);
        }
    }

    public static void main(String[] args) {
        hanoiTowers(3, "A", "B", "C");
    }
}

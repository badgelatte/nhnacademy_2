enum Shape {
    Spade,
    Diamond,
    Heart,
    Club
}

public class Card {
    int number;
    Shape shape;
    
}

class Dealer {
    public static void main(String[] args) {
        Card as = new Card();
        as.number = 1;
        as.shape = Shape.Spade;

        Card a2 = new Card();
        a2.number = 2;
        a2.shape = Shape.Spade;

        Card a3 = new Card();
        a3.number = 3;
        a3.shape = Shape.Diamond;

        // enum - 동일 여부 비교는 되지만 크기 비교 연산은 안된다
        System.out.println(as.shape == a2.shape);
        System.out.println(a2.shape == a3.shape);
    }
}

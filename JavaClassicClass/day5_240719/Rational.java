public class Rational {
    int nominator;
    int denominator;

    public Rational(int nominator, int denominator) {
        if(nominator < 0) {
            nominator *= -1;
            this.nominator = - (nominator / gcd(nominator, denominator));
        }
        else {
            this.nominator = nominator / gcd(nominator, denominator);
        }
        this.denominator = denominator /gcd(nominator, denominator);
    }

    public Rational add(Rational r1) {

        Rational newR = new Rational(r1.nominator * denominator + nominator * r1.denominator, r1.denominator * denominator);
        return newR;
    }

    public Rational add(int i) {
        Rational r= new Rational(i, 1);
        // return this.add(r);
        return r.add(this.add(r));
    }

    public Rational sub(Rational r1) {
        // int denominatorGcd = 1;
        // if(r1.denominator != denominator){
        //     denominatorGcd = gcd(r1.denominator, denominator);
        // }
        Rational newR = new Rational(r1.nominator * denominator - nominator * r1.denominator, r1.denominator * denominator);
        return newR;
    }

    public static int gcd(int i, int j) {
        // 답지 1
        // if(j == 0) {
        //     return 1;
        // }
        // else {
        //     return gcd(j, i%j);
        // }
        // 답지 2 -> ?? 안 되는데? 72랑 90의 최대공약수는 18인디
        return j == 0 ? i : gcd(j, i % j);

        // int smaller = i<j? i : j;
        // int gcd = 1;

        // for (int k = 1; k < smaller; k++) {
        //     if(i % k == 0 && j % k == 0) {
        //         gcd = k;
        //     }
        // }
        // return gcd;
    }

    @Override
    public String toString() {
        return nominator + "/" + denominator;
    }

    public static void main(String[] args) {
        System.out.println(gcd(72,90));
    }
}

class Test {
    public static void main(String[] args) {
        Rational a = new Rational(1, 2);
        a = a.add(new Rational(1,2));
        // Rational b = new Rational(1, 90);

        // System.out.println(a.add(b));
        // System.out.println(a.sub(b));
    }
}

// java 순수 객체 지향이라 보기 어렵다
// add, sub으로 java 개체 
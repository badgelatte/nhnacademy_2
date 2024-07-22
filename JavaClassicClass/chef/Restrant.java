public class Restrant {
    public static void main(String[] args) {
        Chef[] chefs = {
                new KoreanChef("홍길동", "국자"),
                new JapanChef("나카무라", "사시미칼"),
                new ItalianChef("로베르토", "뜰채"),
                new ChineseChef("쯔양", "웍")
        };

        for (Chef chef : chefs) {
            chef.cook();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Shape rect = new Rectangle(10, 5);
        Shape squ = new Square(5);
        
        System.out.println(rect.getArea());
        System.out.println(squ.getArea());
    }
}

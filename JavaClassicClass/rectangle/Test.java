public class Test {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(5);

        System.out.println(rectangle.getArea());

        Rectangle square = new Square();
        square.setWidth(10);
        square.setHeight(5);

        System.out.println(square.getArea());
    }
}

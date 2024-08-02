public class Square implements Shape {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    public int width() {
        return length;
    }

    public int height() {
        return length;
    }

    public void setWidth(int value) {
        this.length = value;
    }

    public void setHeight(int value) {
        this.length = value;
    }

    public int getArea() {
        return length * length;
    }

}
public class Rectangle implements Shape{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int width(){
        return this.width;
    }

    public int height() {
        return this.height;
    }

    public void setWidth(int value) {
        this.width = value;
    }

    public void setHeight(int value) {
        this.height = value;
    }

    public int getArea() {
        return width * height;
    }
}

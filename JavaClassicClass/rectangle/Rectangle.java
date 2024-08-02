public class Rectangle {
    protected int width;
    protected int height;
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getArea() {
        return this.height * this.width;
    }

}
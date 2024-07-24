public class Singleton {
    private Singleton(){
    }

    public void getInstance() {
        new Singleton();
    }
}
public interface Toy {
    public void say(String talk);

    public void say(Toy a, String talk);

    public void say(Toy[] a, String talk);

    public void run(Toy a);

    public String getName();
}
public abstract class Chef {
    String name;
    String toolName;

    public Chef(String name, String toolName) {
        this.name = name;
        this.toolName = toolName;
    }

    public String getName() {
        return this.name;
    }

    public abstract void cook();
}
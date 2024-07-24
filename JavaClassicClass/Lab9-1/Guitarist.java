public class Guitarist {
    String name;
    String teamName;

    private Guitarist(Builder builder) {
        this.name = builder.name;
        this.teamName = builder.teamName;
    }

    @Override
    public String toString() {
        return name + ", " + teamName;
    }

    public static class Builder{
        String name;
        String teamName;

        public Guitarist build() {
            return new Guitarist(this);
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder teamName(String teamName) {
            this.teamName = teamName;
            return this;
        }
    }
}


class Test {
    public static void main(String[] args) {
        Guitarist g = new Guitarist.Builder()
        .name("Jimy Page")
        .teamName("Led Zepplin")
        .build();

        System.out.println(g);
    }
}
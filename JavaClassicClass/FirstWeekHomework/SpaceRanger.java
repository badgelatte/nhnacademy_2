public class SpaceRanger implements Toy {
    private String name;

    public SpaceRanger(String name){
        this.name = name;
    }

    @Override
    public void say(String talk) {
        System.out.println("(" + name + ")" + talk);
    }

    @Override
    public void say(Toy a, String talk) {
        System.out.println("(" + name + "가 " + a.getName() +"에게)" + talk);
    }

    @Override
    public void say(Toy[] a, String talk) {
        System.out.println("(" + name + "가 모두에게)" + talk);
    }

    @Override
    public void run(Toy a) {
        System.out.println(name+"가 " + a.getName() + "에게 뛰어갑니다.");
    }

    @Override
    public String getName() {
        return name;
    }

    public void pushCapButton(){
        System.out.println(name + "의 캡이 열렸습니다.");
    }
    
}

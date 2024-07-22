public class ToyStory {
    public static void main(String[] args) {
        Toy buzz = new SpaceRanger("가짜 버즈");
        Toy buzz2 = new SpaceRanger("버즈");
        Toy woody = new SpaceRanger("우디");
        Dino rex = new Dino("Rex");

        Toy[] toys = {woody, rex};

        ((SpaceRanger)buzz).pushCapButton();
        buzz2.say(buzz, "또 너야!");
        woody.run(buzz);
        woody.say(buzz, "무사했구나");
        buzz.say(toys, "아니, 내가 버즈 라이트이어야");
        buzz2.say(buzz, "내가 버즈야!");
        buzz.say(toys, "내가 버즈야!");
        woody.say("누가 버즈야?");
        buzz.say(toys, "나야!");
        buzz2.say(toys, "나야!");
        buzz2.say(woody, "내가 버즈야, z 대왕이 날 흉내내서 만든거야");

        ((SpaceRanger)buzz).pushCapButton();

    }
}

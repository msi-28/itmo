import actoin.Emotions;
import environment.Cave;
import environment.Rocket;
import items.Boot;
import person.MainShorty;
import environment.Sun;
import person.SideShorty;

public class Main {
    public static void main(String[] args){
        MainShorty Ponchik = new MainShorty("Пончик");
        Boot rightBoot = new Boot("Правый", true, Ponchik);
        Boot leftBoot = new Boot("Левый", false, Ponchik);
        SideShorty Neznayka = new SideShorty("Незнайка");

        Cave cave = new Cave("пещера");
        Rocket rocket = new Rocket("ракета");
        Sun sun = new Sun("солнце");
        Ponchik.call(Neznayka);
        Neznayka.call(Ponchik);
        Ponchik.getEmotion(Emotions.SCARED);
        cave.goOut(Ponchik);
        Ponchik.hobble();
        sun.heatUp(Ponchik);
        Ponchik.run();
        rightBoot.fallBoot(Ponchik);
        leftBoot.fallBoot(Ponchik);
        Ponchik.getEmotion(Emotions.JOYFUL);
        rocket.pressButton(Ponchik);
        rocket.openTheDoor(Ponchik);
        rocket.goTo(Ponchik);
        Ponchik.getEmotion(Emotions.RELIEF);
        Ponchik.getEmotion(Emotions.STRESSED);


    }
}
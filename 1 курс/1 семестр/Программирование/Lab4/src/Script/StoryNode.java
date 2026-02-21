package Script;

import environment.Sun;
import exeptions.WrongInput;
import person.MainShorty;
import person.Shorty;
import person.SideShorty;

import java.util.ArrayList;

public abstract class StoryNode {
    public static ArrayList<String> part = new ArrayList<>();
    public StoryNode() {}

    // Метод для вывода текста (через него можно реализовать эффекты печати)
    public abstract void printDescription(MainShorty mainShorty, SideShorty sideShorty, Sun sun);

    // Метод для обработки выбора
    public abstract StoryNode executeChoice(int choice, Shorty shorty) throws WrongInput;

    // Метод для отображения вариантов
    public abstract void displayOptions();

    public static void createStory(ArrayList<String> part){
        for (String i: part) {
            StoryLog.story.add(i);
        }
    }
    public void printPart(ArrayList<String> part){
        for (String i : part){
            System.out.println(i);
        }
    }
}

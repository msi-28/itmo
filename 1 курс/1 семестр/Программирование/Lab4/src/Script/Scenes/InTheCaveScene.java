package Script.Scenes;


import Script.StoryNode;
import environment.Sun;
import exeptions.WrongInput;
import person.MainShorty;
import person.Shorty;
import person.SideShorty;

import java.util.ArrayList;

public class InTheCaveScene extends StoryNode {
    public InTheCaveScene(){}

    @Override
    public void printDescription(MainShorty mainShorty, SideShorty sideShorty, Sun sun){
        part.add(sideShorty.getName() + " потерялся в пещере");
        part.add(mainShorty.call(sideShorty));
        part.add("Поможет ли ему " + mainShorty.getName());
    }

    @Override
    public void displayOptions(){
        System.out.println("1. Убежать");
        System.out.println("2. Остаться и помочь другу");
    }

    @Override
    public  StoryNode executeChoice(int choice, Shorty mainShorty) throws WrongInput {
        if (choice == 1) {
            part.add(mainShorty.getName() +  " решил убежать");
            return new RunAway();
        } else if (choice == 2) {
            part.add(mainShorty.getName() + " решил остаться и помочь другу");
            return new SaveFriend();
        }
        else{
            throw new WrongInput("Вы выбрали непредусмотренный вариант");
        }
    }
}

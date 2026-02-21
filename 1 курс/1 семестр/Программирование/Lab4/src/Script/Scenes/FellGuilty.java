package Script.Scenes;

import Script.StoryNode;
import environment.Sun;
import exeptions.WrongInput;
import person.MainShorty;
import person.Shorty;
import person.SideShorty;

import java.util.ArrayList;

public class FellGuilty extends StoryNode {
    public FellGuilty(){}

    @Override
    public void printDescription(MainShorty mainShorty, SideShorty sideShorty, Sun sun){
        part.add(mainShorty.getStressed(sideShorty));
    }

    @Override
    public void displayOptions(){
        System.out.println("0. Закончить историю");
    }

    @Override
    public  StoryNode executeChoice(int choice, Shorty mainShorty) throws WrongInput {
        if (choice == 0) {
            part.add("КОНЕЦ");
            return null;
        }
        else{
            throw new WrongInput("Вы выбрали непредусмотренный вариант");
        }
    }
}

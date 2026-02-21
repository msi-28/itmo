package Script.Scenes;

import Script.StoryNode;
import environment.Sun;
import exeptions.WrongInput;
import person.MainShorty;
import person.Shorty;
import person.SideShorty;

public class RunAway extends StoryNode {
    public RunAway(){}

    @Override
    public void printDescription(MainShorty mainShorty, SideShorty sideShorty, Sun sun){
        part.add(mainShorty.getOut());
        part.add(mainShorty.run());
        part.add(sun.heatUp(mainShorty));
        part.add(mainShorty.fallBoot());

        part.add("Вернется ли за другом " +  mainShorty.getName() + "?");
    }

    @Override
    public void displayOptions(){
        System.out.println("1. Спрятаться в ракете");
        System.out.println("2. Вернутся и помочь другу");
    }

    @Override
    public  StoryNode executeChoice(int choice, Shorty mainShorty) throws WrongInput {
        if (choice == 1) {
            part.add(mainShorty.getName() +  " решил спрятаться в ракете");
            return new HideInTheRocketAlong();
        } else if (choice == 2) {
            part.add( mainShorty.getName() +  " решил вернутся и помочь другу");
            return new SaveFriend();
        }
        else{
            throw new WrongInput("Вы выбрали непредусмотренный вариант");
        }
    }
}

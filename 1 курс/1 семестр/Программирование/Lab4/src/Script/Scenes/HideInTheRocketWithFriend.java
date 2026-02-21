package Script.Scenes;

import Script.StoryNode;
import environment.Location;
import environment.Sun;
import exeptions.WrongInput;
import person.MainShorty;
import person.Shorty;
import person.SideShorty;

public class HideInTheRocketWithFriend extends StoryNode {
    public HideInTheRocketWithFriend(){}

    @Override
    public void printDescription(MainShorty mainShorty, SideShorty sideShorty, Sun sun){
        part.add(mainShorty.goTo(Location.NEAR_ROCKET));
        part.add(sideShorty.goTo(Location.NEAR_ROCKET));
        part.add(mainShorty.openTheDoor());
        part.add(mainShorty.getSafe());
        part.add(sideShorty.openTheDoor());
        part.add(sideShorty.getSafe());
    }

    @Override
    public void displayOptions(){
        System.out.println("0. Закончить историю");
    }

    @Override
    public  StoryNode executeChoice(int choice, Shorty mainShorty) throws WrongInput {
        if (choice == 0) {
            part.add(("КОНЕЦ"));
            return null;
        }
        else{
            throw new WrongInput("Вы выбрали непредусмотренный вариант");
        }
    }
}

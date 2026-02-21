package Script.Scenes;

import Script.StoryNode;
import environment.Location;
import environment.Sun;
import exeptions.WrongInput;
import person.MainShorty;
import person.Shorty;
import person.SideShorty;

public class HideInTheRocketAlong extends StoryNode {
    public HideInTheRocketAlong(){}

    @Override
    public void printDescription(MainShorty mainShorty, SideShorty sideShorty, Sun sun){
        part.add(mainShorty.goTo(Location.NEAR_ROCKET));
        part.add(mainShorty.openTheDoor());
        part.add(mainShorty.getSafe());
        part.add( "Чувствует ли " + mainShorty.getName() + " вину");
    }

    @Override
    public void displayOptions(){
        System.out.println("1. Да");
        System.out.println("2. Нет");
    }

    @Override
    public  StoryNode executeChoice(int choice, Shorty mainShorty) throws WrongInput {
        if (choice == 1) {
            return new FellGuilty();
        } else if (choice == 2) {
            part.add(mainShorty.getName() +  " не чувствует вины. Друг из него так себе в целом");
            return null;
        } else {
            throw new WrongInput("Вы выбрали непредусмотренный вариант");
        }
    }
}

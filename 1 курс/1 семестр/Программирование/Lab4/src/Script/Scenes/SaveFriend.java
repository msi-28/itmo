package Script.Scenes;

import Script.StoryLog;
import Script.StoryNode;
import environment.Location;
import environment.Sun;
import exeptions.WrongInput;
import person.MainShorty;
import person.Shorty;
import person.SideShorty;

public class SaveFriend extends StoryNode {
    public SaveFriend(){}

    @Override
    public void printDescription(MainShorty mainShorty, SideShorty sideShorty, Sun sun){
        part.add(mainShorty.goTo(Location.CAVE));
        part.add(mainShorty.getName() + " нашел " + sideShorty.getName());

    }

    @Override
    public void displayOptions(){
        System.out.println("0. Спрятаться в ракете с другом");
    }

    @Override
    public  StoryNode executeChoice(int choice, Shorty mainShorty) throws WrongInput {
        if (choice == 0) {
            part.add(mainShorty.getName() +  " решил спрятаться в ракете с другом");
            return new HideInTheRocketWithFriend();
        }
        else{
            throw new WrongInput("Вы выбрали непредусмотренный вариант");
        }
    }

}

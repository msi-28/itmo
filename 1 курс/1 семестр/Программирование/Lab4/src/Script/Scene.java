package Script;

import Script.Scenes.InTheCaveScene;
import environment.Sun;
import exeptions.WrongInput;
import person.MainShorty;
import person.SideShorty;

import java.util.Scanner;

public record Scene(MainShorty mainShorty, SideShorty sideShorty, Sun sun) {
    public void scenario() throws WrongInput {
        StoryNode currentNode = new InTheCaveScene();
        Scanner scanner = new Scanner(System.in);

        while (currentNode != null){
            System.out.println("===========================");
            currentNode.printDescription(mainShorty, sideShorty, sun);
            currentNode.printPart(StoryNode.part);
            currentNode.displayOptions();

            System.out.print("> ");
            int choice = scanner.nextInt();
            currentNode = currentNode.executeChoice(choice, mainShorty);
        }
    }
}

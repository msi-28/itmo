import Script.Scene;
import Script.SceneFactory;
import Script.StoryLog;
import Script.StoryNode;
import exeptions.NullLocationException;
import exeptions.WrongInput;

import static Script.StoryNode.part;

public class Main {
    public static void main(String[] args) throws WrongInput, NullLocationException {
        SceneFactory sceneFactory = new SceneFactory();
        Scene scene = sceneFactory.create();
        scene.scenario();
        StoryLog log = new StoryLog();
        StoryNode.createStory(part);
        log.printStory();


    }
}
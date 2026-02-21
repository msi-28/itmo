package Script;

import java.util.ArrayList;

public class StoryLog {
    protected static ArrayList <String> story = new ArrayList<>();
    public StoryLog(){}

    public void printStory(){
        System.out.println("ИСТОРИЯ");
        for (String part : story){
            System.out.println(part);
        }
    }
}

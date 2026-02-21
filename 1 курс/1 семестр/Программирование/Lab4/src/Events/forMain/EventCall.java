package Events.forMain;

import Events.Event;
import Events.forSide.EventNoAnswer;
import Events.EventType;
import person.interfaces.Reactable;
import person.Shorty;

import static person.enums.Emotions.getEmotion;

public class EventCall extends Event implements Reactable {
    private final Shorty actor;
    private final Shorty speaker;
    public EventCall(Shorty actor, Shorty speaker){
        super(EventType.CALL);
        this.actor = actor;
        this.speaker = speaker;
    }

    public String reactCallEvent(){
        String status = getEmotion(speaker);
        String message = call();
        if (canReact(actor)) {
            EventNoAnswer eventNoAnswer = new EventNoAnswer();
            eventNoAnswer.reactNoAnswer(actor);
            return speaker.getName() + " "  + status + " " +  message + " " +  actor.getName();
        }
        else{
            return "Персонажи не слышат друг друга";
        }
    }

    public String call(){
        return EventType.CALL.getText();
    }

    public boolean canReact(Shorty actor){
        return actor.getLocation().equals(speaker.getLocation());
    }


}

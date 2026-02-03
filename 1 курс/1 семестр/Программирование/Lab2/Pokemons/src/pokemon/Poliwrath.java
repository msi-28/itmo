package pokemon;
import move.status.Rest;

public final class Poliwrath extends Poliwhirl{
    public Poliwrath (String name, int level){
        super (name, level);
        setStats(90, 85, 95, 70,90, 70);
        this.addMove(new Rest());
    }
}

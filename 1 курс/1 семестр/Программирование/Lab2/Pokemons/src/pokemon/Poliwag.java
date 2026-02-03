package pokemon;
import move.special.Blizzard;
import move.status.Double_Team;
import ru.ifmo.se.pokemon.*;


public class Poliwag extends Pokemon{
    public Poliwag(String name, int level){
        super(name, level);
        setType(Type.WATER);
        setStats(40,50,40,40,40,90);
        this.addMove(new Blizzard());
        this.addMove(new Double_Team());
    }
}

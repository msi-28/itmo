package pokemon;
import move.physical.Fury_Swipes;
import move.status.Amnesia;
import move.status.Rest;
import ru.ifmo.se.pokemon.*;

public class Sentret extends Pokemon {
    public Sentret(String name, int level){
        super(name, level);
        setType(Type.NORMAL);
        setStats(35, 46, 34, 35, 45, 20);
        this.addMove(new Rest());
        this.addMove(new Fury_Swipes());
        this.addMove(new Amnesia());
    }
}

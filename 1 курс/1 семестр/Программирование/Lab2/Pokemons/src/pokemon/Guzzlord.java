package pokemon;
import move.physical.Aerial_Ace;
import move.physical.Psycho_Cut;
import move.physical.X_scissor;
import move.status.Swagger;
import ru.ifmo.se.pokemon.*;

public final class Guzzlord extends Pokemon {
    public Guzzlord(String name, int level){
        super(name, level);
        setType(Type.DARK, Type.DRAGON);
        setStats(223, 101, 53, 97, 53, 43);
        this.addMove(new Psycho_Cut());
        this.addMove(new X_scissor());
        this.addMove(new Aerial_Ace());
        this.addMove(new Swagger());
    }

}

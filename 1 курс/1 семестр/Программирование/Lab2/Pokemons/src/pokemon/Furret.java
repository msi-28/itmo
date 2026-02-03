package pokemon;
import move.special.Thunder;

public final class Furret extends Sentret {
    public Furret(String name, int level){
        super(name, level);
        setStats(85, 76, 64, 45, 55, 90);
        this.addMove(new Thunder());
    }
}

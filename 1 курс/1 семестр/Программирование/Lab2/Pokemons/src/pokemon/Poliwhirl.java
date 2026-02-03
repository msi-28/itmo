package pokemon;
import move.special.Mud_Shot;

public class Poliwhirl extends Poliwag{
    public Poliwhirl (String name, int level){
        super(name, level);
        setStats(65, 65, 65, 50, 50, 90);
        this.addMove(new Mud_Shot());
    }
}

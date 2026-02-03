package move.special;
import ru.ifmo.se.pokemon.*;

public final class Mud_Shot extends SpecialMove{
    public Mud_Shot(){
        super (Type.GROUND, 55, 0.95, 0, 1);
    }
    @Override public void applyOppEffects(Pokemon def){
        def.setMod(Stat.SPEED, -1);
    }
}

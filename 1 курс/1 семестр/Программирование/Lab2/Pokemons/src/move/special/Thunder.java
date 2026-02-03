package move.special;
import ru.ifmo.se.pokemon.*;

public final class Thunder extends SpecialMove {
    public Thunder(){
        super (Type.ELECTRIC, 120, 0.7, 0, 1);
    }
    @Override public void applyOppEffects(Pokemon def){
        if (Math.random() < 0.3){
            Effect.paralyze(def);
        }
    }
    @Override public String describe(){
        return ("Использует специальную атаку Thunder");
    }
}

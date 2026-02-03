package move.special;

import ru.ifmo.se.pokemon.*;

public final class Blizzard extends SpecialMove {
    public Blizzard(){
        super(Type.ICE, 120, 0.7, 0, 1);
    }
    @Override public void applyOppEffects(Pokemon def){
        if (Math.random() < 0.1){
            Effect.freeze(def); // замораживает противника
        }
    }
    @Override public String describe() {
        return ("Использует специальную атаку Blizzard");
    }
}

package move.status;

import ru.ifmo.se.pokemon.*;

public final class Swagger extends StatusMove {
    public Swagger(){
        super (Type.NORMAL, 0, 0.9);
    }
    @Override public void applyOppEffects(Pokemon def){
        def.confuse();
        def.setMod(Stat.ATTACK, +2);
    }
    @Override public String describe(){
        return ("Применяет способность Swagger");
    }
}


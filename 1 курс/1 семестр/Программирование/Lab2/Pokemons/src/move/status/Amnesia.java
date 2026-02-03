package move.status;

import ru.ifmo.se.pokemon.*;

public final class Amnesia extends StatusMove {
    public Amnesia(){
        super(Type.PSYCHIC, 0, 1.0);
    }
    @Override public void applySelfEffects(Pokemon att){
        att.setMod(Stat.SPECIAL_DEFENSE, +2);
    }
    @Override public String describe (){
        return ("Применяет способность Amnesia");
    }
}

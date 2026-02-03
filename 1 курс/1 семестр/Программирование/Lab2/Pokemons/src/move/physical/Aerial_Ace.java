package move.physical;

import ru.ifmo.se.pokemon.*;

public final class Aerial_Ace extends PhysicalMove {
    public Aerial_Ace(){
        super(Type.FLYING, 60, 1.0);
    }
    @Override protected boolean checkAccuracy(Pokemon att, Pokemon def) {
        return true; // Не промахивается
    }
    @Override public String describe(){
        return ("Использует физическую атаку Aerial Ace");
    }
}

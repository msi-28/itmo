package move.physical;

import ru.ifmo.se.pokemon.*;

public final class Fury_Swipes extends PhysicalMove {
    public Fury_Swipes(){
        super (Type.NORMAL, 18, 0.8);
    }
    @Override public double calcBaseDamage(Pokemon att, Pokemon def){
        double multi_hit_chance = Math.random();
        int chance23 = (int)(Math.random()*2+2);
        int chance45 = (int)(Math.random()*4+4);
        if (multi_hit_chance < 0.125) {return (18 * chance45);}
        else if (multi_hit_chance <  0.375) {return (18 * chance23);}
        else {return 18;}
    }
    @Override public String describe(){
        return ("Использует физическую атаку Fury Swipes");
    }
}

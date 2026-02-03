package move.physical;

import ru.ifmo.se.pokemon.*;

public final class Psycho_Cut extends PhysicalMove {
    public Psycho_Cut() {
        super(Type.PSYCHIC, 70, 1.0, 0, 1);
    }
    @Override public double calcSameTypeAttackBonus(Pokemon att, Pokemon def){
        return 1.0/8.0; //шанс крита = 12.5%
    }
    @Override public String describe(){
        return ("Использует физическую атаку Psycho Cut");
    }
}
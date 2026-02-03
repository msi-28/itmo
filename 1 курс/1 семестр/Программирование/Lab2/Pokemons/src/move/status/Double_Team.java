package move.status;
import ru.ifmo.se.pokemon.*;


public final class Double_Team extends StatusMove{
    public Double_Team (){
        super(Type.NORMAL, 0, 1.0);
    }

    @Override public void applySelfEffects(Pokemon att){
        att.setMod(Stat.EVASION, +1); // повышает свое уклонение на 1 ступень
    }
    @Override public String describe(){
        return ("Применяет способность Double Team");
    }

}

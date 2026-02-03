package move.status;

import ru.ifmo.se.pokemon.*;

public final class Rest extends StatusMove {
    public Rest(){
        super(Type.PSYCHIC, 0, 1.0);
    }
    @Override public void applySelfEffects(Pokemon att){
        if (att.getHP() < att.getStat(Stat.HP)) {
            att.restore(); // восттановление здоровья
            Effect.sleep(att); // наложение эффекта сна
        }
    }
    @Override public String describe(){
        return ("Применяет способность Rest");
    }
}

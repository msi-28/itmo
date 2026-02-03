package move.physical;

import ru.ifmo.se.pokemon.*;

public final class X_scissor extends PhysicalMove {
    public X_scissor(){
        super(Type.BUG, 80, 1.0);
    }
    @Override public String describe(){
        return ("Использует физическую атаку X-scissor");
    }
}

import pokemon.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon Guzzlord = new Guzzlord("Guzzlord", 70);
        Pokemon Sentret = new Sentret("Sentret", 23);
        Pokemon Furret = new Furret("Furret", 53);
        Pokemon Poliwag = new Poliwag("Poliwag", 20);
        Pokemon Poliwhirl = new Poliwhirl("Poliwhirl", 16);
        Pokemon Poliwrath = new Poliwrath("Poliwrath", 70);

        b.addAlly(Guzzlord);
        b.addAlly(Sentret);
        b.addAlly(Furret);

        b.addFoe(Poliwag);
        b.addFoe(Poliwhirl);
        b.addFoe(Poliwrath);
        b.go();
    }
}
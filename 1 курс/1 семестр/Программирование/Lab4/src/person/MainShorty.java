package person;
import actoin.Emotions;

public class MainShorty extends Shorty{
    private String name;
    public MainShorty(String name){
        super(name);
    }

    public void getEmotion(Emotions emotion){
        String status = "NONE";
        switch (emotion){
            case SCARED -> status = "страшно перепугался";
            case JOYFUL -> status = "обрадовался";
            case RELIEF -> status = "в безопасности";
            case STRESSED -> status = "тревожится";
            case NORMAL -> status = "в норме";
        }
        System.out.printf("%s %s%n", this.getName(), status);
    }

    @Override
    public void call(Shorty shorty){
        System.out.printf("%s %s %s%n", this.getName(), "позвал персонажа:", shorty.getName());
    }
}

package person.enums;

import person.Shorty;

public enum Emotions {
    SCARED,
    JOYFUL,
    RELIEF,
    STRESSED,
    NORMAL;

    public static String getEmotion(Shorty speaker){
        return switch (speaker.getEmotions()) {
            case NORMAL -> "спокойно";
            case RELIEF -> "облегченно";
            case STRESSED -> "взволнованно";
            case SCARED -> "напуганно";
            case JOYFUL -> "радостно";
            default -> "";
        };
    }
}

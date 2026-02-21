package Events;

public enum EventType {
    CALL("позвал персонажа:"),
    HEAT_UP("припекает со страшной силой персонажа:"),
    GET_OUT("выбрался из"),
    GET_IN("залез в "),
    RUN(""),
    PRESS_THE_BUTTON("нажал на кнопку"),
    OPEN_THE_DOOR("открыл дверь"),
    BOOT_FALL("ботинок свалился с ноги персонажа:"),
    GET_SAFE("здесь в безопасности"),
    GET_STRESSED("переживает из-за друга"),
    GO_TO("перешел в локацию"),
    NO_ANSWER("не ответил");
    private final String text;

    EventType(String text){
        this.text = text;
    }

    public String getText(){return text;}
}

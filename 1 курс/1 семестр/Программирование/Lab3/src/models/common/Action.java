package models.common;

import models.people.Person;

public enum Action {
    CALL_BACK ("окливкнув"),
    MAKE_SURE("убедившись"),
    GO_SEARCH("отправитсья на поиски"),
    GO_BACK("решил поскорей возвратиться", "решила поскорей возвратиться"),
    GET_OUT("выбравшись"),
    HOBBLE("он заковылял", "она заковыляла"),
    COULD_NOT_STAND("не выдержал", "не выдержала"),
    RUN_AND_JUMP("пустился бежать вприпрыжку", "пустилась бежать вприпрыжку"),
    DIDNT_THINK_TO_PICKUP("не подумал его поднимать", "не подумала его поднимать"),
    TO_RUN("бежать"),
    STOP_RUNNING("добежал", "добежала"),
    PUSH_THE_BUTTON("нажал", "нажала"),
    CLIMBED_IN("залез", "залезла"),
    WAS("был", "была"),
    RUN_AWAY("убежал", "убежала"),
    LEAVE("оставив");

    private final String maleText;
    private final String femaleText;

    Action(String text){
        this.maleText = text;
        this.femaleText = text;
    }
    Action(String maleText, String femaleText) {
        this.maleText = maleText;
        this.femaleText = femaleText;
    }

    public String getAction(Person person){
        return person.isMale() ? maleText : femaleText;
    }
}

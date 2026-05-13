package modules;

/**
 * Перечисление должностей, которые работник может занимать в компании.
 *
 * Используется в классе {@link Worker} для указания должности работника.
 * Может принимать одно из четырех значений:
 * {@link #ENGINEER} - инженер
 * {@link #DEVELOPER} - разработчик
 * {@link #LEAD_DEVELOPER} - главный разработчик
 * {@link #BAKER} - пекарь
 * @author vmn
 */
public enum Position implements Gettable<Position>, Comparable<Position>{
    ENGINEER,
    DEVELOPER,
    LEAD_DEVELOPER,
    BAKER;

    /**
     * Через запятую в формате строки выводит все типы позиций,
     * которые работник может занимать в компании строчными буквами
     * @return Строка со всеми элементами enum'a
     */
    public static String getPositions(){
        return Gettable.getValues(Position.class);
    }
}
package modules;

/**
 * Перечисление типов статуса работника.
 *
 * Используется в классе {@link Worker} для указания текущего служебного положения.
 * Может принимать одно из трех значений:
 * {@link #FIRED} - уволен,
 * {@link #HIRED} - нанят,
 * {@link #RECOMMENDED_FOR_PROMOTION} - рекомендован к повышению.
 * @author vmn
 */

public enum Status implements Gettable<Position>{
    FIRED, // работник уволен
    HIRED, // работник нанят
    RECOMMENDED_FOR_PROMOTION; // работник рекомендован к повышению

    /**
     * Через запятую в формате строки выводит все типы статуса строчными буквами
     * @return Строка со всеми элементами enum'a
     */
    public static String getStatus(){
        return Gettable.getValues(Status.class);
    }
}
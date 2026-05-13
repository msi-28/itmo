package modules;

/**
 * Перечисление цветов, которые могут использоваться для описания цвета глаз и волос работника.
 *
 * Используется в классе {@link Person} для указания персональных данных работника.
 * Может принимать одно из шести значений:
 * {@link #RED} - красный,
 * {@link #BLACK} - черный,
 * {@link #BLUE} - синий,
 * {@link #YELLOW} - желтый,
 * {@link #GREEN} - зеленый,
 * {@link  #BROWN} - коричневый.
 * @author vmn
 */
public enum Color implements Gettable<Position>{
    RED,
    BLACK,
    BLUE,
    YELLOW,
    GREEN,
    BROWN;

    /**
     * Через запятую в формате строки выводит все цвета,
     * которые могут использоваться для описания цвета глаз и волос работника строчными буквами
     * @return Строка со всеми элементами enum'a
     */
    public static String getColors(){
        return Gettable.getValues(Color.class);
    }
}

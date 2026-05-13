package modules;

import java.util.StringJoiner;

/**
 * Интерфейс для работы с перечислениями ({@code enum}).
 *
 * Предоставляет статический метод {@link #getValues(Class)} для получения строкового представления
 * всех констант перечисления в нижнем регистре, разделенных запятой. Используется в {@link Status},
 * {@link Position}, {@link Color}.
 * @author vmn
 * @param <T> конкретный тип перечисления для которого применяется интерфейс
 */

public interface Gettable<T extends Enum<T>> {

    /**
     * Возвращает строку, содержащую все константы перечисления,
     * записанные строчными буквами и разделенные запятой.
     * Порядок следования констант соответствует порядку их объявления в перечислении.
     * @param enumClass класс перечисления, для которого нужно получить список значений
     * @return строка вида {@code value1, value2, value3} (все буквы строчные)
     * @param <T> тип перечисления
     */
    static <T extends Enum<T>> String getValues(Class<T> enumClass){
        StringJoiner valuesString = new StringJoiner(", ");
        for (T t : enumClass.getEnumConstants()){
            valuesString.add(t.toString().toLowerCase());
        }
        return valuesString.toString();
    }
}

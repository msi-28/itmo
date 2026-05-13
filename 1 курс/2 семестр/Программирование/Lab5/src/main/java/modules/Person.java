package modules;

/**
 * Класс, с помощью которого описываются персональные данные работника.
 * Объекты {@code Person} хранят информацию о персональных данных работника: рост, цвет глаз, цвет волос.
 *
 * Обязательные поля:
 * {@code height} - рост
 * {@code hairColor} - цвет волос
 *
 * Необязательные поля:
 * {@code eyeColor} - цвет глаз
 *
 * Для задания персональных данных используется конструктор, принимающий данные о работнике.
 *
 * Класс предоставляет методы для сериализации в формате .csv {@link #toStringCSV}
 * и подготовки к выводу коллекции в консоль {@link #toString()}.
 * @author vmn
 * @see Worker
 */

public class Person implements Comparable<Person>{
    private int height; //Значение поля должно быть больше 0
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле не может быть null

    /**
     * Конструктор. Задает персональные данные работника.
     * @param height рост (значение должно быть больше 0)
     * @param eyeColor цвет глаз (может быть {@code null})
     * @param hairColor цвет волос (не может быть {@code null})
     */
    public Person(int height, Color eyeColor, Color hairColor) {
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }
    /**
     * Возвращает строковое представление объекта в формате
     * "height,eye_color,hair_color".
     * @return описание объекта для вывода в консоль
     */
    @Override
    public String toString(){
        return "height: " + this.height + ", eye_color: " + this.eyeColor + ", hair_color: " + this.hairColor;
    }
    /**
     * Возвращает строковое представление объекта в формате
     * "height;eye_color;hair_color".
     * @return описание объекта для записи в файл
     */
    public String toStringCSV(){
        return this.height + ";" + this.eyeColor + ";" + this.hairColor;

    }

    /**
     * Если в классе Worker в методе compareTo сравнение дошло до поля Person,
     * то вызывается этот метод, который последовательно сравнивает характеристики работников.
     * Так же этот метод вызывается при выводе максимального элемента по полю Person
     * @param otherPerson
     * @return 0 если характеристики работников равны, 1 если характеристика текущего работника больше,
     * -1 если характеристика текущего работника меньше
     */
    @Override
    public int compareTo(Person otherPerson){
        int compareHeight = Integer.compare(this.height, otherPerson.height);
        int compareEyeColor = this.eyeColor.compareTo(otherPerson.eyeColor);
        int compareHairColor = this.hairColor.compareTo(otherPerson.hairColor);

        if (compareHeight != 0) return compareHeight;
        if (compareEyeColor != 0) return compareEyeColor;
        return compareHairColor;
    }
}
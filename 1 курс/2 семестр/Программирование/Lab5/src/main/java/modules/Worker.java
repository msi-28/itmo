package modules;

import java.lang.reflect.Field;
import java.util.*;

import static runner.Runner.collectionManager;
/**
 * Класс, представляющий работника.
 * Объекты {@code Worker} хранят информацию о работнике: уникальный id, имя, координаты (x, y), дату создания, зарплату,
 * должность, статус и персональные данные (рост, цвет глаз, цвет волос).
 * Сортировка по умолчанию реализована по всем полям (естественный порядок).
 *
 * Обязательные поля:
 * {@code id} - уникальный идентификационный номер
 * {@code name} - имя работника
 * {@code coordinates} - координаты работника
 * {@code creationDate} - дата создания объекта
 *
 * Необязательные поля:
 * {@code salary} - заработная плата работника
 * {@code position} - должность работника в компании
 * {@code status} - текущий статус работника
 * {@code person} - персональные данные
 *
 * Для создания нового работника используется конструктор без {@code id} и {@code creationDate}
 * (так как они генерируются автоматически).
 *
 * Класс предоставляет методы для сериализации в формате .csv {@link #toStringCSV}
 * и подготовки к выводу коллекции в консоль {@link #toString()}.
 *
 * @author vmn
 */

public class Worker implements Comparable<Worker> {
    /*
     * Универсальный идентификатор работника.
     * Поле не может быть null,
     * значение поля должно быть больше 0,
     * значение этого поля должно быть уникальным,
     * значение генерируется автоматически.
     */
    private long id;

    /*
     * Имя работника.
     * Поле не может быть null,
     * строка не может быть пустой.
     */
    private String name;

    /*
     * Координаты работника.
     * Поле не может быть null.
     */
    private Coordinates coordinates;

    /*
     * Дата создания.
     * Поле не может быть null,
     * значение этого поля должно генерироваться автоматически.
     */
    private Date creationDate;

    /*
     * Зарплата работника.
     * Поле может быть null,
     * значение поля должно быть больше 0.
     */
    private Integer salary;

    /*
     *  Должность работника в компании.
     * Поле может быть null.
     */
    private Position position;

    /*
     * Статус работника.
     * Поле может быть null
     */
    private Status status;

    /*
     * Персональные данные.
     * Поле может быть null
     */
    private Person person;

    /**
     * Конструктор. Создает работника с автоматической генерацией {@code id} и {@code creationDate}.
     * Id генерируется по формуле размер_коллекции + 1, что гарантирует уникальность в пределах одно запуска приложения.
     * {@code creationDate} устанавливает текущую дату.
     *
     * @param name имя работника (не может быть {@code null} или пустым)
     * @param coordinates координаты работника (не могут быть {@code null})
     * @param salary зарплата работника (может быть {@code null}, поле должно быть больше 0)
     * @param position должность (может быть {@code null})
     * @param status статус (может быть {@code null})
     * @param person персональные данные (может быть {@code null})
     */

    public Worker(String name, Coordinates coordinates,
                  Integer salary, Position position, Status status, Person person) {
//        this.id = (long) (Math.random()*100);
//        this.id = collectionManager.getCollection().size() + 1;
        this.id = this.hashCode();
//        this.id = 1L;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.salary = salary;
        this.position = position;
        this.status = status;
        this.person = person;
    }

    public Worker(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getSalary() {
        return salary;
    }


    /**
     * Последовательно сравнивает поля текущего работника, с полями работника переданного в метод
     *
     * @param otherWorker
     * @return 0 если поля работников одинаковы, 1 если поле текущего работника больше, -1 если поле текущего работника меньше
     */
    @Override
    public int compareTo(Worker otherWorker) {
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field);
            try {
                Object val1 = field.get(this);
                Object val2 = field.get(otherWorker);
                if (val1.equals(val2)) continue;
                if (val1 == null) return -1;
                if (val2 == null) return 1;

                if (val1 instanceof Comparable && !val1.getClass().equals(this.creationDate.getClass())) {
                    int res = ((Comparable<Object>) val1).compareTo(val2);
                    if (res != 0) return res;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;

    }

    /**
     * Возвращает строковое представление коллекции в формате
     * "id;name;date;salary;position;status;person".
     * @return описание объекта для вывода в консоль
     */
    @Override
    public String toString(){
        return  "id: " + this.id +
                "; name: " + this.name +
                "; coordinates: " + this.coordinates +
                "; date: " + this.creationDate +
                "; salary: " + this.salary +
                "; position: " + this.position +
                "; status: " + this.status +
                "; person: " + this.person;
    }

        /**
         * Возвращает строковое представление коллекции в формате
         * "id;name;x;y;date;salary;position;status;height;eyeColor;hairColor".
         * @return описание объекта для записи в файл
         */

        public String toStringCSV(){
            return this.id +
                    ";" + this.name +
                    ";" + this.coordinates.toStringCSV() +
                    ";" + this.creationDate +
                    "; " + this.salary +
                    "; " + this.position +
                    ";" + this.status +
                    ";" + this.person.toStringCSV() + "\n";
        }
    /*
    public String toStringCSV() throws IllegalAccessException {
        StringJoiner allFields = new StringJoiner(";");
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String content = field.get(this).toString();
            if (field.toString().contains(".coordinates") || field.toString().contains(".person")) {

                for (String st : content.split(", ")) {
                    allFields.add(st.split(": ")[1]);
                }
            } else allFields.add(content);
        }
        return allFields + "\n";
    }

    @Override
    public String toString() {
        StringJoiner allFields = new StringJoiner("; ");
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                String content = field.getName() + ": " + field.get(this).toString();
                allFields.add(content);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return allFields.toString();
    }

    public String toStringForFile() throws IllegalAccessException {
        StringJoiner allFields = new StringJoiner(";");
        List<String> worker = List.of(this.toString().split("; "));
        for (String field : worker){
            List<String> splitField = List.of(field.split(": "));
            if (splitField.size() == 2){
                allFields.add(splitField.get(1));
            }
            if (splitField.size() > 2){
                splitField = List.of(field.split(" "));
                for (int i = 0 ; i < splitField.size() ; i++){
                    if (i%2 == 0 && i != 0){
                        allFields.add(splitField.get(i).replace(',', ' ').trim());
                    }
                }
            }

        }
        System.out.println(allFields);
        return allFields.toString() + "\n";
    }
     */

}
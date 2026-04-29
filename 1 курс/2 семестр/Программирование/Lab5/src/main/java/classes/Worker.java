package classes;

import java.lang.reflect.Field;
import java.util.*;

import static runner.Runner.collectionManager;
import static runner.Runner.scanner;

public class Worker implements Comparable<Worker>{
    private long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer salary; //Поле может быть null, Значение поля должно быть больше 0
    private Position position; //Поле может быть null
    private Status status; //Поле может быть null
    private Person person; //Поле может быть null

    public Worker (String name, Coordinates coordinates,
                  Integer salary, Position position, Status status, Person person) {
//        this.id = (long) (Math.random()*100);
        this.id = collectionManager.getCollection().size() + 1;
//        this.id = this.hashCode();
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

    public Date getCreationDate() {
        return creationDate;
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

    @Override
    public int compareTo(Worker other) {
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field);
            try {
                Object val1 = field.get(this);
                Object val2 = field.get(other);
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

    public String toStringForFile() throws IllegalAccessException {
        StringJoiner allFields = new StringJoiner(";");
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            String content = field.get(this).toString();

            if (field.toString().contains(".coordinates") || field.toString().contains(".person") ) {

                for (String st : content.split(", ")){
                    allFields.add(st.split(": ")[1]);
                }
            }
            else allFields.add(content);
        }
        return allFields + "\n";
    }
}
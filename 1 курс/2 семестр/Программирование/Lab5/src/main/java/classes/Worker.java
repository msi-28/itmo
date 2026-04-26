package classes;

import java.util.Date;

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
//        this.id = 1L;
        this.id = this.hashCode();
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
        // Сортировка по имени (лексикографически)
        return Long.compare(this.id, other.id);
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

    public static Worker workerMaker(){
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        Coordinates coordinates = Coordinates.coordinatesMaker();
        System.out.print("Введите его ЗП: ");
        Integer salary = scanner.nextInt();
        Position position = Position.positionMaker();
        Status status = Status.statusMaker();
        Person person = Person.personMaker();
        return new Worker(name, coordinates, salary, position, status, person);
    }



    //    @Override
//    public boolean validate() {
//        if (id == null || name == null || coordinates == null || creationDate == null || salary == null
//        || position == null || status == null || person == null) return false;
//
//        if (id <= 0 || salary <= 0 || name.isEmpty()) return false;
//
//        return true;
//    }
}
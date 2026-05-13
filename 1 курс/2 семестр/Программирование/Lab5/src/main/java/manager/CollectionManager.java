package manager;

import modules.Status;
import modules.Worker;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс, содержащий в себе реализацию всех методов для работы с работы с коллекцией
 * @author vmn
 */
public class CollectionManager {
    private final LinkedList<Worker> workers;

    /**
     * Конструктор
     */
    public CollectionManager(){
        this.workers = new LinkedList<>();
    }

    public LinkedList<Worker> getCollection(){
        return workers;
    }

    /**
     * Добавление работника в коллекцию
     * @param worker
     */
    public void addWorker(Worker worker){
        this.workers.add(worker);
        Collections.sort(workers);
    }

    /**
     * Удаления первого элемента из коллекции
     */
    public void removeHead(){
        this.workers.removeFirst();
    }

    /**
     *  Удаления всех элементов, которые меньше заданного (этот элемент передается в функцию)
     * @param ref_worker
     * @return Строка, в которой обозначается сколько элементов было удалено
     */
    public String removeLower(Worker ref_worker){
        LinkedList<Worker> copy_workers = (LinkedList<Worker>) workers.clone();
        for (Worker worker : workers) {
            if (worker.compareTo(ref_worker) > 0){
                copy_workers.remove(worker);
            }
        }
        int i = workers.size() - copy_workers.size();
        workers.clear();
        workers.addAll(copy_workers);
        return "Удалено " + i + " элементов";
    }

    /**
     * Отчищает всю коллекцию
     */
    public void clearWorker(){
        this.workers.clear();
    }

    /**
     *  Вывод коллекции в консоль
     */
    public void showCollection(){
        for (Worker worker : workers){
            System.out.println(worker);
        }
    }

    /**
     * Завершение работы программы и прерывание ввода, без сохранения в файл
     */
    public void exit(){
        System.exit(0);
    }

    /**
     * Поиск элемента по его id
     * @param id
     * @return Элемент, если такой id есть в коллекции, null если такого id нет
     */
    public Worker findById(long id){
        for (Worker worker : workers) {
            if (worker.getId() == id) {
                return worker;
            }
        }
        System.out.println("Такого id нет в коллекции");
        return null;
    }

    /**
     * Удаление элемента из коллекции по его id
     * @param id
     */
    public void removeById(long id){
        Worker element = findById(id);
        if (element != null){
            workers.remove(findById(id));
        }
    }

    /**
     * Обновление значения элемента по его id
     * @param id
     * @param newWorker
     */
    public void update(long id, Worker newWorker){
         removeById(id);
         newWorker.setId(id);
         addWorker(newWorker);
    }

    /**
     * Добавление элемента в коллекцию если его значение меньше минимального
     * @param worker
     * @return
     */
    public String addIfMin(Worker worker) {
        if (!workers.isEmpty()) {
            Worker min_worker = Collections.min(workers);
            if (worker.compareTo(min_worker) < 0) {
                addWorker(worker);
                return "Новый элемент добавлен";
            }
            return "Новый элемент не меньше нового!";
        }
        addWorker(worker);
        return "Новый элемент добавлен";
    }

    /**
     * Поиск максимального элемента коллекции по полю Person
     * @return Значение максимального элемента коллекции по полю Person, если коллекция пуста, возвращает null
     */
    public Worker maxByPerson(){
        return workers.stream().max(Comparator.comparing(Worker::getPerson)).orElse(null);
    }

    /**
     * Подсчет элементов коллекции с определенным значением поля Status
     * @param status
     * @return Количество элементов коллекции с определенным значением поля Status
     */
    public long countByStatus(Status status){
        return workers.stream().filter(worker -> worker.getStatus() == status).count();
    }

    /**
     * Формирование списка полей Salary элементов в порядке возрастания
     * @return Список полей Salary элементов в порядке возрастания, если коллекция пуста, возвращает пустой список
     */
    public List<Integer> printFieldSalary(){
        List<Integer> salary = new ArrayList<>();
        for (Worker worker : workers){
            salary.add(worker.getSalary());
        }
        return salary.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Сохраняет коллекцию в файл формата .csv, имя которого передается в метод
     * @param fileName
     */
    public void saveFile(String fileName) {
        OutputManager<Worker> oum = new OutputManager<>(fileName);
        StringBuilder elements = new StringBuilder();
        String header = "*id*;Name;X;Y;Date;Salary;Position;Status;Height;Eye Color;Hair Color\n";
        for (Worker worker : workers){
            elements.append(worker.toStringCSV());
        }
        oum.writeFile(header + elements);
    }
}

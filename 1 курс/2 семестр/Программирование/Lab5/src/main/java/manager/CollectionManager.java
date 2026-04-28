package manager;

import classes.Status;
import classes.Worker;

import java.util.*;
import java.util.stream.Collectors;


public class CollectionManager {
    private final LinkedList<Worker> workers;

    public CollectionManager(){
        this.workers = new LinkedList<>();
    }

    public void addWorker(Worker worker){
        this.workers.add(worker);
        Collections.sort(workers);
    }

    public void removeHead(){
        this.workers.removeFirst();
    }

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

    public void clearWorker(){
        this.workers.clear();
    }

    public void showCollection(){
        for (Worker worker : workers){
            System.out.println(worker);
        }
    }

    public LinkedList<Worker> getCollection(){
        return workers;
    }

    public void exit(){
        System.exit(0);
    }

    public Worker findById(long id){
        for (Worker worker : workers) {
            if (worker.getId() == id) {
                return worker;
            }
        }
        System.out.println("Такого id нет в коллекции");
        return null;
    }

    public void update(long id, Worker newWorker){
         removeById(id);
         newWorker.setId(id);
         addWorker(newWorker);
    }

    public void removeById(long id){
        Worker element = findById(id);
        if (element != null){
            workers.remove(findById(id));
        }
    }

    public String addIfMin(Worker worker) {
        if (!workers.isEmpty()) {
            Worker min_worker = Collections.min(workers);
            if (min_worker.getId() > worker.getId()) {
                addWorker(worker);
                return "Новый элемент добавлен";
            }
            return "Новый элемент не меньше нового!";
        }
        addWorker(worker);
        return "Новый элемент добавлен";
    }

    public Worker maxByPerson(){
        return workers.stream().max(Comparator.comparing(w -> w.getPerson().getHeight())).orElse(null);
    }

    public long countByStatus(Status status){
        return workers.stream().filter(worker -> worker.getStatus() == status).count();
    }

    public List<Integer> printFieldSalary(){
        List<Integer> salary = new ArrayList<>();
        for (Worker worker : workers){
            salary.add(worker.getSalary());
        }
        return salary.stream().sorted().collect(Collectors.toList());
    }

    public void saveFile(String fileName) {
        OutputManager<Worker> oum = new OutputManager<>(fileName);
        StringBuilder elements = new StringBuilder();
        for (Worker worker : workers){
            try {
                elements.append(worker.toStringForFile());
            }
            catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        oum.writeFile(elements.toString());
    }
}

package Firm;
import Human.Worker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Firm {
    private List<Worker> workers;
    private String name;

    public Firm(String name, Worker[] workers){
        this.name = name;
        this.workers = new ArrayList(Arrays.asList(workers));
    }

    public void AddWorker(Worker worker) {
        this.workers.add(worker);
    }

    public void DeleteWorkerById(int id) {
        this.workers.remove(id);
    }

    public List<Worker> GetWorkers() {
        return this.workers;
    }

    public String GetName() {
        return this.name;
    }
}

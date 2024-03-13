package Tasks;
import TaskManagement.TaskStatus;
import java.util.ArrayList;

public class EpicTask extends Task {
    private ArrayList<Integer> subtasks;

    public EpicTask(String title, String description) {
        super(title, description);
    }

    public void addSubtask(Integer id) {
        subtasks.add(id);
    }

    public void setStatus(TaskStatus newStatus) {
        this.status = newStatus;
    }

    public ArrayList<Integer> getSubtasks() {
        return subtasks;
    }

    public void removeLinkedSubtask(Integer id) {
        subtasks.remove(id);
    }

    public void deleteSubtasks() {
        subtasks.clear();
    }

}
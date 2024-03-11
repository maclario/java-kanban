import java.util.ArrayList;

public class EpicTask {
    private String title;
    private String description;
    private TaskStatus status;
    private ArrayList<Integer> subtasks;

    public EpicTask(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = TaskStatus.NEW;
    }

    public EpicTask(EpicTask currEpicTask, TaskStatus newStatus) {
        this.status = newStatus;
        this.title = currEpicTask.getTitle();
        this.description = currEpicTask.getDescription();
    }

    public void setSubtask(Integer subtaskID) {
        subtasks.add(subtaskID);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

}



/*
    Переопределение toString для эмуляции тестов
    @Override
    public String toString() {
        return "EpicTask{" + "status=" + getStatus() + ", title=" + getTitle() + "}";
    }
 */
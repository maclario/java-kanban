public class Task {
    private String title;
    private String description;
    private TaskStatus status;

    public Task(String title, String description) {
        this.status = TaskStatus.NEW;
        this.title = title;
        this.description = description;
    }

    public Task(String title, String description, TaskStatus newStatus) {
        this.status = newStatus;
        this.title = title;
        this.description = description;
    }

    protected Task() {
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
        return "Task{" + "status=" + getStatus() + ", title=" + getTitle() + "}";
    }
 */
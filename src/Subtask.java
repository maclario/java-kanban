public class Subtask extends Task {
    private String title;
    private String description;
    private TaskStatus status;
    private Integer generalTaskID;

    public Subtask(String title, String description, Integer generalTaskID) {
        super(title, description);
        this.generalTaskID = generalTaskID;
        this.status = TaskStatus.NEW;
    }

    public Subtask(String title, String description, Integer generalTaskID, TaskStatus newStatus) {
        super(title, description);
        this.generalTaskID = generalTaskID;
        this.status = newStatus;
    }

    public Integer getGeneralTaskID() {
        return generalTaskID;
    }

}

/*
    Переопределение toString для эмуляции тестов
    @Override
    public String toString() {
        return "Subtask{" + "status=" + getStatus() + ", title=" + getTitle() + " of epic " + getGeneralTaskID() + " }";
    }
 */
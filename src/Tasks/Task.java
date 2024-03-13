package Tasks;
import TaskManagement.TaskStatus;

import java.util.Objects;

public class Task {
    protected Integer id;
    protected String title;
    protected String description;
    protected TaskStatus status;

    public Task(String title, String description) {
        this.status = TaskStatus.NEW;
        this.title = title;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, status);
    }
}

/*
У класса задач должны должны быть переопределены методы equals() и hashCode(),
которые выдают равенство задач с одинаковыми айди
 */
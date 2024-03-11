import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    public TaskManager() {
    }

    HashMap<Integer, Task> allStandartTasks = new HashMap<>();
    HashMap<Integer, EpicTask> allEpicTasks = new HashMap<>();
    HashMap<Integer, Subtask> allSubtasks = new HashMap<>();
    private Integer taskID = 0;
    public Integer generateID() {
        taskID++;
        return taskID;
    }

    public void CreateStandartTask(String title, String description) {
        allStandartTasks.put(generateID(), new Task(title, description));
    }

    public void CreateSubtask(String title, String description, Integer generalTaskID) {
        allSubtasks.put(generateID(), new Subtask(title, description, generalTaskID));
    }

    public void CreateEpicTask(String title, String description) {
        allEpicTasks.put(generateID(), new EpicTask(title, description));
    }

    public HashMap<Integer, Task> getAllStandartTasks() {
        return allStandartTasks;
    }

    public HashMap<Integer, EpicTask> getAllEpicTasks() {
        return allEpicTasks;
    }

    public HashMap<Integer, Subtask> getAllSubtasks() {
        return allSubtasks;
    }

    public Task getStandartTask(Integer ID) {
        return allStandartTasks.get(ID);
    }

    public EpicTask getEpicTask(Integer ID) {
        return allEpicTasks.get(ID);
    }

    public Subtask getSubtask(Integer ID) {
        return allSubtasks.get(ID);
    }

    public void deleteAllStandartTasks() {
        allStandartTasks.clear();
    }

    public void deleteAllEpicTasks() {
        allEpicTasks.clear();
    }

    public void deleteAllSubtasks() {
        allSubtasks.clear();
    }

    public void deleteStandartTask(Integer ID) {
        allStandartTasks.remove(ID);
    }

    public void deleteEpicTask(Integer ID) {
        allEpicTasks.remove(ID);
    }

    public void deleteSubtask(Integer ID) {
        int generalTaskID = allSubtasks.get(ID).getGeneralTaskID();
        allSubtasks.remove(ID);
        updateEpicTask(generalTaskID);
    }

    public ArrayList<Subtask> getSubtasksOfEpic(Integer ID) {
        ArrayList<Subtask> subtasksOfEpic = new ArrayList<>();
        for (Subtask subtask : allSubtasks.values()) {
            if (subtask.getGeneralTaskID() == ID) {
                subtasksOfEpic.add(subtask);
            }
        }
        return subtasksOfEpic;
    }

    public void updateStandartTask(Integer ID, String title, String description, TaskStatus newStatus) {
        allStandartTasks.put(ID, new Task(title, description, newStatus));
    }

    public void updateSubtask(Integer ID, String title, String description, TaskStatus newStatus) {
        Subtask subtask = allSubtasks.get(ID);
        Integer generalTaskID = subtask.getGeneralTaskID();
        allSubtasks.put(ID, new Subtask(title, description, generalTaskID, newStatus));
        updateEpicTask(generalTaskID);
    }

    private void updateEpicTask(Integer ID) {
        int newSubtaskCounter = 0;
        int doneSubtaskCounter = 0;
        int subtasksOfEpicSize = getSubtasksOfEpic(ID).size();
        if (subtasksOfEpicSize == 0) {
            allEpicTasks.put(ID, new EpicTask(getEpicTask(ID), TaskStatus.NEW));
            return;
        }
        for (Subtask subtask : getSubtasksOfEpic(ID)) {
            if (subtask.getStatus() == TaskStatus.NEW) {
                newSubtaskCounter++;
            } else if (subtask.getStatus() == TaskStatus.DONE) {
                doneSubtaskCounter++;
            }
        }
        if (newSubtaskCounter == subtasksOfEpicSize) {
            allEpicTasks.put(ID, new EpicTask(getEpicTask(ID), TaskStatus.NEW));
        } else if (doneSubtaskCounter == subtasksOfEpicSize) {
            allEpicTasks.put(ID, new EpicTask(getEpicTask(ID), TaskStatus.DONE));
        } else {
            allEpicTasks.put(ID, new EpicTask(getEpicTask(ID), TaskStatus.IN_PROGRESS));
        }
    }

}
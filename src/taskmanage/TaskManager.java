package taskmanage;

import tasks.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {

    private HashMap<Integer, Task> allStandartTasks = new HashMap<>();
    private HashMap<Integer, EpicTask> allEpicTasks = new HashMap<>();
    private HashMap<Integer, Subtask> allSubtasks = new HashMap<>();
    private Integer taskId = 0;
    private Integer generateId() {
        return ++taskId;
    }

    public void createStandartTask(Task task) {
        Integer newId = generateId();
        task.setId(newId);
        allStandartTasks.put(newId, task);
    }

    public void createSubtask(Subtask subtask) {
        Integer newId = generateId();
        subtask.setId(newId);
        EpicTask epicTask = getEpicTask(subtask.getEpicId());
        epicTask.addSubtask(newId);
        allSubtasks.put(newId, subtask);
        updateEpicTaskStatus(subtask.getEpicId());
    }

    public void createEpicTask(EpicTask epictask) {
        Integer newId = generateId();
        epictask.setId(newId);
        allEpicTasks.put(newId, epictask);
    }

    public ArrayList<Task> getAllStandartTasks() {
        return new ArrayList<>(allStandartTasks.values());
    }

    public ArrayList<EpicTask> getAllEpicTasks() {
        return new ArrayList<>(allEpicTasks.values());
    }

    public ArrayList<Subtask> getAllSubtasks() {
        return new ArrayList<>(allSubtasks.values());
    }

    public Task getStandartTask(Integer id) { // Готово условно
        return allStandartTasks.get(id);
    }

    public EpicTask getEpicTask(Integer id) { // Готово условно
        return allEpicTasks.get(id);
    }

    public Subtask getSubtask(Integer id) { // Готово условно
        return allSubtasks.get(id);
    }

    public void deleteAllStandartTasks() { // Готово условно
        allStandartTasks.clear();
    }

    public void deleteAllEpicTasks() {
        allSubtasks.clear();
        allEpicTasks.clear();
    }

    public void deleteAllSubtasks() {
        for (EpicTask epictask : allEpicTasks.values()) {
            epictask.deleteSubtasks();
            epictask.setStatus(TaskStatus.NEW);
        }
        allSubtasks.clear();
    }

    public void deleteStandartTask(Integer id) {
        allStandartTasks.remove(id);
    }

    public void deleteEpicTask(Integer id) {
        for (Integer subtaskId : getEpicTask(id).getSubtasks()) {
            allSubtasks.remove(subtaskId);
        }
        allEpicTasks.remove(id);
    }

    public void deleteSubtask(Integer id) {
        int epicId = allSubtasks.get(id).getEpicId();
        getEpicTask(epicId).removeLinkedSubtask(id);
        allSubtasks.remove(id);
        updateEpicTaskStatus(epicId);
    }

    public ArrayList<Subtask> getSubtasksOfEpic(Integer id) {
        ArrayList<Subtask> subtasksOfEpic = new ArrayList<>();
        EpicTask epictask = allEpicTasks.get(id);
        if (epictask != null) {
            for (Integer subtaskId : getEpicTask(id).getSubtasks()) {
                subtasksOfEpic.add(getSubtask(subtaskId));
            }
        }
        return subtasksOfEpic;
    }

    public void updateStandartTask(Task task) {
        allStandartTasks.put(task.getId(), task);
    }

    public void updateSubtask(Subtask subtask) {
        Integer epicID = subtask.getEpicId();
        allSubtasks.put(subtask.getId(), subtask);
        updateEpicTaskStatus(epicID);
    }

    public void updateEpicTask(EpicTask newEpictask) {
        EpicTask currEpicTask = allEpicTasks.get(newEpictask.getId());
        currEpicTask.setTitle(newEpictask.getTitle());
        currEpicTask.setDescription(newEpictask.getDescription());
    }

    private void updateEpicTaskStatus(Integer id) {
        EpicTask epictask = allEpicTasks.get(id);
        if (epictask != null) {
            ArrayList<Subtask> subtasksOfEpic = getSubtasksOfEpic(id);
            int subtasksOfEpicSize = subtasksOfEpic.size();
            int newSubtaskCounter = 0;
            int doneSubtaskCounter = 0;
            if (subtasksOfEpicSize == 0) {
                epictask.setStatus(TaskStatus.NEW);
            } else {
                for (Subtask subtask : subtasksOfEpic) {
                    if (subtask.getStatus() == TaskStatus.NEW) {
                        newSubtaskCounter++;
                    } else if (subtask.getStatus() == TaskStatus.DONE) {
                        doneSubtaskCounter++;
                    }
                }
                if (subtasksOfEpicSize == newSubtaskCounter) {
                    epictask.setStatus(TaskStatus.NEW);
                } else if (subtasksOfEpicSize == doneSubtaskCounter) {
                    epictask.setStatus(TaskStatus.DONE);
                } else {
                    epictask.setStatus(TaskStatus.IN_PROGRESS);
                }
            }
        }
    }

}
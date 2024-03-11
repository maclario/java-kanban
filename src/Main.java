public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        // 1. Создать 2 задачи
        taskManager.CreateStandartTask("Бассейн", "Cвободные дорожки: 9 и 10");
        taskManager.CreateStandartTask("Ретро по спринту", "Ссылка на zoom-встречу");
        // 2. Создать эпик с 2 подзадачами
        taskManager.CreateEpicTask("Форматирование отчета", "Отчет по А/Б-тесту");
        taskManager.CreateSubtask("Отформатировать заголовки", "Roboto 18 bold", 3);
        taskManager.CreateSubtask("Отформатировать текст", "Roboto 13 regular", 3);
        taskManager.getSubtasksOfEpic(3);
        // 3. Создать эпик с 1 подзадачей
        taskManager.CreateEpicTask("Визит к неврологу", "ул. Гудкова, 3а");
        taskManager.CreateSubtask("Забрать результаты рентгена", "Кабинет №14", 6);
        // 4. Получить задачи всех типов
        taskManager.getAllStandartTasks();
        taskManager.getAllEpicTasks();
        taskManager.getAllSubtasks();
        // 5. Изменить статусы созданных объектов. Получить задачи всех типов
        taskManager.updateStandartTask(1, "Бассейн", "Свободные дорожки: 9 и 10", TaskStatus.IN_PROGRESS);
        taskManager.updateSubtask(4, "Отформатировать заголовки", "Roboto 18 bold", TaskStatus.DONE);
        taskManager.updateSubtask(7, "Забрать результаты рентгена", "Кабинет №14", TaskStatus.DONE);
        // 6. Удалить 1 задачу и 1 эпик. Получить задачи всех типов
        taskManager.deleteStandartTask(2);
        taskManager.deleteEpicTask(6);
        taskManager.deleteSubtask(5);
        taskManager.getAllStandartTasks();
        taskManager.getAllEpicTasks();
        taskManager.getAllSubtasks();
        // 6. Удалить все задачи, все эпики, все подзадачи. Получить задачи всех типов
        taskManager.deleteAllStandartTasks();
        taskManager.deleteAllEpicTasks();
        taskManager.deleteAllSubtasks();
        taskManager.getAllStandartTasks();
        taskManager.getAllEpicTasks();
        taskManager.getAllSubtasks();
    }
}

/*
Переместить эмуляцию тестов сюда
 */
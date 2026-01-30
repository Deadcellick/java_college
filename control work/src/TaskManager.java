public class TaskManager
{
    public static void main(String[] args) {
        TaskController controller = new TaskController();

        controller.addMainTask("Подготовка к экзамену");
        controller.addSubTask("Подготовка к экзамену", "Прочитать учебник");
        controller.addSubTask("Подготовка к экзамену", "Сделать конспект");
        controller.addSubTask("Подготовка к экзамену", "Решить задачи");
        controller.showAllTasks();

        System.out.println("Начинаем выполнение подзадач");
        controller.addSubTask("Подготовка к экзамену", "Прочитать учебник");
        controller.completeSubTask("Подготовка к экзамену", "Прочитать учебник");

        controller.addSubTask("Подготовка к экзамену", "Сделать конспект");
        controller.completeSubTask("Подготовка к экзамену", "Сделать конспект");
        controller.showAllTasks();

        TaskUtils.checkTaskStatus(controller.getTask("Подготовка к экзамену"));

        System.out.println("Завершаем последнюю подзадачу");
        controller.addSubTask("Подготовка к экзамену", "Решить задачи");
        controller.completeSubTask("Подготовка к экзамену", "Решить задачи");

        controller.showAllTasks();

        TaskUtils.checkTaskStatus(controller.getTask("Подготовка к экзамену"));

        System.out.println("\nСоздаем новую задачу");
        controller.addMainTask("Уборка дома");
        controller.addSubTask("Уборка дома", "Помыть посуду");
        controller.addSubTask("Уборка дома", "Пропылесосить");

        controller.showAllTasks();
    }
}


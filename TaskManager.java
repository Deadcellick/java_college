import Controller.TaskController;
import Utils.TaskUtils;
import models.Client;
import models.MainTask;
import models.Master;

public class TaskManager
{
    public static void main(String[] args)
    {
        TaskController controller = new TaskController();

        Client client = new Client("Анна", controller);
        Master master = new Master("Иван");

        client.deposit(2000);

        client.createMainTask("Подготовка к экзамену", 1000);
        client.addSubTask("Подготовка к экзамену", "Прочитать учебник");
        client.addSubTask("Подготовка к экзамену", "Сделать конспект");
        client.addSubTask("Подготовка к экзамену", "Решить задачи");

        client.assignTaskToMaster("Подготовка к экзамену", master);

        System.out.println("\n--- Мастер приступает к работе ---");
        MainTask examTask = controller.getTask("Подготовка к экзамену");

        master.startSubTask(examTask, "Прочитать учебник");
        master.completeSubTask(examTask, "Прочитать учебник");

        master.startSubTask(examTask, "Сделать конспект");
        master.completeSubTask(examTask, "Сделать конспект");

        controller.showAllTasks();

        master.startSubTask(examTask, "Решить задачи");
        master.completeSubTask(examTask, "Решить задачи");

        controller.showAllTasks();
        TaskUtils.checkTaskStatus(examTask);

        System.out.println("Баланс клиента " + client.getName() + ": " + client.getBalance());
        System.out.println("Баланс мастера " + master.getName() + ": " + master.getBalance());

        client.addSubTask("Подготовка к экзамену", "Дополнительная задача");

        System.out.println("\n=== Новая задача ===");
        Master anotherMaster = new Master("Пётр");
        client.createMainTask("Уборка дома", 500);
        client.addSubTask("Уборка дома", "Помыть посуду");
        client.addSubTask("Уборка дома", "Пропылесосить");
        client.assignTaskToMaster("Уборка дома", anotherMaster);

        controller.showAllTasks();

        MainTask homeTask = controller.getTask("Уборка дома");
        anotherMaster.startSubTask(homeTask, "Помыть посуду");
        anotherMaster.completeSubTask(homeTask, "Помыть посуду");
        anotherMaster.startSubTask(homeTask, "Пропылесосить");
        anotherMaster.completeSubTask(homeTask, "Пропылесосить");

        controller.showAllTasks();
        System.out.println("Баланс клиента " + client.getName() + ": " + client.getBalance());
        System.out.println("Баланс мастера " + anotherMaster.getName() + ": " + anotherMaster.getBalance());
    }
}
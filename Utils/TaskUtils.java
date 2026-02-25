package Utils;

import models.MainTask;
import models.TaskStatus;

public class TaskUtils
{
    public static void checkTaskStatus(MainTask task)
    {
        if (task == null)
        {
            System.out.println("Задача не найдена");
            return;
        }
        System.out.println("Проверка статуса задачи: " + task.getName());
        System.out.println("Статус: " + task.getStatus());
        if (task.getStatus() == TaskStatus.DONE)
        {
            System.out.println("Задача полностью выполнена!");
        }
        else
        {
            System.out.println("Задача ещё не завершена");
        }
        System.out.println();
    }
}
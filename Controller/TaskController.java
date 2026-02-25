package Controller;

import models.Client;
import models.MainTask;

import java.util.*;

public class TaskController
{
    private Map<String, MainTask> tasks;

    public TaskController()
    {
        this.tasks = new LinkedHashMap<>();
    }

    public void addMainTask(String name, Client client, double price)
    {
        tasks.put(name, new MainTask(name, client, price));
    }

    public void addSubTask(String mainTaskName, String subTaskName)
    {
        MainTask mainTask = tasks.get(mainTaskName);
        if (mainTask != null)
        {
            mainTask.addSubTask(subTaskName);
        }
    }

    public void startSubTask(String mainTaskName, String subTaskName)
    {
        MainTask mainTask = tasks.get(mainTaskName);
        if (mainTask != null)
        {
            mainTask.startSubTask(subTaskName);
        }
    }

    public void completeSubTask(String mainTaskName, String subTaskName)
    {
        MainTask mainTask = tasks.get(mainTaskName);
        if (mainTask != null)
        {
            mainTask.completeSubTask(subTaskName);
        }
    }

    public void showAllTasks()
    {
        System.out.println("=== Все задачи ===");
        for (MainTask task : tasks.values())
        {
            task.showStatus();
        }
    }

    public MainTask getTask(String name)
    {
        return tasks.get(name);
    }

    public Set<String> getTaskNames()
    {
        return tasks.keySet();
    }
}
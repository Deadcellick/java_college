import java.util.HashMap;
import java.util.Map;

class TaskController
{
    private Map<String, MainTask> tasks;

    public TaskController()
    {
        this.tasks = new HashMap<>();
    }

    public void addMainTask(String name)
    {
        tasks.put(name, new MainTask(name));
    }

    public void addSubTask(String mainTaskName, String subTaskName)
    {
        if (tasks.containsKey(mainTaskName))
        {
            tasks.get(mainTaskName).addSubTask(subTaskName);
        }
    }

    public void startSubTask(String mainTaskName, String subTaskName)
    {
        if (tasks.containsKey(mainTaskName))
        {
            tasks.get(mainTaskName).startSubTask(subTaskName);
        }
    }

    public void completeSubTask(String mainTaskName, String subTaskName)
    {
        if (tasks.containsKey(mainTaskName))
        {
            tasks.get(mainTaskName).completeSubTask(subTaskName);
        }
    }

    public void showAllTasks()
    {
        System.out.println("Все задачи");
        for (MainTask task : tasks.values())
        {
            task.showStatus();
        }
    }

    public MainTask getTask(String name)
    {
        return tasks.get(name);
    }
}
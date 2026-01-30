import java.util.HashMap;
import java.util.Map;

class MainTask
{
    private String name;
    private TaskStatus status;
    private Map<String, SubTask> subTasks;

    public MainTask(String name)
    {
        this.name = name;
        this.status = TaskStatus.NULL;
        this.subTasks = new HashMap<>();
    }

    public String getName()
    {
        return name;
    }

    public TaskStatus getStatus()
    {
        return status;
    }

    public void addSubTask(String name)
    {
        subTasks.put(name, new SubTask(name));
    }

    public void startSubTask(String name)
    {
        if (subTasks.containsKey(name))
        {
            subTasks.get(name).start();
        }
    }

    public void completeSubTask(String name)
    {
        if (subTasks.containsKey(name))
        {
            subTasks.get(name).complete();
            checkAllSubTasks();
        }
    }

    private void checkAllSubTasks()
    {
        boolean allDone = true;

        for (SubTask task : subTasks.values())
        {
            if (!task.isDone())
            {
                allDone = false;
                break;
            }
        }

        if (allDone && !subTasks.isEmpty())
        {
            this.status = TaskStatus.done;
        }
    }

    public void showStatus() {
        System.out.println("Главная задача: " + name);
        System.out.println("Статус главной задачи: " + status);
        System.out.println("Подзадачи:");

        for (SubTask task : subTasks.values())
        {
            System.out.println("  - " + task.getName() + ": " + task.getStatus());
        }
        System.out.println();
    }
}
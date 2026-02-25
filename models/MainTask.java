package models;

import java.util.*;

public class MainTask extends AbstractTask
{
    private Map<String, SubTask> subTasks;
    private Master master;
    private Client client;
    private double price;

    public MainTask(String name, Client client, double price)
    {
        super(name);
        this.client = client;
        this.price = price;
        this.subTasks = new LinkedHashMap<>();
    }

    public void setMaster(Master master)
    {
        this.master = master;
    }

    public Master getMaster()
    {
        return master;
    }

    public Client getClient()
    {
        return client;
    }

    public double getPrice()
    {
        return price;
    }

    public void addSubTask(String name)
    {
        if (this.status == TaskStatus.DONE)
        {
            System.out.println("Нельзя добавить подзадачу к выполненной задаче.");
            return;
        }
        subTasks.put(name, new SubTask(name));
    }

    public void startSubTask(String name)
    {
        SubTask task = subTasks.get(name);
        if (task != null)
        {
            task.start();
        }
    }

    public void completeSubTask(String name)
    {
        SubTask task = subTasks.get(name);
        if (task != null)
        {
            task.complete();
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
            this.status = TaskStatus.DONE;
            completeTask();
        }
    }

    private void completeTask()
    {
        if (client != null && master != null)
        {
            client.makePayment(price);
            master.receivePayment(price);
            System.out.println("Задача \"" + getName() + "\" выполнена. Произведён расчёт.");
        } else
        {
            System.out.println("Задача выполнена, но клиент или мастер не назначены, расчёт не произведён.");
        }
    }

    public void showStatus()
    {
        List<SubTask> taskList = new ArrayList<>(subTasks.values());
        int maxNameLength = 0;
        for (SubTask task : taskList)
        {
            int len = task.getName().length();
            if (len > maxNameLength)
            {
                maxNameLength = len;
            }
        }
        if (maxNameLength < 10)
        {
            maxNameLength = 10;
        }

        System.out.println("============================================================");
        System.out.println("Главная задача: " + getName());
        System.out.println("Статус: " + getStatus());
        System.out.println("Стоимость: " + price + " руб.");
        if (master != null)
        {
            System.out.println("Ответственный мастер: " + master.getName());
        }
        else
        {
            System.out.println("Ответственный мастер: не назначен");
        }

        if (taskList.isEmpty())
        {
            System.out.println("Подзадачи: отсутствуют");
        }
        else
        {
            System.out.println("Подзадачи:");
            int number = 1;
            for (SubTask task : taskList)
            {
                String format = "  %d. %-" + maxNameLength + "s [%s]";
                System.out.println(String.format(format, number++, task.getName(), task.getStatus()));
            }
        }
        System.out.println("============================================================");
        System.out.println();
    }
}
package models;

import Inrefaces.PaymentOperations;
import java.util.*;

public class Master extends User implements PaymentOperations
{
    private List<MainTask> assignedTasks;

    public Master(String name)
    {
        super(name);
        this.assignedTasks = new ArrayList<>();
    }

    @Override
    public void receivePayment(double amount)
    {
        addFunds(amount);
        System.out.println("Мастер " + name + " получил " + amount + " руб. Баланс: " + balance);
    }

    @Override
    public void makePayment(double amount)
    {
        throw new UnsupportedOperationException("Мастер не может совершать платежи");
    }

    public void assignTask(MainTask task)
    {
        if (!assignedTasks.contains(task))
        {
            assignedTasks.add(task);
            task.setMaster(this);
            System.out.println("Мастер " + name + " назначен на задачу \"" + task.getName() + "\"");
        }
    }

    public void startSubTask(MainTask task, String subTaskName) {
        if (assignedTasks.contains(task))
        {
            task.startSubTask(subTaskName);
            System.out.println("Мастер " + name + " начал подзадачу \"" + subTaskName + "\"");
        }
        else
        {
            System.out.println("Ошибка: задача не назначена этому мастеру");
        }
    }

    public void completeSubTask(MainTask task, String subTaskName) {
        if (assignedTasks.contains(task))
        {
            task.completeSubTask(subTaskName);
            System.out.println("Мастер " + name + " завершил подзадачу \"" + subTaskName + "\"");
        }
        else
        {
            System.out.println("Ошибка: задача не назначена этому мастеру");
        }
    }

    public void showAssignedTasks() {
        System.out.println("Мастер " + name + ", назначенные задачи:");
        if (assignedTasks.isEmpty())
        {
            System.out.println("  нет задач");
        }
        else
        {
            for (MainTask task : assignedTasks)
            {
                task.showStatus();
            }
        }
    }
}
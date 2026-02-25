package models;

import Controller.TaskController;
import Inrefaces.PaymentOperations;

public class Client extends User implements PaymentOperations
{
    private TaskController controller;

    public Client(String name, TaskController controller)
    {
        super(name);
        this.controller = controller;
    }

    @Override
    public void receivePayment(double amount)
    {
        throw new UnsupportedOperationException("Клиент не может получать платежи");
    }

    @Override
    public void makePayment(double amount)
    {
        subtractFunds(amount);
        System.out.println("Клиент " + name + " заплатил " + amount + " руб. Баланс: " + balance);
    }

    public void createMainTask(String taskName, double price)
    {
        controller.addMainTask(taskName, this, price);
        System.out.println("Клиент " + name + " создал главную задачу \"" + taskName + "\" стоимостью " + price + " руб.");
    }

    public void addSubTask(String mainTaskName, String subTaskName)
    {
        controller.addSubTask(mainTaskName, subTaskName);
        System.out.println("Клиент " + name + " добавил подзадачу \"" + subTaskName + "\" к задаче \"" + mainTaskName + "\"");
    }

    public void assignTaskToMaster(String taskName, Master master)
    {
        MainTask task = controller.getTask(taskName);
        if (task != null)
        {
            master.assignTask(task);
        } else
        {
            System.out.println("Ошибка: задача \"" + taskName + "\" не найдена");
        }
    }
}

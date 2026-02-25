package models;

abstract class User
{
    protected String name;
    protected double balance;

    public User(String name)
    {
        this.name = name;
        this.balance = 0.0;
    }

    public String getName()
    {
        return name;
    }

    public void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
        }
    }

    public double getBalance()
    {
        return balance;
    }

    public void addFunds(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
        }
    }

    protected void subtractFunds(double amount)
    {
        if (amount > 0 && balance >= amount)
        {
            balance -= amount;
        }
        else
        {
            throw new IllegalArgumentException("Недостаточно средств или неверная сумма");
        }

    }
}
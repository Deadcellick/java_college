package models;

abstract class AbstractTask
{
    protected String name;
    protected TaskStatus status;

    public AbstractTask(String name)
    {
        this.name = name;
        this.status = TaskStatus.NULL;
    }

    public String getName()
    {
        return name;
    }

    public TaskStatus getStatus()
    {
        return status;
    }

    public boolean isDone()
    {
        return status == TaskStatus.DONE;
    }

    public void start()
    {
    }

    public void complete()
    {
    }
}
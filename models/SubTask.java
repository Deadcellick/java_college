package models;

class SubTask extends AbstractTask
{
    public SubTask(String name)
    {
        super(name);
    }

    @Override
    public void start()
    {
        this.status = TaskStatus.IN_PROGRESS;
    }

    @Override
    public void complete()
    {
        this.status = TaskStatus.DONE;
    }
}
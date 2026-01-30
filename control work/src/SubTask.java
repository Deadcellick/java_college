// Класс для отдельной подзадачи
class SubTask {
    private String name;
    private TaskStatus status;

    public SubTask(String name) {
        this.name = name;
        this.status = TaskStatus.NULL;
    }

    public String getName() {
        return name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void start() {
        this.status = TaskStatus.in_progress;
    }

    public void complete() {
        this.status = TaskStatus.done;
    }

    public boolean isDone() {
        return status == TaskStatus.done;
    }
}
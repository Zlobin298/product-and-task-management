package test.task2j;

class Task {
    private String name;
    private String description;
    private int priority;
    private Status status;

    public Task() {}

    public Task(String name, String description, int priority, Status status) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        String format = String.format("["+ getStatus() +"] (%d) %s: %s", getPriority(), getName(), getDescription());

        return format;
    }
}

package mybatis.models;

public class Task {
    int id;
    String task_name;
    Boolean is_complete;
    int user_id;

    public Task(){
    }

    public Task(int id, String task_name, Boolean is_complete, int user_id) {
        this.id = id;
        this.task_name = task_name;
        this.is_complete = is_complete;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public Boolean getIs_complete() {
        return is_complete;
    }

    public void setIs_complete(Boolean is_complete) {
        this.is_complete = is_complete;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task_name='" + task_name + '\'' +
                ", is_complete=" + is_complete +
                ", user_id=" + user_id +
                '}';
    }
}

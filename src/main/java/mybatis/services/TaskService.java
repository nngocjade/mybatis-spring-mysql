package mybatis.services;


import mybatis.mappers.TaskMapper;
import mybatis.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {

    @Autowired
    TaskMapper taskMapper; //field injection

    public ArrayList<Task> getAllTasks(){
        return taskMapper.getAllTasks();
    }

    public int deleteById(int id){
        return taskMapper.deleteById(id);
    }

    public Task getById(int id){
        return taskMapper.getById(id);
    }

    public Task insertTask(Task task){
        int i = taskMapper.insertTask(task);//return a task
        return task;
    }

    public int updateTask(Task task){
        return taskMapper.updateTask(task);
    }

    public ArrayList<Task> getTasksByUserId(int user_id, String complete){

        if(complete.equalsIgnoreCase("true")){
            return taskMapper.getTasksByUserIdBoolean(user_id, true);
        }else if (complete.equalsIgnoreCase("false")){
            return taskMapper.getTasksByUserIdBoolean(user_id, false);
        }
        return taskMapper.getTasksByUserId(user_id);
    }


}

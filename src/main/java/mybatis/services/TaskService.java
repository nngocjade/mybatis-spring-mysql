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

    public int insertTask(Task task){
        return taskMapper.insertTask(task);
    }


}

package mybatis.controllers;

import mybatis.exceptions.NewUserException;
import mybatis.models.Task;
import mybatis.models.User;
import mybatis.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/tasks")//mapping at the class level
public class TaskController {

    @Autowired
    TaskService taskService;


    @GetMapping
    public ArrayList<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @DeleteMapping
    public int deleteTask(@RequestParam(value="id")int id){
        return taskService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable(value="id")int id) {

        return taskService.getById(id);
    }
    @PostMapping
    public int insertTask(@RequestBody Task task){
        return taskService.insertTask(task);
    }
    @PatchMapping
    public User updateUser(@RequestBody User user) throws NewUserException {
        return taskService.updatUser(task);
    }




}

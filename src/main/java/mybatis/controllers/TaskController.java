package mybatis.controllers;

import mybatis.models.Task;
import mybatis.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/tasks")//mapping at the class level
public class TaskController {

    @Autowired
    TaskService taskService;

    //http://localhost:8080/tasks
    @GetMapping
    public ArrayList<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @DeleteMapping("/{id}")
    public int deleteTask(@RequestParam(value="id")int id){
        return taskService.deleteById(id);
    }
    @GetMapping("/{id}")
    public Task getById(@PathVariable(value="id")int id) {
        return taskService.getById(id);
    }
    @PostMapping
    public Task insertTask(@RequestBody Task task){
        return taskService.insertTask(task);
    }
    @PatchMapping
    public int updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }





}

package mybatis.controllers;

import mybatis.models.ResponseObject;
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

    //Get
    //http://localhost:8080/tasks
    @GetMapping
    public ResponseObject getAllTasks(){
        ResponseObject<ArrayList<Task>> returnVal = new ResponseObject<>();
        returnVal.setData(taskService.getAllTasks());
        returnVal.setResponse_code(200);
        returnVal.setMessage("Here are the tasks");
        return returnVal;
    }
    //Delete
    //localhost:8080/tasks/2?id=2
    @DeleteMapping("/{id}")
    public ResponseObject deleteTask(@PathVariable("id") int id){
        int status = taskService.deleteById(id);
        ResponseObject<String> returnVal = new ResponseObject<>();

        if(status == 1){
            returnVal.setMessage("Task successfully deleted");
            returnVal.setResponse_code(200); //200 means good
        }else if (status == 0){
            returnVal.setMessage("No such task to delete");
            returnVal.setResponse_code(200);
        }else{
            returnVal.setMessage("It appears more thn one task was deleted");
            returnVal.setResponse_code(200);
        }
        return returnVal;
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

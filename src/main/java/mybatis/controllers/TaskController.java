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
    //Get
    //localhost:8080/tasks/5
    //body-empty
    //response
        //{
    //    "data": {
    //        "id": 5,
    //        "task_name": "clean",
    //        "is_complete": true,
    //        "user_id": 5
    //    },
    //    "message": "Here are the tasks",
    //    "response_code": 200
    //}
    @GetMapping("/{id}")
    public ResponseObject getTaskById(
            @PathVariable("id") int id){
        ResponseObject<Task> returnVal = new ResponseObject<>();
        returnVal.setData(taskService.getTaskById(id));
        returnVal.setResponse_code(200);
        returnVal.setMessage("Here are the tasks");
        return returnVal;
    }
    //Delete
    //localhost:8080/tasks/2
    //body-empty
    //response
         //{
        //    "data": null,
        //    "message": "Task successfully deleted",
        //    "response_code": 200
        //}
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
    //Post (Create)
    //
    @PostMapping
    public Task insertTask(@RequestBody Task task){
        return taskService.insertTask(task);
    }
    @PatchMapping
    public int updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }





}

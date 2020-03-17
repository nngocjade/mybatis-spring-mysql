package mybatis.controllers;

import mybatis.exceptions.NewUserException;
import mybatis.models.taskapp.Task;
import mybatis.models.taskapp.User;
import mybatis.services.TaskService;
import mybatis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    //localhost:8080/users
    @GetMapping
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }
    //Post (create)
    //localhost:8080/users
    //{
    //	"first_name": "Donald",
    //	"last_name": "Duck",
    //	"isActive": true
    //}
    @PostMapping
    public User insertUser(@RequestBody User user) throws NewUserException {
        return userService.insertUser(user);
    }
    //Delete
    //localhost:8080/users?id=3
    //{
    //	"isActive": false
    //}
    @DeleteMapping("/{id}")
    public User deleteUser(@RequestParam(value="id")int id) throws NewUserException {
        return userService.deleteUser(id);
    }
    //Patch
    //localhost:8080/users
    //{
    //	"id": 3,
    //	"first_name": "Mickey",
    //	"last_name": "Mouse",
    //	"isActive": true
    //}
    @PatchMapping
    public User updateUser(@RequestBody User user) throws NewUserException {
        return userService.updateUser(user);
    }
    //Get
    //localhost:8080/users/3
    //body (empty)
    @GetMapping("/{id}")
    public User getById(@PathVariable(value="id")int id) {
        return userService.getById(id);
    }
    //Get
    //localhost:8080/users/4/tasks
    //Get
    //localhost:8080/users/3/tasks?complete=false
    @GetMapping("/{user_id}/tasks")
    public ArrayList<Task> getTasksByUserId(
            @PathVariable (value = "user_id") int user_id,
            @RequestParam (value = "complete", defaultValue = "-1") String complete){
        return taskService.getTasksByUserId(user_id, complete);
    }

}

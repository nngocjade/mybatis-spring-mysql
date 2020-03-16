package mybatis.controllers;

import mybatis.exceptions.NewUserException;
import mybatis.models.Task;
import mybatis.models.User;
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

    @GetMapping
    public ArrayList<User> getAllUsers(){

        return userService.getAllUsers();
    }
    @PostMapping
    public User insertUser(@RequestBody User user) throws NewUserException {
        return userService.insertUser(user);
    }
    @DeleteMapping
    public User deleteUser(@RequestParam(value="id")int id) throws NewUserException {
        return userService.deleteUser(id);
    }
    @PatchMapping
    public User updateUser(@RequestBody User user) throws NewUserException {
        return userService.updateUser(user);
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable(value="id")int id) {
        return userService.getById(id);
    }

    @GetMapping("/{user_id}/tasks")
    public ArrayList<Task> getTasksByUserId(
            @PathVariable (value = "user_id") int user_id,
            @RequestParam (value = "complete", defaultValue = "-1") String complete){
        return taskService.getTasksByUserId(user_id, complete);
    }







}

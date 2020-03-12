package mybatis.controllers;

import mybatis.exceptions.NewUserException;
import mybatis.models.User;
import mybatis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

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
        return userService.makeUserInactive(id);
    }

//    @UpdateMapping("/{id}")
//    public User updateUser(@PathVariable(value="id")int id) {
//        return userService.deleteUser(id);
//    }



}

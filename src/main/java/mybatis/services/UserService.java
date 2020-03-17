package mybatis.services;


import mybatis.exceptions.NewUserException;
import mybatis.mappers.UserMapper;
import mybatis.models.taskapp.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service //a bean Spring manages
public class UserService {

    @Autowired //a part of dependency mapper
    UserMapper userMapper;

    public ArrayList<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    public User insertUser(User user) throws NewUserException {
        int numOfRows = userMapper.insertUser(user);
        if(numOfRows == 1){
            return userMapper.findUserByFirstNameLastName(user.getFirst_name(), user.getLast_name());
        }else {
            NewUserException ne = new NewUserException("error creating new user");
            throw ne;
        }
    }

    public User deleteUser(int id) throws NewUserException {//this method is used in the controller class
        int numOfRows = userMapper.makeUserInactive(id); //this is the method from the mapper class

        //1 is referring to 1 row
        if(numOfRows == 1){
            return userMapper.findUserById(id);
        } else {
            NewUserException ne = new NewUserException("error deleting the user");
            throw ne;
        }
    }

    public User updateUser(User user) throws NewUserException{
        int numOfRows = userMapper.updateUser(user);
        if(numOfRows == 1){
            return userMapper.findUserById(user.getId());
        }else {
            NewUserException ne = new NewUserException("error updating the user");
            throw ne;
        }
    }

    public User getById(int id) {
        return userMapper.findUserById(id);
    }
}

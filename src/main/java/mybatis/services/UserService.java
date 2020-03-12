package mybatis.services;


import mybatis.exceptions.NewUserException;
import mybatis.mappers.UserMapper;
import mybatis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service //a bean Spring manages
public class UserService {

    @Autowired //apart of dependency mapper
    UserMapper userMapper;

    public ArrayList<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    public User insertUser(User user) throws NewUserException {
        int i = userMapper.insertUser(user);

        if(i == 1){
            return userMapper.findUserByFirstNameLastName(user.getFirst_name(), user.getLast_name());
        }else {
            NewUserException ne = new NewUserException("error creating new user");
            throw ne;
        }
    }


    public User deleteUser(int id) throws NewUserException {//this method is used in the controller class

        int i = userMapper.makeUserInactive(id); //this is the method from the mapper class

        //1 is referring to 1 row
        if(i == 1){
            return userMapper.findUserById(id);
        }else {
            NewUserException ne = new NewUserException("error creating new user");
            throw ne;
        }

    }




}

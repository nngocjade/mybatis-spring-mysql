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


    public User makeUserInactive(int id) throws NewUserException {

        makeUserInactive(id).setActive(false);

        int i = userMapper.makeUserInactive(id);

        //1 is referring to 1 row
        if(i == 1){
            return userMapper.findUserById(user.getFirst_name(), user.getLast_name());
        }else {
            NewUserException ne = new NewUserException("error creating new user");
            throw ne;
        }

    }




}

package mybatis.services;


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
}

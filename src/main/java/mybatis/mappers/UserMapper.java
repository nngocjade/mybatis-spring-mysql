package mybatis.mappers;

import mybatis.models.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface UserMapper {

    String SELECT_ALL_USERS = "select * from `mybatis-test`.users";

    String SELECT_BY_FIRST_LAST_NAME = "select * from `mybatis-test` .users" +
            "where first_name = #{first_name} and last_name = #{last_name}";

    String INSERT_USER = "INSERT INTO `mybatis-test`.users (first_name, last_name)" + "VALUES (#{first_name}, #{last_name}";

    @Select(SELECT_ALL_USERS)
    public ArrayList<User> getAllUsers();

    @Select(SELECT_BY_FIRST_LAST_NAME)
    User findUserByFirstNameLastName(String first_name, String last_name);

    @Insert(INSERT_USER)
    public int insertUser(User user);


}

package mybatis.mappers;

import mybatis.models.taskapp.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface UserMapper {

    String SELECT_ALL_USERS = "select * from `mybatis-test`.users";

    String SELECT_BY_FIRST_LAST_NAME = "select * from `mybatis-test`.users " +
            " where first_name = #{param1} and last_name = #{param2}";
    //findUserById
    String SELECT_BY_ID = "select * from `mybatis-test`.users where id = #{id}";

    String INSERT_USER = "INSERT INTO `mybatis-test`.users (first_name, last_name) " +
            "VALUES (#{first_name}, #{last_name})";

    String DELETE_USER = "update `mybatis-test`.users SET isActive = 0 where id = #{id}";

    String UPDATE_USER = "update `mybatis-test`.users SET first_name = #{first_name}, last_name = #{last_name}, isActive = #{isActive} where id = #{id}";

    @Select(SELECT_ALL_USERS)
    public ArrayList<User> getAllUsers();

    @Select(SELECT_BY_FIRST_LAST_NAME)
    User findUserByFirstNameLastName(String first_name, String last_name);

    @Select(SELECT_BY_ID)//
    User findUserById(int id);

    @Insert(INSERT_USER)
    public int insertUser(User user);

    @Update(DELETE_USER)
    public int makeUserInactive(int id);

    @Update(UPDATE_USER)
    public int updateUser(User user); //the int returned is a row


}

package mybatis.mappers;


import mybatis.models.Task;
import mybatis.models.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface TaskMapper {

    String SELECT_ALL_TASKS = "SELECT * FROM `mybatis-test`.tasks";//variables in interfaces are inherently final( all caps)
    //delete a task
    String DELETE_TASK_BY_ID = "DELETE FROM `mybatis-test`.`tasks` WHERE id = #{id}";
    String SELECT_BY_ID = "SELECT * FROM `mybatis-test`.tasks WHERE id = #{id}";
    //create - post a task
    String INSERT_TASK = "INSERT INTO `mybatis-test`.`tasks` (task_name, is_complete, user_id)" +
             "VALUES (#{task_name}, #{is_complete}, #{user_id})";

    String UPDATE_TASK = "UPDATE `mybatis-test`.`tasks` SET task_name = #{task_name}, is_complete = #{is_complete}, user_id = #{user_id} WHERE id = #{id}";

    String SELECT_TASK_BY_USER_ID = "SELECT * FROM `mybatis-test`.tasks WHERE user_id = #{user_id}";

    String SELECT_TASK_BY_USER_ID_BOOLEAN = "SELECT * FROM `mybatis-test`.tasks WHERE user_id = #{param1} and is_complete = #{param2}";

    @Select(SELECT_ALL_TASKS) //this select annotation requires a query to run
    public ArrayList<Task> getAllTasks();//this method returns a collection of tasks, the body of this method will be created by mybatist-test

    @Delete(DELETE_TASK_BY_ID)
    public int deleteById(int id);//returns an int will show how many rows affected in workbench

    @Select(SELECT_BY_ID)
    Task getById(int id);

    @Insert(INSERT_TASK)
    @Options(useGeneratedKeys = true)
    public int insertTask(Task task);

    @Update(UPDATE_TASK)
    public int updateTask(Task task);

    @Select(SELECT_TASK_BY_USER_ID)
    public ArrayList<Task> getTasksByUserId(int user_id);

    @Select(SELECT_TASK_BY_USER_ID_BOOLEAN)
    public ArrayList<Task> getTasksByUserIdBoolean(int user_id, boolean complete);
}

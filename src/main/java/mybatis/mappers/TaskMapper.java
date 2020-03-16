package mybatis.mappers;


import mybatis.models.Task;
import mybatis.models.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface TaskMapper {

    String SELECT_ALL_TASKS = "SELECT * FROM `mybatis-test`.tasks";//variables in interfaces are inherently final( all caps)
    String DELETE_TASK_BY_ID = "DELETE FROM `mybatis-test`.`tasks` WHERE id = #{id}";
    String SELECT_BY_ID = "SELECT * FROM `mybatis-test`.tasks WHERE id = #{id}";
    String INSERT_TASK = "INSERT INTO `mybatis-test`.tasks (task_name, is_complete, user_id) " +
            "VALUES (#{task_name}, #{is_complete}, #{user_id)";


    @Select(SELECT_ALL_TASKS) //this select annotation requires a query to run
    public ArrayList<Task> getAllTasks();//this method returns a collection of tasks, the body of this method will be created by mybatist-test

    @Delete(DELETE_TASK_BY_ID)
    public int deleteById(int id);//returns an int will show how many rows affected in workbench

    @Select(SELECT_BY_ID)
    Task getById(int id);

    @Insert(INSERT_TASK)
    public int insertTask(Task task);



}

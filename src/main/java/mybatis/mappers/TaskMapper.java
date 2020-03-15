package mybatis.mappers;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {
    //variables in interfaces are inherently final( all caps)
    String SELECT_ALL_TASKS = "SELECT * FROM `mybatis-test`.tasks";

}
